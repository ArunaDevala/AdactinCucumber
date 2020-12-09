package com.adactin.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingConfirmation {
	public static WebDriver driver;

	@FindBy(xpath = "//input[@id='my_itinerary']")
	private WebElement myItinerary;
	
	public BookingConfirmation(WebDriver l4driver) {
		this.driver=l4driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getMyItinerary() {
		return myItinerary;
	}

}
