package com.miko.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MikoMaxPage {
	public WebDriver driver;
	
	public MikoMaxPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(text(),'One Time - Annual Purchase')]/../..//div[contains(@class,'subscription-title')]")
	private WebElement yearSubscription_title;

	@FindBy(xpath="//div[contains(text(),'One Time - Annual Purchase')]/../..//div[@class='subscription-price']") 
	private WebElement yearSubscription_price;

	@FindBy(xpath="//div[contains(text(),'One Time - Annual Purchase')]/../..//div[@class='subscription-cut_price']") 
	private WebElement yearSubscription_cut_price;

	@FindBy(xpath="//div[contains(text(),'One Time - Annual Purchase')]/../..//div[@class='subscription-monthly-price']")
	private WebElement yearSubscription_perMonth;

	@FindBy(xpath="//div[contains(text(),'One Time - Annual Purchase')]/../..//div[@class='subscription-discount']")
	private WebElement yearSubscription_discount;

	@FindBy(xpath="//div[contains(text(),'One Time - Annual Purchase')]/../..//button[contains(@class,'btn-1')]")
	private WebElement yearSubscription_addToCartBtn;

	@FindBy(xpath="//div[contains(text(),'One Time - 3 Month Purchase')]/../..//div[contains(@class,'subscription-title')]")
	private WebElement monthSubscription_title;

	@FindBy(xpath="//div[contains(text(),'One Time - 3 Month Purchase')]/../..//div[@class='subscription-price']")
	private WebElement monthSubscription_price;

	@FindBy(xpath="//div[contains(text(),'One Time - 3 Month Purchase')]/../..//div[@class='subscription-monthly-price']")
	private WebElement monthSubscription_perMonth;

	@FindBy(xpath="//div[contains(text(),'One Time - 3 Month Purchase')]/../..//button[contains(@class,'btn-1')]")
	private WebElement monthSubscription_addToCartBtn;

	

	public WebElement getYearSubscription_title() {
		return yearSubscription_title;
	}

	public WebElement getYearSubscription_price() {
		return yearSubscription_price;
	}

	public WebElement getYearSubscription_cut_price() {
		return yearSubscription_cut_price;
	}

	public WebElement getYearSubscription_perMonth() {
		return yearSubscription_perMonth;
	}

	public WebElement getYearSubscription_discount() {
		return yearSubscription_discount;
	}

	public WebElement getYearSubscription_addToCartBtn() {
		return yearSubscription_addToCartBtn;
	}

	public WebElement getMonthSubscription_title() {
		return monthSubscription_title;
	}

	public WebElement getMonthSubscription_price() {
		return monthSubscription_price;
	}

	public WebElement getMonthSubscription_perMonth() {
		return monthSubscription_perMonth;
	}

	public WebElement getMonthSubscription_addToCartBtn() {
		return monthSubscription_addToCartBtn;
	}
}
