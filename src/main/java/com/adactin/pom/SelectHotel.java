package com.adactin.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotel {

	public static WebDriver driver;

	@FindBy(xpath = "//input[@id='radiobutton_0']")
	private WebElement selectHotel;

	@FindBy(xpath = "//input[@id='continue']")
	private WebElement cont;

	public SelectHotel(WebDriver l2driver) {
		this.driver = l2driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getSelectHotel() {
		return selectHotel;
	}

	public WebElement getCont() {
		return cont;
	}

}
