package com.miko.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressBookPage {

	public WebDriver driver;
	
	public AddressBookPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//div[@class='my_accout_title sf-heading']")
	private WebElement pageTitle;
	@FindBy(xpath = "//div[@data-cy='billing-details-tab_details']")
	private WebElement savedAddreses_TextBox;
	@FindBy(className = "billing add-address-btn")
	private WebElement addAddress_Btn;
	@FindBy(id="first-name")
	private WebElement firstName_TxtField;
	@FindBy(id="last-name")
	private WebElement lastName_TxtField;
	@FindBy(id="streetName")
	private WebElement streetName_TxtField;
	@FindBy(id="apartment")
	private WebElement doorNumber_TxtField;
	@FindBy(id="city")
	private WebElement city_TxtField;
	@FindBy(id="Country")
	private WebElement country_DropDown;
	@FindBy(id="State/Province")
	private WebElement stateOrProvince_DropDown;
	@FindBy(id="zipCode")
	private WebElement zipCode_TxtField;
	@FindBy(id="company")
	private WebElement company_TxtField;
	@FindBy(xpath="//button[@class=' sf-button--text sf-button']")
	private WebElement edit_Address_Link;
	@FindBy(xpath="//button[@class='billing__button-delete sf-button--text sf-button']")
	private WebElement remove_address_Link;
	@FindBy(id="phone")
	private WebElement phoneNumber_TxtField;
	@FindBy(xpath ="//button[@class='form__button sf-button']/parent::div")
	private WebElement addAddressPage_addAddress_Btn;
	@FindBy(xpath = "//button[@class='form__button btn-bordered sf-button']/parent::div")
	private WebElement addAddressPage_cancel_Btn;
	



	public  WebElement getPageTitle() {
		return pageTitle;
	}


	public  WebElement getPhoneNumber_TxtField() {
		return phoneNumber_TxtField;
	}


	public  WebElement getAddAddressPage_addAddress_Btn() {
		return addAddressPage_addAddress_Btn;
	}


	public  WebElement getAddAddressPage_cancel_Btn() {
		return addAddressPage_cancel_Btn;
	}


	public  WebElement getSavedAddreses_TextBox() {
		return savedAddreses_TextBox;
	}


	public  WebElement getAddAddress_Btn() {
		return addAddress_Btn;
	}


	public  WebElement getFirstName_TxtField() {
		return firstName_TxtField;
	}


	public  WebElement getLastName_TxtField() {
		return lastName_TxtField;
	}


	public  WebElement getStreetName_TxtField() {
		return streetName_TxtField;
	}


	public  WebElement getDoorNumber_TxtField() {
		return doorNumber_TxtField;
	}


	public  WebElement getCity_TxtField() {
		return city_TxtField;
	}


	public  WebElement getCountry_DropDown() {
		return country_DropDown;
	}


	public  WebElement getStateOrProvince_DropDown() {
		return stateOrProvince_DropDown;
	}


	public  WebElement getZipCode_TxtField() {
		return zipCode_TxtField;
	}


	public  WebElement getCompany_TxtField() {
		return company_TxtField;
	}


	public  WebElement getEdit_Address_Link() {
		return edit_Address_Link;
	}


	public  WebElement getRemove_address_Link() {
		return remove_address_Link;
	}
	
}
