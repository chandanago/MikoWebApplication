package com.miko.EndToEndTests;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.miko.genericLibrary.BaseClass;
import com.miko.genericLibrary.ListenerImplementationClass;
import com.miko.pomRepository.FooterPageELementsPom;
import com.miko.pomRepository.HomePage;
import com.miko.pomRepository.LoginPage;
import com.miko.pomRepository.Miko3Page;
import com.miko.pomRepository.MikoMaxPage;
import com.miko.pomRepository.ShoppingCartPage;

@Listeners(ListenerImplementationClass.class)



public class MIKO_AI_EE_TC_010 extends BaseClass {
	@Parameters({"env"})
	@Test
	public void MIKO_AI_EE_TC_010_Test(String env) throws InterruptedException {

		
		ShoppingCartPage shoppingCart = new ShoppingCartPage(driver);
		driver.get(env);
		
		/* Verify home page is displayed */
		Assert.assertTrue(driver.getCurrentUrl().contains(env),
				"Home page is not loaded");
		ListenerImplementationClass.test.log(Status.INFO, "Home page is Loaded successfully-->"+driver.getCurrentUrl());
		HomePage homePage = new HomePage(driver);
		
	//	rUsable.selectGeoLocationForUS(driver);
		String productPriceOnBottomBar = excelData.readDataFromExcel("CommonData", 14, 4);
		Assert.assertTrue(homePage.getBottombar_price().getText().contains(productPriceOnBottomBar));
		ListenerImplementationClass.test.log(Status.INFO, "Product price is displayed on bottom-bar successfully");
		
		Assert.assertTrue(homePage.getMikologo().isDisplayed());
		ListenerImplementationClass.test.log(Status.INFO,
				"Miko3 Logo is displayed in the Home page Verified successfully");
		
		Assert.assertTrue(homePage.getMiko3Btn().isDisplayed());
		ListenerImplementationClass.test.log(Status.INFO,
				"Miko3 Tab is displayed in the Home page Verified successfully");
		
		Assert.assertTrue(homePage.getMikoMaxBtn().isDisplayed());
		ListenerImplementationClass.test.log(Status.INFO,
				"Miko Max Tab is displayed in the Home page Verified successfully");
		
		Assert.assertTrue(homePage.getTechSpecsBtn().isDisplayed());
		ListenerImplementationClass.test.log(Status.INFO,
				"Tech Specs  Tab is displayed in the Home page Verified successfully");
	
		Assert.assertTrue(homePage.getTrackYourOrderBtn().isDisplayed());
		ListenerImplementationClass.test.log(Status.INFO,
				"Track Your Order Tab is displayed in the Home page Verified successfully");
		
		Assert.assertTrue(homePage.getBlogBtn().isDisplayed());
		ListenerImplementationClass.test.log(Status.INFO,
				"Blog Tab is displayed in the Home page Verified successfully");
		
		Assert.assertTrue(homePage.getHelpCenterBtn().isDisplayed());
		ListenerImplementationClass.test.log(Status.INFO,
				"Help Center Tab is displayed in the Home page Verified successfully");
	
		Assert.assertTrue(homePage.getCartBtn().isDisplayed());
		ListenerImplementationClass.test.log(Status.INFO,
				"Shopping Cart Icon  is displayed in the Home page Verified successfully");
	
		Assert.assertTrue(homePage.getProfile_Icon().isDisplayed());
		ListenerImplementationClass.test.log(Status.INFO,
				"Profile Icon  is displayed in the Home page Verified successfully");
	
		Assert.assertTrue(homePage.getBuyNowBtn().isDisplayed());
		ListenerImplementationClass.test.log(Status.INFO,
				"Add To Cart button  is displayed in the Home page Header  Verified successfully");
		
		Assert.assertTrue(homePage.getBuyNowBtn().isDisplayed());
		ListenerImplementationClass.test.log(Status.INFO,
				"Buy Now button  is displayed in the Home page body  Verified successfully");
	
		Assert.assertTrue(homePage.getBottom_bar_text().isDisplayed());
		ListenerImplementationClass.test.log(Status.INFO,
				"Bottom Bar Text is displayed in the Home page body  Verified successfully --> "
						+ homePage.getBottom_bar_text().getAttribute("innerText"));
	
		Assert.assertTrue(homePage.getBottombar_price().isDisplayed());
		ListenerImplementationClass.test.log(Status.INFO,
				"Bottom Bar price is displayed in the Home page body  Verified successfully -->"
						+ homePage.getBottombar_price().getAttribute("innerText"));
	
		Assert.assertTrue(homePage.getBottombar_redRadioBtn().isDisplayed());
		ListenerImplementationClass.test.log(Status.INFO,
				"Bottom Bar Martian Red radio button is displayed in the Home page body  Verified successfully ");
	
		Assert.assertTrue(homePage.getBottombar_blueRadioBtn().isDisplayed());
		ListenerImplementationClass.test.log(Status.INFO,
				"Bottom Bar Pixie Blue radio button is displayed in the Home page body  Verified successfully ");
	
		Assert.assertTrue(homePage.getBottombar_BuyNowBtn().isDisplayed());
		ListenerImplementationClass.test.log(Status.INFO,
				"Bottom Bar Add To Cart button is displayed in the Home page body  Verified successfully ");
		
		
		/* Verify Miko 3 Tab */

		webDriverUtil.clickDisabledElement(homePage.getMiko3Btn(), driver);
		webDriverUtil.explicitlyWaitForUrl(driver, rUsable.readData().get("miko3pageUrl"));
		Assert.assertTrue(driver.getCurrentUrl().contains( rUsable.readData().get("miko3pageUrl"))  );
		webDriverUtil.explicitlyWaitForPage(driver, rUsable.readData().get("miko3pageTitle"));
		Assert.assertEquals(driver.getTitle(), rUsable.readData().get("miko3pageTitle"));
		ListenerImplementationClass.test.log(Status.INFO,
				"Miko3 Tab navigated to Miko 3 page , miko 3 page is displayed successfully");
		
		
		/* Verify Miko max Tab */
		webDriverUtil.clickDisabledElement(homePage.getMikoMaxBtn(), driver);
		webDriverUtil.explicitlyWaitForUrl(driver, rUsable.readData().get("mikoMaxUrl"));
		Assert.assertTrue(driver.getCurrentUrl().contains(rUsable.readData().get("mikoMaxUrl")));
		webDriverUtil.explicitlyWaitForPage(driver, rUsable.readData().get("mikoMaxTitle"));
		Assert.assertEquals(driver.getTitle(), rUsable.readData().get("mikoMaxTitle"));
		ListenerImplementationClass.test.log(Status.INFO,
				"Miko Max Tab navigated to Miko Max page successfully");
		
		/* Verify Tech Specs Tab */
		webDriverUtil.clickDisabledElement(homePage.getTechSpecsBtn(), driver);
		webDriverUtil.explicitlyWaitForUrl(driver, rUsable.readData().get("techSpectsUrl"));
		Assert.assertTrue(driver.getCurrentUrl().contains(rUsable.readData().get("techSpectsUrl")));
		webDriverUtil.explicitlyWaitForPage(driver, rUsable.readData().get("miko3pageTitle"));
		Assert.assertEquals(driver.getTitle(), rUsable.readData().get("miko3pageTitle"));
		ListenerImplementationClass.test.log(Status.INFO,
				"Tech Specs Tab navigated to Tech Specs page and displayed successfully");
	
		String ParentWindow = driver.getWindowHandle();

		/* Verify Blog Tab */
		webDriverUtil.clickDisabledElement(homePage.getBlogBtn(), driver);
		webDriverUtil.switchToWindowWithUrl(driver, rUsable.readData().get("blogPageUrl"));
		webDriverUtil.explicitlyWaitForUrl(driver, rUsable.readData().get("blogPageUrl"));

		Assert.assertTrue(driver.getCurrentUrl().contains( rUsable.readData().get("blogPageUrl")));
		webDriverUtil.explicitlyWaitForPage(driver, rUsable.readData().get("mikoBlogTitle"));
		Assert.assertEquals(driver.getTitle(), rUsable.readData().get("mikoBlogTitle"));
		ListenerImplementationClass.test.log(Status.INFO,
				"Blog Tab navigated to Miko Blog page and displayed page successfully");
		driver.close();
		webDriverUtil.switchWindow(driver, ParentWindow);

		/* Verify Help Center Tab */
		webDriverUtil.clickDisabledElement(homePage.getHelpCenterBtn(), driver);
		webDriverUtil.switchToWindowWithUrl(driver, rUsable.readData().get("helpcenterUrl"));
		webDriverUtil.explicitlyWaitForUrl(driver, rUsable.readData().get("helpcenterUrl"));

		Assert.assertTrue(driver.getCurrentUrl().contains(rUsable.readData().get("helpcenterUrl")));
		Assert.assertEquals(driver.getTitle(), rUsable.readData().get("mikoHelpCenterTitle"));
		ListenerImplementationClass.test.log(Status.INFO,
				"Help Center Tab navigated to Miko Help Center page , page is displayed successfully");
		driver.close();
		webDriverUtil.switchWindow(driver, ParentWindow);

		/* Verify Shopping Cart icon */
		webDriverUtil.clickDisabledElement(homePage.getCartBtn(), driver);
	    Assert.assertTrue(shoppingCart.getPageTitle().getAttribute("innerText")
				.contains(rUsable.readData().get("shoppingCartOverlayTitle")));
		ListenerImplementationClass.test.log(Status.INFO,
				" Click on Shopping Cart icon has successfully displayed Shopping Cart overlay");
	    shoppingCart.getCloseButton().click();

		/* Verify Profile icon */
		webDriverUtil.clickDisabledElement(homePage.getProfile_Icon(), driver);
		LoginPage login = new LoginPage(driver);
		Assert.assertTrue(login.getLoginTitleText().getAttribute("innerText").contains("Login"));
		Assert.assertTrue(login.getEmailTxtField().isDisplayed());
		Assert.assertTrue(login.getPasswordTxtField().isDisplayed());
		Assert.assertTrue(login.getEmailTxtField().isDisplayed());
		Assert.assertTrue(login.getForgotPasswordLink().isDisplayed());
		Assert.assertTrue(login.getLoginBtn().isDisplayed());
		Assert.assertTrue(login.getCreateAccountLink().isDisplayed());    

		ListenerImplementationClass.test.log(Status.INFO,
				" Click on Profile icon has successfully displayed Login page ");
		
		login.getCloseBtn().click();
		/* Verify buy now icon */
		webDriverUtil.clickDisabledElement(homePage.getBuyNowBtn(), driver);
		Miko3Page productPage = new Miko3Page(driver);
		Assert.assertTrue(driver.getCurrentUrl().contains(rUsable.readData().get("miko3pageUrl")));
		Assert.assertEquals(driver.getTitle(), rUsable.readData().get("miko3pageTitle"));
		ListenerImplementationClass.test.log(Status.INFO,
				"header 'BuyNow' button has navigated to Miko 3 Detail Page successfully");
		
		
		webDriverUtil.scrollBy(1034, 400, driver);

		// 4) On Miko3 Tab, select bot color Red/Blue Color radio button, select
		// Quantity, if required select Max subscription
		webDriverUtil.explicitlyWaitForElementToClick(driver, productPage.getBlueColor_Btn());
		webDriverUtil.clickDisabledElement(productPage.getBlueColor_Btn(), driver);
		
		String actualQty = productPage.getQuantity().getAttribute("innerText");
		
		webDriverUtil.scrollBy(1034, 100, driver);
		
		webDriverUtil.explicitlyWaitForElementClick(driver, homePage.getPopupCloseBtn());
		webDriverUtil.clickDisabledElement(homePage.getPopupCloseBtn(), driver);
		
		// 5) Click on miko3 page 'Buy Now' button.
		webDriverUtil.explicitlyWaitForElement(driver, productPage.getBuyNow_Btn());
		webDriverUtil.clickDisabledElement(productPage.getBuyNow_Btn(), driver);
		
		Assert.assertEquals(actualQty, shoppingCart.getBlue_inputQty().getAttribute("innerText"));
		ListenerImplementationClass.test.log(Status.INFO,
				"Proper product Quantity displyed successfully");
		webDriverUtil.clickDisabledElement(shoppingCart.getCloseButton(), driver);
		  
		
		/*
		 * 
		 * miko max page link
		 */
		MikoMaxPage mikomax = new MikoMaxPage(driver);
		webDriverUtil.clickDisabledElement(homePage.getMikoMaxBtn(), driver);

		/*month subscription*/
		webDriverUtil.scrollToWebElement(driver, mikomax.getMonthSubscription_addToCartBtn());
		webDriverUtil.clickDisabledElement(mikomax.getMonthSubscription_addToCartBtn(), driver);
		
		Assert.assertTrue(shoppingCart.getPageTitle().getAttribute("innerText")
				.contains(rUsable.readData().get("shoppingcartOverlay")));
		ListenerImplementationClass.test.log(Status.INFO,
				"Click on 3 month subscription 'add to cart' button has successfully displayed Shopping Cart overlay");
		webDriverUtil.clickDisabledElement(shoppingCart.getCloseButton(), driver);
		
			
		/*Annual subscription*/
		webDriverUtil.explicitlyWaitForElement(driver, mikomax.getYearSubscription_addToCartBtn());
		webDriverUtil.clickDisabledElement(mikomax.getYearSubscription_addToCartBtn(), driver);
		Assert.assertTrue(shoppingCart.getPageTitle().getAttribute("innerText")
				.contains(rUsable.readData().get("shoppingCartOverlayTitle")));
		ListenerImplementationClass.test.log(Status.INFO,
				"Click on year subscription 'add to cart' button has successfully displayed Shopping Cart overlay");

		webDriverUtil.clickDisabledElement(shoppingCart.getCloseButton(), driver);
		
		webDriverUtil.scrollToElement(homePage.getMikologo(), 1320, -530, driver);
		webDriverUtil.moveToElementUsingCoordinates(driver, 79, 25);
		webDriverUtil.clickDisabledElement(homePage.getMikologo(), driver);
		webDriverUtil.explicitlyWaitForUrl(driver, rUsable.readData().get("homePageUrl"));
		Assert.assertTrue(driver.getCurrentUrl().contains(rUsable.readData().get("homePageUrl")), "home page is not displayed");


		/*Footer element verification*/
			
		webDriverUtil.implicitWait(driver);

		javaUtil.keyPress("END");
		webDriverUtil.explicitlyWaitForElement(driver, homePage.getFooter_Miko3_Logo());
		Assert.assertTrue(homePage.getFooter_Miko3_Logo().isDisplayed(), "Logo is not displayed in footer of the page");
		ListenerImplementationClass.test.log(Status.INFO, "Miko3 Logo is displayed in footer of the page");

		javaUtil.keyPress("END");
		javaUtil.keyPress("pagedown");
		
		webDriverUtil.clickDisabledElement(homePage.getAboutUs_Link(), driver); // footer.getAboutUs_Link().click();
	
		webDriverUtil.explicitlyWaitForUrl(driver, env+rUsable.readData().get("aboutus_Url"));
		Assert.assertTrue(driver.getCurrentUrl().contains(rUsable.readData().get("aboutus_Url")),
				"about Us link is broken");
		ListenerImplementationClass.test.log(Status.INFO, "about Us link is displayed and Verified Successfully");
		String miko3Window = driver.getWindowHandle();

		javaUtil.keyPress("END");
		
		webDriverUtil.clickDisabledElement(homePage.getHelp_Center_Link(), driver);
		webDriverUtil.switchToWindowWithUrl(driver, env+rUsable.readData().get("helpcenterUrl"));
		//webDriverUtil.explicitlyWaitForUrl(driver, rUsable.readData().get(env+"helpcenterUrl"));
		Assert.assertTrue(rUsable.readData().get("helpcenterUrl").contains(driver.getCurrentUrl()),
				"Help Center link is broken");
		driver.close();
		ListenerImplementationClass.test.log(Status.INFO, "Help Center link is displayed and Verified Successfully");
		driver.switchTo().window(miko3Window);
		
		javaUtil.keyPress("END");
		webDriverUtil.clickDisabledElement(homePage.getBroucher_Link(), driver);
		
		webDriverUtil.switchToWindowWithUrl(driver, env+rUsable.readData().get("broucherUrl"));
		//webDriverUtil.explicitlyWaitForUrl(driver, env+rUsable.readData().get("broucherUrl"));
		Assert.assertTrue(rUsable.readData().get("broucherUrl").contains(driver.getCurrentUrl()),
				"Broucher link is broken");
		driver.close();
		ListenerImplementationClass.test.log(Status.INFO, "Broucher link is displayed and Verified Successfully");
		driver.switchTo().window(miko3Window);

		javaUtil.keyPress("END");
		webDriverUtil.clickDisabledElement(homePage.getAppStore_Link(), driver);
		//footer.getAppStore_Link().click();
		webDriverUtil.switchToWindowWithUrl(driver, rUsable.readData().get("appstoreUrl"));
		webDriverUtil.explicitlyWaitForUrl(driver, rUsable.readData().get("appstoreUrl"));
		Assert.assertTrue(rUsable.readData().get("appstoreUrl").contains(driver.getCurrentUrl()),
				"App Store Link is broken");
		
		
		
		webDriverUtil.explicitlyWaitForPage(driver, rUsable.readData().get("appstoreTitle"));
		Assert.assertTrue(driver.getTitle().contains(rUsable.readData().get("appstoreTitle")));
		driver.close();
		ListenerImplementationClass.test.log(Status.INFO, "AppStore link is displayed and Verified Successfully");
		driver.switchTo().window(miko3Window);

		javaUtil.keyPress("END");
		webDriverUtil.clickDisabledElement(homePage.getPlayStore_Link(), driver);
		webDriverUtil.switchToWindowWithUrl(driver, rUsable.readData().get("playStoreUrl"));
		webDriverUtil.explicitlyWaitForUrl(driver, rUsable.readData().get("playStoreUrl"));
		Assert.assertTrue(rUsable.readData().get("playStoreUrl").contains(driver.getCurrentUrl()),
				"Play Store Link is broken");
		webDriverUtil.explicitlyWaitForPage(driver, rUsable.readData().get("playstoreTitle"));
		Assert.assertEquals(driver.getTitle(), rUsable.readData().get("playstoreTitle"));
		driver.close();
		ListenerImplementationClass.test.log(Status.INFO, "PlayStore link is displayed and Verified Successfully");
		driver.switchTo().window(miko3Window);

		javaUtil.keyPress("END");
		//// webDriverUtil.mouseHoveOnElement(driver, footer.getFacebook_Icon());
		webDriverUtil.clickDisabledElement(homePage.getFacebook_Icon(), driver);
		webDriverUtil.switchToWindowWithUrl(driver, rUsable.readData().get("facebkUrl"));
		webDriverUtil.explicitlyWaitForUrl(driver, rUsable.readData().get("facebkUrl"));
		Assert.assertTrue(rUsable.readData().get("facebkUrl").contains(driver.getCurrentUrl()),
				"Facebook link is broken");
		webDriverUtil.explicitlyWaitForPage(driver, rUsable.readData().get("facebkTitle"));
		Assert.assertEquals(driver.getTitle(), rUsable.readData().get("facebkTitle"));
		driver.close();
		ListenerImplementationClass.test.log(Status.INFO, "Facebook link is displayed and Verified Successfully");
		driver.switchTo().window(miko3Window);


		javaUtil.keyPress("END");
		//// webDriverUtil.mouseHoveOnElement(driver, footer.getTwitter_Icon());
		webDriverUtil.clickDisabledElement(homePage.getTwitter_Icon(), driver);
		webDriverUtil.switchToWindowWithUrl(driver, rUsable.readData().get("twitterUrl"));
		webDriverUtil.explicitlyWaitForUrl(driver, rUsable.readData().get("twitterUrl"));
		Assert.assertTrue(rUsable.readData().get("twitterUrl").contains(driver.getCurrentUrl()),
				"Twitter link is broken");
		//webDriverUtil.explicitlyWaitForPage(driver, twitterTitle);
		//Assert.assertEquals(driver.getTitle(), twitterTitle);
		
		driver.close();
		ListenerImplementationClass.test.log(Status.INFO, "Twitter link is displayed and Verified Successfully");
		driver.switchTo().window(miko3Window);

		javaUtil.keyPress("END");
		//// webDriverUtil.mouseHoveOnElement(driver, footer.getInstagram_Icon());
		webDriverUtil.clickDisabledElement(homePage.getInstagram_Icon(), driver);
		webDriverUtil.switchToWindowWithUrl(driver, rUsable.readData().get("instagramUrl"));
		webDriverUtil.explicitlyWaitForUrl(driver, rUsable.readData().get("instagramUrl"));
		Assert.assertTrue(rUsable.readData().get("instagramUrl").contains(driver.getCurrentUrl()),
				"Instagram link is broken");

		//	webDriverUtil.explicitlyWaitForPage(driver, excelData.readDataFromExcel("CommonData", 28, 1));
		//	Assert.assertTrue(driver.getTitle().contains(excelData.readDataFromExcel("CommonData", 28, 1)));
		driver.close();
		driver.switchTo().window(miko3Window);
		ListenerImplementationClass.test.log(Status.INFO, "Instagram link is displayed and Verified Successfully");
		driver.switchTo().window(miko3Window);

		javaUtil.keyPress("END");
		webDriverUtil.clickDisabledElement(homePage.getYouTube_Icon(), driver);
		webDriverUtil.switchToWindowWithUrl(driver, rUsable.readData().get("youtubeUrl"));
		webDriverUtil.explicitlyWaitForUrl(driver, rUsable.readData().get("youtubeUrl"));
		Assert.assertTrue(rUsable.readData().get("youtubeUrl").contains(driver.getCurrentUrl()),
				"Youtube link is broken");
		webDriverUtil.explicitlyWaitForPage(driver, rUsable.readData().get("youtubeTitle"));
		Assert.assertEquals(driver.getTitle(), rUsable.readData().get("youtubeTitle"));
		driver.close();
		ListenerImplementationClass.test.log(Status.INFO, "YouTube link is displayed and Verified Successfully");
		driver.switchTo().window(miko3Window);

		javaUtil.keyPress("END");
		webDriverUtil.clickDisabledElement(homePage.getLinkedIn_Icon(), driver);
		webDriverUtil.switchToWindowWithUrl(driver, rUsable.readData().get("linkedinUrl"));
		webDriverUtil.explicitlyWaitForUrl(driver, rUsable.readData().get("linkedinUrl"));

		Assert.assertTrue(driver.getCurrentUrl().contains(rUsable.readData().get("linkedinUrl")),
				"LinkedIn link is broken");
		webDriverUtil.explicitlyWaitForPage(driver, rUsable.readData().get("linkedinTitle"));
		Assert.assertTrue(driver.getTitle().contains(rUsable.readData().get("linkedinTitle")));
		driver.close();
		ListenerImplementationClass.test.log(Status.INFO, "LinledIn link is displayed and Verified Successfully");
		driver.switchTo().window(miko3Window);

		javaUtil.keyPress("END");
		webDriverUtil.clickDisabledElement(homePage.getTermsAndConditions_Link(), driver);

		webDriverUtil.explicitlyWaitForUrl(driver,env+rUsable.readData().get("termsAndCondnUrl"));
		
		Assert.assertTrue(driver.getCurrentUrl().contains(rUsable.readData().get("termsAndCondnUrl")),
				"terms and conditions link is broken");
		
		javaUtil.keyPress("END");
		webDriverUtil.explicitlyWaitForPage(driver, rUsable.readData().get("termsAndCondnTitle"));
		Assert.assertEquals(driver.getTitle(), rUsable.readData().get("termsAndCondnTitle"));
		ListenerImplementationClass.test.log(Status.INFO, "TermsAndConditions link is displayed and Verified Successfully");

		javaUtil.keyPress("END");
		webDriverUtil.clickDisabledElement(homePage.getPrivacyPolicy_Link(), driver);
		
		webDriverUtil.explicitlyWaitForUrl(driver,env+ rUsable.readData().get("prvtPolicyUrl"));
		
		Assert.assertEquals(driver.getCurrentUrl(), env+rUsable.readData().get("prvtPolicyUrl"),"Privacy policy link is broken");
		
		javaUtil.keyPress("END");
		webDriverUtil.explicitlyWaitForPage(driver, rUsable.readData().get("prvtPolicyTitle"));
		Assert.assertEquals(driver.getTitle(), rUsable.readData().get("prvtPolicyTitle"));
		ListenerImplementationClass.test.log(Status.INFO, "Privacy policy link is displayed and Verified Successfully");

		javaUtil.keyPress("END");
		webDriverUtil.clickDisabledElement(homePage.getShippingPolicy_Link(), driver);

		webDriverUtil.explicitlyWaitForUrl(driver,env+rUsable.readData().get("shoppingPolicyUrl"));
		Assert.assertEquals(env+rUsable.readData().get("shoppingPolicyUrl"), driver.getCurrentUrl(),"Shipping policy link is broken");

//		Assert.assertTrue(rUsable.readData().get("shoppingPolicyUrl").contains(driver.getCurrentUrl()),
//				"Shipping policy link is broken");
		javaUtil.keyPress("END");
		webDriverUtil.explicitlyWaitForPage(driver, rUsable.readData().get("shoppingPolicyTitle"));
		Assert.assertEquals(driver.getTitle(), rUsable.readData().get("shoppingPolicyTitle"));
		ListenerImplementationClass.test.log(Status.INFO, "Shipping policy link is displayed and Verified Successfully");

		javaUtil.keyPress("END");
		webDriverUtil.clickDisabledElement(homePage.getDo_not_sell_my_personal_information_Link(), driver);
		
		
		webDriverUtil.explicitlyWaitForUrl(driver,env+rUsable.readData().get("dontSellMyInfoUrl"));
		Assert.assertTrue(driver.getCurrentUrl().contains(rUsable.readData().get("dontSellMyInfoUrl")),
				"opt out link is broken");

		webDriverUtil.explicitlyWaitForPage(driver, rUsable.readData().get("dontSellMyInfoTitle"));
		Assert.assertEquals(driver.getTitle(), rUsable.readData().get("dontSellMyInfoTitle"));
		ListenerImplementationClass.test.log(Status.INFO, " opt out link is displayed and Verified Successfully");

		javaUtil.keyPress("END");
		webDriverUtil.clickDisabledElement(homePage.getAlsoAvailableIn_Btn(), driver);

		webDriverUtil.clickDisabledElement(homePage.getCountry_DropDown(), driver);
		webDriverUtil.selectElementByVisibleText(homePage.getCountry_DropDown(),
				rUsable.readData().get("countryDropDown"));
		
		webDriverUtil.clickDisabledElement(homePage.getSelectCountry_PopUP_SubmitBtn(), driver);
	    ListenerImplementationClass.test.log(Status.INFO, " Footer Country button is displayed and Verified Successfully");
		ListenerImplementationClass.test.log(Status.INFO, "All Home page Elements are verified successfully");
	}
}

