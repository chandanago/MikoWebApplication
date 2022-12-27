package com.miko.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.miko.genericLibrary.ExcelUtility;
import com.miko.genericLibrary.WebDriverUtilityClass;

public class CheckOutInformationPage {
	public WebDriver driver;

	public CheckOutInformationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	/* CheckOut Information page */
	// Express Checkout
	@FindBy(xpath = "//a[contains(@aria-label,'Shop Pay')]") 
	private WebElement shopPay_Btn;
	@FindBy(xpath = "//div[contains(@class,'gpay-button-fill')]")
	private WebElement google_Pay_Btn;

	@FindBy(xpath="//input[@id='email']")
	private WebElement email_id_TxtField;
	@FindBy(xpath = "//iframe[contains(@class,'component-frame visible')]")
	private WebElement payPal_btn;


	@FindAll({@FindBy(xpath="(//p[contains(text(),'One Time - 3 Months')])[1]"), @FindBy(xpath="(//p[contains(text(),'One Time - 1 Year')])[1]")})
	private WebElement maxSubscription_Txt;

	@FindBy(xpath="//input[@name='marketing_opt_in']")
	private WebElement emil_notifications_checkBox;
	@FindBy(xpath="//select[@name='countryCode']")
	private WebElement country_Drop_Down;
	@FindBy(xpath="//input[@name='firstName']")
	private WebElement firstName_TxtField;
	@FindBy(xpath="//input[@name='lastName']")
	private WebElement lastName_TxtField;
	@FindBy(xpath="//input[@name='address1']")
	private WebElement address_TxtFiled;
	@FindBy(xpath="//input[@name='address2']")
	private WebElement apartment_address_TxtFiled;
	@FindBy(xpath="//input[@name='city']")
	private WebElement city_TxtField;
	@FindBy(xpath="//select[@name='zone']")
	private WebElement state_Drop_Down;
	@FindBy(xpath="//input[@name='postalCode']")
	private WebElement zipcode_TxtFiled;
	@FindBy(id = "checkout_shipping_address_phone")
	private WebElement phone_TxtField;
	@FindBy(xpath="//span[contains(text(),'Continue to shipping')]")
	private WebElement continue_To_Shipping_Btn;

	@FindBy(xpath="//div[text()='Log in or sign up']")
	private WebElement shopPayLoginText;
	 
	public WebElement getShopPayLoginText() {
		return shopPayLoginText;
	}
	public WebElement getMaxSubscription_Txt() {
		return maxSubscription_Txt;
	}
	public WebElement getPayPal_btn() {
		return payPal_btn;
	}

	public WebElement getShopPay_Btn() {
		return shopPay_Btn;
	}

	public WebElement getGoogle_Pay_Btn() {
		return google_Pay_Btn;
	}

	public WebElement getEmail_id_TxtField() {
		return email_id_TxtField;
	}


	public WebElement getEmil_notifications_checkBox() {
		return emil_notifications_checkBox;
	}

	public WebElement getCountry_Drop_Down() {
		return country_Drop_Down;
	}

	public WebElement getFirstName_TxtField() {
		return firstName_TxtField;
	}

	public WebElement getLastName_TxtField() {
		return lastName_TxtField;
	}

	public WebElement getAddress_TxtFiled() {
		return address_TxtFiled;
	}

	public WebElement getApartment_address_TxtFiled() {
		return apartment_address_TxtFiled;
	}

	public WebElement getCity_TxtField() {
		return city_TxtField;
	}

	public WebElement getState_Drop_Down() {
		return state_Drop_Down;
	}

	public WebElement getZipcode_TxtFiled() {
		return zipcode_TxtFiled;
	}

	public WebElement getPhone_TxtField() {
		return phone_TxtField;
	}

	public WebElement getContinue_To_Shipping_Btn() {
		return continue_To_Shipping_Btn;
	}

	public void enterAddress(String email_id, String firstName, String lastName, String address, String apartment, String city, String state, String pincode) {
		WebDriverUtilityClass webDriverUtil = new WebDriverUtilityClass();
		getEmail_id_TxtField().sendKeys(email_id);
		getFirstName_TxtField().sendKeys(firstName);
		getLastName_TxtField().sendKeys(lastName);
		getAddress_TxtFiled().sendKeys(address);
		getApartment_address_TxtFiled().sendKeys(apartment);
		getCity_TxtField().sendKeys(city);
		webDriverUtil.selectElementByVisibleText(getState_Drop_Down(), state);
		getZipcode_TxtFiled().sendKeys(pincode);

	}
}
