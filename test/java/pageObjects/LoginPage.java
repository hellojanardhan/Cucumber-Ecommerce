package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver d) {
		driver=d;
		PageFactory.initElements(d, this);
	}
	
	@FindBy(name = "Email")
	WebElement Email;
	
	@FindBy(name = "Password")
	WebElement Password;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath = "/html/body/div[3]/nav/div/ul/li[3]/a")
	WebElement logoutBtn;
	public void setEmail(String email) {
		Email.clear();
		Email.sendKeys(email);
	}
	public void setPassword(String password) {
		Password.clear();
		Password.sendKeys(password);
	}
	public void Login() {
		loginBtn.click();
	}
	
	public void Logout() {
		logoutBtn.click();
	}
}
