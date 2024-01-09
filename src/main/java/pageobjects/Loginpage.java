package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	//create webdriver variable
		public WebDriver driver;
		//initialize pagefactory class init method in constructor
		public Loginpage(WebDriver driver) {
			//initialize pagefactory init and driver
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
		//locate an element on signup page
		
		//link click
		@FindBy(id="login2")
		WebElement loginlinkfield;
		
		//login username
		@FindBy(id="loginusername")
		WebElement usernameloginfield;
		//login password
		@FindBy(id="loginpassword")
		WebElement userpasswordlloginfield;
		
		//login button
		@FindBy (xpath="//button[.='Log in']")
		WebElement userloginbtn;
		
		//create method
		
		public void loginlinkclick() {
			loginlinkfield.click();
		}
		
		public void getusername(String username) {
			usernameloginfield.sendKeys(username);
		}
		
		public void getpassword(String password) {
			userpasswordlloginfield.sendKeys(password);
		}
		public void click_submit_login() {
			userloginbtn.click();
		}
		
		

}
