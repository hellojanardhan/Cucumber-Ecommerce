Feature: Add Customer functionality	 

Background: Below are common for every scenario
	When User launch firefox browser
	Then User opens URL "https://admin-demo.nopcommerce.com/login"
	And  Enter valid Email as "admin@yourstore.com" and Password as "admin"
	And  click on login button
	Then User can view dashboard

Scenario: Add new customer
	When Click on customer menu
	And  Click on customer menu item
	And  Click on add new 
	Then User can view add new customer page
	When User enter customer info
	And  Click on save button
	Then User can view confirmation message "The new customer has been added successfully."
	And  Close browser
	
Scenario: Search customer by Email ID
	When Click on customer menu
	And  Click on customer menu item
	And  Enter user name
	When Click Search button
	Then User email found in the search box
	And  Close browser
	
	