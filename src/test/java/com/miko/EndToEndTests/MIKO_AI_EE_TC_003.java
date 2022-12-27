package com.miko.EndToEndTests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
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
import com.miko.pomRepository.Miko3Page;
import com.miko.pomRepository.OrderConfirmationPage;
import com.miko.pomRepository.ShoppingCartPage;

@Listeners(ListenerImplementationClass.class)
public class MIKO_AI_EE_TC_003 extends BaseClass {

	@Test
	public void MIKO_AI_EE_TC_003_Test() {

		Miko3Page productPage = new Miko3Page(driver);
		String Miko3PageUrl = property.readDataFromProperty("Miko3Page_Url");
		String CheckOutshipping = property.readDataFromProperty("shipping_CheckoutPage");
		
		String homePageUrl = property.readDataFromProperty("URL");
		String productPriceOnBottomBar = excelData.readDataFromExcel("CommonData", 14, 4);
		String colorText = excelData.readDataFromExcel("elementText", 1, 2);
		String expectedOrderId1 = excelData.readDataFromExcel("CommonData", 37, 1);
		String expectedOrderId2 = excelData.readDataFromExcel("CommonData", 37, 2);

		//1)Home page should display
		HomePage homePage = new HomePage(driver);
		webDriverUtil.explicitlyWaitForUrl(driver, homePageUrl);
		
		Assert.assertTrue(driver.getCurrentUrl().contains(homePageUrl),"given url is not entered in the address bar");
		ListenerImplementationClass.test.log(Status.INFO, "Home page is displayed successfully");

		//2)Select the location as United States of America  and click on continue button
		rUsable.selectGeoLocationForUS(driver);

		//3) Click on 'Buy Now' Button
		webDriverUtil.clickDisabledElement(homePage.getBuyNowBtn(), driver);
		webDriverUtil.explicitlyWaitForUrl(driver, Miko3PageUrl);
		Assert.assertTrue(driver.getCurrentUrl().contains(Miko3PageUrl), "different url is displayed for miko3 page");
		ListenerImplementationClass.test.log(Status.INFO, "Miko3 tab is displayed successfully");


		//4) On Miko3 Tab, select bot color Red/Blue Color radio button, select Quantity,  if required select Max subscription 
		webDriverUtil.explicitlyWaitForElementClick(driver, productPage.getRedColor_Btn());
		webDriverUtil.clickDisabledElement(productPage.getRedColor_Btn(), driver);   

		String actualQty = productPage.getQuantity().getText();
		webDriverUtil.scrollBy(1352, 240, driver);

		String bottomBarPrice = homePage.getBottombar_price().getText();
		//5) Click on 'Buy Now' button  
		webDriverUtil.clickDisabledElement(productPage.getBuyNow_Btn(), driver);

		//6)Verify shopping cart page details
		ShoppingCartPage shoppingCart = new ShoppingCartPage(driver);
		webDriverUtil.explicitlyWaitForElement(driver, shoppingCart.getSub_Total());
		String subtotalAmt = shoppingCart.getSub_Total().getText();
		Reporter.log(subtotalAmt+"subtotalAmt",true);
		rUsable.verifyShoppingCartDetails(driver, productPriceOnBottomBar, bottomBarPrice);

		String productPrice  = shoppingCart.getSub_Total().getText();
		
		//7->ii)Click on 'Go To Checkout' button 
		shoppingCart.getGo_TO_CheckOut_Btn().click();
		CheckOutInformationPage checkOutInformation = new CheckOutInformationPage(driver);

		//verify information page and fill the address
		rUsable.verifyCheckoutInformation(driver);

		webDriverUtil.explicitlyWaitForElementToClick(driver, checkOutInformation.getContinue_To_Shipping_Btn());
		webDriverUtil.doubleClickElement(driver, checkOutInformation.getContinue_To_Shipping_Btn());
		webDriverUtil.clickDisabledElement(checkOutInformation.getContinue_To_Shipping_Btn(), driver);
		ListenerImplementationClass.test.log(Status.INFO, "expected state selected successfully");

		//shipping
		CheckoutShippingPage checkOutShippingPage = new CheckoutShippingPage(driver);
		WebElement economyRadioBtn = checkOutShippingPage.getShippingMode_Economy_RadioBtn();
		rUsable.verifyCheckOutShipping(CheckOutshipping, economyRadioBtn, driver);

		//apply discount and verify orderSummary 
		CheckoutOrderSummaryPage OrderSummary = new CheckoutOrderSummaryPage(driver);
		webDriverUtil.explicitlyWaitForElementTextToPresent(driver, OrderSummary.getFinalAmt(), subtotalAmt);
		String beforeDiscountFinalAmt = OrderSummary.getFinalAmt().getText();
		rUsable.verifyOrderSummaryWithDiscount(driver, subtotalAmt, colorText, beforeDiscountFinalAmt);
		webDriverUtil.explicitlyWaitForElementClick(driver, checkOutShippingPage.getContinue_To_Payment_Btn());
		webDriverUtil.clickDisabledElement(checkOutShippingPage.getContinue_To_Payment_Btn(), driver);

		//payment
		CheckoutPaymentPage checkOutPayment = new CheckoutPaymentPage(driver);
		rUsable.verifyCheckoutPayment(driver, beforeDiscountFinalAmt, productPrice);

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
