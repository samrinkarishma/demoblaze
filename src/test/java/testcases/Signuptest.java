package testcases;

import org.testng.annotations.Test;

import base.baseclass;
import pageobjects.Signuppage;

public class Signuptest extends baseclass {
	
	@Test
	public void signup() throws InterruptedException {
		//create an object of signup page
		Signuppage signup=new Signuppage(driver);
		signup.signup_linkclick();
		signup.getusername(prop.getProperty("username"));
		Thread.sleep(2000);
		signup.getpassword(prop.getProperty("password"));
		Thread.sleep(2000);
		signup.click_submit_signup();
	}

}
