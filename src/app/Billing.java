package app;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import pageObjects.CheckoutPage;

public  class Billing {
	static String S_firstname;
	static String S_lastname;
	static String S_AddressLine;
	static String S_City;
	static String S_State;
	static String S_Zipcode;
	static String S_PhoneNumber;
	static String S_Email;
	static String S_Password;
	static String promocode;
	static int row = 0;
	public static void InsertBilling(WebDriver driver ,Workbook w,Sheet s) throws BiffException, IOException, InterruptedException
	{
		
		
		S_firstname = s.getCell(0,row).getContents();
		CheckoutPage.getSenderFirstName().clear();
		CheckoutPage.getSenderFirstName().sendKeys(S_firstname);
		
		S_lastname = s.getCell(1,row).getContents();
		CheckoutPage.getSenderLastName().clear();
		CheckoutPage.getSenderLastName().sendKeys(S_lastname);
		
		S_AddressLine = s.getCell(2,row).getContents();
		CheckoutPage.getsenderAddressLine1().clear();
		CheckoutPage.getsenderAddressLine1().sendKeys(S_AddressLine);
		
		S_City=s.getCell(3,row).getContents();
		CheckoutPage.getAddressCity().clear();
		CheckoutPage.getAddressCity().sendKeys(S_City);
		
		S_State=s.getCell(4,row).getContents();
		CheckoutPage.getsenderState().selectByVisibleText(S_State);
		
		S_Zipcode=s.getCell(5,row).getContents();
		CheckoutPage.getsenderAddressZip().clear();
		CheckoutPage.getsenderAddressZip().sendKeys(S_Zipcode);
		
		S_PhoneNumber=s.getCell(6,row).getContents();
		CheckoutPage.getDaytimePhoneNumber().clear();
		CheckoutPage.getDaytimePhoneNumber().sendKeys(S_PhoneNumber);
		
		CheckoutPage.getsenderCCNumber();
		
		CheckoutPage.getCreditCardDetails_ExpirationMonth();
		
		CheckoutPage.getCreditCardDetails_ExpirationYear();
		
		/*checkout your order  for logged in user */
	if(!(CheckoutPage.getsenderEmail().isDisplayed()&&CheckoutPage.getsenderPassword().isDisplayed()))
			{
			 promocode = s.getCell(20,row).getContents();
			 if(promocode==null)
			 {
			 
			 CheckoutPage.getbuyerNext();
			 Thread.sleep(10000);
			 }
			 else 
			 {
				 CheckoutPage.getPromoCode().sendKeys(promocode);
				 CheckoutPage.getbuyerNext();
				 Thread.sleep(10000);
			 }
			}
	/*checkout your order for guest */
	else if (CheckoutPage.getsenderEmail().isDisplayed()&&CheckoutPage.getsenderPassword().isDisplayed())
						{
					S_Email=s.getCell(7,row).getContents();
					CheckoutPage.getsenderEmail().clear();
					CheckoutPage.getsenderEmail().sendKeys(S_Email);
					S_Password=s.getCell(8,row).getContents();
					CheckoutPage.getsenderPassword().sendKeys(S_Password);
					promocode = s.getCell(20,row).getContents();
					if(promocode==null)
						{
		 
						CheckoutPage.getbuyerNext();
						/*WebDriverWait wait = new WebDriverWait(driver, 20); //here, wait time is 20 seconds
						wait.until(ExpectedConditions.visibilityOf(element)); //this will wait for elememt to be visible for 20 seconds
*/						}
					else 
					{
						CheckoutPage.getPromoCode().sendKeys(promocode);
						CheckoutPage.getbuyerNext();
						Thread.sleep(10000);
					}
		
			}
		}
	
	}