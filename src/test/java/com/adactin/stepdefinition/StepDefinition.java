package com.adactin.stepdefinition;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.adactin.helper.FileReaderManager;
import com.adactin.helper.PageObjectManager;
import com.adactin.pom.BaseClass;
import com.adactin.runner.TestRunner;



import cucumber.api.Scenario;
import cucumber.api.java.*;
import cucumber.api.java.en.*;

public class StepDefinition extends BaseClass {

	public static WebDriver driver = TestRunner.driver;
	
	PageObjectManager pom = new PageObjectManager(driver);
	@Before
	public void beforeHooks(Scenario scenario) {
		String name = scenario.getName();
		System.out.println("Scenario Name: "+ name);

	}
	@After
	public void afetrHooks(Scenario scenario) throws IOException {
		String status = scenario.getStatus();
		System.out.println("		Scenario Status:"+ status);
		if (scenario.isFailed()) {
			screenShot(scenario.getName());
		}

	}
	@Given("^User launches tha application$")
	public void user_launches_tha_application() throws Throwable {
		System.out.println("User launches tha application");
	}

	@When("^User log into application$")
	public void user_log_into_application() throws Throwable {
	 System.out.println("User log into application"); 
	}

	

	@Given("^User launches the application$")
	public void user_launches_the_application() throws IOException {
		// driver = getBrowser("chrome");
		// getURL("http://adactinhotelapp.com/");
		String url = FileReaderManager.getInstance().getCrInstance().getUrl();
		getURL(url);

	}

	
	/*
	 * @When("^User enters the valid user name in the username field$") public void
	 * user_enters_the_valid_user_name_in_the_username_field() { SignInPage sp = new
	 * SignInPage(driver); inputValueToElement(sp.getEmail(), "gopikrish6030");
	 * 
	 * }
	 * 
	 * @When("^User enters the valid password in the password field$") public void
	 * user_enters_the_valid_password_in_the_password_field() { SignInPage sp = new
	 * SignInPage(driver); inputValueToElement(sp.getPassword(), "santhisekar30");
	 * 
	 * }
	 */
	@When("^User enters the valid \"([^\"]*)\" in the username field$")
	public void user_enters_the_valid_in_the_username_field(String username) throws Throwable {
		inputValueToElement(pom.getSp().getEmail(), username);
	}

	@When("^User enters the valid \"([^\"]*)\" in the password field$")
	public void user_enters_the_valid_in_the_password_field(String password) throws Throwable {
		inputValueToElement(pom.getSp().getPassword(), password);
	}
	

	@When("^User click on the login button$")
	public void user_click_on_the_login_button() {
		clickElement(pom.getSp().getLogIn());

	}

	@Then("^User verifies whether Homepage navigates to search hotel page$")
	public void user_verifies_whether_Homepage_navigates_to_search_hotel_page() {
		
		//assert.assertEquals("A","a");
		//Assert.assertEquals("A", "a");
	}
	

	
	
	/*
	 * @Given("^User select the location from the Location drop down option$")
	 * public void user_select_the_location_from_the_Location_drop_down_option() {
	 * SearchHotel sh = new SearchHotel(driver); dropDown(sh.getLocation(), "index",
	 * "1");
	 * 
	 * }
	 * 
	 * @Given("^User select the hotel from the Hotels drop down option$") public
	 * void user_select_the_hotel_from_the_Hotels_drop_down_option() { SearchHotel
	 * sh = new SearchHotel(driver); dropDown(sh.getHotels(), "index", "1");
	 * 
	 * }
	 * 
	 * @Given("^User select the room type from the Room Type drop down option$")
	 * public void user_select_the_room_type_from_the_Room_Type_drop_down_option() {
	 * SearchHotel sh = new SearchHotel(driver); dropDown(sh.getRoomType(), "index",
	 * "1");
	 * 
	 * }
	 * 
	 * @Given("^User select the number of rooms from the Number Of Rooms drop down option$"
	 * ) public void
	 * user_select_the_number_of_rooms_from_the_Number_Of_Rooms_drop_down_option() {
	 * SearchHotel sh = new SearchHotel(driver); dropDown(sh.getNoRoom(), "index",
	 * "2");
	 * 
	 * }
	 * 
	 * @Given("^User enters the valid check in date in the Check In Date field$")
	 * public void user_enters_the_valid_check_in_date_in_the_Check_In_Date_field()
	 * { SearchHotel sh = new SearchHotel(driver);
	 * inputValueToElement(sh.getCheckIn(), "01/12/2020");
	 * 
	 * }
	 * 
	 * @Given("^User enters the valid check out date in the Check Out Date field$")
	 * public void
	 * user_enters_the_valid_check_out_date_in_the_Check_Out_Date_field() {
	 * SearchHotel sh = new SearchHotel(driver);
	 * inputValueToElement(sh.getCheckOut(), "05/12/2020");
	 * 
	 * }
	 * 
	 * @Given("^User select the adults per room from the Adults per Room drop down option$"
	 * ) public void
	 * user_select_the_adults_per_room_from_the_Adults_per_Room_drop_down_option() {
	 * SearchHotel sh = new SearchHotel(driver); dropDown(sh.getAdultRoom(),
	 * "index", "2");
	 * 
	 * }
	 * 
	 * @Given("^User select the children per room from the Children per Room drop down option$"
	 * ) public void
	 * user_select_the_children_per_room_from_the_Children_per_Room_drop_down_option
	 * () { SearchHotel sh = new SearchHotel(driver); dropDown(sh.getChildRoom(),
	 * "index", "2");
	 * 
	 * }
	 */

	@Given("^User select the location from the \"([^\"]*)\" as \"([^\"]*)\" drop down option$")
	public void user_select_the_location_from_the_as_drop_down_option(String option, String location) throws Throwable {
		dropDown(pom.getSh().getLocation(), option, location);

	}

	@Given("^User select the hotel from the \"([^\"]*)\" as \"([^\"]*)\" drop down option$")
	public void user_select_the_hotel_from_the_as_drop_down_option(String option, String hotel) throws Throwable {
		dropDown(pom.getSh().getHotels(), option, hotel);


	}

	@Given("^User select the room type from \"([^\"]*)\" as \"([^\"]*)\" drop down option$")
	public void user_select_the_room_type_from_as_drop_down_option(String option, String roomType) throws Throwable {
		dropDown(pom.getSh().getRoomType(), option, roomType);

	}

	@Given("^User select the number of rooms from the \"([^\"]*)\" as \"([^\"]*)\" drop down option$")
	public void user_select_the_number_of_rooms_from_the_as_drop_down_option(String option, String numberOfRoom) throws Throwable {
		dropDown(pom.getSh().getNoRoom(), option, numberOfRoom);


	}

	/*
	 * @Given("^User enters the valid check in date in the \"([^\"]*)\" Date field$"
	 * ) public void user_enters_the_valid_check_in_date_in_the_Date_field(String
	 * ChkIn) throws Throwable { SearchHotel sh = new SearchHotel(driver);
	 * inputValueToElement(sh.getCheckIn(), ChkIn);
	 * 
	 * }
	 * 
	 * @Given("^User enters the valid check out date in the \"([^\"]*)\" Date field$"
	 * ) public void user_enters_the_valid_check_out_date_in_the_Date_field(String
	 * CheckOut) throws Throwable { SearchHotel sh = new SearchHotel(driver);
	 * inputValueToElement(sh.getCheckOut(), CheckOut);
	 * 
	 * 
	 * }
	 */
	@And("^User enters the valid check in date in the \"([^\"]*)\" Date field$")
	public void user_enters_the_valid_check_in_date_in_the_Date_field(String indate) throws Throwable {
		inputValueToElement(pom.getSh().getCheckIn(), indate);
	}

	@And("^User enters the valid check out date in the \"([^\"]*)\" Date field$")
	public void user_enters_the_valid_check_out_date_in_the_Date_field(String outdate) throws Throwable {
		inputValueToElement(pom.getSh().getCheckOut(), outdate);
	}

	@Given("^User select the adults per room from the \"([^\"]*)\" as \"([^\"]*)\" drop down option$")
	public void user_select_the_adults_per_room_from_the_as_drop_down_option(String option, String adultsPerRoom) throws Throwable {
		dropDown(pom.getSh().getAdultRoom(), option, adultsPerRoom);


	}

	@Given("^User select the children per room from the \"([^\"]*)\" as \"([^\"]*)\" drop down option$")
	public void user_select_the_children_per_room_from_the_as_drop_down_option(String option, String childrensPerRoom) throws Throwable {
		dropDown(pom.getSh().getChildRoom(), option, childrensPerRoom);


	}


	@Given("^User click on the search button$")
	public void user_click_on_the_search_button() {
		clickElement(pom.getSh().getSearch());

	}

	@Then("^User verifies whether search hotel page navigates to select hotel page$")
	public void user_verifies_whether_search_hotel_page_navigates_to_select_hotel_page() {
		
	}

	@Given("^User select the hotel on radio button in select field$")
	public void user_select_the_hotel_on_radio_button_in_select_field() {
		clickElement(pom.getSh1().getSelectHotel());

	}

	@Given("^User click on the continue button$")
	public void user_click_on_the_continue_button() {
		clickElement(pom.getSh1().getCont());

	}

	@Then("^User verifies whether select hotel page navigates to Book A Hotel page$")
	public void user_verifies_whether_select_hotel_page_navigates_to_Book_A_Hotel_page() {

	}

	/*
	 * @Given("^User enters the valid first name in the First Name field$") public
	 * void user_enters_the_valid_first_name_in_the_First_Name_field() { BookHotel
	 * bh = new BookHotel(driver); inputValueToElement(bh.getFirstName(), "Gopi");
	 * 
	 * }
	 * 
	 * @Given("^User enters the valid last name in the Last Name field$") public
	 * void user_enters_the_valid_last_name_in_the_Last_Name_field() { BookHotel bh
	 * = new BookHotel(driver); inputValueToElement(bh.getLastName(), "Sekar");
	 * 
	 * }
	 * 
	 * @Given("^User enters the valid billing address in the Billing Address field$"
	 * ) public void
	 * user_enters_the_valid_billing_address_in_the_Billing_Address_field() {
	 * BookHotel bh = new BookHotel(driver);
	 * inputValueToElement(bh.getBillAddress(), "No. Braminar St. Cheyyar");
	 * 
	 * }
	 * 
	 * @Given("^User enters the valid (\\d+) digit credit card number in the Credit Card No\\. field$"
	 * ) public void
	 * user_enters_the_valid_digit_credit_card_number_in_the_Credit_Card_No_field(
	 * int arg1) { BookHotel bh = new BookHotel(driver);
	 * inputValueToElement(bh.getCcNumber(), "2546987125412315");
	 * 
	 * }
	 * 
	 * @Given("^User select the credit card type from the Credit Card Type drop down option$"
	 * ) public void
	 * user_select_the_credit_card_type_from_the_Credit_Card_Type_drop_down_option()
	 * { BookHotel bh = new BookHotel(driver); dropDown(bh.getCcType(), "index",
	 * "2"); }
	 * 
	 * @Given("^User select the expiry month in the Expiry Date option$") public
	 * void user_select_the_expiry_month_in_the_Expiry_Date_option() { BookHotel bh
	 * = new BookHotel(driver); dropDown(bh.getExpMonth(), "index", "2");
	 * 
	 * }
	 * 
	 * @Given("^User select the expiry year in the Expiry Date option$") public void
	 * user_select_the_expiry_year_in_the_Expiry_Date_option() { BookHotel bh = new
	 * BookHotel(driver); dropDown(bh.getExpYear(), "value", "2021");
	 * 
	 * }
	 * 
	 * @Given("^User enters the valid CVV number in the CVV number field$") public
	 * void user_enters_the_valid_CVV_number_in_the_CVV_number_field() { BookHotel
	 * bh = new BookHotel(driver); inputValueToElement(bh.getCvvNumber(), "456");
	 * 
	 * }
	 */

	@Given("^User enters the valid first name as \"([^\"]*)\" in the First Name field$")
	public void user_enters_the_valid_first_name_as_in_the_First_Name_field(String fName) throws Throwable {
		inputValueToElement(pom.getBh().getFirstName(), fName);

	}

	@Given("^User enters the valid last name as \"([^\"]*)\" in the Last Name field$")
	public void user_enters_the_valid_last_name_as_in_the_Last_Name_field(String lName) throws Throwable {
		inputValueToElement(pom.getBh().getLastName(), lName);


	}

	@Given("^User enters the valid billing address as \"([^\"]*)\" in the Billing Address field$")
	public void user_enters_the_valid_billing_address_as_in_the_Billing_Address_field(String address) throws Throwable {
		inputValueToElement(pom.getBh().getBillAddress(), address);


	}

	@And("^User enters the valid sixteen digit credit card number as \"([^\"]*)\" in the Credit Card No\\. field$")
	public void user_enters_the_valid_sixteen_digit_credit_card_number_as_in_the_Credit_Card_No_field(String ccnumber) throws Throwable {
		inputValueToElement(pom.getBh().getCcNumber(), ccnumber);
	}

	@Given("^User select the credit card type \"([^\"]*)\" as \"([^\"]*)\" from the Credit Card Type drop down option$")
	public void user_select_the_credit_card_type_as_from_the_Credit_Card_Type_drop_down_option(String option, String ccType) throws Throwable {
		dropDown(pom.getBh().getCcType(), option, ccType);
		

	}

	@Given("^User select the expiry month as \"([^\"]*)\" and \"([^\"]*)\" in the Expiry Date option$")
	public void user_select_the_expiry_month_as_and_in_the_Expiry_Date_option(String option, String expMonth) throws Throwable {
		dropDown(pom.getBh().getExpMonth(), option, expMonth);
	

	}

	@Given("^User select the expiry year as \"([^\"]*)\" and \"([^\"]*)\" in the Expiry Date option$")
	public void user_select_the_expiry_year_as_and_in_the_Expiry_Date_option(String option, String expYr) throws Throwable {
		dropDown(pom.getBh().getExpYear(), option, expYr);


	}

	@Given("^User enters the valid CVV number as \"([^\"]*)\" in the CVV number field$")
	public void user_enters_the_valid_CVV_number_as_in_the_CVV_number_field(String cvvNumber) throws Throwable {
		inputValueToElement(pom.getBh().getCvvNumber(), cvvNumber);

	}


	@Given("^User click on the book now button$")
	public void user_click_on_the_book_now_button() {
		clickElement(pom.getBh().getBookNow());
	}

	@Then("^User verifies book now page navigates into Booking confirmation$")
	public void user_verifies_book_now_page_navigates_into_Booking_confirmation() {

	}

	@Given("^User click on myItinerary button\\.$")
	public void user_click_on_myItinerary_button() {
		clickElement(pom.getBc().getMyItinerary());

	}

	@Then("^User Verifies Booking confirmation page navigates to Booked Itinerary$")
	public void user_Verifies_Booking_confirmation_page_navigates_to_Booked_Itinerary() {

	}

}