package com.miko.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	private WebElement emailTxtField;
	@FindBy(id="password")
	private WebElement passwordTxtField;
	@FindBy(xpath="//button[@type='submit']/div")
	private WebElement loginBtn;
	@FindBy(xpath="//button[@data-cy='login-btn_forgot-password']")
	private WebElement forgotPasswordLink; 
	@FindBy(xpath="//span[@class='bottom__paragraph']")
	private WebElement createAccountQuery;
	@FindBy(xpath="//button[@data-cy='login-btn_sign-up']")
	private WebElement createAccountLink;
	@FindBy(xpath="//*[@class='sf-bar__title']")
	private WebElement loginTitleText;
	@FindBy(xpath="//button[@data-testid='close-button']")
	private WebElement closeBtn;



	public WebElement getEmailTxtField() {
		return emailTxtField;
	}

	public WebElement getPasswordTxtField() {
		return passwordTxtField;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getForgotPasswordLink() {
		return forgotPasswordLink;
	}

	public WebElement getCreateAccountQuery() {
		return createAccountQuery;
	}

	public WebElement getCreateAccountLink() {
		return createAccountLink;
	}

	public WebElement getLoginTitleText() {
		return loginTitleText;
	}

	public WebElement getCloseBtn() {
		return closeBtn;
	}

}
