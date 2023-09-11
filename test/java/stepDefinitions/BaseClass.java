package stepDefinitions;


import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomer;

public class BaseClass {
	static WebDriver driver;
	public LoginPage lPage;
	public AddCustomerPage aPage;
	public SearchCustomer customer;
	public String setRandomEmail() {
		String randomEmail=RandomStringUtils.randomAlphanumeric(5);
		return randomEmail;
	}
}
