package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class utility {
	public static WebDriver driver;
	public Properties prop;
	//develop functionality for browser selection
	public WebDriver initializeDriver() throws IOException{
	//use the properties from data.properties
	prop=new Properties();
	//path to property
	String propath=System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties";
	//create input stream object
	FileInputStream fis=new FileInputStream(propath);
	prop.load(fis);//we can get the data fron data.properties
	
	//code for selecting browser
	String choicebrowser=prop.getProperty("browser","chrome");
	
	if(choicebrowser.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}else if(choicebrowser.equals("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}else if(choicebrowser.equals("ie")) {
		WebDriverManager.iedriver().setup();
		driver=new InternetExplorerDriver();
	}else {
		System.out.println("Invalid browser selection");
		System.exit(1);
	}
	
	//maximize the window
		driver.manage().window().maximize();
		
	//delete cookies
		driver.manage().deleteAllCookies();
	//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
	return driver;
	}
	//Add Functionality to Takescreen shot
	public <TakeScreenshot> String takeScreenshot(String testname,WebDriver driver) throws IOException {
		File srcScreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//provide path for capture screenshot
		String screenshotfilepath=System.getProperty("user.dir")+"\\Screenshot\\"+testname+".png";
		//copy the file
		FileUtils.copyFile(srcScreenshot,new File(screenshotfilepath));
		return screenshotfilepath;	
}
	//Switching to window handle
	public static void Switchwindow() {
		String parentwindow=driver.getWindowHandle();
		Set<String> Windowhandles=driver.getWindowHandles();
		Windowhandles.size();
		//iterate through windows
		for(String childWindow:Windowhandles) {
			if(!childWindow.contentEquals(parentwindow)) {
				driver.switchTo().window(childWindow);
				
			}
			
		}
		
	}
	//function to wait for an element to be clickable
	public static WebElement Waitforelementtobeclickable(By locator, int timeoutinseconds) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(timeoutinseconds));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
		
	}
	}
	



