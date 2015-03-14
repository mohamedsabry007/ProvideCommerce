package automationFramework;

import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import pageObjects.CheckoutPage;
import pageObjects.ProductDetails;
import pageObjects.checkoutConfirmationPage;
import app.Billing;
import app.Recipient;
import app.Setup;

public class TakeAHintCheckout {
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	Sheet s;
	Setup set = new Setup();
	public int row =1,col = 0;
	String WMessage;
	String FName;
	String LName; 	
	String Recipient_Line;
	String Recipient_Line1;
	String City;
	String State;
	String PhoneNumber;
	String PostalCode;
	String Email;
	String S_firstname;
	String S_lastname;
	String S_AddressLine;
	String S_City;
	String S_State;
	String S_Zipcode;
	String S_PhoneNumber;
	String S_Email;
	String S_Password;
@Before
	public void setUp() throws Exception 
				{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

				}

@Test
		public void testCheckout() throws Exception
			{
				try 
					{
	  			CheckoutPage checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);	  
  				ProductDetails PdpPage = PageFactory.initElements(driver, ProductDetails.class);
  				
  				checkoutConfirmationPage confirmationPage=PageFactory.initElements(driver, checkoutConfirmationPage.class);
  				driver.get(Setup.baseurl());
  				
  				
  				FileInputStream fi = new FileInputStream("E:\\kallaTestAutomation\\TestData2.xls");
  				Workbook w = Workbook.getWorkbook(fi);
				s = w.getSheet(0);
				String a[][] = new String[s.getRows()][s.getColumns()];
  		    	FileOutputStream fo = new FileOutputStream("E:\\kallaTestAutomation\\TestData3.xls");
  		     	WritableWorkbook wwb= Workbook.createWorkbook(fo);
  		        WritableSheet wsheet = wwb.createSheet("First Sheet", 0);
  		        System.out.println("s.getRows() = " + s.getRows());
  		        for (int i = 0; i < s.getRows(); i++) 
  		        {
  		        System.out.println("s.getColumns = " + s.getColumns());
  		        for (int j = 0; j < s.getColumns(); j++) 
  		        	{
  		        a[i][j] = s.getCell(j, i).getContents();
  		        jxl.write.Label l = new jxl.write.Label(j, i, a[i][j]);
  		        wsheet.addCell(l);
  		        	}
  		        }
  			
	 		/*Test procedures for recipient page*/	
				for( row=1;row<s.getRows()-1;row++)
					{
						//AddAccessory.Addchocolate();
  							//ProductDetails.AddwineChocolate(driver);
  							PdpPage.Checkout();
  							/*Test Procedures for Recipient section */	
  							Recipient.InsertRecipient();
  							/*Test Procedures for Delivery date */
  							CheckoutPage.PressASAP();
  							checkoutPage.PressNext();
		  						/*Test Procedure For billing Section*/
  							Billing.InsertBilling();
  							
  							/*Get Billing Invoice*/
  							String subTotalOrder=CheckoutPage.getSubTotalTxt().getText();
		  					String Tax = CheckoutPage.getTaxText().getText();
		  					String TotalOrder = CheckoutPage.getTotal().getText();
		  						//String discount=CheckoutPage.getDiscount().getText();
		  						
		  						jxl.write.Label l2 = new jxl.write.Label(16, row, subTotalOrder);
		  						jxl.write.Label l3 = new jxl.write.Label(17, row, Tax);
		  						//jxl.write.Label l4 = new jxl.write.Label(18, row, discount);
		  						jxl.write.Label l5 = new jxl.write.Label(19, row, TotalOrder);
		  						jxl.write.Label l6 = new jxl.write.Label(21, row, "Pass");
		  						wsheet.addCell(l2);
		  						wsheet.addCell(l3);
		  						//wsheet.addCell(l4);
		  						wsheet.addCell(l5);
		  						wsheet.addCell(l6);
		  						/*place order and checkout confirmation */
		  						checkoutPage.getPlaceOrder();
		  						confirmationPage.getCheckoutConfirmation();
		  					}
					wwb.write();
					wwb.close();
					
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
