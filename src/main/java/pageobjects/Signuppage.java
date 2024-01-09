package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signuppage {

	//create webdriver variable
	public WebDriver driver;
	//initialize pagefactory class init method in constructor
	public Signuppage(WebDriver driver) {
		//initialize pagefactory init and driver
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	//locate an element on signup page
	
	//signup dashboard link
	@FindBy(id="signin2")
	WebElement signupclicklink;
	
	//username
	@FindBy(id="sign-username")
	WebElement usernamefield;
	
	//password
	@FindBy(id="sign-password")
	WebElement userpassword;
	
	//submit button
	@FindBy(xpath="//button[.='Signup']")
	WebElement usersignuploginbtn;
	
	//close button
	@FindBy(xpath="(//button[.='Close'])[2]")
	WebElement usersignupclosebtn;
	
	
	//create method
	
	public void signup_linkclick() {
		signupclicklink.click();
	}
	
	public void getusername(String username) {
		usernamefield.sendKeys(username);
	}
	
	public void getpassword(String password) {
		userpassword.sendKeys(password);
	}
	public void click_submit_signup() {
		usersignupclosebtn.click();
	}
}
