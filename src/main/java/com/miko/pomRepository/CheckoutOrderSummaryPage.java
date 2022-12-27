package com.miko.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOrderSummaryPage {
public WebDriver driver;

public CheckoutOrderSummaryPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

	
	/* Product details  pane */
	@FindBy(xpath = "//table[@class='product-table']/descendant::td[@class='product__image']/descendant::span[@class='product-thumbnail__quantity']")
	private WebElement qty_From_Product_Image;
	@FindBy(xpath = "//table[@class='product-table']/descendant::td[@class='product__price']/descendant::span")
	private WebElement product_Price;
	@FindBy(xpath = "//table[@class='total-line-table']/descendant :: tr[@class='total-line total-line--subtotal']/td[1]/span")
	private WebElement subTotoal;
	@FindBy(xpath = "//table[@class='total-line-table']/descendant :: tr[@class='total-line total-line--shipping']/td[1]/span")
	private WebElement shgipping_Charges;
	@FindBy(xpath = "//table[@class='total-line-table']/descendant :: tr[@class='total-line total-line--taxes ']/td[1]/span")
	private WebElement taxes;
	@FindBy(xpath = "//table[@class='total-line-table']/tfoot/tr/td/span[@class='payment-due__currency remove-while-loading']")
	private WebElement billing_Currency;
	@FindBy(xpath = "//table[@class='total-line-table']/tfoot/tr/td/span[@class='payment-due__price skeleton-while-loading--lg']")
	private WebElement billing_price;
	@FindBy(xpath = "//div[@class='sf-input sf-quantity-selector__input has-text']/preceding-sibling::button")
	private WebElement minus_Btn;
	@FindBy(xpath = "//div[@class='sf-input__wrapper']")
	private WebElement quantity;
	@FindBy(xpath = "//div[@class='sf-input sf-quantity-selector__input has-text']/preceding-sibling::button[1]")
	private WebElement plus_Btn;

	
	@FindAll({@FindBy(xpath = "//input[@name='reductions']"), @FindBy(id = "checkout_reduction_code")})
	private WebElement discount_Code_TxtField;

	@FindAll({@FindBy(xpath = "//button[@aria-label='Apply Discount Code']"),@FindBy(xpath = "//button[@id='checkout_submit']")})
	private WebElement applyBtn;

	@FindAll({@FindBy(xpath="//span[contains(text(),'Total')]/../../descendant::strong[.]"),@FindBy(xpath = "//span[contains(@class,'payment-due__price')]")})
	private WebElement finalAmt;

	@FindAll({@FindBy(xpath = "//p[contains(text(),'Miko 3')]/../child::div/p"),
	@FindBy(xpath = "//span[contains(@class,'product__description__variant')]")})
	private WebElement productClr;

	
	
	public WebElement getProductClr() {
		return productClr;
	}
	
	public WebElement getFinalAmt() {
		return finalAmt;
	}
	
	public WebElement getApplyBtn() {
		return applyBtn;
	}
	
	public WebElement getQuantity() {
		return quantity;
	}

	public void setQuantity(WebElement quantity) {
		this.quantity = quantity;
	}

	public WebElement getMinus_Btn() {
		return minus_Btn;
	}

	public WebElement getPlus_Btn() {
		return plus_Btn;
	}

	public WebElement getQty_From_Product_Image() {
		return qty_From_Product_Image;
	}

	public WebElement getProduct_Price() {
		return product_Price;
	}

	public WebElement getDiscount_Code_TxtField() {
		return discount_Code_TxtField;
	}

	public WebElement getSubTotoal() {
		return subTotoal;
	}

	public WebElement getShgipping_Charges() {
		return shgipping_Charges;
	}

	public WebElement getTaxes() {
		return taxes;
	}

	public WebElement getBilling_Currency() {
		return billing_Currency;
	}

	public WebElement getBilling_price() {
		return billing_price;
	}	

}
