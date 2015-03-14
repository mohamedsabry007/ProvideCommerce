package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class checkoutConfirmationPage {

	@FindBy(css="html.js body.page-checkout-confirm div.root div.view-checkout section.confirm div.content div.boxed-content div.continue-shopping-wrapper a.kalla-cta")
	private WebElement CheckoutConfirmation;
	
	@FindBy(css="html.js body.page-checkout-confirm div.root div.view-checkout section.confirm div.content div.boxed-content div.message-container div.media div.email-recipient-overlay div.overlay-wrapper div.overlay-content div.email-recipient-content div#recipientEmail.kalla-form div.recipientEmail-form div a.kalla-cta")
	private  WebElement Submit;
	
	public void getCheckoutConfirmation()
	{
		this.CheckoutConfirmation.click();
	}
	/*public void getPhoto()
	{
		this.AddPhoto.sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\Hydrangeas.jpg");
	}
	public void getVedio()
	{
		this.AddVedio.sendKeys("C:\\Users\\Public\\Videos\\Sample Videos\\Wildlife.wmv");
	}
	public void AddRecipientEmail()
	{
		Recipient_Email.sendKeys("mmahran@integrant.com");
		this.Submit.click();
	}*/
	
}
