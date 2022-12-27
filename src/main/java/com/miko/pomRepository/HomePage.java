package com.miko.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@class='redirectionBar_select']")
	private WebElement countryDropDown;
	@FindBy(xpath = "//button[@class='redirectionBar_button']")
	private WebElement continueBtn;
	@FindBy(xpath="//img[@alt='Logo Main Branding']")
	private WebElement mikologo;
	@FindBy(xpath="//span[text()='Miko 3']")
	private WebElement miko3Btn;
	@FindBy(xpath="//span[text()='Miko Max']")
	private WebElement mikoMaxBtn;
	@FindBy(xpath="//span[text()='Tech Specs']")
	private WebElement techSpecsBtn;
	@FindBy(xpath="//span[text()='Track Your Order']")
	private WebElement trackYourOrderBtn;
	@FindBy(xpath="//span[text()='Blog']")
	private WebElement blogBtn;
	@FindBy(xpath="//span[text()='Help Center']")
	private WebElement helpCenterBtn;
	@FindBy(xpath="//button[@aria-label='Cart']")
	private WebElement cartBtn;
	
	
//	@FindAll({@FindBy(xpath = "//span[contains(text(),'Subtotal')]/../descendant::span[@class='sf-price__regular']"),@FindBy(xpath = "//span[contains(text(),'Subtotal')]/..//span[contains(text(),'211.00')]")}) 
//	private WebElement sub_Total;
	
	
	@FindBy(xpath="//a[contains(text(),'Buy Now')]")
	private WebElement buyNowBtn;
	@FindBy(xpath="//button[@aria-label='User']")
	private WebElement profile_Icon;
	
	
	@FindBy(xpath="//h1[@class='banner-title']/p")
	private WebElement bannerTitle;	
	@FindBy(xpath ="//h2[text()='Miko 3']")
	private WebElement  bottom_bar_text;
	@FindBy(xpath ="//div[@class='product_bottom_bar_price']")
	private WebElement  bottombar_price;
	@FindBy(xpath ="//div[@class='color-option small-co']/descendant::button[@aria-label='Martian Red']")
	private WebElement  bottombar_redRadioBtn;
	@FindBy(xpath ="//div[@class='color-option small-co']/descendant::button[@aria-label='Pixie Blue']")
	private WebElement  bottombar_blueRadioBtn;
	@FindBy(xpath ="//button[@class='sf-add-to-cart__button cart-btn sf-button']") 
	private WebElement bottombar_BuyNowBtn;
	
	@FindBy(xpath ="//span[@class='sf-notification__message']") 
	private WebElement toastMessage_Text;
	
	@FindBy(xpath ="//button[contains(@class,'needsclick klaviyo-close-form')]") 
	private WebElement popupCloseBtn;
	
	
	
	/* footer elements*/
	
	
	
	@FindBy (xpath = "//footer/descendant::img[@class='sf-footer__logo-image']")
	private WebElement footer_Miko3_Logo;
	@FindBy(xpath="//span[text()='About']")
	private WebElement aboutUs_Link;
	@FindBy(xpath = "//footer/descendant::a[@href='https://help.miko.ai/']")
	private WebElement help_Center_Link;
	@FindBy (xpath="//footer/descendant::button[@data-testid='Brochure']")
	private WebElement broucher_Link;
	@FindBy (xpath  = "//span[contains(text(),'Terms & Conditions')]")
	private WebElement termsAndConditions_Link;
	
	@FindAll({@FindBy (xpath = "//span[contains(text(),'Privacy Policy')]"),@FindBy(xpath= "//div[@class='footer-bottom']/descendant::ul/li/a[@href='/privacy-policy']")})
	private WebElement privacyPolicy_Link;
	
	@FindAll({@FindBy (xpath  ="//span[contains(text(),'Shipping Policy')]"),@FindBy(xpath="//div[@class='footer-bottom']/descendant::ul/li/a[@href='/shipping-policy']" )})
	private WebElement shippingPolicy_Link;
	@FindAll({@FindBy (xpath  = "//span[contains(text(),'Do not sell my personal information')]"),@FindBy (xpath= "//div[@class='footer-bottom']/descendant::ul/li/a[@href='/opt-out']")})
	private WebElement Do_not_sell_my_personal_information_Link;
	@FindBy (xpath = "//div[@class='country_dropdown dropdown_desktop']/button")
	private WebElement alsoAvailableIn_Btn;
	@FindBy(xpath = "//div[@class='sf-bar__title']")
	private WebElement selectCountry_Popup_Title;
	@FindBy(xpath = "//select[@id='Country']")
	private WebElement country_DropDown;
	@FindBy(xpath = "//button[@data-cy='login-btn_submit']")
	private WebElement selectCountry_PopUP_SubmitBtn;

	@FindBy (xpath = "//div[@class='footer-app-list']/descendant::a[@data-cy='appstore-url_logo' and contains(@href,'https://apps.apple.com/my/app/miko-3-parent/')]")
	private WebElement appStore_Link;
	@FindBy (xpath="//div[@class='footer-app-list']/descendant::a[@data-cy='playstore-url_logo' and @href='https://play.google.com/store/apps/details?id=com.miko3.app']")
	private WebElement playStore_Link;


	@FindBy (xpath  = "//div[@class='footer-bottom-right']/ul/li/a[contains(@href,'https://www.facebook.com/Miko')]")
	private WebElement facebook_Icon;
	@FindBy (xpath = "//div[@class='footer-bottom-right']/ul/li/a[contains(@href,'https://twitter.com/mikorobotusa')]")
	private WebElement twitter_Icon;
	@FindBy (xpath = "//div[@class='footer-bottom-right']/ul/li/a[contains(@href,'https://www.instagram.com/mikorobotusa/')]")
	private WebElement instagram_Icon;
	@FindBy (xpath = "//div[@class='footer-bottom-right']/ul/li/a[contains(@href,'https://www.youtube.com/c/MikoRobot')]")
	private WebElement youTube_Icon;
	@FindBy (xpath= "//div[@class='footer-bottom-right']/ul/li/a[contains(@href,'https://www.linkedin.com/company/mikorobot/mycompany/')]")
	private WebElement linkedIn_Icon;
	
	
	public WebElement getPopupCloseBtn() {
		return popupCloseBtn;
	} 
	
	
	public WebElement getToastMessage_Text() {
		return toastMessage_Text;
	} 
	
	public WebElement getCountryDropDown() {
		return countryDropDown;
	}


	public WebElement getContinueBtn() {
		return continueBtn;
	}


	public WebElement getMikologo() {
		return mikologo;
	}


	public WebElement getMiko3Btn() {
		return miko3Btn;
	}


	public WebElement getMikoMaxBtn() {
		return mikoMaxBtn;
	}


	public WebElement getTechSpecsBtn() {
		return techSpecsBtn;
	}


	public WebElement getTrackYourOrderBtn() {
		return trackYourOrderBtn;
	}


	public WebElement getBlogBtn() {
		return blogBtn;
	}


	public WebElement getHelpCenterBtn() {
		return helpCenterBtn;
	}


	public WebElement getCartBtn() {
		return cartBtn;
	}


	public WebElement getBuyNowBtn() {
		return buyNowBtn;
	}


	public WebElement getProfile_Icon() {
		return profile_Icon;
	}


	public WebElement getBannerTitle() {
		return bannerTitle;
	}


	public WebElement getBottom_bar_text() {
		return bottom_bar_text;
	}


	public WebElement getBottombar_price() {
		return bottombar_price;
	}


	public WebElement getBottombar_redRadioBtn() {
		return bottombar_redRadioBtn;
	}


	public WebElement getBottombar_blueRadioBtn() {
		return bottombar_blueRadioBtn;
	}

	public WebElement getBottombar_BuyNowBtn() {
		return bottombar_BuyNowBtn;
	}
	
	
	
	/*footer*/
	

	public WebElement getFooter_Miko3_Logo() {
		return footer_Miko3_Logo;
	}
	public WebElement getAboutUs_Link() {
		return aboutUs_Link;
	}
	public WebElement getHelp_Center_Link() {
		return help_Center_Link;
	}
	public WebElement getBroucher_Link() {
		return broucher_Link;
	}
	public WebElement getTermsAndConditions_Link() {
		return termsAndConditions_Link;
	}
	public WebElement getPrivacyPolicy_Link() {
		return privacyPolicy_Link;
	}
	public WebElement getShippingPolicy_Link() {
		return shippingPolicy_Link;
	}
	public WebElement getDo_not_sell_my_personal_information_Link() {
		return Do_not_sell_my_personal_information_Link;
	}
	public WebElement getAlsoAvailableIn_Btn() {
		return alsoAvailableIn_Btn;
	}
	public WebElement getSelectCountry_Popup_Title() {
		return selectCountry_Popup_Title;
	}
	public WebElement getCountry_DropDown() {
		return country_DropDown;
	}
	public WebElement getSelectCountry_PopUP_SubmitBtn() {
		return selectCountry_PopUP_SubmitBtn;
	}
	public WebElement getAppStore_Link() {
		return appStore_Link;
	}
	public WebElement getPlayStore_Link() {
		return playStore_Link;
	}
	public WebElement getFacebook_Icon() {
		return facebook_Icon;
	}
	public WebElement getTwitter_Icon() {
		return twitter_Icon;
	}
	public WebElement getInstagram_Icon() {
		return instagram_Icon;
	}
	public WebElement getYouTube_Icon() {
		return youTube_Icon;
	}
	public WebElement getLinkedIn_Icon() {
		return linkedIn_Icon;
	}
	
}
