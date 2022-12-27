package com.miko.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {
	public WebDriver driver;
	
	public CreateAccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	private WebElement emailTxtField;
	@FindBy(id="first-name")
	private WebElement firstNameTxtField;
	@FindBy(id="last-name")
	private WebElement lastNameTxtField;
	@FindBy(id="password")
	private WebElement passwordTxtField;
	@FindBy(xpath="//div[@data-testid='create-account']/descendant::div[@class='sf-checkbox__checkmark']")
	private WebElement termsAndConditionsCheckBox;
	@FindBy(xpath = "//a[@type='button' and @href='/terms-and-conditions']")
	private WebElement readMoreLink;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement createAnAccountBtn;
	@FindBy(xpath = "//button[@data-cy='login-btn_login-into-account']")
	private WebElement loginLink;
	
	

	public WebElement getEmailTxtField() {
		return emailTxtField;
	}

	public WebElement getFirstNameTxtField() {
		return firstNameTxtField;
	}

	public WebElement getLastNameTxtField() {
		return lastNameTxtField;
	}

	public WebElement getPasswordTxtField() {
		return passwordTxtField;
	}

	public WebElement getTermsAndConditionsCheckBox() {
		return termsAndConditionsCheckBox;
	}

	public WebElement getReadMoreLink() {
		return readMoreLink;
	}

	public WebElement getCreateAnAccountBtn() {
		return createAnAccountBtn;
	}

	public WebElement getLoginLink() {
		return loginLink;
	}

}
