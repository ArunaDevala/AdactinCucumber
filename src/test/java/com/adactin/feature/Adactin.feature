Feature: Booking functionality of Adactin application

Background:
 Given User launches tha application
 When User log into application


@SmokeTest
Scenario Outline: Verify the user is able to login the application
	Given User launches the application
	When User enters the valid "<username>" in the username field
	And User enters the valid "<password>" in the password field
	And User click on the login button
	Then User verifies whether Homepage navigates to search hotel page
	
	Examples:
	|username|password|
	|AAA|111|
	|BBB|222|
	|ArunaDevala|aruna123@|

	@RegressionTest
Scenario: To check User can update all the fields in Search Hotel page
	And User select the location from the "index" as "1" drop down option
	And User select the hotel from the "index" as "1" drop down option
	And User select the room type from "index" as "1" drop down option
	And User select the number of rooms from the "index" as "2" drop down option
	And User enters the valid check in date in the "10/12/2020" Date field
	And User enters the valid check out date in the "12/12/2020" Date field
	And User select the adults per room from the "index" as "2" drop down option
	And User select the children per room from the "index" as "2" drop down option
	And User click on the search button
	Then User verifies whether search hotel page navigates to select hotel page
	
	
	@SanityTest
Scenario: To check User can Select the Hotel name to continue the booking
	And User select the hotel on radio button in select field
	And User click on the continue button
	Then User verifies whether select hotel page navigates to Book A Hotel page

Scenario: Verify user can able to book a hotel with payment option
	And User enters the valid first name as "Gopi" in the First Name field
	And User enters the valid last name as "Sekar" in the Last Name field
	And User enters the valid billing address as "No. Braminar St. Cheyyar" in the Billing Address field
	And User enters the valid sixteen digit credit card number as "2456897894152314" in the Credit Card No. field
	And User select the credit card type "index" as "2" from the Credit Card Type drop down option
	And User select the expiry month as "index" and "2" in the Expiry Date option	
	And User select the expiry year as "value" and "2021" in the Expiry Date option
	And User enters the valid CVV number as "456" in the CVV number field
	And User click on the book now button
	Then User verifies book now page navigates into Booking confirmation

Scenario: Verify user booking confirmation with Order ID
	And User click on myItinerary button.
	Then User Verifies Booking confirmation page navigates to Booked Itinerary
