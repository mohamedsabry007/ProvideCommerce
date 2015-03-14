package automationFramework;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.w3c.dom.events.EventException;

import pageObjects.ProductDetails;
import pageObjects.homePage;
import app.Setup;

public class AddChocolatePDP {
	  private WebDriver driver; 
	  private StringBuffer verificationErrors = new StringBuffer();
	  Setup set = new Setup();
	  int row=0 ;
	  int col =0;
	  Sheet sheet; 
	  
	  @Before
	  public void setUp() throws EventException {
	    
		  driver = new FirefoxDriver();
	    
	      driver.manage().window().maximize();
	    
	      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  }

	  @Test
	  
	  public void testPDP() throws Exception {
		
		 		  
		   		
		  		driver.get(Setup.baseurl());
			
		 		sheet= w.getSheet(0);
		  		
		 		while( row<sheet.getRows() -1 )
		  			{
		  			
		 			String Bouquet= sheet.getCell(col,row).getContents();
					
					driver.findElement(By.xpath(Bouquet)).click();
		  				  			
		  			driver.findElement(By.xpath("/html/body/div[1]/div/form/div/div[1]/div[1]/div/div[1]/div/a")).click();
		  			
		  			ProductDetails.EnterRecipientFirstName();
					
		  			ProductDetails.AddPairing();
					
		  			ProductDetails.addChocolates();
		  				
		  			row++;
		  				
		  			homePage.OpenHomePage();
		  			
		  			}
	  
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    java.lang.String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }
	}


