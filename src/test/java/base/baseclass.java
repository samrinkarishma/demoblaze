package base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.utility;

public class baseclass extends utility {

	//write code for starting and ending browser
	@BeforeMethod
	public void startup()throws IOException{
		driver=initializeDriver();
		//send the website url
		driver.get(prop.getProperty("url"));//it will set b
		
	}

	@AfterMethod
	public void close()
	{
		driver.quit();
	}

}
