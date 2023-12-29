package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import genricLibrary.BaseClass;

public class Report {
	ExtentReports  report=new ExtentReports("./Reports/report.html");
	
	ExtentTest test=report.startTest("loginTest");
	
	@Test
	public void reportTest1() {
		WebDriver driver=new ChromeDriver();
		test.log(LogStatus.INFO, "Chrome browser lanuched");
		
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Chrome browser maximized");
		
		driver.get("https://demowebshop.tricentis.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.partialLinkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("deepakselvam06@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Mydemo@2001");
		driver.findElement(By.cssSelector("[value='Log in']")).click();
		Assert.assertEquals(driver.findElement(By.linkText("Log out")).isDisplayed(), true);
		test.log(LogStatus.PASS, "Log Successfull");
		
		report.endTest(test);
		report.flush();
		
		
		
		
		
	}
	@Test
	public void reportTest2() {
		WebDriver driver=new ChromeDriver();
		test.log(LogStatus.INFO, "Chrome browser lanuched");
		
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Chrome browser maximized");
		
		driver.get("https://demowebshop.tricentis.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.partialLinkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("deepakselvam06@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Mydemo@2001");
		driver.findElement(By.cssSelector("[value='Log in']")).click();
		Assert.assertEquals(driver.findElement(By.linkText("Log out")).isDisplayed(), true);
		test.log(LogStatus.FAIL, "Log UnSuccessfull");
		
		
		report.endTest(test);
		report.flush();
		
		driver.quit();
	}
}
