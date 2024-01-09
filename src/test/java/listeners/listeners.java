package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.baseclass;
import utilities.Extentreport;

public class listeners extends baseclass implements ITestListener {
	WebDriver driver=null;
	//create extent report object
	ExtentReports extentReport=Extentreport.getExtentReports();
	//Intialize extenttest variable
	ExtentTest extentTest;

	public void onTestStart(ITestResult result) {
		extentTest=extentReport.createTest(result.getName());
	}
	
	
	//create one more method before each test
	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, "Test passed..");
	}
	public void onTestFailure(ITestResult result) {
		extentTest.fail(result.getThrowable());
		//get the name of testcase
		String testName =result.getName();
		//logic to capture screenshot
		try {
		driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		
	}catch(Exception e) {
		e.printStackTrace();
	}
		
		try {
			
			//take screenshot
			String screenshotpath=takeScreenshot(testName,driver);
			extentTest.addScreenCaptureFromPath(screenshotpath,testName);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}

	
	public void onFinish(ITestContext context) {
		extentReport.flush();
	}
}

	
