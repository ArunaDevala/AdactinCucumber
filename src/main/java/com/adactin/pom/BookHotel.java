package com.adactin.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookHotel {

	public static WebDriver driver;

	@FindBy(xpath = "//input[@id='first_name']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@id='last_name']")
	private WebElement lastName;

	@FindBy(xpath = "//textarea[@name='address']")
	private WebElement billAddress;

	@FindBy(xpath = "//input[@id='cc_num']")
	private WebElement ccNumber;

	@FindBy(xpath = "//select[@id='cc_type']")
	private WebElement ccType;

	@FindBy(xpath = "//select[@id='cc_exp_month']")
	private WebElement expMonth;

	@FindBy(xpath = "//select[@id='cc_exp_year']")
	private WebElement expYear;

	@FindBy(xpath = "//input[@id='cc_cvv']")
	private WebElement cvvNumber;

	@FindBy(xpath = "//input[@name='book_now']")
	private WebElement bookNow;

	public BookHotel(WebDriver l3driver) {
		this.driver = l3driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getBillAddress() {
		return billAddress;
	}

	public WebElement getCcNumber() {
		return ccNumber;
	}

	public WebElement getCcType() {
		return ccType;
	}

	public WebElement getExpMonth() {
		return expMonth;
	}

	public WebElement getExpYear() {
		return expYear;
	}

	public WebElement getCvvNumber() {
		return cvvNumber;
	}

	public WebElement getBookNow() {
		return bookNow;
	}

}
