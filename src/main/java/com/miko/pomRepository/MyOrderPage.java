package com.miko.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyOrderPage {
	public WebDriver driver;
	
	public MyOrderPage(WebDriver driver) {          
		PageFactory.initElements(driver, this);
	} 
	
	@FindBy(xpath = "//button[@data-testid='My Orders']") private WebElement MyOrder_link;
	@FindBy(xpath = "//h1[@class='sf-heading__title']") private WebElement MyOrder_Text;
	@FindBy(xpath = "//p[@class='no-orders__title']") private WebElement NoOrder_ErrorText ;
	@FindBy(xpath ="//a[@class='no-orders__button form__button sf-button']") private WebElement StartShopping_button;


	public WebElement getMyOrder_link() {
		return MyOrder_link;
	}


	public WebElement getMyOrder_Text() {
		return MyOrder_Text;
	}


	public WebElement getNoOrder_ErrorText() {
		return NoOrder_ErrorText;
	}


	public WebElement getStartShopping_button() {
		return StartShopping_button;
	}
}

//button[@data-testid='Log out']   --> logout
