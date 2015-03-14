package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetails {
	
	@FindBy(id="checkoutButton")
	private static WebElement checkout;
	
	@FindBy(linkText="more about our chocolates")
		private static WebElement AboutBouquet;
	
	@FindBy(xpath="html/body/div[1]/div/form/div/div[1]/div[1]/div/div[3]/div/a[2]")
		private static WebElement Addchocolatebtn;
	
	@FindBy(xpath="html/body/div[1]/div/form/div/div[1]/div[1]/div/div[3]/div/a[1]")
		private WebElement NothanksForChocolate;
		
	@FindBy(id="WineAgeConfirmationHelper")
		private static WebElement AgeConfirmation;
	
	@FindBy(xpath="html/body/div[1]/div/form/div/div[1]/div[1]/div/div[4]/div/a[2]")
		private static WebElement AddWine;
	
	@FindBy(linkText="more about our chocolates")
		private static WebElement AboutWine;
	
	@FindBy(xpath="html/body/div[1]/div/form/div/div[1]/div[1]/div/div[4]/div/a[1]")
		private static WebElement NothanksForWine;
	
	@FindBy (name ="Message")
		private WebElement Message;
				
	@FindBy(linkText="Personalize")
		private WebElement getPersonalize;
	
	@FindBy(linkText ="Click here")
		private WebElement getRafcode;
		
	@FindBy(id="filePhoto")
		private WebElement filePhoto;

	@FindBy(id="vimeoFileUpload")
		private WebElement VideoUpload;

	@FindBy(xpath = ".//*[@id='checkoutButton']")
		private  WebElement checkoutbtn;
	
	public static void btncheckout()
	{
		checkout.click();
	}

	public static void AboutBouquet()
	{
		AboutBouquet.click();
	}
	public  void Checkout() {
		// TODO Auto-generated method stub
		checkoutbtn.click();
	}

	public static void  addChocolates()
	{
		Addchocolatebtn.click();
	}

	public static void  Add_Wine()
	{
		AddWine.click();
	}

	public WebElement  InsertMessage()
	{
		
		return Message;
	}
	public void  getReferAFriend()
	{
		try
		{
			this.getRafcode.click();
		}
		catch(Exception ex)
		{
			ex.getMessage().toString();
		}
	}
	public static void  getAgeConfirmation()
	{
		try
		{
			AgeConfirmation.click();
		}
		catch(Exception ex)
		{
			ex.getMessage();
		}
	}
	public void  getPersonalize()
	{
		try
		{
			this.getPersonalize.click();
		}
		catch(Exception ex)
		{
			ex.getCause().toString();
		}
	}
	public void  getPhoto()
	{
		try
		{
		
			
			this.filePhoto.sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\Hydrangeas.jpg");
		
		}
		catch(Exception ex)
		{
			ex.getCause();
		}
	}
	public void  getVedio()
	{
		try
		{
		this.VideoUpload.sendKeys("C:\\Users\\Public\\Videos\\Sample Videos\\Wildlife.wmv");
		
		}
		catch(Exception ex)
		{
			ex.getCause();
		}
	}
	
	

}
