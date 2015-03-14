package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class LoginPage
			{

	@FindBy(xpath ="/html/body/header/ul/li[3]/a/span[1]")
		private  static  WebElement Login_register ;
	
	@FindBy(xpath ="/html/body/header/ul/li[3]/a/span[2]")
	private    WebElement ViewProfile ;
		
	@FindBy(name="user[email]")
		private static  WebElement emailAddress;
		
	@FindBy(name = "user[password]")
		private static WebElement  userPassword;
	
	@FindBy(xpath="html/body/header/div[2]/div/div/div[1]/form/div[4]/input")
		private static  WebElement signIn;
		
	@FindBy(className="sign-out")
		 private static   WebElement signout;
		 
	@FindBy(css="html.js body.page-index header.global-header ul.nav-triggers li.fr a.fl" )
		 private WebElement profile;
		
	public static  WebElement  getEmailAddress()
		{
		emailAddress.clear();
		return emailAddress ;
		}
	
	
	public static WebElement getUserPassword() 
				{
			userPassword.clear();
			return userPassword ;
				}

	public static void getLogin() throws InterruptedException

				{
												
				signIn.click();
				
				}
	
	public void getpassword()
	{
		return;
	}
	
	public void signout()
		 {
			 
			signout.click();
			
		 }
		 
		public void getProfile() {
			// TODO Auto-generated method stub
			try
				{
			 this.profile.click();
				}
			catch(Exception ex)
				{
				System.out.println(ex.getMessage().toString());
				}
			}

		public static void  Open_Login_Register() {
			// TODO Auto-generated method stub
			Login_register.click();
		}
		
		public void  ViewProfile() {
			// TODO Auto-generated method stub
			ViewProfile.click();
		}
	
	}
		
