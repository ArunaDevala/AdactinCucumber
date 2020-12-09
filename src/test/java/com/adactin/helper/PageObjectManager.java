package com.adactin.helper;

import org.openqa.selenium.WebDriver;

import com.adactin.pom.BookHotel;
import com.adactin.pom.BookingConfirmation;
import com.adactin.pom.SearchHotel;
import com.adactin.pom.SelectHotel;
import com.adactin.pom.SignInPage;

public class PageObjectManager {
public WebDriver driver;
	
	private SignInPage sp;
	private SearchHotel sh;
	private SelectHotel sh1;
	private BookHotel bh;
	private BookingConfirmation bc;

	public Object getLoginPage;

	public PageObjectManager(WebDriver ldriver) {

		this.driver=ldriver;
	}

	public SignInPage getSp() {
		sp = new SignInPage(driver);
		return sp;
	}

	public SearchHotel getSh() {
		sh = new SearchHotel(driver);
		return sh;
	}

	public SelectHotel getSh1() {
		sh1 = new SelectHotel(driver);
		return sh1;
	}

	public BookHotel getBh() {
		bh = new BookHotel(driver);
		return bh;
	}

	public BookingConfirmation getBc() {
		bc = new BookingConfirmation(driver);
		return bc;
	}
}
