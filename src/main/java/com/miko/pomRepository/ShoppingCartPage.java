package com.miko.pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	public WebDriver driver;


	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath = "//div[@class='product-title']")
	private WebElement product_Title;

	@FindBy(xpath = "//img[contains(@src,'Miko3_Blue_Front_f__1_.png')]")
	private WebElement blue_product;

	@FindBy(xpath = "(//img[contains(@src,'Miko3_Blue_Front_f__1_.png')]/../../..//button[contains(@class,'sf-quantity-selector')])[1]")
	private WebElement blue_minusBtn;

	@FindBy(xpath = "(//img[contains(@src,'Miko3_Blue_Front_f__1_.png')]/../../..//button[contains(@class,'sf-quantity-selector')])[2]")
	private WebElement blue_plusBtn;

	@FindBy(xpath = "//img[contains(@src,'Miko3_Blue_Front_f__1_.png')]/../../..//input[contains(@type,'number')]")
	private WebElement blue_inputQty;

	@FindBy(xpath = "//img[contains(@src,'Miko3_Blue_Front_f__1_.png')]/../../..//button[contains(@data-testid,'Martian Red')]")
	private WebElement blue_martianRedBtn;


	@FindBy(xpath = "//img[contains(@src,'Miko3_Blue_Front_f__1_.png')]/../../..//button[contains(@data-testid,'Pixie Blue')]")
	private WebElement blue_pixieBlueBtn;

	@FindBy(xpath = "//img[contains(@src,'Miko3_Blue_Front_f__1_.png')]/../../..//span[contains(text(),'Pixie Blue')]")
	private WebElement blue_botClrText;

	@FindBy(xpath = "//img[contains(@src,'Miko3_Blue_Front_f__1_.png')]/../../..//button[contains(text(),'Remove')]")
	private WebElement blue_removeLink;

	@FindBy(xpath = "//img[contains(@src,'Miko3_Blue_Front_f__1_.png')]/../../..//div[contains(@class,'sf-price')]")
	private WebElement blue_ProductPrice;

	//--------------------------------------------------------------------------------------
	@FindBy(xpath = "//img[contains(@src,'Miko3_Red_Front_f__1_.png')]")
	private WebElement red_productimg;
	
	@FindBy(xpath = "(//img[contains(@src,'Miko3_Red_Front_f__1_.png')]/../../..//button[contains(@class,'sf-quantity-selector')])[2]")
	private WebElement red_plusBtn;

	@FindBy(xpath = "(//img[contains(@src,'Miko3_Red_Front_f__1_.png')]/../../..//button[contains(@class,'sf-quantity-selector')])[1]")
	private WebElement red_minusBtn;

	@FindBy(xpath = "//img[contains(@src,'Miko3_Red_Front_f__1_.png')]/../../..//input[contains(@type,'number')]")
	private WebElement red_inputQty;

	@FindBy(xpath = "//img[contains(@src,'Miko3_Red_Front_f__1_.png')]/../../..//button[contains(@data-testid,'Martian Red')]")
	private WebElement red_martianRedBtn;

	@FindBy(xpath = "//img[contains(@src,'Miko3_Red_Front_f__1_.png')]/../../..//button[contains(@data-testid,'Pixie Blue')]")
	private WebElement red_pixieBlueBtn;

	@FindBy(xpath = "//img[contains(@src,'Miko3_Red_Front_f__1_.png')]/../../..//span[contains(text(),'Martian Red')]")
	private WebElement red_botClrText;

	@FindBy(xpath = "//img[contains(@src,'Miko3_Red_Front_f__1_.png')]/../../..//button[contains(text(),'Remove')]")
	private WebElement red_removeLink;

	@FindBy(xpath = "//img[contains(@src,'Miko3_Red_Front_f__1_.png')]/../../..//div[contains(@class,'sf-price')]")
	private WebElement red_ProductPrice;

	//---------------------------------------------------------------------


	@FindBy(xpath = "//span[contains(text(),'Subtotal')]/..//span[contains(@class,'sf-price__regular')]")
	private WebElement sub_Total;

	@FindBy(xpath = "//button[@class='miko-max-btn btn-add-to-cart sf-button']")
	private WebElement add_Another_Miko_Link;

	@FindBy(xpath = "//div[@class='summary-property']/descendant::span[@class='summary-name' and .='Shipping']/following-sibling::span[@class='summary-value']")
	private WebElement shipping_Charges;

	@FindBy(xpath = "//div[@class='summary-property']/descendant::span[@class='summary-name' and .='Est. Tax & Fees']/following-sibling::span[@class='summary-value']']")
	private WebElement estd_Tax_And_Fees;

	@FindBy(xpath = "//button[@class='btn-1 checkout-init sf-button']/descendant::div[@class='sf-price']/span[@class='sf-price__regular']")
	private WebElement total_Amount;

	@FindBy(xpath = "//button[@class='btn-1 checkout-init sf-button']")
	private WebElement go_TO_CheckOut_Btn;

	@FindBy(xpath = "//span[@class='sf-notification__message']")
	private WebElement notificationPopupTitle;

	@FindBy(xpath = "//button[contains(@class,'sf-button_remove_item sf-button')]")
	private WebElement notification_YesBtn;

	@FindBy(xpath = "//button[@class='sf-button']")
	private WebElement notification_CancelBtn;


//--------------------------------------------------------
	
	// miko subscription for 3 months 
	
	@FindBy(xpath = "(//div[contains(text(),'39.00')])[2]")
	private WebElement month_price;

	@FindBy(xpath = "//div[contains(text(),'39.00')]/..//div[contains(@class,'cart-onetime-1year')]")
	private WebElement month_oneYearCard;


	@FindBy(xpath = "//div[contains(text(),'39.00')]/..//div[contains(@class,'cart-onetime-3months')]")
	private WebElement month_threeMntCard;


	@FindBy(xpath = "(//div[contains(text(),'39.00')]/..//button[contains(@class,'selector__button sf')])[1]")
	private WebElement month_minusBtn;


	@FindBy(xpath = "(//div[contains(text(),'39.00')]/..//button[contains(@class,'selector__button sf')])[2]")
	private WebElement month_plusBtn;

	@FindBy(xpath = "//div[contains(text(),'39.00')]/..//input[contains(@type,'number')]")
	private WebElement month_inputQty;


	@FindBy(xpath = "//div[contains(text(),'39.00')]/..//button[contains(@class,'remove-item')]")
	private WebElement month_removeBtn;


	@FindBy(xpath = "//div[contains(text(),'39.00')]/..//div[contains(text(),'One Time - 3 Months purchase')]")
	private WebElement month_threeMntText;
	

	@FindBy(xpath = "//div[contains(text(),'39.00')]/..//div[contains(text(),'One Time - 1 Year purchase')]")
	private WebElement month_oneYearText;


	@FindBy(xpath = "(//div[contains(text(),'39.00')]/..//div[contains(@class,'sf-radio__checkmark')])[1]")
	private WebElement month_threeMntRadioBtn;


	@FindBy(xpath = "(//div[contains(text(),'39.00')]/..//div[contains(@class,'sf-radio__checkmark')])[2]")
	private WebElement month_oneYearRadioBtn;
	
	//-------------------year subscription---------------------
	

	@FindBy(xpath = "(//div[contains(text(),'89.00')])[2]")
	private WebElement year_price;

	@FindBy(xpath = "//div[contains(text(),'89.00')]/..//div[contains(@class,'cart-onetime-1year')]")
	private WebElement year_oneYearCard;

	@FindBy(xpath = "//div[contains(text(),'89.00')]/..//div[contains(@class,'cart-onetime-3months')]")
	private WebElement year_threeMntCard;


	@FindBy(xpath = "(//div[contains(text(),'89.00')]/..//button[contains(@class,'selector__button sf')])[1]")
	private WebElement year_minusBtn;


	@FindBy(xpath = "(//div[contains(text(),'89.00')]/..//button[contains(@class,'selector__button sf')])[2]")
	private WebElement year_plusBtn;

	@FindBy(xpath = "//div[contains(text(),'89.00')]/..//input[contains(@type,'number')]")
	private WebElement year_inputQty;


	@FindBy(xpath = "//div[contains(text(),'89.00')]/..//button[contains(@class,'remove-item')]")
	private WebElement year_removeBtn;


	@FindBy(xpath = "//div[contains(text(),'89.00')]/..//div[contains(text(),'One Time - 3 Months purchase')]")
	private WebElement year_threeMntText;
	

	@FindBy(xpath = "//div[contains(text(),'89.00')]/..//div[contains(text(),'One Time - 1 Year purchase')]")
	private WebElement year_oneYearText;


	@FindBy(xpath = "(//div[contains(text(),'89.00')]/..//div[contains(@class,'sf-radio__checkmark')])[1]")
	private WebElement year_threeMntRadioBtn;


	@FindBy(xpath = "(//div[contains(text(),'89.00')]/..//div[contains(@class,'sf-radio__checkmark')])[2]")
	private WebElement year_oneYearRadioBtn;

	@FindBy(xpath = "//button[contains(@class,'sm btn-add-to-cart sf')]")
	private WebElement addMiko3Btn;

	@FindBy(xpath = "//span[contains(@class,'sf-alert__message')]")
	private WebElement errorMsgForWithoutMiko;
	
	
	@FindBy(xpath = "//div[@class='close-icon']")
	private WebElement closeButton;


	@FindBy(xpath = "//h3[@class='sf-heading__title h3']")
	private WebElement pageTitle;


	public WebElement getPageTitle() {
		return pageTitle;
	}	


	public WebElement getCloseButton() {
		return closeButton;
	}	
	

	public WebElement getProduct_Title() {
		return product_Title;
	}


	public WebElement getBlue_product() {
		return blue_product;
	}


	public WebElement getBlue_minusBtn() {
		return blue_minusBtn;
	}


	public WebElement getBlue_plusBtn() {
		return blue_plusBtn;
	}


	public WebElement getBlue_inputQty() {
		return blue_inputQty;
	}


	public WebElement getBlue_martianRedBtn() {
		return blue_martianRedBtn;
	}


	public WebElement getBlue_pixieBlueBtn() {
		return blue_pixieBlueBtn;
	}


	public WebElement getBlue_botClrText() {
		return blue_botClrText;
	}


	public WebElement getBlue_removeLink() {
		return blue_removeLink;
	}


	public WebElement getBlue_ProductPrice() {
		return blue_ProductPrice;
	}


	public WebElement getRed_productimg() {
		return red_productimg;
	}

	
	public WebElement getRed_plusBtn() {
		return red_plusBtn;
	}


	public WebElement getRed_minusBtn() {
		return red_minusBtn;
	}


	public WebElement getRed_inputQty() {
		return red_inputQty;
	}


	public WebElement getRed_martianRedBtn() {
		return red_martianRedBtn;
	}


	public WebElement getRed_pixieBlueBtn() {
		return red_pixieBlueBtn;
	}


	public WebElement getRed_botClrText() {
		return red_botClrText;
	}


	public WebElement getRed_removeLink() {
		return red_removeLink;
	}


	public WebElement getRed_ProductPrice() {
		return red_ProductPrice;
	}


	public WebElement getSub_Total() {
		return sub_Total;
	}


	public WebElement getAdd_Another_Miko_Link() {
		return add_Another_Miko_Link;
	}


	public WebElement getShipping_Charges() {
		return shipping_Charges;
	}


	public WebElement getEstd_Tax_And_Fees() {
		return estd_Tax_And_Fees;
	}


	public WebElement getTotal_Amount() {
		return total_Amount;
	}


	public WebElement getGo_TO_CheckOut_Btn() {
		return go_TO_CheckOut_Btn;
	}


	public WebElement getNotificationPopupTitle() {
		return notificationPopupTitle;
	}


	public WebElement getNotification_YesBtn() {
		return notification_YesBtn;
	}


	public WebElement getNotification_CancelBtn() {
		return notification_CancelBtn;
	}


	public WebElement getMonth_price() {
		return month_price;
	}


	public WebElement getMonth_oneYearCard() {
		return month_oneYearCard;
	}


	public WebElement getMonth_threeMntCard() {
		return month_threeMntCard;
	}


	public WebElement getMonth_minusBtn() {
		return month_minusBtn;
	}


	public WebElement getMonth_plusBtn() {
		return month_plusBtn;
	}


	public WebElement getMonth_inputQty() {
		return month_inputQty;
	}


	public WebElement getMonth_removeBtn() {
		return month_removeBtn;
	}


	public WebElement getMonth_threeMntText() {
		return month_threeMntText;
	}


	public WebElement getMonth_oneYearText() {
		return month_oneYearText;
	}


	public WebElement getMonth_threeMntRadioBtn() {
		return month_threeMntRadioBtn;
	}


	public WebElement getMonth_oneYearRadioBtn() {
		return month_oneYearRadioBtn;
	}


	public WebElement getYear_price() {
		return year_price;
	}


	public WebElement getYear_oneYearCard() {
		return year_oneYearCard;
	}


	public WebElement getYear_threeMntCard() {
		return year_threeMntCard;
	}


	public WebElement getYear_minusBtn() {
		return year_minusBtn;
	}


	public WebElement getYear_plusBtn() {
		return year_plusBtn;
	}


	public WebElement getYear_inputQty() {
		return year_inputQty;
	}


	public WebElement getYear_removeBtn() {
		return year_removeBtn;
	}


	public WebElement getYear_threeMntText() {
		return year_threeMntText;
	}


	public WebElement getYear_oneYearText() {
		return year_oneYearText;
	}


	public WebElement getYear_threeMntRadioBtn() {
		return year_threeMntRadioBtn;
	}


	public WebElement getYear_oneYearRadioBtn() {
		return year_oneYearRadioBtn;
	}


	public WebElement getAddMiko3Btn() {
		return addMiko3Btn;
	}


	public WebElement getErrorMsgForWithoutMiko() {
		return errorMsgForWithoutMiko;
	}
	
	
	
	public WebElement selectColorText(WebDriver driver, String passColorText) {
		WebElement colorTxt = driver.findElement(By.xpath("//img[contains(@class,'sf-image-loaded')]/../../..//span[contains(text(),'"+passColorText+"')]"));
		return colorTxt;
	}
}


/*
error message before adding miko3
text = "You must add Miko3 in order to proceed with checkout!"
*/