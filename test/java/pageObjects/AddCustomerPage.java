package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	WebDriver driver;
	
	public AddCustomerPage(WebDriver d) {
		driver=d;
		PageFactory.initElements(d, this);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	//Customer-menu
	By customerMenu=By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a");
	
	//Customer-menu Item
	By customerMenuItem=By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a[1]");
	
	//Add new 
	By addNew=By.xpath("//a[@class='btn btn-primary']");
	
	//Customer information
	//Email
	By Email=By.id("Email");
	//Password
	By Password=By.id("Password");
	//first-name
	By firstName=By.id("FirstName");
	//last-name
	By lastName=By.id("LastName");
	//Gender_male
	By genderMale=By.id("Gender_Male");
	//Gender_female
	By genderFemale=By.id("Gender_Female");
	//date of birth
	By dateOfBirth=By.id("DateOfBirth");
	//Company
	By Company=By.id("Company");
	//tax
	By tax=By.id("IsTaxExempt");
	
	//customerRoles
	By customerRoles=By.id("//div[@class='input-group-append input-group-required']//div[@class='input-group']//div[@class='k-widget k-multiselect k-multiselect-clearable']//div[@class='k-multiselect-wrap k-floatwrap']");
	//administrators
	By AdminRole=By.xpath("//li[contains(text(),'Administrators')]");
	//moderators
	By forumRole=By.xpath("//li[contains(text(),'Forum Moderators')]");
	//guests
	By guestRole=By.xpath("//li[contains(text(),'Guests')]");
	//registered
	By registerRole=By.xpath("/html[1]/body[1]/div[6]/div[1]/div[2]/ul[1]/li[4]");
	//vendors
	By vendorRole=By.xpath("//li[contains(text(),'Vendors')]");
	
	
	//Manage of vendor
	By 	ManageVendor=By.id("VendorId");
	//adminContent
	By adminContent=By.id("AdminComment");
	
	//Save button
	By saveBtn=By.name("save");
	
	public void clickCustomerMenu() {
		driver.findElement(customerMenu).click();
	}
	public void clickCustomerMenuItem() {
		driver.findElement(customerMenuItem).click();
	}
	public void clickAddNew() {
		driver.findElement(addNew).click();
	}
	public void setEmail(String email) {
		driver.findElement(Email).sendKeys(email);
	}
	public void setPassword(String password) {
		driver.findElement(Password).sendKeys(password);
	}
	public void setfName(String fname) {
		driver.findElement(firstName).sendKeys(fname);
	}
	public void setlName(String lname) {
		driver.findElement(lastName).sendKeys(lname);
	}
	public void setGenderMale(String gender) {
		if(gender.equals("Male")) {
			driver.findElement(genderMale).click();
		}
		else {
			driver.findElement(genderFemale).click();
		}
	}
	public void setDOB(String dob) {
		driver.findElement(dateOfBirth).sendKeys(dob);
	}
	public void setCompanyName(String company) {
		driver.findElement(Company).sendKeys(company);
	}
	public void setTax() {
		driver.findElement(tax).click();
	}
	public void setManagerVendor(String value) {
		Select select=new Select(driver.findElement(ManageVendor));
		select.selectByVisibleText(value);
	}
	public void adminComment(String content) {
		driver.findElement(adminContent).sendKeys(content);
	}
	public void clickSave() {
		driver.findElement(saveBtn).click();
	}
	
	
}
