package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrowsePage {
	
	@FindBy(css="html.js body.page-browse header.global-header ul.nav-triggers li.logo a img")
	private WebElement KallaImage;
	
	public void getHomePage()
	{
		try
		{
		this.KallaImage.click();
		Thread.sleep(5000);
		}
		catch(Exception ex)
		{
			System.out.println(ex.toString());
		}
	}

}
