package com.miko.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPaymentPage {
	public WebDriver driver;
	
	public CheckoutPaymentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindAll({@FindBy(xpath="//span[contains(text(),'Ship to')]/../following-sibling::div[.]"),@FindBy(xpath = "//div[@class='review-block']/descendant::div[@class='review-block__content']/address")})
	private WebElement ship_To_address;

	@FindAll({@FindBy(xpath="//span[contains(text(),'Contact')]/../following-sibling::div[.]"),@FindBy(xpath = "//div[@class='review-block']/descendant::div[@class='review-block__content']/bdo")})
	private WebElement contact_Mail;
	
	@FindBy(xpath="//a[contains(@aria-label,'Change shipping method')]")
	private WebElement change_MethodLink;

	/*payment checkout page*/

	@FindBy(xpath = "//a[contains(@aria-label,'Change contact information')]")
	private WebElement change_Contact_Link;

	@FindBy(xpath = "//a[contains(@aria-label,'Change shipping address')]")
	private WebElement change_Shipping_Address_Link;
	
	@FindBy(xpath = "//div[@data-review-section='shipping-cost']")
	private WebElement shipping_Cost;
	
	@FindBy(id = "basic-paymentOnDelivery")
	private WebElement cashOnDeliveryRadioBtn;

	/*checkout payment gateway*/ 
	//credit card payment
	@FindBy(xpath = "//div[@data-gateway-name='credit_card']/descendant::input")
	private WebElement credit_Card_Radio_Btn;

	@FindBy(xpath = "//div[@data-card-field-placeholder='Card number']")
	private WebElement card_number_TxtFiled;
	
	@FindBy(xpath = "//input[contains(@aria-describedby,'name tooltip-for-name')]")
	private WebElement card_number;
	
	@FindBy(xpath = "//div[@data-card-fields='name']")
	private WebElement cardHolderNameTxtFiled;
	
	@FindBy(xpath = "//input[@data-current-field='name']")
	private WebElement cardHolderName;
	
	@FindBy(xpath = "//input[@placeholder='Expiration date (MM / YY)']")
	private WebElement card_Expiry_Date;
	
	@FindBy(xpath = "//div[contains(@id,'expiry')]")
	private WebElement card_Expiry_Date_TxtField;
	
	
	@FindBy (xpath = "//input[@placeholder='Security code']")
	private WebElement security_Code;
	
	@FindBy (xpath = "//div[contains(@data-card-fields,'verification_value')]")
	private WebElement security_Code_CVV_TxtField;
	
	//ShopPay Shopify installments
	@FindBy(xpath = "//div[@data-gateway-name='shopify_installments']/descendant::input[@class='input-radio']")
	private WebElement shop_pay_Radio_Btn;
	
	@FindAll({@FindBy(xpath = "//span[contains(text(),'Same as shipping address')]/../../../descendant::input[@type='radio']") ,@FindBy(id="checkout_different_billing_address_false")})
	private WebElement same_as_Shipping_address_Radio_Btn;

	@FindBy(id="billing_address_selector-custom_billing_address")
	private WebElement different_Billing_Address_Radio_Btn;
	
	@FindBy (id="checkout_remember_me")
	private WebElement remember_Me_Check_Box;
	
	@FindBy (xpath = "//span[text()='Return to shipping']")
	private WebElement return_To_Shipping_Link;

	@FindAll({@FindBy(xpath = "//button[@type='submit']/span[contains(text(),'Complete order')]"),@FindBy (xpath="//button[@type='submit']/span[contains(text(),'Pay now')]")})
	private WebElement pay_Now_Button;
	
	@FindAll({@FindBy(xpath = "//span[contains(text(),'Method')]/../following-sibling::div[.]"), @FindBy (xpath ="//div[@data-review-section='shipping-cost']")})
	private WebElement selected_Methodmode_Txt;
	
	//paypal
	@FindBy(xpath="//input[contains(@id,'basic-PAYPAL_EXPRESS')]")
	private WebElement payPalRadioBtn;
	
	@FindAll({@FindBy(xpath="//iframe[contains(@class,'component-frame visible')]"), @FindBy(xpath="//div[@class='paypal-button-label-container']")})
	private WebElement payWithPayPalBtn;
	
	@FindBy(name="login_email")
	private WebElement payPal_emailaddressTextField;
	
	@FindBy(name="btnNext")
	private WebElement payPal_nextBtn;
	
	@FindBy(name="login_password")
	private WebElement payPal_PasswordBtn;
	
	@FindBy(name="btnLogin")
	private WebElement payPal_LoginBtn;
	
//different Billing Address
	
	
	@FindBy(xpath="//input[contains(@placeholder,'First name (optional)')]")
	private WebElement firstName_TxtField;
	
	@FindBy(xpath="//input[contains(@placeholder,'Last name')]")
	private WebElement lastName_TxtField;
	
	@FindBy(xpath="//input[contains(@placeholder,'Address')]")
	private WebElement address1_TxtField;
	
	@FindBy(xpath="//input[contains(@placeholder,'Apartment, suite')]")
	private WebElement address2_TxtField;
	
	
	@FindBy(xpath="//input[contains(@placeholder,'City')]")
	private WebElement city_TxtField;
	
	@FindBy(xpath="//select[contains(@name,'zone')]")
	private WebElement state_dropdwn;
	
	@FindBy(xpath="//input[contains(@placeholder,'ZIP code')]")
	private WebElement zipCode_TxtField;


	
	public WebElement getFirstName_TxtField() {
		return firstName_TxtField;
	} 
	
	public WebElement getLastName_TxtField() {
		return lastName_TxtField;
	}
	
	public WebElement getAddress1_TxtField() {
		return address1_TxtField;
	}
	public WebElement getAddress2_TxtField() {
		return address2_TxtField;
	} 
	
	public WebElement getCity_TxtField() {
		return city_TxtField;
	}
	
	public WebElement getState_dropdwn() {
		return state_dropdwn;
	}
	
	public WebElement getZipCode_TxtField() {
		return zipCode_TxtField;
	}	
	
	public WebElement getChange_MethodLink() {
		return change_MethodLink;
	} 
	
	public WebElement getPayWithPayPalBtn() {
		return payWithPayPalBtn;
	}
	
	public WebElement getPayPal_LoginBtn() {
		return payPal_LoginBtn;
	}
	
	
	public WebElement getPayPal_PasswordBtn() {
		return payPal_PasswordBtn;
	}
	
	public WebElement getPayPal_nextBtn() {
		return payPal_nextBtn;
	}
	
	public WebElement getPayPal_emailaddressTextField() {
		return payPal_emailaddressTextField;
	}
	
	public WebElement getPayPalRadioBtn() {
		return payPalRadioBtn;
	}
	public WebElement getcashOnDeliveryRadioBtn() {
		return cashOnDeliveryRadioBtn;
	}
	
	public WebElement getSelected_Methodmode_Txt() {
		return selected_Methodmode_Txt;
	}
	
	public WebElement getShipping_Cost() {
		return shipping_Cost;
	}

	public WebElement getCredit_Card_Radio_Btn() {
		return credit_Card_Radio_Btn;
	}

	public WebElement getCard_number_TxtField() {
		return card_number_TxtFiled;
	}

	public WebElement getCard_number() {
		return card_number;
	}
	public WebElement getCardHolderNameTxtFiled() {
		return cardHolderNameTxtFiled;
	}
	public WebElement getCardHolderName() {
		return cardHolderName;
	}

	public WebElement getCard_Expiry_Date_TxtField() {
		return card_Expiry_Date_TxtField;
	}
	
	public WebElement getCard_Expiry_Date() {
		return card_Expiry_Date;
	}

	public WebElement getSecurity_Code_CVV_TxtField() {
		return security_Code_CVV_TxtField;
	}
	
	public WebElement getSecurity_Code() {
		return security_Code;
	}
 

	public WebElement getShop_pay_Radio_Btn() {
		return shop_pay_Radio_Btn;
	}

	public WebElement getSame_as_Shipping_address_Radio_Btn() {
		return same_as_Shipping_address_Radio_Btn;
	}

	public WebElement getDifferent_Billing_Address_Radio_Btn() {
		return different_Billing_Address_Radio_Btn;
	}

	public WebElement getRemember_Me_Check_Box() {
		return remember_Me_Check_Box;
	}

	public WebElement getReturn_To_Shipping_Link() {
		return return_To_Shipping_Link;
	}

	public WebElement getPay_Now_Button() {
		return pay_Now_Button;
	}

	public WebElement getContact_Mail() {
		return contact_Mail;
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
}
