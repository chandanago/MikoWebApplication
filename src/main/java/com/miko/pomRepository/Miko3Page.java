package com.miko.pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.miko.genericLibrary.ExcelUtility;

public class Miko3Page {

	public WebDriver driver;


	public Miko3Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath ="//div[@class='product__colors']/descendant::span" )
	private WebElement color;
	@FindBy(xpath = "//div[@class='color-option']/descendant::button[contains(@class,'pixieblue sf-button--pure sf')]")

	private WebElement blueColor_Btn;
	@FindBy(xpath = "//div[@class='color-option']/..//button[@data-testid='Martian Red']")
	private WebElement redColor_Btn;
	@FindBy(xpath = "//div[@class='sf-checkbox__label']")
	private WebElement micoMaxSubscription_Radio_Btn;
	@FindBy(xpath = "//div[@class='sf-input__wrapper']")
	private WebElement quantity;
	@FindBy (xpath = "//button[contains(@class,'add-to-cart product-button')]")
	private WebElement buyNow_Btn;
	//miko3 page

	@FindBy(xpath = "//div[@class='sf-input sf-quantity-selector__input has-text']/preceding-sibling::button")
	private WebElement minus_Btn;

	@FindBy(xpath = "//div[@class='sf-input sf-quantity-selector__input has-text']/preceding-sibling::button[1]")
	private WebElement plus_Btn;


	public static WebElement colorText(WebDriver driver,String passColorTxt ) {
		WebElement colorTxt = driver.findElement(By.xpath("//span[contains(text(),'"+passColorTxt+"')]"));
		return colorTxt;
	}


	public WebElement getMinus_Btn() {
		return minus_Btn;
	}

	public WebElement getPlus_Btn() {
		return plus_Btn;
	}

	public WebElement getColor() {
		return color;
	}

	public WebElement getBlueColor_Btn() {
		return blueColor_Btn;
	}

	public WebElement getRedColor_Btn() {
		return redColor_Btn;
	}

	public WebElement getMicoMaxSubscription_Radio_Btn() {
		return micoMaxSubscription_Radio_Btn;
	}

	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getBuyNow_Btn() {
		return buyNow_Btn;
	}
}
