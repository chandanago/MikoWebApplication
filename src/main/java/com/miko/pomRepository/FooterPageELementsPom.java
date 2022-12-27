package com.miko.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterPageELementsPom {
	private WebDriver driver;
	@FindBy (xpath = "//footer/descendant::img[@class='sf-footer__logo-image']")
	private WebElement footer_Miko3_Logo;
	@FindBy(xpath="//span[text()='About']")
	private WebElement aboutUs_Link;
	@FindBy(xpath = "//footer/descendant::a[@href='https://help.miko.ai/']")
	private WebElement help_Center_Link;
	@FindBy (xpath="//footer/descendant::button[@data-testid='Brochure']")
	private WebElement broucher_Link;
	@FindBy (xpath  = "//div[@class='footer-bottom']/descendant::ul/li/a[@href='/terms-and-conditions']")
	private WebElement termsAndConditions_Link;
	@FindBy (xpath  = "//div[@class='footer-bottom']/descendant::ul/li/a[@href='/privacy-policy']")
	private WebElement privacyPolicy_Link;
	@FindBy (xpath  ="//div[@class='footer-bottom']/descendant::ul/li/a[@href='/shipping-policy']" )
	private WebElement shippingPolicy_Link;
	@FindBy (xpath  = "//div[@class='footer-bottom']/descendant::ul/li/a[@href='/opt-out']")
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


	public FooterPageELementsPom(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

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
