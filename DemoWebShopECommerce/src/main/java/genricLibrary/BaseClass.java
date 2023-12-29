package genricLibrary;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;

import objectReprostory.HomePage;
import objectReprostory.LoginPage;

public class BaseClass extends WebDriverUtility {
	public WebDriver driver;
	@BeforeSuite
	public void beforeSuite() {
		//Reporter.log("Connect to database",true);
		report=new ExtentReports(REPORT_PATH+getSystemDate()+".html");
	}
	
	@BeforeTest
	public void beforeTest() {
		Reporter.log("BeforeTest",true);
	}
	
    @BeforeClass
	public void beforeClass() {
		Reporter.log("Before class",true);
		String browser=FileUtility.getProperty("browser");
		String url=FileUtility.getProperty("url");
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		
	}
	
	@BeforeMethod
	public void beforeMethod(Method method) {
	String MethodName=method.getName();
	test=report.startTest(MethodName);
		Reporter.log("Login",true);
		HomePage homepage=new HomePage(driver);                                                
		LoginPage loginPage=new LoginPage(driver);
		
		loginPage.logOut(driver);
			
//	    //click on login page
		homepage.getLoginLink().click();
//		
//		//enter the email
		loginPage.getEmailTextFeild().sendKeys(FileUtility.getProperty("email"));
//		
//		//enter password
		loginPage.getPasswordTextFeild().sendKeys(FileUtility.getProperty("password"));
//		
//		//click on remember me checkbox
		loginPage.getRememberMeCheckbox().click();
//		
//		//click on login button
		loginPage.getLoginButton().click();
		
//		driver.findElement(By.linkText("Log in")).click();
//		driver.findElement(By.id("Email")).sendKeys(FileUtility.getProperty("email"));
//		driver.findElement(By.id("Password")).sendKeys(FileUtility.getProperty("password"));
//		driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}
	
	@AfterMethod
	public void afterMethod() {
		Reporter.log("Log out",true);
        driver.findElement(By.linkText("Log out")).click();
		LoginPage loginPage=new LoginPage(driver);
		
		loginPage.logOut(driver);
		report.endTest(test);
	}
	
	@AfterClass
	public void afterClass() {
		Reporter.log("After class",true);
		driver.quit();
    }
	
	@AfterTest
	public void afterTest() {
		Reporter.log("After test",true);
    }
	
	@AfterSuite
	public void afterSuite() {
		report.flush();
		Reporter.log("Close Connection to database",true);
    }

}
