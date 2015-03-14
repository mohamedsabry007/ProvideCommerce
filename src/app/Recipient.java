package app;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import pageObjects.CheckoutPage;

public class Recipient {
	static String FName;
	static String LName; 	
	static String Recipient_Line;
	static String Recipient_Line1;
	static String City;
	static String State;
	static String PhoneNumber;
	static String PostalCode;
	static String Email;
	static int row = 0;
	
	
	public static void InsertRecipient(WebDriver driver,Workbook w,Sheet S ) throws BiffException, IOException
	{
		CheckoutPage.getRecipient_FirstName().clear();
		FName= S.getCell(0, row).getContents();
		CheckoutPage.getRecipient_FirstName().sendKeys(FName);

		CheckoutPage.getRecipient_LastName().clear();
		LName= S.getCell(1,row).getContents();
		CheckoutPage.getRecipient_LastName().sendKeys(LName);

		CheckoutPage.getRecipient_Line().clear();
		Recipient_Line= S.getCell(2, row).getContents();
		CheckoutPage.getRecipient_Line().sendKeys(Recipient_Line);
					      					
		CheckoutPage.getRecipient_PostalCode().clear();
		PostalCode= S.getCell(3, row).getContents();
		CheckoutPage.getRecipient_PostalCode().sendKeys(PostalCode);

		PhoneNumber= S.getCell(4,row).getContents();
		CheckoutPage.getRecipient_PhoneNumber().clear();
		CheckoutPage.getRecipient_PhoneNumber().sendKeys(PhoneNumber);

		Email=S.getCell(5,row).getContents();
		CheckoutPage.getRecipient_Email().clear();
		CheckoutPage.getRecipient_Email().sendKeys(Email);

		CheckoutPage.getConfirmMobile();
		CheckoutPage.getNext();

	}
}
