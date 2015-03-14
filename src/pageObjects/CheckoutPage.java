package pageObjects;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage 
	{
	
	@FindBy(id="Recipient_FirstName")
		private static  WebElement Recipient_FirstName;
	
	@FindBy(id="Recipient_LastName")
		private static WebElement  Recipient_LastName;
	
	@FindBy(id="Recipient_Line1")
		private static WebElement  Recipient_Line;
	
	@FindBy(id="Recipient_Line2")
		private  WebElement Recipient_Line2;
	
	@FindBy(id="Recipient_City")
		private WebElement  Recipient_City; 
	
	@FindBy(id="Recipient_StateProvince")
		private WebElement  StateProvince;
	
	@FindBy(id="Recipient_PostalCode")
		private static WebElement  PostalCode;

	@FindBy(id="Recipient_DaytimePhoneNumber")  
		private static WebElement  PhoneNumber;
	
	@FindBy(id="Recipient_Email")
		private static WebElement  Email;
	
	@FindBy(id="chkRecipientMobileConfirm")
		private static WebElement ConfirmMobile;
			
	@FindBy(className="kalla-cta")
		private static WebElement Recipient_Next;
		
	@FindBy(xpath="html/body/div[1]/div[2]/form/section[2]/header/h3")
	    private WebElement Recipient_Menu;
	
	@FindBy(xpath="/html/body/div/div/form/section[3]/div/div[2]/div/div[2]/p/a")
		private static WebElement ASAP;
	
	@FindBy(xpath="html/body/div[1]/div[2]/form/section[3]/div/div[2]/div[2]/a")
		private WebElement Delivery_Next;
	
	@FindBy(how=How.XPATH , using ="html/body/div[1]/div[2]/form/section[2]/div/div[2]/div[2]/div[1]/div[1]/label/i")
		private WebElement first_name;
	
	@FindBy(how=How.XPATH , using ="html/body/div[1]/div[2]/form/section[2]/div/div[2]/div[2]/div[1]/div[2]/label/i")
		private WebElement Last_name;
	
	@FindBy(id = "Sender_FirstName")
		private static WebElement FirstName;

	@FindBy(id = "Sender_LastName")
		private static WebElement LastName;
		
	@FindBy(id = "senderAddressLine1")
		private static WebElement senderAddressLine1;
	
	@FindBy(css = "html.js body.page-checkout div.root div.view-checkout form.checkout-form section.sender div.content div.boxed-content div.kalla-form div.grid-row div.span-3 div.field-wrapper select#senderAddressState")
		private static WebElement AddressState;
		
	@FindBy(id="senderAddressCity")
		
		private static WebElement AddressCity;
	
	@FindBy(id = "senderAddressZip")
		private static WebElement senderAddressZip;
	
	@FindBy(id = "Sender_DaytimePhoneNumber")
		private static WebElement Sender_DaytimePhoneNumber;
	
	@FindBy(id = "senderCCNumber")
		private static WebElement senderCCNumber;
		
	@FindBy(id = "CreditCardDetails_ExpirationMonth")
		private static WebElement CreditCardDetails_ExpirationMonth;

	@FindBy(id = "CreditCardDetails_ExpirationYear")
		private static WebElement CreditCardDetails_ExpirationYear;
	
	@FindBy(id = "Sender_Email")
		private static WebElement Sender_Email;
	
	@FindBy(id="Sender_NewPassword")
		private static WebElement Sender_Passsword;
	
	@FindBy(css="html.js.flexbox.flexboxlegacy.canvas.canvastext.webgl.no-touch.geolocation.postmessage.no-websqldatabase.indexeddb.hashchange.history.draganddrop.websockets.rgba.hsla.multiplebgs.backgroundsize.borderimage.borderradius.boxshadow.textshadow.opacity.cssanimations.csscolumns.cssgradients.no-cssreflections.csstransforms.csstransforms3d.csstransitions.fontface.generatedcontent.video.audio.localstorage.sessionstorage.webworkers.applicationcache.svg.inlinesvg.smil.svgclippaths.avgrund-ready body.page-checkout div.root div.view-checkout.site-inner-width form.checkout-form section.sender.accordion.open div.content div.boxed-content.checkout-form-content div.kalla-form.grid-container div.next-wrapper a.kalla-cta.show-review")
		private static WebElement SenderNext;
	
	@FindBy(id="senderPromoCode")
		private static WebElement PromoCode;
		
	@FindBy(className ="subtotal")
		private static WebElement SubTotalTxt;
		
	@FindBy(className ="tax")
		private static WebElement TaxText;
		
	@FindBy(className ="total")
		private static WebElement TotalTxt;
		
	@FindBy(xpath="html/body/div[1]/div[2]/form/section[5]/div/div[2]/div[2]/a")
		private  WebElement placeorderbtn;
	
	@FindBy(className="discount-value")
		private static  WebElement Discount;
	
		public static WebElement getRecipient_FirstName() {
		// TODO Auto-generated method stub
		return Recipient_FirstName ;
	}
		public static WebElement getRecipient_LastName() {
			// TODO Auto-generated method stub
			return Recipient_LastName ;
		}
		public static WebElement getRecipient_Line() {
			return Recipient_Line;
		}
		public WebElement getRecipient_Line1() {
			// TODO Auto-generated method stub
			return  Recipient_Line2;
		}
		public WebElement getRecipient_City() {
			// TODO Auto-generated method stub
			return  Recipient_City;
		}
		public Select getRecipient_State() {
			// TODO Auto-generated method stub
			return new Select(StateProvince);
			
		}
		public static WebElement getRecipient_PostalCode()
		{
			return PostalCode;
		}
		public static WebElement getRecipient_PhoneNumber()
		{
			return PhoneNumber;
		}
		public static WebElement getRecipient_Email()
		{
			return Email;
		}
		public static void getConfirmMobile()
		{
			
			ConfirmMobile.click();
		}
		public static void getNext()
		{
			Recipient_Next.click();
		}
		public void getRecipientSection()
		{
			this.Recipient_Menu.click();
		}
		public static void PressASAP() {
			// TODO Auto-generated method stub
			ASAP.click();
		}
		public void PressNext()
		{
			this.Delivery_Next.click();
		}
		public static WebElement getSenderFirstName()  

		{
		return FirstName;
		}
		public static WebElement getSenderLastName()  

			{
				return LastName;
			
			}
		public static WebElement getsenderAddressLine1() {
			
			// TODO Auto-generated method stub
			return senderAddressLine1;
			}
		public static WebElement getAddressCity() throws BiffException, IOException  
		{

		return AddressCity;
		}
		public static  Select getsenderState() throws BiffException, IOException  
	
			{
		
			return new Select(AddressState);	
		
			}
		public static WebElement  getsenderAddressZip()  
			{
			return senderAddressZip;
			}
		public static WebElement getDaytimePhoneNumber() throws BiffException, IOException  
			{
			
		 return Sender_DaytimePhoneNumber;
			}
		public static void getsenderCCNumber() throws BiffException, IOException  {
		try
		{
			
			senderCCNumber.clear();
			senderCCNumber.sendKeys("4012888888881881");
		}
		
		catch (Exception ex)
		{
			System.out.printf(ex.toString(), "error");
		}
	}
		public static void getCreditCardDetails_ExpirationYear() throws BiffException, IOException  {
		try
		{
							
			new Select(CreditCardDetails_ExpirationYear).selectByValue("2017");
		}
		
		catch (Exception ex)
		{
			System.out.printf(ex.toString(), "error");
		}
	}
		public static void getCreditCardDetails_ExpirationMonth() throws BiffException, IOException  {

		try
		{
							
			new Select(CreditCardDetails_ExpirationMonth).selectByValue("3");
		}
		
		catch (Exception ex)
		{
			System.out.printf(ex.toString(), "error");
		}
	}
		public static WebElement  getPromoCode()
		{
			return PromoCode;
		}
		public static WebElement getsenderEmail()
			{
		return Sender_Email;
			}
		public static WebElement getsenderPassword()
				{
		return Sender_Passsword;
				}
		public static void getbuyerNext()
		{
		SenderNext.click();
		}
		public static WebElement getSubTotalTxt()
		{
			return SubTotalTxt;
		}
		public static WebElement getTaxText()
		{
			return TaxText;
		}
		public static WebElement getTotal()
		{
			return TotalTxt;
		}
		public static  WebElement getDiscount()
		{
			return Discount; 
		}
		public void getPlaceOrder()
		{
		placeorderbtn.click();
		}
	}
	

