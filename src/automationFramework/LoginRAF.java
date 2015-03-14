package automationFramework;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import pageObjects.LoginPage;
import pageObjects.ProductDetails;
import pageObjects.homePage;
import pageObjects.referFriendPage;
import app.Products;
import app.Setup;

import org.openqa.selenium.WebDriver;
	

public class LoginRAF {
	private WebDriver driver;
	static int row=1;
	String username;
	String Password;
	@Before

	public void setUp() throws Exception 
	{

	driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

@Test	
	public void TestRefBalance() throws Exception 
	
	{

	homePage home_Page = PageFactory.initElements(driver, homePage.class);
	
	ProductDetails RAFLNK=PageFactory.initElements(driver, ProductDetails.class);
	
	referFriendPage RefPage = PageFactory.initElements(driver, referFriendPage.class);
	
	LoginPage login_Page = PageFactory.initElements(driver, LoginPage.class);

	driver.get(Setup.baseurl());
 
	home_Page.ClosePopup();
	
	Products.SelectBouquet(driver);
	
	RAFLNK.getReferAFriend();
	
	Sheet s;
	FileInputStream fi = new FileInputStream("E:\\kallaTestAutomation\\TestData2.xls");
	Workbook w = Workbook.getWorkbook(fi);
	s = w.getSheet(1);
	try
	{
	while(row<s.getRows()-1)
			{
		
		username=s.getCell(0,row).getContents();
		RefPage.getuserEmail().sendKeys(username);
		Password=s.getCell(1,row).getContents();
		RefPage.getuserPassword().sendKeys(Password);
		RefPage.ClaimCode();
		Thread.sleep(3000);
		login_Page.ViewProfile();
        login_Page.signout();
        row++;
		
			}
	}
	catch(Exception ex)
	{
		ex.getMessage();
	}
	finally
	{
		driver.close();
		driver.quit();
	}

	}
}
