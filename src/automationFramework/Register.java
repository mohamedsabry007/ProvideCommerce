package automationFramework;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import pageObjects.homePage;
import pageObjects.RegisterPage;


public class Register {
  private WebDriver driver;
  private StringBuffer verificationErrors = new StringBuffer();
  int row = 0 ;
  String firstname;
  String Lastname;
  String Email;
  String Password;

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  

  }

  @Test
  public void testRegister() throws Exception 
  
  {
    
	  RegisterPage Registerpage = PageFactory.initElements(driver, RegisterPage.class);
	
	  homePage homePage = PageFactory.initElements(driver, homePage.class);
	  
	  driver.get(app.Setup.baseurl());
	  
	  
	  homePage.ClosePopup();	
	  
	  
	  /*Registerpage.Open_Login_Register();	*/
        
	  		try 
        		{
    	
      assertEquals("Kalla", driver.getTitle());
    	
    		} 
	  		catch (Error e) 
	  			{
      verificationErrors.append(e.toString());
	  			}
    
   
    Sheet s2;	
	
    FileInputStream fi = new FileInputStream("E:\\TestData.xls");

	Workbook w = Workbook.getWorkbook(fi);

	s2 = w.getSheet(1);
    
		while( row<s2.getRows()-1 )
		 	
				{
					Registerpage.NewAccountbtn();
					
					Registerpage.getFirstName().clear();
					firstname = s2.getCell(0,row).getContents();
					Registerpage.getFirstName().sendKeys(firstname);
					
					Registerpage.getLastname().clear();
					Lastname =s2.getCell(1,row).getContents();
					Registerpage.getLastname().sendKeys(Lastname);
					
					Registerpage.getEmail().clear();
					Email=s2.getCell(2,row).getContents();
					Registerpage.getEmail().sendKeys(Email);
					
					Registerpage.getPassword().clear();
					Password = s2.getCell(3,row).getContents();
					Registerpage.getPassword().sendKeys(Password);
					Registerpage.CreateAccount();
					
					
					row++;
					
			  }
		
  		}

  @After
  public void tearDown() throws Exception 
  	{
	  	driver.quit();
	  	String verificationErrorString = verificationErrors.toString();
	  	if (!"".equals(verificationErrorString)) 
	  		{
	  			fail(verificationErrorString);
	  		}
  	}
}
