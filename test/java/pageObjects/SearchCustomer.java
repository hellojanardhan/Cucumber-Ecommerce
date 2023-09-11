package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomer {
	WebDriver driver;
	public SearchCustomer(WebDriver d) {
		driver=d;
		PageFactory.initElements(d, this);
	}
	
	@FindBy(id = "SearchEmail")
	WebElement Email;
	
	@FindBy(id = "search-customers")
	WebElement SearchBtn;
	
	@FindBy(xpath = "//table[@id='customers-grid']")
	WebElement table;
	
	@FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr")
	List<WebElement> rows;
	
	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr/td")
	List<WebElement> cols;
	
	
	public void setEmail(String email) throws InterruptedException {
		Thread.sleep(2000);
		Email.clear();
		Email.sendKeys(email);
	}
	
	public void clickSearchBtn() {
		SearchBtn.click();
	}
	public int getRows() {
		return rows.size();
	}
	public int getCols() {
		return cols.size();
	}
	
	public boolean searchCustomerByEmail(String email) {
		boolean flag=false;
		for(int i=1;i<=getRows();i++) {
			String emailId=table.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(emailId);
			
			if(emailId.equals(email)) {
				flag=true;
			}
		}
		return flag;
	}
}
