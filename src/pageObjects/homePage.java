package pageObjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage {
	
		
	@FindBy(xpath = "/html/body/div[2]/div/a")
	private WebElement closePopup;
	
	@FindBy(xpath="html/body/header/ul/li[2]/a/img")
	private static WebElement KallaLogo;

	public void ClosePopup() {

		// TODO Auto-generated method stub
		try
		{
		 
		this.closePopup.click();
		}
		catch(NoSuchElementException nsee) {
			   System.out.println("The splash was not located.");
			} catch(AssertionError ae) {
			   System.out.println("The splash was located, but not displayed.");
			}
		
	}
	public  static void OpenHomePage() {
		// TODO Auto-generated method stub
		KallaLogo.click();	
	}
	
}
