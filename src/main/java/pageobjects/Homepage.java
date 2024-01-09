package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	//create webdriver variable
			public WebDriver driver;
			//initialize pagefactory class init method in constructor
			public Homepage(WebDriver driver) {
				//initialize pagefactory init and driver
				this.driver=driver;
				PageFactory.initElements(driver,this);
			}
			//locate an element on page
           @FindBy(xpath="//*[@id=\"nava\"]/img")
           WebElement logo;
           
           @FindBy(xpath="//*[@id=\"navbarExample\"]/ul")
           List<WebElement> allmenuitems;
           
           
           @FindBy(xpath="//div[@id='tbodyid']/div[1]/div/div/h4/a")
           WebElement Samsunggalaxys6;
        //method   
		public Boolean islogodisplayed() {
			return logo.isDisplayed();
		}
           
        //create a method to verify title of the page
		public String verifyHomepagetitle() {
			return driver.getTitle();
		}
		//return collection of item
		public List<WebElement>getmenuitems(){
			return allmenuitems;

		}
		public boolean is_featuresproductavailable() {
			return Samsunggalaxys6.isDisplayed();
		}
}

