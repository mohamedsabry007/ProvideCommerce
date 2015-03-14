package automationFramework;
import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import app.Billing;
import app.PdpStartOrder;
import app.Recipient;
import app.Setup;
import pageObjects.CheckoutPage;
import pageObjects.checkoutConfirmationPage;

public class Checkout {
			
			private WebDriver driver;
			private StringBuffer verificationErrors = new StringBuffer();
			Sheet s;
			public int row =1,col = 0;
			
  @Before
    		public void setUp() throws Exception 
  					{
	  		driver = new FirefoxDriver();
	  		driver.manage().window().maximize();
	  		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
   					}

  	@Test
  			public void testCheckout() throws Exception
  				{
  					try 
  						{
  						
  		  				CheckoutPage checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);	  
		  				checkoutConfirmationPage confirmationPage=PageFactory.initElements(driver, checkoutConfirmationPage.class);
		  				FileInputStream fi = new FileInputStream("E:\\kallaTestAutomation\\TestData.xls");
		  				Workbook w = Workbook.getWorkbook(fi);
						s = w.getSheet(0);
		 		/*Test procedures for recipient page*/	
     				for( row=0;row<s.getRows()-1;row++)
		     		  			{
     					/* Select bouquet from excel sheet and Enter to Pdp*/
     								String bouquet=s.getCell(1,row).getContents(); 
     								driver.get(Setup.baseurl() + bouquet);
     					/*Test Procedures for select a bouquet , Add chocolate then checkout the product*/
     								PdpStartOrder.CheckoutWithChocolateAccessory(driver);
     								/*Test Procedures for Recipient section */	
     								Sheet RecipientSheet=w.getSheet(1);
		  							Recipient.InsertRecipient(driver,w,RecipientSheet);
		  							/*Test Procedures for Delivery date */
		  							CheckoutPage.PressASAP();
		  							checkoutPage.PressNext();
     		  						/*Test Procedure For billing Section*/
		  							Sheet PaymentSheet=w.getSheet(2);
		  							Billing.InsertBilling(driver,w,PaymentSheet);
		  						/*place order and checkout confirmation */
     		  						checkoutPage.getPlaceOrder();
     		  						confirmationPage.getCheckoutConfirmation();
     		  					}
     					
  						}
	  		catch(Exception ex)
	  						{
	  							System.out.printf(ex.getMessage(), "Error");
	  						}
  				
  				finally
  				{
  					driver.quit();
  					
  				}
  			}
  	
  			@After
  			public void tearDown() throws Exception 
  			{
	  			driver.quit();
	  			String verificationErrorString = verificationErrors.toString();
	  			if (!"".equals(verificationErrorString)) {
	  				fail(verificationErrorString);
	  				}
  			}
	
		}
			
