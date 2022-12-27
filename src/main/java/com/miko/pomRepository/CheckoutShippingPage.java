package com.miko.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutShippingPage {
	public WebDriver driver;
	
	public CheckoutShippingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/* CheckOutShipping Page */
	
	
	@FindBy(xpath="//p[contains(text(),'Economy')]/ancestor::label/descendant::input[@name='shipping_methods']")
	private WebElement shippingMode_Economy_RadioBtn;
	@FindBy(xpath = "//button[@type='submit']/span[contains(text(),'Continue to payment')]")
	private WebElement continue_To_Payment_Btn;

	@FindBy(xpath = "//div[@class='review-block']/descendant::div[@class='review-block__content']/bdo")
	private WebElement contact_Mail;
	@FindBy(xpath = "//span[@class='visually-hidden' and text()='Change contact information']/ancestor::div[@class='review-block__link']")
	private WebElement change_Contact_Link;
	@FindBy(xpath = "//div[@class='review-block']/descendant::div[@class='review-block__content']/address")
	private WebElement ship_To_address;
	@FindBy(xpath = "//span[@class='visually-hidden' and text()='Change shipping address']/ancestor::div[@class='review-block__link']")
	private WebElement change_Shipping_Address_Link;
	
	@FindBy(xpath = "//span[@data-shipping-method-label-title='Standard']/../..//input[@class='input-radio']")
	private WebElement shippingMode_Standard_RadioBtn;
	
	@FindBy(xpath = "//span[@data-shipping-method-label-title='Economy']")
	private WebElement shippingMode_Economy_Text;
	@FindBy(xpath = "//span[@data-shipping-method-label-title='Standard']")
	private WebElement shippingMode_Standard_Text;

	@FindBy(xpath = "//span[@data-shipping-method-label-title='Free Shipping']")
	private WebElement shipping_Method;
	@FindBy(xpath = "//span[@class='content-box__emphasis']")
	private WebElement accessory;
	@FindBy(xpath = "//span[text()='Return to information']")
	private WebElement return_to_information_Link;

	

	public WebElement getContact_Mail() {
		return contact_Mail;
	}
	
	
	public WebElement getShippingMode_Standard_Text() {
		return shippingMode_Standard_Text;
	}
	public WebElement getShippingMode_Economy_Text() {
		return shippingMode_Economy_Text;
	}
	

	public WebElement getChange_Contact_Link() {
		return change_Contact_Link;
	}

	public WebElement getShip_To_address() {
		return ship_To_address;
	}

	public WebElement getChange_Shipping_Address_Link() {
		return change_Shipping_Address_Link;
	}

	public WebElement getShippingMode_Economy_RadioBtn() {
		return shippingMode_Economy_RadioBtn;
	}
	
	public WebElement getShippingMode_Standard_RadioBtn() {
		return shippingMode_Standard_RadioBtn;
	}

	public WebElement getShipping_Method() {
		return shipping_Method;
	}

	public WebElement getAccessory() {
		return accessory;
	}

	public WebElement getReturn_to_information_Link() {
		return return_to_information_Link;
	}

	public WebElement getContinue_To_Payment_Btn() {
		return continue_To_Payment_Btn;
	}

}
