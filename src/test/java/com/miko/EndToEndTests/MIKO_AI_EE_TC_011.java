package com.miko.EndToEndTests;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.miko.genericLibrary.BaseClass;
import com.miko.genericLibrary.ListenerImplementationClass;
import com.miko.pomRepository.CheckOutInformationPage;
import com.miko.pomRepository.CheckoutOrderSummaryPage;
import com.miko.pomRepository.CheckoutPaymentPage;
import com.miko.pomRepository.CheckoutShippingPage;
import com.miko.pomRepository.HomePage;
import com.miko.pomRepository.OrderConfirmationPage;
import com.miko.pomRepository.ShoppingCartPage;

@Listeners(ListenerImplementationClass.class)
public class MIKO_AI_EE_TC_011 extends BaseClass {


	@Test
	public void MIKO_AI_EE_TC_011_Test() throws InterruptedException {

		String homePageUrl = property.readDataFromProperty("URL");
		String CheckOutshipping = property.readDataFromProperty("shipping_CheckoutPage");
		String colorText = excelData.readDataFromExcel("elementText", 1, 2);
		String expectedOrderId1 = excelData.readDataFromExcel("CommonData", 37, 1);
		String expectedOrderId2 = excelData.readDataFromExcel("CommonData", 37, 2);
		String expectedtoastMsg_addedMiko = excelData.readDataFromExcel("CommonData", 45, 1);
		String expectedtoastMsg_removedMiko = excelData.readDataFromExcel("CommonData", 46, 1);
		CheckoutPaymentPage checkOutPayment = new CheckoutPaymentPage(driver);

		//1)Home page should display
		HomePage homePage = new HomePage(driver);
		webDriverUtil.explicitlyWaitForUrl(driver, homePageUrl);
		Assert.assertTrue(driver.getCurrentUrl().contains(homePageUrl),"given url is not entered in the address bar");
		ListenerImplementationClass.test.log(Status.INFO, "Home page is displayed successfully");

		//2)Select the location as United States of America  and click on continue button
		rUsable.selectGeoLocationForUS(driver);
		webDriverUtil.explicitlyWaitForElementToClick(driver, homePage.getBottombar_redRadioBtn());
		webDriverUtil.clickDisabledElement(homePage.getBottombar_redRadioBtn(), driver);
		String bottomBarPrice = homePage.getBottombar_price().getText();

		//3)click on buy now button
		webDriverUtil.clickDisabledElement(homePage.getBottombar_BuyNowBtn(), driver);

		//Verify on shopping cart page, product detail should display
		ShoppingCartPage shoppingCart = new ShoppingCartPage(driver);
		webDriverUtil.explicitlyWaitForElement(driver, shoppingCart.getSub_Total());
		String subtotalAmt = shoppingCart.getSub_Total().getText();
		String actualColor = shoppingCart.selectColorText(driver, colorText).getText();
		String productPriceOnBottomBar = shoppingCart.getRed_ProductPrice().getText();
		ListenerImplementationClass.test.log(Status.INFO, "expected product details present successfully");

		//5)on shopping cart page, Click on "Add another Miko" link
		shoppingCart.getAdd_Another_Miko_Link().click();
		webDriverUtil.explicitlyWaitForElement(driver, shoppingCart.getRed_productimg());
		Assert.assertTrue(shoppingCart.getRed_productimg().isDisplayed(), "red bot is not present ");
		ListenerImplementationClass.test.log(Status.INFO, "expected product added successfully");
		rUsable.verifyShoppingCartDetailsforTwoBot(driver, productPriceOnBottomBar, bottomBarPrice);

		String addedMiko_ToastMsg = homePage.getToastMessage_Text().getText();
		webDriverUtil.explicitlyWaitForElement(driver, homePage.getToastMessage_Text());
		Assert.assertEquals(addedMiko_ToastMsg, expectedtoastMsg_addedMiko,"different toast message displayed after adding miko");
		ListenerImplementationClass.test.log(Status.INFO, "expected toast message displayed successfully after adding miko");

		//6)on shopping cart page, Click on Pixie blue bot  "Remove" link
		webDriverUtil.explicitlyWaitForElementToClick(driver, shoppingCart.getBlue_removeLink());
		webDriverUtil.clickDisabledElement(shoppingCart.getBlue_removeLink(), driver);

		//7)on popup, click on "Yes" button
		shoppingCart.getNotification_YesBtn().click();

		try {
			webDriverUtil.explicitlyWaitForElement(driver, homePage.getToastMessage_Text());
			String removedMiko_ToastMsg = homePage.getToastMessage_Text().getText();
			webDriverUtil.explicitlyWaitForElementTextToPresent(driver, homePage.getToastMessage_Text(), expectedtoastMsg_removedMiko); 	
			Assert.assertEquals(removedMiko_ToastMsg, expectedtoastMsg_removedMiko,"different toast message displayed after removing miko");
			ListenerImplementationClass.test.log(Status.INFO, "expected toast message displayed successfully after removing miko");

		} catch (Exception e) {
			e.printStackTrace();
		}

		String productPrice  = shoppingCart.getSub_Total().getText();
		//->8)Click on 'Go To Checkout' button
		shoppingCart.getGo_TO_CheckOut_Btn().click();
		CheckOutInformationPage checkOutInformation = new CheckOutInformationPage(driver);

		//verify information page and fill the address
		//click on paypal
		String currentHandle = driver.getWindowHandle();
		checkOutInformation.getPayPal_btn().click();
		Set<String> handles = driver.getWindowHandles(); 
		for (String handle : handles) 
		{ 
			if (!handle .equals(currentHandle)) 
			{ 
				driver.switchTo().window(handle); 	    
				String payPalTitle = excelData.readDataFromExcel("CommonData", 38, 1);
				webDriverUtil.explicitlyWaitForPage(driver, payPalTitle);
				Assert.assertEquals(driver.getTitle(), payPalTitle, "paypal page is not displayed");
				checkOutPayment.getPayPal_emailaddressTextField().sendKeys("ftgyuh@gmail.com");
				driver.close(); 
			} 
			driver.switchTo().window(currentHandle); 
		}

		rUsable.verifyCheckoutInformation(driver);
		webDriverUtil.explicitlyWaitForElementToClick(driver, checkOutInformation.getContinue_To_Shipping_Btn());
		webDriverUtil.doubleClickElement(driver, checkOutInformation.getContinue_To_Shipping_Btn());
		ListenerImplementationClass.test.log(Status.INFO, "expected state selected successfully");

		//shipping
		CheckoutShippingPage checkOutShippingPage = new CheckoutShippingPage(driver);
		WebElement economyRadioBtn = checkOutShippingPage.getShippingMode_Economy_RadioBtn();
		rUsable.verifyCheckOutShipping(CheckOutshipping, economyRadioBtn, driver);

		//apply discount and verify orderSummary 
		CheckoutOrderSummaryPage OrderSummary = new CheckoutOrderSummaryPage(driver);
		webDriverUtil.explicitlyWaitForElementTextToPresent(driver, OrderSummary.getFinalAmt(), subtotalAmt);
		String beforeDiscountFinalAmt = OrderSummary.getFinalAmt().getText();
		rUsable.verifyOrderSummaryWithDiscount(driver, subtotalAmt, actualColor, beforeDiscountFinalAmt);

		//click on contact change link in shipping page  and verify information page
		checkOutPayment.getChange_Contact_Link().click();
		String CheckOutInformation = property.readDataFromProperty("information_CheckoutPage");
		webDriverUtil.explicitlyWaitForUrl(driver, CheckOutInformation);
		Assert.assertTrue(driver.getCurrentUrl().contains(CheckOutInformation), "checkout-Information page is not display");
		ListenerImplementationClass.test.log(Status.INFO, "Click on contact's change link and CheckOut-Information Page displayed successfully");

		//click on continue to shipping button and verify shipping page
		webDriverUtil.explicitlyWaitForElementClick(driver, checkOutInformation.getContinue_To_Shipping_Btn());
		webDriverUtil.clickDisabledElement(checkOutInformation.getContinue_To_Shipping_Btn(), driver);
		webDriverUtil.explicitlyWaitForUrl(driver, CheckOutshipping);
		Assert.assertTrue(driver.getCurrentUrl().contains(CheckOutshipping), "different url displayed for shipping page");
		ListenerImplementationClass.test.log(Status.INFO, "click on 'continue to shipping' button and CheckOut-shipping Page displayed successfully");

		//click on ship to change link and verify information page
		checkOutPayment.getChange_Shipping_Address_Link().click();
		webDriverUtil.explicitlyWaitForUrl(driver, CheckOutInformation);
		Assert.assertTrue(driver.getCurrentUrl().contains(CheckOutInformation), "checkout-Information page should display");
		ListenerImplementationClass.test.log(Status.INFO, "Click on 'ship to' change link and CheckOut-Information Page displayed successfully");

		//click on continue shipping link and verify shipping page
		webDriverUtil.explicitlyWaitForElementClick(driver, checkOutInformation.getContinue_To_Shipping_Btn());
		webDriverUtil.clickDisabledElement(checkOutInformation.getContinue_To_Shipping_Btn(), driver);
		webDriverUtil.explicitlyWaitForUrl(driver, CheckOutshipping);
		Assert.assertTrue(driver.getCurrentUrl().contains(CheckOutshipping), "different url displayed for shipping page");
		ListenerImplementationClass.test.log(Status.INFO, "click on 'continue to shipping' button and CheckOut-shipping Page displayed successfully");

		//click on return to information link
		webDriverUtil.clickDisabledElement(checkOutShippingPage.getReturn_to_information_Link(), driver);
		webDriverUtil.explicitlyWaitForUrl(driver, CheckOutInformation);
		Assert.assertTrue(driver.getCurrentUrl().contains(CheckOutInformation), "checkout-Information page should display");
		ListenerImplementationClass.test.log(Status.INFO, "click on 'return to information link' and CheckOut-Information Page displayed successfully");

		//click on continue shipping link and verify shipping page
		webDriverUtil.explicitlyWaitForElementClick(driver, checkOutInformation.getContinue_To_Shipping_Btn());
		webDriverUtil.clickDisabledElement(checkOutInformation.getContinue_To_Shipping_Btn(), driver);
		webDriverUtil.explicitlyWaitForUrl(driver, CheckOutshipping);
		Assert.assertTrue(driver.getCurrentUrl().contains(CheckOutshipping), "different url displayed for shipping page");
		ListenerImplementationClass.test.log(Status.INFO, "click on 'continue to shipping' button and CheckOut-shipping Page displayed successfully");

		//click on continue payment btn
		webDriverUtil.explicitlyWaitForElementClick(driver, checkOutShippingPage.getContinue_To_Payment_Btn());
		webDriverUtil.explicitlyWaitForElementTextToPresent(driver, checkOutShippingPage.getContinue_To_Payment_Btn(), "Continue to payment");
		webDriverUtil.clickDisabledElement(checkOutShippingPage.getContinue_To_Payment_Btn(), driver);


		//--------------------------------payment -------------------	
		//verify payment page
		rUsable.verifyCheckoutPayment(driver, beforeDiscountFinalAmt, productPrice);

		//1)click on contact change link and verify information page 
		checkOutPayment.getChange_Contact_Link().click();
		webDriverUtil.explicitlyWaitForUrl(driver, CheckOutInformation);
		Assert.assertTrue(driver.getCurrentUrl().contains(CheckOutInformation), "checkout-Information page should display");
		ListenerImplementationClass.test.log(Status.INFO, "Click on contact's change link and CheckOut-Information Page displayed successfully");

		//click on continue shipping and continue payment button and verify payment page
		webDriverUtil.explicitlyWaitForElementClick(driver, checkOutInformation.getContinue_To_Shipping_Btn());
		webDriverUtil.clickDisabledElement(checkOutInformation.getContinue_To_Shipping_Btn(), driver);
		webDriverUtil.explicitlyWaitForElement(driver, checkOutShippingPage.getContinue_To_Payment_Btn());
		webDriverUtil.clickDisabledElement(checkOutShippingPage.getContinue_To_Payment_Btn(), driver);
		String CheckOutPayment = property.readDataFromProperty("payment_CheckoutPage");
		webDriverUtil.explicitlyWaitForUrl(driver, CheckOutPayment);
		Assert.assertTrue(driver.getCurrentUrl().contains(CheckOutPayment), "different url displayed for payment page");
		ListenerImplementationClass.test.log(Status.INFO, "click on continue shipping and continue payment button and verify CheckOut-payment Page displayed successfully");

		//------click on ship to change link and verify information page	
		checkOutPayment.getChange_Shipping_Address_Link().click();
		webDriverUtil.explicitlyWaitForUrl(driver, CheckOutInformation);
		Assert.assertTrue(driver.getCurrentUrl().contains(CheckOutInformation), "checkout-Information page should display");
		ListenerImplementationClass.test.log(Status.INFO, "Click on 'ship to' change link and CheckOut-Information Page displayed successfully");
		webDriverUtil.explicitlyWaitForElementClick(driver, checkOutInformation.getContinue_To_Shipping_Btn());

		//click on continue shipping and continue payment button and verify payment page
		webDriverUtil.clickDisabledElement(checkOutInformation.getContinue_To_Shipping_Btn(), driver);
		webDriverUtil.explicitlyWaitForElementClick(driver, checkOutShippingPage.getContinue_To_Payment_Btn());
		webDriverUtil.clickDisabledElement(checkOutShippingPage.getContinue_To_Payment_Btn(), driver);
		webDriverUtil.explicitlyWaitForUrl(driver, CheckOutPayment);
		Assert.assertTrue(driver.getCurrentUrl().contains(CheckOutPayment), "different url displayed for payment page");
		ListenerImplementationClass.test.log(Status.INFO, "Click on continue shipping and continue payment button and verify CheckOut-payment Page displayed successfully");

		//click on method change link and verify shipping page
		checkOutPayment.getChange_MethodLink().click();
		webDriverUtil.explicitlyWaitForUrl(driver, CheckOutshipping);
		Assert.assertTrue(driver.getCurrentUrl().contains(CheckOutshipping), "different url displayed for shipping page");
		ListenerImplementationClass.test.log(Status.INFO, "Click on method change link and CheckOut-shipping Page displayed successfully");

		//click on continue payment btn and verify payment page
		webDriverUtil.explicitlyWaitForElementClick(driver, checkOutShippingPage.getContinue_To_Payment_Btn());		
		webDriverUtil.clickDisabledElement(checkOutShippingPage.getContinue_To_Payment_Btn(), driver);
		webDriverUtil.explicitlyWaitForUrl(driver, CheckOutPayment);
		Assert.assertTrue(driver.getCurrentUrl().contains(CheckOutPayment), "different url displayed for payment page");
		ListenerImplementationClass.test.log(Status.INFO, "continue payment button and verify CheckOut-payment Page displayed successfully");

		//click on return to shipping link
		webDriverUtil.clickDisabledElement(checkOutPayment.getReturn_To_Shipping_Link(), driver);	
		webDriverUtil.explicitlyWaitForUrl(driver, CheckOutshipping);
		Assert.assertTrue(driver.getCurrentUrl().contains(CheckOutshipping), "different url displayed for shipping page");
		ListenerImplementationClass.test.log(Status.INFO, "Click on Return to shipping link and CheckOut-shipping Page displayed successfully");


		//click on continue payment btn and verify payment page
		webDriverUtil.explicitlyWaitForElementClick(driver, checkOutShippingPage.getContinue_To_Payment_Btn());		
		webDriverUtil.clickDisabledElement(checkOutShippingPage.getContinue_To_Payment_Btn(), driver);
		webDriverUtil.explicitlyWaitForUrl(driver, CheckOutPayment);
		Assert.assertTrue(driver.getCurrentUrl().contains(CheckOutPayment), "different url displayed for payment page");
		ListenerImplementationClass.test.log(Status.INFO, "continue payment button and verify CheckOut-payment Page displayed successfully");

		checkOutPayment.getcashOnDeliveryRadioBtn().click();
		webDriverUtil.scrollToElement(checkOutPayment.getSame_as_Shipping_address_Radio_Btn(), 1347, 420, driver);
		webDriverUtil.clickDisabledElement(checkOutPayment.getSame_as_Shipping_address_Radio_Btn(), driver);
		Assert.assertTrue(checkOutPayment.getSame_as_Shipping_address_Radio_Btn().isSelected(),"same as shipping method not selected");
		webDriverUtil.scrollBy(1352, 100, driver);
		webDriverUtil.clickDisabledElement(checkOutPayment.getPay_Now_Button(), driver);

		OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
		String orderId = orderConfirmationPage.getOrderId().getText();
		if(orderId.contains(expectedOrderId1))	{
			Assert.assertTrue(orderId.contains(expectedOrderId1));
		}else if(orderId.contains(expectedOrderId2)){
			Assert.assertTrue(orderId.contains(expectedOrderId2));
		}
		ListenerImplementationClass.test.log(Status.INFO, "order placed successfully");
	}
}