package objectReprostory;

import org.apache.commons.collections4.multimap.AbstractListValuedMap;
import org.apache.poi.hssf.record.chart.AxisUsedRecord;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v118.tethering.Tethering;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genricLibrary.FileUtility;
import net.bytebuddy.asm.Advice.Unused;
import net.bytebuddy.asm.Advice.AssignReturned.ToAllArguments;

public class LoginPage  {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	
	/**
	 * Used to login to application by using valid email and password
	 */
	public void login(WebDriver driver) {
		HomePage homepage=new HomePage(driver);
		LoginPage loginPage=new LoginPage(driver);
		
		 //click on login page
		homepage.getLoginLink().click();
		
		//enter the email
		loginPage.getEmailTextFeild().sendKeys(FileUtility.getProperty("email"));
		
		//enter password
		loginPage.getPasswordTextFeild().sendKeys(FileUtility.getProperty("password"));
		
		//click on remember me checkbox
		loginPage.getRememberMeCheckbox().click();
		
		//click on login button
		loginPage.getLoginButton().click();
	}
	
	/**
	 *Used to logout from the application
	 */
	public void logOut(WebDriver driver) {
		HomePage homePage=new HomePage(driver);
		
		//Click on Log out link
		homePage.getLoginLink().click();
	}
    @FindBy(id="Log in")
	private WebElement loginlink;
	
	@FindBy(id="Email")
	private WebElement emailTextFeild;
	
	@FindBy(id="Password")
	private WebElement passwordTextFeild;
	
	public WebElement getLoginlink() {
		return loginlink;
	}

	public WebElement getEmailTextFeild() {
		return emailTextFeild;
	}

	public WebElement getPasswordTextFeild() {
		return passwordTextFeild;
	}

	public WebElement getRememberMeCheckbox() {
		return rememberMeCheckbox;
	}

	public WebElement getForgotpassword() {
		return forgotpassword;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	@FindBy(id="RememberMe")
	private WebElement rememberMeCheckbox;
	
	@FindBy(linkText ="Forgot password?")
	private WebElement forgotpassword;
	
	@FindBy(css = "[value='Log in']")
	private WebElement loginButton;
	
	
	

}
