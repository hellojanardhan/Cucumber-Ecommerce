Feature: Login Functionality

Scenario: Successful login with valid credentials
	When User launch firefox browser
	Then User opens URL "https://admin-demo.nopcommerce.com/login"
	And  Enter valid Email as "admin@yourstore.com" and Password as "admin"
	And  click on login button
	Then page title should be "Dashboard / nopCommerce administration"
	When user Click on Logout
	Then page title should be "Your store. Login"
	And  Close browser
	
Scenario Outline:  Successful login with valid credentials
	When User launch firefox browser
	Then User opens URL "https://admin-demo.nopcommerce.com/login"
	And  Enter valid Email as "<email>" and Password as "<password>"
	And  click on login button
	Then page title should be "Dashboard / nopCommerce administration"
	When user Click on Logout
	Then page title should be "Your store. Login"
	And  close browser

	Examples: 
	|email| password |
	| janardhan@abc.com | admin |
	| admin@yourstore.com | admin |