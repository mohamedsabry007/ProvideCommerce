package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PdpStartOrder {
	
	public  static void CheckoutWithChocolateAccessory(WebDriver driver)
			{
			driver.findElement(By.xpath("//a[contains(text(),'Customize & Send')]")).click();
			driver.findElement(By.name("RecipientName")).sendKeys("Mohamed Mahran");
			driver.findElement(By.xpath("//a[contains(text(),'Next: Add Pairings')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Yes, Please (+$25)')]")).click();
			WebElement element=driver.findElement(By.xpath("//div/div[4]/div/a"));
			WebDriverWait wait = new WebDriverWait(driver, 20); //here, wait time is 20 seconds
			wait.until(ExpectedConditions.visibilityOf(element)); //this will wait for elememt to be visible for 20 seconds
			element.click();
			driver.findElement(By.id("checkoutButton")).click();
			
			}
	public  static void CheckoutWithWinAccessory(WebDriver driver)
		{
		
		}

}
