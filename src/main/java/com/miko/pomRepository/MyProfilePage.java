package com.miko.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage {
	public WebDriver driver;
	
	public MyProfilePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	} 
	
	@FindBy(xpath="//div[@class='my_accout_title sf-heading']")
	private WebElement pageTitle;
	@FindBy(id="firstName")
	private WebElement firstNameTxtField;
	@FindBy(id="last-name")
	private WebElement lastNameTxtField;
	@FindBy(id="email")
	private WebElement emailTxtField;
	@FindBy(xpath = "//button[@data-cy='my-profile-btn_update']")
	private WebElement saveYourInfoBtn;
	@FindBy(id="newPassword")
	private WebElement newPasswordTxtField;
	@FindBy(id="repeatPassword")
	private WebElement confirmPasswordTxtField;
	@FindBy(xpath = "//button[@data-cy='my-profile-btn_update-password']")
	private WebDriver changePasswordBtn;
	
	

	public WebElement getPageTitle() {
		return pageTitle;
	}

	public WebElement getFirstNameTxtField() {
		return firstNameTxtField;
	}

	public WebElement getLastNameTxtField() {
		return lastNameTxtField;
	}

	public WebElement getEmailTxtField() {
		return emailTxtField;
	}

	public WebElement getSaveYourInfoBtn() {
		return saveYourInfoBtn;
	}

	public WebElement getNewPasswordTxtField() {
		return newPasswordTxtField;
	}

	public WebElement getConfirmPasswordTxtField() {
		return confirmPasswordTxtField;
	}

	public WebDriver getChangePasswordBtn() {
		return changePasswordBtn;
	}
	
	
}
