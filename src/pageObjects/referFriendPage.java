package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class referFriendPage {
	/*Sign In Elements*/
			@FindBy(xpath="html/body/div[1]/div/section/div/div/div[5]/input")
				private  WebElement ClaimYuorCode;
			@FindBy(xpath="html/body/div[1]/div/section/div/div/div[2]/form/div[1]/input")
				private   WebElement useremail;
			@FindBy(xpath="html/body/div[1]/div/section/div/div/div[2]/form/div[2]/input")
			private   WebElement userPassword;
/*Register elements*/
			@FindBy(name="user[name][first]")
			private WebElement FirstName;
			@FindBy(name="user[name][last]")
			private WebElement LastName;
			@FindBy(name="user[password]")
			private WebElement password;


			public  WebElement getuserEmail()

	{
		
		return useremail;
	}
	

	public  WebElement getuserPassword()

	{
		
		
		return userPassword;
	}


	public void ClaimCode()
	{
		
		ClaimYuorCode.click();
	}
}
