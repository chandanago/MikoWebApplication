package com.miko.EndToEndTests;


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
public class MIKO_AI_EE_TC_012 extends BaseClass {

		@Test
		public void MIKO_AI_EE_TC_012_Test()  {

			String homePageUrl = property.readDataFromProperty("URL");
			String CheckOutshipping = property.readDataFromProperty("shipping_CheckoutPage");
			String colorText = excelData.readDataFromExcel("elementText", 1, 2);
			String expectedOrderId1 = excelData.readDataFromExcel("CommonData", 37, 1);
			String expectedOrderId2 = excelData.readDataFromExcel("CommonData", 37, 2);
			
			String firstName = excelData.readDataFromExcel("CommonData", 2, 2);
			String lastName = excelData.readDataFromExcel("CommonData", 3, 2);
			String address = excelData.readDataFromExcel("CommonData", 4, 2);
			String apartment = excelData.readDataFromExcel("CommonData", 5, 2);
			String city = excelData.readDataFromExcel("CommonData", 6, 2);
			String state = excelData.readDataFromExcel("CommonData", 7, 2);
			String zipcode = excelData.readDataFromExcel("CommonData", 8, 2);
			
			//1)Home page should display
			HomePage homePage = new HomePage(driver);
			webDriverUtil.explicitlyWaitForUrl(driver, homePageUrl);
			Assert.assertTrue(driver.getCurrentUrl().contains(homePageUrl),"given url is not entered in the address bar");
			ListenerImplementationClass.test.log(Status.INFO, "Home page is displayed successfully");

			//2)Select the location as United States of America  and click on continue button
			rUsable.selectGeoLocationForUS(driver);

			//3)click on Bottom bar 'Buy Now' button
			webDriverUtil.explicitlyWaitForElementToClick(driver, homePage.getBottombar_redRadioBtn());
			webDriverUtil.clickDisabledElement(homePage.getBottombar_redRadioBtn(), driver);
			String bottomBarPrice = homePage.getBottombar_price().getText();
			webDriverUtil.clickDisabledElement(homePage.getBottombar_BuyNowBtn(), driver);

			//6)Verify shopping cart page details
			ShoppingCartPage shoppingCart = new ShoppingCartPage(driver);
			webDriverUtil.explicitlyWaitForElement(driver, shoppingCart.getSub_Total());
			String subtotalAmt = shoppingCart.getSub_Total().getText();
			String actualColor = shoppingCart.selectColorText(driver, colorText).getText();
			String productPriceOnBottomBar = shoppingCart.getRed_ProductPrice().getText();
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
			
			rUsable.verifyOrderSummaryWithDiscount(driver, subtotalAmt, actualColor, beforeDiscountFinalAmt);
			webDriverUtil.explicitlyWaitForElementClick(driver, checkOutShippingPage.getContinue_To_Payment_Btn());
			webDriverUtil.clickDisabledElement(checkOutShippingPage.getContinue_To_Payment_Btn(), driver);

			//payment
			CheckoutPaymentPage checkOutPayment = new CheckoutPaymentPage(driver);
			rUsable.verifyCheckoutPayment(driver, beforeDiscountFinalAmt, productPrice);
			webDriverUtil.clickDisabledElement(checkOutPayment.getcashOnDeliveryRadioBtn(), driver);			
			webDriverUtil.clickDisabledElement(checkOutPayment.getDifferent_Billing_Address_Radio_Btn(), driver);
			
			checkOutPayment.getFirstName_TxtField().sendKeys(firstName);
			checkOutPayment.getLastName_TxtField().sendKeys(lastName);
			checkOutPayment.getAddress1_TxtField().sendKeys(address);
			checkOutPayment.getAddress2_TxtField().sendKeys(apartment);
			checkOutPayment.getCity_TxtField().sendKeys(city);
			checkOutPayment.getState_dropdwn().sendKeys(state);
			checkOutPayment.getZipCode_TxtField().sendKeys(zipcode);
			
			webDriverUtil.scrollBy(1352, 100, driver);
			webDriverUtil.doubleClickElement(driver, checkOutPayment.getPay_Now_Button());
		
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
