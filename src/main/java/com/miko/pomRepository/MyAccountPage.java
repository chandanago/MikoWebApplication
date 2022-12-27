package com.miko.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

	public WebDriver driver;
	
	
	public MyAccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
 
	@FindBy(xpath = "//button[@data-testid='My profile']/span[@class='sf-menu-item__label']")
	private WebElement myProfileBtn;
	@FindBy(xpath ="//button[@data-testid='Address Book']/span[@class='sf-menu-item__label']") 
	private WebElement addressBookBtn;
	@FindBy(xpath ="//button[@data-testid='My Orders']/span[@class='sf-menu-item__label']") 
	private WebElement myOrdersBtn;
	@FindBy(xpath ="//button[@data-testid='Log out']/span[@class='sf-menu-item__label']") 
	private WebElement logOutBtn;
	
	
	public WebElement getMyProfileBtn() {
		return myProfileBtn;
	}

	public WebElement getAddressBookBtn() {
		return addressBookBtn;
	}

	public WebElement getMyOrdersBtn() {
		return myOrdersBtn;
	}

	public WebElement getLogOutBtn() {
		return logOutBtn;
	}
	
}
