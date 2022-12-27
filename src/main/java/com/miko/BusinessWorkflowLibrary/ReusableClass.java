package com.miko.BusinessWorkflowLibrary;

import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.miko.genericLibrary.ExcelUtility;
import com.miko.genericLibrary.JavaUtility;
import com.miko.genericLibrary.ListenerImplementationClass;
import com.miko.genericLibrary.PropertiesClass;
import com.miko.genericLibrary.WebDriverUtilityClass;
import com.miko.pomRepository.CheckOutInformationPage;
import com.miko.pomRepository.CheckoutOrderSummaryPage;
import com.miko.pomRepository.CheckoutPaymentPage;
import com.miko.pomRepository.CheckoutShippingPage;
import com.miko.pomRepository.CreateAccountPage;
import com.miko.pomRepository.HomePage;
import com.miko.pomRepository.LoginPage;
import com.miko.pomRepository.ShoppingCartPage;

public class ReusableClass {
	public WebDriver driver;


	public void login(WebDriver driver) {
		PropertiesClass property = new PropertiesClass();
		String emailId = property.readDataFromProperty("username");
		String password = property.readDataFromProperty("password");
		HomePage homePage= new HomePage(driver);
		LoginPage loginPage= new LoginPage(driver);
		ExcelUtility excelData = new ExcelUtility();
		WebDriverUtilityClass webDriverUtil = new WebDriverUtilityClass();
		String expectedToastMsg = excelData.readDataFromExcel("CommonData", 43, 1);
		homePage.getProfile_Icon().click();
		webDriverUtil.explicitlyWaitForElement(driver, loginPage.getLoginTitleText());
		ListenerImplementationClass.test.log(Status.INFO, "Login pop-up  is displayed successfully");
		loginPage.getEmailTxtField().sendKeys(emailId);
		loginPage.getPasswordTxtField().sendKeys(password);
		loginPage.getLoginBtn().click();
		captureToastMessage(driver, expectedToastMsg);
		ListenerImplementationClass.test.log(Status.INFO, "Login successfully");

	}

	public void creatAccount(WebDriver driver) {
		ExcelUtility excelData = new ExcelUtility();
		String expectedCreatAccntToastMsg = excelData.readDataFromExcel("CommonData", 44, 1);
		String expectedLoginToastMsg= excelData.readDataFromExcel("CommonData", 43, 1);
		WebDriverUtilityClass webDriverUtil = new WebDriverUtilityClass();

		HomePage homePage= new HomePage(driver);
		JavaUtility javaUtil = new JavaUtility();
		webDriverUtil.clickDisabledElement(homePage.getProfile_Icon(), driver);
		LoginPage loginPage= new LoginPage(driver);
		loginPage.getCreateAccountLink().click();
		String randmStr = javaUtil.generateRandomString();
		String emailId = randmStr+"@gmail.com";
		String password = randmStr+"@#45";
		CreateAccountPage creatAccount = new CreateAccountPage(driver);
		creatAccount.getEmailTxtField().sendKeys(emailId);
		creatAccount.getFirstNameTxtField().sendKeys(randmStr+"bh");
		creatAccount.getLastNameTxtField().sendKeys("khan");
		creatAccount.getPasswordTxtField().sendKeys(password);
		creatAccount.getTermsAndConditionsCheckBox().click();
		creatAccount.getCreateAnAccountBtn().click();
		captureToastMessage(driver, expectedCreatAccntToastMsg);
		ListenerImplementationClass.test.log(Status.INFO, "Account Created successfully");

		loginPage.getEmailTxtField().sendKeys(emailId);
		loginPage.getPasswordTxtField().sendKeys(password);
		loginPage.getLoginBtn().click();
		webDriverUtil.explicitlyWaitForElementTextToPresent(driver, homePage.getToastMessage_Text(), "You are successfully logged in");
		captureToastMessage(driver, expectedLoginToastMsg);
		ListenerImplementationClass.test.log(Status.INFO, "Login successfully");
	}


	public void selectGeoLocationForUS(WebDriver driver) {
		ExcelUtility excelData = new ExcelUtility();
		String productPriceOnBottomBar = excelData.readDataFromExcel("CommonData", 14, 4);
		WebDriverUtilityClass webDriverUtil = new WebDriverUtilityClass();
		HomePage homePage= new HomePage(driver);
		String SelectUSFromDropdown = excelData.readDataFromExcel("CommonData", 14, 2);
		webDriverUtil.clickDisabledElement(homePage.getCountryDropDown(), driver);
		webDriverUtil.selectElementByVisibleText(homePage.getCountryDropDown(),SelectUSFromDropdown);
		webDriverUtil.clickDisabledElement(homePage.getContinueBtn(), driver);
		webDriverUtil.scrollBy(1354, 500, driver);
		JavaUtility javaUtil = new JavaUtility();
		javaUtil.keyPress("pagedown");
		Assert.assertTrue(homePage.getBottombar_price().getText().contains(productPriceOnBottomBar));
		ListenerImplementationClass.test.log(Status.INFO, "Product price is displayed as per US dollars on bottom-bar successfully");

		//homePage.getPopupCloseBtn().click();

	}



	public static HashMap<String,String> readData() {
		HashMap<String, String> map = new HashMap<String, String>();
		ExcelUtility excelData = new ExcelUtility();
		PropertiesClass property = new PropertiesClass();

		map.put("Miko3PageUrl", property.readDataFromProperty("Miko3Page_Url"));
		map.put("CheckOutInformation", property.readDataFromProperty("information_CheckoutPage"));
		map.put("CheckOutshipping", property.readDataFromProperty("shipping_CheckoutPage"));
		map.put("CheckOutPayment", property.readDataFromProperty("payment_CheckoutPage"));
		map.put("homePageUrl", property.readDataFromProperty("URL"));
		map.put("email_id", excelData.readDataFromExcel("CommonData", 1, 1));
		map.put("firstName", excelData.readDataFromExcel("CommonData", 2, 1));
		map.put("lastName", excelData.readDataFromExcel("CommonData", 3, 1));
		map.put("address", excelData.readDataFromExcel("CommonData", 4, 1));
		map.put("apartment", excelData.readDataFromExcel("CommonData", 5, 1));
		map.put("city", excelData.readDataFromExcel("CommonData", 6, 1));
		map.put("state", excelData.readDataFromExcel("CommonData", 7, 1));
		map.put("pincode", excelData.readDataFromExcel("CommonData", 8, 1));
		map.put("country", excelData.readDataFromExcel("CommonData", 9, 1));
		map.put("shippingMethod", excelData.readDataFromExcel("CommonData", 11, 1));
		map.put("discountCode", excelData.readDataFromExcel("CommonData", 12, 1));

		map.put("colorText", excelData.readDataFromExcel("elementText", 1, 1));
		map.put("twitterUrl", property.readDataFromProperty("twitter_URL"));
		map.put("twitterTitle", excelData.readDataFromExcel("CommonData", 25, 1));
		map.put("instagramUrl", property.readDataFromProperty("Instagram_URL"));
		map.put("youtubeUrl", property.readDataFromProperty("youtube_URl"));
		map.put("youtubeTitle", excelData.readDataFromExcel("CommonData", 26, 1));
		map.put("linkedinUrl", property.readDataFromProperty("linkedIn_URL"));
		map.put("linkedinTitle", excelData.readDataFromExcel("CommonData", 27, 1));
		map.put("termsAndCondnUrl", property.readDataFromProperty("termsAndConditions_Url"));
		map.put("termsAndCondnTitle", excelData.readDataFromExcel("CommonData", 31, 1));
		map.put("prvtPolicyUrl", property.readDataFromProperty("privacyPolicy_Url"));
		map.put("prvtPolicyTitle", excelData.readDataFromExcel("CommonData", 30, 1));
		map.put("shoppingPolicyUrl", property.readDataFromProperty("shippingpolicy_Url"));
		map.put("shoppingPolicyTitle", excelData.readDataFromExcel("CommonData", 29, 1));
		map.put("dontSellMyInfoUrl", property.readDataFromProperty("don'tSellMyInfo_Url"));
		map.put("dontSellMyInfoTitle", excelData.readDataFromExcel("CommonData", 32, 1));
		map.put("countryDropDown", property.readDataFromProperty("country"));
		map.put("homePageUrl", property.readDataFromProperty("URL"));
		map.put("miko3pageUrl", property.readDataFromProperty("Miko3Page_Url"));
		map.put("miko3pageTitle", property.readDataFromProperty("Miko3Page_Title"));
		map.put("mikoMaxUrl", property.readDataFromProperty("MikoMaxPage_Url"));
		map.put("mikoMaxTitle", property.readDataFromProperty("MikoMax_Title"));
		map.put("techSpectsUrl", property.readDataFromProperty("techSpectsPage"));
		map.put("blogPageUrl", property.readDataFromProperty("blogPage"));
		map.put("mikoBlogTitle", property.readDataFromProperty("MikoBlog_Title"));
		map.put("helpcenterUrl", property.readDataFromProperty("helpCenter_Url"));
		map.put("mikoHelpCenterTitle", property.readDataFromProperty("MikoHelpCenter_Title"));
		map.put("shoppingcartOverlay", property.readDataFromProperty("ShoppingCartOverlay_Title"));
		map.put("shoppingCartOverlayTitle", property.readDataFromProperty("ShoppingCartOverlay_Title"));
		map.put("broucherUrl", property.readDataFromProperty("broucher_Url"));
		map.put("appstoreUrl", property.readDataFromProperty("appStore_URL"));
		map.put("appstoreTitle", excelData.readDataFromExcel("CommonData", 22, 1));
		map.put("playStoreUrl", property.readDataFromProperty("playStore_URL"));
		map.put("playstoreTitle", excelData.readDataFromExcel("CommonData", 23, 1));
		map.put("facebkUrl", property.readDataFromProperty("facebook_URL"));
		map.put("facebkTitle", excelData.readDataFromExcel("CommonData", 24, 1));
		map.put("aboutus_Url", property.readDataFromProperty("aboutUs_Url"));
		return map;
	}


	public void verifyShoppingCartDetails(WebDriver driver, String productPriceOnBottomBar, String bottomBarPrice) {
		ShoppingCartPage shoppingCart = new ShoppingCartPage(driver);
		WebDriverUtilityClass webDriverUtil = new WebDriverUtilityClass();

		webDriverUtil.explicitlyWaitForElement(driver, shoppingCart.getRed_plusBtn());
		Assert.assertTrue(shoppingCart.getRed_plusBtn().isDisplayed(), "shopping cart plus/increment botton is displayed");
		ListenerImplementationClass.test.log(Status.INFO, "On shopping cart overlay, increament button displayed successfully");	
		//Assert.assertEquals(shoppingCart.selectColorText(driver, colorText).getText(), actualColor, "proper product color should be selected");
		//ListenerImplementationClass.test.log(Status.INFO, "expected color is selected successfully");
		Assert.assertTrue(shoppingCart.getRed_minusBtn().isDisplayed(), "shopping cart minus/decrement botton is displayed");
		ListenerImplementationClass.test.log(Status.INFO, "On shopping cart overlay, decrement button displayed successfully");
		String productPrice = shoppingCart.getRed_ProductPrice().getText();
		String subtotalAmt = shoppingCart.getSub_Total().getText();
		Assert.assertTrue(productPrice.contains(productPriceOnBottomBar),"expected product price is displayed successully"); 
		ListenerImplementationClass.test.log(Status.INFO, "product price displyed successfully");
		Assert.assertTrue(subtotalAmt.contains(productPriceOnBottomBar),"expected subtotal amount is not displayed successully"); 
		ListenerImplementationClass.test.log(Status.INFO, "subtotal amount displyed successfully");
	}


	public void verifyShoppingCartDetailsforTwoBot(WebDriver driver, String productPriceOnBottomBar, String bottomBarPrice) {
		ShoppingCartPage shoppingCart = new ShoppingCartPage(driver);
		WebDriverUtilityClass webDriverUtil = new WebDriverUtilityClass();

		webDriverUtil.explicitlyWaitForElement(driver, shoppingCart.getBlue_plusBtn());
		Assert.assertTrue(shoppingCart.getBlue_plusBtn().isDisplayed(), "shopping cart plus/increment botton is displayed not for blue color bot");
		ListenerImplementationClass.test.log(Status.INFO, "On shopping cart overlay, increament button is successfully displayed for blue color bot");	
		Assert.assertTrue(shoppingCart.getBlue_minusBtn().isDisplayed(), "shopping cart minus/decrement botton is not displayed successfully for pixie blue bot");
		ListenerImplementationClass.test.log(Status.INFO, "shopping cart minus/decrement botton is displayed successfully for pixie blue bot");
		String productPrice = shoppingCart.getBlue_ProductPrice().getText();
		String subtotalAmt = shoppingCart.getSub_Total().getText();
		Assert.assertTrue(productPrice.contains(productPriceOnBottomBar),"expected product price is not displayed successully for pixie blue bot"); 
		ListenerImplementationClass.test.log(Status.INFO, "product price displyed successfully for pixie blue bot");

		//miko3 red bot
		webDriverUtil.explicitlyWaitForElement(driver, shoppingCart.getRed_plusBtn());
		Assert.assertTrue(shoppingCart.getRed_plusBtn().isDisplayed(), "shopping cart plus/increment botton is not displayed for maritan red bot");
		ListenerImplementationClass.test.log(Status.INFO, "On shopping cart overlay, increament button displayed successfully for maritan red bot");	
		Assert.assertTrue(shoppingCart.getRed_minusBtn().isDisplayed(), "shopping cart minus/decrement botton is not displayed for maritan red bot");
		ListenerImplementationClass.test.log(Status.INFO, "On shopping cart overlay, decrement button displayed successfully for maritan red bot");
		String redBotProductPrice = shoppingCart.getRed_ProductPrice().getText();
		Assert.assertTrue(redBotProductPrice.contains(productPriceOnBottomBar),"expected product price is not displayed successully"); 
		ListenerImplementationClass.test.log(Status.INFO, "expected product price displyed successfully for maritan red bot");

		//get two bot price
		String blueBotPrice = shoppingCart.getBlue_ProductPrice().getText();
		String redBotPrice = shoppingCart.getRed_ProductPrice().getText();
		blueBotPrice = blueBotPrice.substring(1,6);
		redBotPrice = redBotPrice.substring(1,6);
		//convert two bot price to double
		double blueBotPrice1=Double.parseDouble(blueBotPrice);
		double redBotPrice1=Double.parseDouble(redBotPrice);
		//add two bot price
		double botPrice = blueBotPrice1 + redBotPrice1;
		//convert Double to string
		String expectedTwoBotPrice = Double.toString(botPrice);
		Assert.assertTrue(subtotalAmt.contains(expectedTwoBotPrice),"expected subtotal amount is not displayed successully"); 
		ListenerImplementationClass.test.log(Status.INFO, "subtotal amount displyed suuccessfully on shopping cart overlay"+subtotalAmt);

	}


	public void verifyCheckoutInformation(WebDriver driver) {

		ExcelUtility excelData = new ExcelUtility();
		PropertiesClass property = new PropertiesClass();
		CheckOutInformationPage checkOutInformation = new CheckOutInformationPage(driver);
		String email_id = excelData.readDataFromExcel("CommonData", 1, 1);
		String firstName = excelData.readDataFromExcel("CommonData", 2, 1);
		String lastName = excelData.readDataFromExcel("CommonData", 3, 1);
		String address = excelData.readDataFromExcel("CommonData", 4, 1);
		String apartment = excelData.readDataFromExcel("CommonData", 5, 1);
		String city = excelData.readDataFromExcel("CommonData", 6, 1);
		String state = excelData.readDataFromExcel("CommonData", 7, 1);
		String pincode = excelData.readDataFromExcel("CommonData", 8, 1);
		String country = excelData.readDataFromExcel("CommonData", 9, 1);

		WebDriverUtilityClass webDriverUtil = new WebDriverUtilityClass();
		String CheckOutInformation = property.readDataFromProperty("information_CheckoutPage");
		webDriverUtil.explicitlyWaitForUrl(driver, CheckOutInformation);
		Assert.assertTrue(driver.getCurrentUrl().contains(CheckOutInformation), "checkout-Information page should display");
		ListenerImplementationClass.test.log(Status.INFO, "CheckOut-Information Page displayed successfully");

		checkOutInformation.enterAddress(email_id, firstName, lastName, address, apartment, city, state, pincode);
		Assert.assertEquals(checkOutInformation.getCountry_Drop_Down().getText(), country, "different country name is displayed ");
		ListenerImplementationClass.test.log(Status.INFO, "expected country selected successfully");
		Assert.assertTrue(checkOutInformation.getState_Drop_Down().getText().contains(state), "different country name is displayed ");
		ListenerImplementationClass.test.log(Status.INFO, "expected state selected successfully");
	}



	public void verifyCheckOutShipping(String CheckOutshippingpage, WebElement passWebElmt, WebDriver driver ) {

		CheckoutShippingPage checkOutShippingPage = new CheckoutShippingPage(driver);
		WebDriverUtilityClass webDriverUtil = new WebDriverUtilityClass();
		webDriverUtil.explicitlyWaitForUrl(driver, CheckOutshippingpage);
		Assert.assertTrue(driver.getCurrentUrl().contains(CheckOutshippingpage), "different url displayed for shipping page");
		ListenerImplementationClass.test.log(Status.INFO, "CheckOut-shipping Page displayed successfully");
		passWebElmt.click();
		Assert.assertTrue(passWebElmt.isSelected(), "shipping mode for economy is not selected" );
		ListenerImplementationClass.test.log(Status.INFO, "expected shipping mode selected successfully");
	}

	public void verifyOrderSummaryWithDiscount(WebDriver driver, String subtotalAmt, String actualColor, String beforeDiscountFinalAmt) { 

		//apply discount and verify orderSummary 
		ExcelUtility excelData = new ExcelUtility();
		CheckoutOrderSummaryPage OrderSummary = new CheckoutOrderSummaryPage(driver);
		String discountCode = excelData.readDataFromExcel("CommonData", 12, 1);
		Assert.assertEquals(beforeDiscountFinalAmt, subtotalAmt, "different amount found");
		ListenerImplementationClass.test.log(Status.INFO, "expected amount is displayed successfully on ordersummary section");
		String prodClr = OrderSummary.getProductClr().getText();
		Assert.assertEquals(prodClr, actualColor, "different color is displayed");
		ListenerImplementationClass.test.log(Status.INFO, "expected product color is displayed successfully on ordersummary section");
		OrderSummary.getDiscount_Code_TxtField().sendKeys(discountCode);
		WebDriverUtilityClass webDriverUtil = new WebDriverUtilityClass();
		webDriverUtil.explicitlyWaitForElementClick(driver, OrderSummary.getApplyBtn());
		OrderSummary.getApplyBtn().click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}



	public void verifyCheckoutPayment(WebDriver driver, String beforeDiscountFinalAmt, String productPrice ) {
		PropertiesClass property = new PropertiesClass();
		ExcelUtility excelData = new ExcelUtility();
		String CheckOutPayment = property.readDataFromProperty("payment_CheckoutPage");
		WebDriverUtilityClass webDriverUtil = new WebDriverUtilityClass();
		CheckoutOrderSummaryPage OrderSummary = new CheckoutOrderSummaryPage(driver);
		CheckoutPaymentPage checkOutPayment = new CheckoutPaymentPage(driver);

		webDriverUtil.explicitlyWaitForUrl(driver, CheckOutPayment);
		Assert.assertTrue(driver.getCurrentUrl().contains(CheckOutPayment), "different url displayed for payment page");
		ListenerImplementationClass.test.log(Status.INFO, "CheckOut-payment Page displayed successfully");

		String afterDiscount_FinalAmt = OrderSummary.getFinalAmt().getText();
		Assert.assertNotEquals(afterDiscount_FinalAmt, beforeDiscountFinalAmt, "after and before should not match");
		ListenerImplementationClass.test.log(Status.INFO, "expected discount amount is displayed successfully once after applying the discount code");

		String productPrice1 = productPrice.substring(1, 5);
		double productPrice2 = Double.parseDouble(productPrice1);
		double dicountAmt = productPrice2-(productPrice2/10);

		String expectedDicountedAmt = String.valueOf(dicountAmt).substring(0, 3);
		Assert.assertTrue(afterDiscount_FinalAmt.contains(expectedDicountedAmt), "different final amount is displayed");
		ListenerImplementationClass.test.log(Status.INFO, "Discount applied successfully");

		String email_id = excelData.readDataFromExcel("CommonData", 1, 1);
		String pincode = excelData.readDataFromExcel("CommonData", 8, 1);
		String shippingMethod = excelData.readDataFromExcel("CommonData", 11, 1);

		Assert.assertTrue(checkOutPayment.getContact_Mail().getText().contains(email_id));
		ListenerImplementationClass.test.log(Status.INFO, "proper contact info displayed successfully");
		Assert.assertTrue(checkOutPayment.getShip_To_address().getText().contains(pincode));
		ListenerImplementationClass.test.log(Status.INFO, "proper shipto address displayed successfully");
		Assert.assertTrue(checkOutPayment.getSelected_Methodmode_Txt().getText().contains(shippingMethod));
		ListenerImplementationClass.test.log(Status.INFO, "proper shipping method selected successfully");
	}

	public void captureToastMessage(WebDriver driver, String expectedToastMsg) {
		HomePage homePage = new HomePage(driver);
		WebDriverUtilityClass webDriverUtil = new WebDriverUtilityClass();
		webDriverUtil.explicitlyWaitForElement(driver, homePage.getToastMessage_Text());
		String toastText = homePage.getToastMessage_Text().getText();
		Assert.assertEquals(toastText, expectedToastMsg, "different toast message is displayed");
		ListenerImplementationClass.test.log(Status.INFO, "expected toast message displayed successfully");
		
	}


	public void verifyPaypal(WebDriver driver) {
		PropertiesClass property = new PropertiesClass();
		CheckOutInformationPage checkOutInformation = new CheckOutInformationPage(driver);
		CheckoutPaymentPage checkOutPayment = new CheckoutPaymentPage(driver);
		WebDriverUtilityClass webDriverUtil = new WebDriverUtilityClass();
		ExcelUtility excelData = new ExcelUtility();
		String paypalUrl = property.readDataFromProperty("payPal");

		String payPalTitle = excelData.readDataFromExcel("CommonData", 38, 1);
		String currentHandle = driver.getWindowHandle();

		checkOutPayment.getPayPalRadioBtn().click();
		webDriverUtil.explicitlyWaitForElementClick(driver, checkOutInformation.getPayPal_btn());
		checkOutInformation.getPayPal_btn().click();

		Set<String> handles = driver.getWindowHandles(); 
		for (String handle : handles) 
		{ 
			if (!handle .equals(currentHandle)) 
			{ 
				driver.switchTo().window(handle); 	    
				webDriverUtil.explicitlyWaitForPage(driver, payPalTitle);
				Assert.assertEquals(driver.getTitle(), payPalTitle, "paypal page is not displayed");
				ListenerImplementationClass.test.log(Status.INFO, "paypal page is displayed successfully");
				
				//-------------------------paypal credential needed
				checkOutPayment.getPayPal_emailaddressTextField().sendKeys("ftgyuh@gmail.com");
				Assert.assertTrue(driver.getCurrentUrl().contains(paypalUrl), "pay pal login page is displayed");
				ListenerImplementationClass.test.log(Status.INFO, "paypal login page is displayed successfully");
				driver.close(); 
			} 
			driver.switchTo().window(currentHandle); 
		}
	}
	
	public void currencyVerification() {
		
		
		
		
		
		
	}
	
	
	
}

