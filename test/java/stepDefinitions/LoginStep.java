package stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomer;

public class LoginStep extends BaseClass{
	
	@When("User launch firefox browser")
	public void user_launch_firefox_browser() {
	    WebDriverManager.firefoxdriver().setup();
	    driver=new FirefoxDriver();
	    lPage=new LoginPage(driver);
	    aPage=new AddCustomerPage(driver);
	    customer=new SearchCustomer(driver);
	}

	@Then("User opens URL {string}")
	public void user_opens_url(String url) {
		
	    driver.get(url);
	}

	@Then("Enter valid Email as {string} and Password as {string}")
	public void enter_valid_email_as_and_password_as(String email, String password) {
	    lPage.setEmail(email);
	    lPage.setPassword(password);
	}

	@Then("click on login button")
	public void click_on_login_button() {
	  lPage.Login();
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String title) {
	    if(driver.getPageSource().contains("Login was unsuccessful")) {
	    	driver.close();
	    	Assert.assertTrue(false);
	    }
	    else {
			assertEquals(title, driver.getTitle());
		}
	}
	

	@When("user Click on Logout")
	public void user_click_on_logout() throws InterruptedException {
		Thread.sleep(3000);
	    lPage.Logout();
	    
	}

	@Then("Close browser")
	public void Close_browser() {
	    driver.quit();
	}
	
	//Add Customer functionality
	@Then("User can view dashboard")
	public void user_can_view_dashboard() throws InterruptedException {
		Thread.sleep(2000);
	    assertEquals(aPage.getTitle(), "Dashboard / nopCommerce administration");
	}

	@When("Click on customer menu")
	public void click_on_customer_menu() throws InterruptedException{
		Thread.sleep(2000);
	    aPage.clickCustomerMenu();
	}

	@When("Click on customer menu item")
	public void click_on_customer_menu_item() throws InterruptedException{
		Thread.sleep(2000);
		aPage.clickCustomerMenuItem();
	}

	@When("Click on add new")
	public void click_on_add_new() throws InterruptedException{
		Thread.sleep(2000);
		aPage.clickAddNew();
	}

	@Then("User can view add new customer page")
	public void user_can_view_add_new_customer_page() throws InterruptedException {
		Thread.sleep(2000);
	    assertEquals(aPage.getTitle(), "Add a new customer / nopCommerce administration");
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		Thread.sleep(2000);
		String Email=setRandomEmail()+"@gmail.com";
		aPage.setEmail(Email);
		aPage.setPassword("test123");
		aPage.setfName("Jhonwick");
		aPage.setlName("Jhon");
		Thread.sleep(1000);
		aPage.setManagerVendor("Vendor 2");
		aPage.setGenderMale("Male");
		aPage.setDOB("7/09/2000");
		aPage.setCompanyName("KingFisher");
		aPage.adminComment("This is for testing......");

	}

	@When("Click on save button")
	public void click_on_save_button() throws InterruptedException {
		Thread.sleep(2000);
		aPage.clickSave();
	    
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String value) throws InterruptedException {
		Thread.sleep(2000);
		assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));
	}
	
	
	
	//Searching a customer using email Id
	@When("Enter user name")
	public void enter_user_name() throws InterruptedException  {
	    customer.setEmail("victoria_victoria@nopCommerce.com");
	}

	@When("Click Search button")
	public void click_search_button() throws InterruptedException {
	    customer.clickSearchBtn();
	    Thread.sleep(2000);
	}

	@Then("User email found in the search box")
	public void user_email_found_in_the_search_box() {
		boolean status=customer.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		if(status==true) {
			System.out.println("Email Found");
		}
		else {
			System.out.println("not found");
		}
	}


}
