package com.miko.EndToEndTests;

import org.openqa.selenium.WebElement;
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
import com.miko.pomRepository.MikoMaxPage;
import com.miko.pomRepository.OrderConfirmationPage;
import com.miko.pomRepository.ShoppingCartPage;

@Listeners(ListenerImplementationClass.class)
public class MIKO_AI_EE_TC_008 extends BaseClass {
	@Test
	public void MIKO_AI_EE_TC_008_Test()  {
		String expectedOrderId1 = excelData.readDataFromExcel("CommonData", 37, 1);
		String expectedOrderId2 = excelData.readDataFromExcel("CommonData", 37, 2);
		//1)Home page should display
		HomePage homePage = new HomePage(driver);
		webDriverUtil.explicitlyWaitForUrl(driver, rUsable.readData().get("homePageUrl"));
		Assert.assertTrue(driver.getCurrentUrl().contains(rUsable.readData().get("homePageUrl")),"given url is not entered in the address bar");
		ListenerImplementationClass.test.log(Status.INFO, "Home page is displayed successfully");

		//2)Select the location as United States of America  and click on continue button
		rUsable.selectGeoLocationForUS(driver);

		MikoMaxPage mikoMax = new MikoMaxPage(driver);
		webDriverUtil.clickDisabledElement(homePage.getMikoMaxBtn(), driver);
		
		webDriverUtil.scrollToWebElement(driver, mikoMax.getYearSubscription_addToCartBtn());
		webDriverUtil.clickDisabledElement(mikoMax.getYearSubscription_addToCartBtn(), driver);
		
		try {
			homePage.getPopupCloseBtn().click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String subscriptionTitle = mikoMax.getYearSubscription_title().getText();

		String subscriptionCost = mikoMax.getYearSubscription_price().getText();
		ListenerImplementationClass.test.log(Status.INFO, "Miko Max 3 months subscription is selected successfully \n"
				+ subscriptionTitle + "\n" + subscriptionCost);

		ShoppingCartPage shoppingCart = new ShoppingCartPage(driver);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		Assert.assertEquals(excelData.readDataFromExcel("CommonData", 18, 1),shoppingCart.getPageTitle().getAttribute("innerText"));
		ListenerImplementationClass.test.log(Status.INFO, "shopping cart overlay displayed successfully");
		
		shoppingCart.getYear_inputQty().isDisplayed();
		ListenerImplementationClass.test.log(Status.INFO, "on shopping cart overlay, 'one time- one year' subscription input Qty displayed successfully");
		
		shoppingCart.getYear_minusBtn().isDisplayed();
		ListenerImplementationClass.test.log(Status.INFO, "on shopping cart overlay, 'one time- one year' subscription minus button displayed successfully");
		
		shoppingCart.getYear_plusBtn().isDisplayed();
		ListenerImplementationClass.test.log(Status.INFO, "on shopping cart overlay, 'one time- one year' subscription plus button displayed successfully");
		
		shoppingCart.getYear_oneYearCard().isSelected();
		ListenerImplementationClass.test.log(Status.INFO, "on shopping cart overlay, 'one time- one year' subscription card is selected successfully");
		
		shoppingCart.getYear_threeMntCard().isDisplayed();
		ListenerImplementationClass.test.log(Status.INFO, "on shopping cart overlay, 'one time- 3 month' subscription card displayed successfully");
		
		shoppingCart.getYear_removeBtn().isDisplayed();
		ListenerImplementationClass.test.log(Status.INFO, "on shopping cart overlay, 'one time- one year' subscription remove button displayed successfully");
		
		String yearSubscriptionPrice = shoppingCart.getYear_price().getText();
		String yearSubscriptionCost = yearSubscriptionPrice.substring(1,4);
		double subscriptionPrice = Double.parseDouble(yearSubscriptionCost);

		String oneYearMaxText = shoppingCart.getYear_oneYearText().getText();

		webDriverUtil.scrollToWebElement(driver, shoppingCart.getAddMiko3Btn());
		webDriverUtil.clickDisabledElement(shoppingCart.getAddMiko3Btn(), driver);
		shoppingCart.getRed_productimg().isDisplayed();
		ListenerImplementationClass.test.log(Status.INFO, "Miko3 subscription and product  is added successfully to the cart");

		shoppingCart.getRed_botClrText().isDisplayed();
		ListenerImplementationClass.test.log(Status.INFO, "on shopping cart overlay, 'Martian red' color Text displayed successfully");
		
		shoppingCart.getRed_minusBtn().isDisplayed();
		ListenerImplementationClass.test.log(Status.INFO, "on shopping cart overlay, 'Martian red' bot minus button displayed successfully");
		
		shoppingCart.getRed_plusBtn().isDisplayed();
		ListenerImplementationClass.test.log(Status.INFO, "on shopping cart overlay, 'Martian red' plus button displayed successfully");
		
		String actualColor = shoppingCart.getRed_botClrText().getText();
		String miko3Price = shoppingCart.getRed_ProductPrice().getText();
		String miko3Price1 = miko3Price.substring(1,5);
		double miko3ProductPrice = Double.parseDouble(miko3Price1);
		Reporter.log(miko3ProductPrice+"miko3 product price",true);
		ListenerImplementationClass.test.log(Status.INFO, "on shopping cart overlay, miko3 bot detail displayed successfully");
		
		//subtotal amount calculation
		double expectedSubTotalAmt1 = miko3ProductPrice + subscriptionPrice;
		String expectedSubTotalAmt = Double.toString(expectedSubTotalAmt1);

		String actualSubTotalAmt = shoppingCart.getSub_Total().getText();
		Assert.assertTrue(actualSubTotalAmt.contains(expectedSubTotalAmt), "actual sub total amount equal to expected sub total amount");
		ListenerImplementationClass.test.log(Status.INFO, "expected subtotal amount equal to actual subtotal amount  \n"
				+ expectedSubTotalAmt + "=\n" + actualSubTotalAmt);

		ListenerImplementationClass.test.log(Status.INFO, "Miko3 subscription and product  is added successfully to the cart");
		String productPrice  = shoppingCart.getSub_Total().getText();


		//7->ii)Click on 'Go To Checkout' button 
		shoppingCart.getGo_TO_CheckOut_Btn().click();
		CheckOutInformationPage checkOutInformation = new CheckOutInformationPage(driver);
		String actualThreeMntMaxText = checkOutInformation.getMaxSubscription_Txt().getText();
		Assert.assertTrue(oneYearMaxText.contains(actualThreeMntMaxText), "different subscription plan is present");
		ListenerImplementationClass.test.log(Status.INFO, "expected subscription plan is selected successfully");

		//verify information page and fill the address
		rUsable.verifyCheckoutInformation(driver);


		webDriverUtil.explicitlyWaitForElementToClick(driver, checkOutInformation.getContinue_To_Shipping_Btn());
		webDriverUtil.doubleClickElement(driver, checkOutInformation.getContinue_To_Shipping_Btn());
		webDriverUtil.clickDisabledElement(checkOutInformation.getContinue_To_Shipping_Btn(), driver);
		ListenerImplementationClass.test.log(Status.INFO, "expected state selected successfully");

		//shipping
		CheckoutShippingPage checkOutShippingPage = new CheckoutShippingPage(driver);
		WebElement economyRadioBtn = checkOutShippingPage.getShippingMode_Economy_RadioBtn();
		String CheckOutshipping = property.readDataFromProperty("shipping_CheckoutPage");
		rUsable.verifyCheckOutShipping(CheckOutshipping, economyRadioBtn, driver);

		//apply discount and verify orderSummary 
		CheckoutOrderSummaryPage OrderSummary = new CheckoutOrderSummaryPage(driver);
		webDriverUtil.explicitlyWaitForElementTextToPresent(driver, OrderSummary.getFinalAmt(), actualSubTotalAmt);
		String beforeDiscountFinalAmt = OrderSummary.getFinalAmt().getText();
		rUsable.verifyOrderSummaryWithDiscount(driver, actualSubTotalAmt, actualColor, beforeDiscountFinalAmt);
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

