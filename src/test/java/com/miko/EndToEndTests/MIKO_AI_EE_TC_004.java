package com.miko.EndToEndTests;

import java.util.Set;

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
public class MIKO_AI_EE_TC_004 extends BaseClass {

	@Test
	public void MIKO_AI_EE_TC_004_Test() {

		Miko3Page productPage =  new Miko3Page(driver);
		String Miko3PageUrl = property.readDataFromProperty("Miko3Page_Url");
		String colorText = excelData.readDataFromExcel("elementText", 1, 2);
		String payPalTitle = excelData.readDataFromExcel("CommonData", 38, 1);
		String homePageUrl = property.readDataFromProperty("URL");
		
		//1)Home page should display
		HomePage homePage = new HomePage(driver);
		webDriverUtil.explicitlyWaitForUrl(driver, property.readDataFromProperty("URL"));
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

		webDriverUtil.scrollBy(1352, 210, driver);
		javaUtil.keyPress("pagedown");

		//5) Click on 'Buy Now' button  
		webDriverUtil.clickDisabledElement(productPage.getBuyNow_Btn(), driver);

		//6)Verify shopping cart page details
		ShoppingCartPage shoppingCart = new ShoppingCartPage(driver);
		webDriverUtil.explicitlyWaitForElement(driver, shoppingCart.getSub_Total());
		String subtotalAmt = shoppingCart.getSub_Total().getText();
		Reporter.log(subtotalAmt+"subtotalAmt",true);
		
		//7->ii)Click on 'Go To Checkout' button 
		shoppingCart.getGo_TO_CheckOut_Btn().click();
		CheckOutInformationPage checkOutInformation = new CheckOutInformationPage(driver);

		String CheckOutInformation = property.readDataFromProperty("information_CheckoutPage");
		webDriverUtil.explicitlyWaitForUrl(driver, CheckOutInformation);
		Assert.assertTrue(driver.getCurrentUrl().contains(CheckOutInformation), "checkout-Information page should display");
		ListenerImplementationClass.test.log(Status.INFO, "CheckOut-Information Page displayed successfully");
		
        CheckoutOrderSummaryPage OrderSummary = new CheckoutOrderSummaryPage(driver);
		
		webDriverUtil.explicitlyWaitForElementTextToPresent(driver, OrderSummary.getFinalAmt(), subtotalAmt);
		String beforeDiscountFinalAmt = OrderSummary.getFinalAmt().getText();
		
		rUsable.verifyOrderSummaryWithDiscount(driver, subtotalAmt, colorText, beforeDiscountFinalAmt);
		
		String currentHandle = driver.getWindowHandle();

		checkOutInformation.getPayPal_btn().click();	
		CheckoutPaymentPage checkOutPayment = new CheckoutPaymentPage(driver);
		
		Set<String> handles = driver.getWindowHandles(); 
		for (String handle : handles) 
		{ 
		  if (!handle .equals(currentHandle)) 
		  { 
		    driver.switchTo().window(handle); 	    
		    
			webDriverUtil.explicitlyWaitForPage(driver, payPalTitle);
			Assert.assertEquals(driver.getTitle(), payPalTitle, "paypal page is not displayed");
			
			//-------------------------paypal credentoial needed
			checkOutPayment.getPayPal_emailaddressTextField().sendKeys("ftgyuh@gmail.com");
		//	checkOutPayment.getPayPal_nextBtn().click();
		//	checkOutPayment.getPayPal_PasswordBtn().sendKeys("789");//567890hjk
		//	checkOutPayment.getPayPal_LoginBtn().click();
		    
		    driver.close(); 
		  } 
		  driver.switchTo().window(currentHandle); 
		}
		
    	Assert.assertTrue(driver.getCurrentUrl().contains(CheckOutInformation), "checkout-Information page should display");	
		ListenerImplementationClass.test.log(Status.INFO, "CheckOut-Information Page displayed successfully");
		
	} 
}