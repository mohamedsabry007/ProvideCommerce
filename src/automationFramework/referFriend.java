package automationFramework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import app.Setup;
import app.Sign_IN;
import pageObjects.LoginPage;
import pageObjects.ProductDetails;
import pageObjects.homePage;
import app.Products;

public class referFriend {
		private WebDriver driver;
		int row ;
		Sheet s;
		String username;
		String Password;
		String ActualResult;
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
		
		LoginPage login_Page = PageFactory.initElements(driver, LoginPage.class);
	
		driver.get(Setup.baseurl());
	 
		home_Page.ClosePopup();
		
		Products.SelectBouquet(driver);
		
		RAFLNK.getReferAFriend();
	
		FileInputStream fi = new FileInputStream("E:\\kallaTestAutomation\\TestData2.xls");
    	Workbook w = Workbook.getWorkbook(fi);
    	s = w.getSheet(1);
    	
    	String a[][] = new String[s.getRows()][s.getColumns()];
    	FileOutputStream fo = new FileOutputStream("E:\\kallaTestAutomation\\TestData.xls");
     	WritableWorkbook wwb= Workbook.createWorkbook(fo);
        WritableSheet wsheet = wwb.createSheet("First Sheet", 0);
        
        for (int i = 0; i < s.getRows(); i++) 
        {
        for (int j = 0; j < s.getColumns(); j++) 
        	{
        a[i][j] = s.getCell(j, i).getContents();
        
        jxl.write.Label l = new jxl.write.Label(j, i, a[i][j]);
        jxl.write.Label l1 = new jxl.write.Label(2, 0, "Actual Result");
        jxl.write.Label l2 = new jxl.write.Label(3, 0, "discount credit");
        jxl.write.Label l3 = new jxl.write.Label(4, 0, "balance code");
        wsheet.addCell(l);
        wsheet.addCell(l1);
        wsheet.addCell(l2);
        wsheet.addCell(l3);
        
        	}
       }
       
        try
        {
        	for( row = 1 ;row <s.getRows()-1 ; row++  )
				{
    			
    			LoginPage.Open_Login_Register();
    			Sign_IN.login(driver);
    			Thread.sleep(5000);
    			if( driver.getPageSource().contains("Sorry, the username and password combination isn't recognized"))
        		{
    				System.out.println("Element is InVisible");
    				LoginPage.Open_Login_Register();
    				ActualResult= driver.findElement(By.xpath("html/body/div[1]/div/section/div/div/div[1]")).getText();
    				jxl.write.Label l3 = new jxl.write.Label(2, row, ActualResult);
    				wsheet.addCell(l3);
    				continue;
         		}
        else if ( !(driver.getPageSource().contains("Sorry, the username and password combination isn't recognized")))
        		{
        		System.out.println("Element is Visible");
        		String ActualResult = "GOOD TO SEE YOU AGAIN!";
        		String DiscountCredit = driver.findElement(By.xpath("html/body/div[1]/div/section/div/div/h3[2]/span[1]")).getText();
        		String PersonalCode = driver.findElement(By.xpath("html/body/div[1]/div/section/div/div/h3[1]/span")).getText();
        		
        		jxl.write.Label l3 = new jxl.write.Label(2, row, ActualResult);
        		jxl.write.Label l4 = new jxl.write.Label(3, row, DiscountCredit);
        		jxl.write.Label l5 = new jxl.write.Label(4, row, PersonalCode);
          
        		wsheet.addCell(l3);
        		wsheet.addCell(l4);
        		wsheet.addCell(l5);
            
        		login_Page.ViewProfile();
        		login_Page.signout();
        		Thread.sleep(5000);
            
        		}
     		}
        }
        catch(Exception ex)
        	{
        	ex.getMessage();
        	}
        finally
    	{
    		driver.quit();
    	}
    	wwb.write();
    	wwb.close();
   	
	}

	@After
	public void tearDown() throws Exception {
	driver.quit();
	}

}