package pageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class RegisterPage {
	
	@FindBy(name = "user[name][first]")
	  private WebElement Firstname;
	
	@FindBy(name = "user[name][last]")
	  private WebElement lastname;
	
	@FindBy(xpath="/html/body/header/div[2]/div/div[2]/form/div[4]/input")
	 private WebElement Email;
	
	@FindBy(name="password")
	 private WebElement password;
	
	@FindBy(xpath="/html/body/header/div[2]/div/div[2]/form/div[6]/input")  
	private WebElement CreateAccount;
	
	@FindBy(xpath = "/html/body/header/div[2]/div/div[2]/div/p/a") 
	private WebElement SignInstead;
			
	@FindBy(xpath="/html/body/header/div[2]/div/div/div/a")
	private WebElement NewKalla;
	
	@FindBy(css="html.js body.page-profile header.global-header ul.nav-triggers li.logo a img")
	private WebElement homePageLink;
	
	
			
	
		
	public WebElement getFirstName() {
		return Firstname ;
	}
	
	public void setFirstName(WebElement userFirstName)
	{

		Firstname = userFirstName;
	}
	
	public WebElement getLastname() {
		return lastname ;
	}

	public void setLastName(WebElement userLastName)
	{

		lastname = userLastName;
	}
	
	public WebElement getEmail() {
		return Email ;
	}

	public void setEmail(WebElement email) {
		this.Email = email;
	}
	
	public WebElement getPassword() {
		return password;
	}

	public void setPassword(WebElement Password) {

		this.password = Password;
	}

	public Void CreateAccount()
	{
		this.CreateAccount.click();
		return null;
		
	}
	
	public void SignIn()
	{
		
		this.SignInstead.click();
		
	}

	public void openhomePage()
	{
		this.homePageLink.click();
	}
	

	public void NewAccountbtn() {
		// TODO Auto-generated method stub
		this.NewKalla.click();
	}
}
