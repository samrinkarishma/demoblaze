package testcases;

import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.baseclass;
import pageobjects.Homepage;

public class Homepagetest extends baseclass{
	Homepage homepage;
	
	@Test
	public void verifytitle_on_Homepage() {
		homepage=new Homepage(driver);
		Assert.assertEquals(homepage.verifyHomepagetitle(),"STORE");
		
	}
	@Test
	public void verifylogo_on_homepage() {
		homepage=new Homepage(driver);
		Assert.assertTrue(homepage.islogodisplayed());
		
	}
	
	@Test
	public void verify_allmenuitems_on_homepage() {
		homepage=new Homepage(driver);
		List<String>menulist=Arrays.asList("Home","Contact","About us","Cart","Log in","Sign up");
		List<WebElement> menuitems=homepage.getmenuitems();
		
		for(int i=0;i<menulist.size();i++) {
			for(WebElement element:menuitems) {
				if(menulist.get(i).equals(element.getText())) {
					System.out.println("All navigation menu items are available");
					assertTrue(true);
				}else {
					System.out.println("All navigation menu items are not available");
				}
			}
		}
	}
	
	@Test
	public void verify_product_features_presence() {
		homepage=new Homepage(driver);
		Assert.assertTrue(homepage.is_featuresproductavailable());

	}


}
