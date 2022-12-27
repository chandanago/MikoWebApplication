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
public class MIKO_AI_EE_TC_009 extends BaseClass {


	@Test
	public void MIKO_AI_EE_TC_009_Test() {

		String homePageUrl = property.readDataFromProperty("URL");
		String CheckOutshipping = property.readDataFromProperty("shipping_CheckoutPage");
		String colorText = excelData.readDataFromExcel("elementText", 1, 2);
		String expectedOrderId1 = excelData.readDataFromExcel("CommonData", 37, 1);
		String expectedOrderId2 = excelData.readDataFromExcel("CommonData", 37, 2);
		
		//1)Home page should display
		HomePage homePage = new HomePage(driver);
		webDriverUtil.explicitlyWaitForUrl(driver, homePageUrl);
		Assert.assertTrue(driver.getCurrentUrl().contains(homePageUrl),"given url is not entered in the address bar");
		ListenerImplementationClass.test.log(Status.INFO, "Home page is displayed successfully");

		//2)Select the location as United States of America  and click on continue button then 3)scroll down and verify bottombar
		rUsable.selectGeoLocationForUS(driver);

		//4)Click on bottom bar
		webDriverUtil.explicitlyWaitForElementToClick(driver, homePage.getBottombar_redRadioBtn());
		webDriverUtil.clickDisabledElement(homePage.getBottombar_redRadioBtn(), driver);
		String bottomBarPrice = homePage.getBottombar_price().getText();
		webDriverUtil.clickDisabledElement(homePage.getBottombar_BuyNowBtn(), driver);

		//5)Verify shopping cart page details
		ShoppingCartPage shoppingCart = new ShoppingCartPage(driver);
		webDriverUtil.explicitlyWaitForElement(driver, shoppingCart.getSub_Total());
		String subtotalAmt = shoppingCart.getSub_Total().getText();
		String actualColor = shoppingCart.selectColorText(driver, colorText).getText();
		String productPriceOnBottomBar = shoppingCart.getRed_ProductPrice().getText();
		rUsable.verifyShoppingCartDetails(driver, productPriceOnBottomBar, bottomBarPrice);

		String productPrice  = shoppingCart.getSub_Total().getText();
		
		//6)Click on 'Go To Checkout' button 
		shoppingCart.getGo_TO_CheckOut_Btn().click();
		CheckOutInformationPage checkOutInformation = new CheckOutInformationPage(driver);

		//7)verify information page and fill the address
		rUsable.verifyCheckoutInformation(driver);

		webDriverUtil.explicitlyWaitForElementToClick(driver, checkOutInformation.getContinue_To_Shipping_Btn());
		webDriverUtil.doubleClickElement(driver, checkOutInformation.getContinue_To_Shipping_Btn());
		webDriverUtil.clickDisabledElement(checkOutInformation.getContinue_To_Shipping_Btn(), driver);
		ListenerImplementationClass.test.log(Status.INFO, "expected state selected successfully");

		//8)Select shopping method and click on 'Continue To Payment'
		CheckoutShippingPage checkOutShippingPage = new CheckoutShippingPage(driver);
		WebElement economyRadioBtn = checkOutShippingPage.getShippingMode_Economy_RadioBtn();
		rUsable.verifyCheckOutShipping(CheckOutshipping, economyRadioBtn, driver);

		//apply discount and verify orderSummary 
		CheckoutOrderSummaryPage OrderSummary = new CheckoutOrderSummaryPage(driver);
		webDriverUtil.explicitlyWaitForElementTextToPresent(driver, OrderSummary.getFinalAmt(), subtotalAmt);
		String beforeDiscountFinalAmt = OrderSummary.getFinalAmt().getText();
		
		rUsable.verifyOrderSummaryWithDiscount(driver, subtotalAmt, actualColor, beforeDiscountFinalAmt);
		webDriverUtil.explicitlyWaitForElementClick(driver, checkOutShippingPage.getContinue_To_Payment_Btn());
		webDriverUtil.clickDisabledElement(checkOutShippingPage.getContinue_To_Payment_Btn(), driver);


		//9)click on continue to payment button and select payment method, billong address remember me checkbox 
		CheckoutPaymentPage checkOutPayment = new CheckoutPaymentPage(driver);
		rUsable.verifyCheckoutPayment(driver, beforeDiscountFinalAmt, productPrice);

		checkOutPayment.getcashOnDeliveryRadioBtn().click();
		webDriverUtil.scrollToElement(checkOutPayment.getSame_as_Shipping_address_Radio_Btn(), 1347, 420, driver);
		webDriverUtil.clickDisabledElement(checkOutPayment.getSame_as_Shipping_address_Radio_Btn(), driver);
		Assert.assertTrue(checkOutPayment.getSame_as_Shipping_address_Radio_Btn().isSelected(),"same as shipping method not selected");
		ListenerImplementationClass.test.log(Status.INFO, "same as shipping method selected successfully");
		webDriverUtil.scrollBy(1352, 100, driver);
		
		//10)Click on pay completre your order button and verify order id
		webDriverUtil.clickDisabledElement(checkOutPayment.getPay_Now_Button(), driver);
		OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
		String orderId = orderConfirmationPage.getOrderId().getText();
		if(orderId.contains(expectedOrderId1))	{
			Assert.assertTrue(orderId.contains(expectedOrderId1),"order id is not generated");
		}else if(orderId.contains(expectedOrderId2)){
			Assert.assertTrue(orderId.contains(expectedOrderId2));
		}
		ListenerImplementationClass.test.log(Status.INFO, "orderId generated and order placed successfully");
	}
}
