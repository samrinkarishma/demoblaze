package testcases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.baseclass;
import pageobjects.Loginpage;


public class Logintest extends baseclass{
	
//define a method that should drive a data from excel 
	@DataProvider(name="login")
	public Object[][] getlogindata() throws EncryptedDocumentException, IOException, InterruptedException
	{
		//create a file object from where i want to pull the data
		FileInputStream file=new FileInputStream("C:\\Users\\Dell-2023\\eclipse-workspace\\pomframework\\src\\test\\java\\testdata\\login.xlsx");
		Workbook workbook=WorkbookFactory.create(file);
		//Access the sheet in sheet1
		Sheet sheet=workbook.getSheet("Sheet1");
		
		//get the total number of row in sheet
		int rowcount= sheet.getLastRowNum();
		
		//get total number of column
		int columnCount= sheet.getRow(0).getLastCellNum();
		
		//create to store 2d array
		Object[][] data=new Object[rowcount][columnCount];
		
		Thread.sleep(2000);
		//iterate through each column 
		
		for(int i=0;i<rowcount;i++) {
		//get the current row
			Row row= sheet.getRow(i+1);
			
			//iterATE THROUGH column
			for(int j=0;j<columnCount;j++) {
				Cell cell=row.getCell(j);
				
				//store the cell value
				data[i][j]=(cell!=null)?cell.toString():null;
				
				
			}
			
		}
		
		
		return data;
	}
		
		
	@Test(dataProvider="login")
	public void LoginWith_valid_credentials(String username,String password ) throws InterruptedException{
		Reporter.log("Welcome to loginpage",true);		
		//create an object of loginpage
		Loginpage loginobj=new Loginpage(driver);
		loginobj.loginlinkclick();
		//loginobj.getusername(prop.getProperty("username"));
		Thread.sleep(2000);
		loginobj.getusername(username);
		loginobj.getpassword(password);
		//loginobj.getpassword(prop.getProperty("password"));
		Thread.sleep(2000);
		loginobj.click_submit_login();
		
	}

}
