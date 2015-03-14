package automationFramework;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.events.EventException;
import app.Setup;
import app.Sign_IN;
import pageObjects.homePage;
import pageObjects.LoginPage;


public class Login {
	
	 	private  WebDriver driver = null;
		private StringBuffer verificationErrors = new StringBuffer();
		int row = 1 ;
		String Email_Address;
		String Password;
	  @Before
	  public void setUp() throws EventException {
		  
		  driver = new FirefoxDriver();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
	  }
  
	  @Test
	  public void testlogin() throws BiffException, IOException, InterruptedException
	  	{
		  try
		  	{  	
		  	  	LoginPage login = PageFactory.initElements(driver, LoginPage.class);
			  	homePage homePage = PageFactory.initElements(driver, homePage.class);
			  	
			  	
			  	driver.get(Setup.baseurl());
			  	homePage.ClosePopup();    
			  	Sheet s; 
			  	FileInputStream fi = new FileInputStream("E:\\kallaTestAutomation\\TestData1.xls");
			  	Workbook w = Workbook.getWorkbook(fi);
			  	s = w.getSheet(1);
			  	
			while( row<s.getRows()-1 )
					{
					LoginPage.Open_Login_Register();
					Sign_IN.login(driver);				
					String ErrorMessage= driver.findElement(By.xpath("html/body/header/div[2]/div/div/div[1]/form/div[1]")).getText();
				if(!IsTextPresent(ErrorMessage))
					{
						LoginPage.Open_Login_Register();
						Thread.sleep(3000);
						row++;
						continue;
					}
					
					else 
					{
					Thread.sleep(3000);	
					System.out.println("Sign_IN Successfully");
					String Actual = driver.findElement(By.xpath("html/body/header/div[2]/div/div/div[3]/h3[1]")).getText();
					String Expected = s.getCell(2,row).getContents();
					assertTrue("Verification Failed: The Actual is  the same as  Expected ",Actual.equals(Expected));
					loginPage.signout();
					Thread.sleep(3000);
					row++;
					
					pageObjects.homePage.OpenHomePage();
					}
				}
		  }
		  	catch(Error e)
					{
				verificationErrors.append(e.toString());
					}
		 
	  	}

	@After
		public void tearDown() throws Exception {
	  			driver.quit();
	  			String verificationErrorString = verificationErrors.toString();
	  			if (!"".equals(verificationErrorString))
	  				{
	  				fail(verificationErrorString);
	  				}
	  		}	
		public Boolean IsTextPresent(String textToBeVerified)
	{
		try
		{
				if (driver.findElement(By.xpath("//*[contains(.,'" + textToBeVerified + "')]")) != null)
					{
						
					return true;
						
					}
				} 
		catch (Exception ex)
						{
							return false;
							
						}

				return false;
			} 
	}


	  
	  


	

