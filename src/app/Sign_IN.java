package app;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import pageObjects.LoginPage;

public class Sign_IN {
	 
	static int row=1;
	public static void login(WebDriver driver) throws InterruptedException, BiffException, IOException
	{
		Sheet s;
		FileInputStream fi = new FileInputStream("E:\\kallaTestAutomation\\TestData2.xls");
		Workbook w=Workbook.getWorkbook(fi);
		s=w.getSheet(1);
		String Email_Address =s.getCell(0,row).getContents();
		LoginPage.getEmailAddress().clear();
		LoginPage.getEmailAddress().sendKeys(Email_Address);
		LoginPage.getUserPassword().clear();
		String Password=s.getCell(1,row).getContents();
		LoginPage.getUserPassword().sendKeys(Password);
		LoginPage.getLogin();
		row++;
		
	}
}
