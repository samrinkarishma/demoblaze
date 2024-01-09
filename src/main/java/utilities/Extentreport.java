package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreport {

	//method to create an extent report objects for generating our report
	public static ExtentReports getExtentReports() {
		String extentReportpath=System.getProperty("user.dir")+"\\reports\\extentreport.html";
		//create an object of Extentsparkreport
		ExtentSparkReporter reporter=new ExtentSparkReporter(extentReportpath);
		
		//set the document name and title
		reporter.config().setReportName("Demoblaze");
		reporter.config().setDocumentTitle("Demoblaze automation test.....");
		
		//create an object of extentreports
		ExtentReports extentreport=new ExtentReports();
		extentreport.attachReporter(reporter);
		
		
		return extentreport;
	}
}
