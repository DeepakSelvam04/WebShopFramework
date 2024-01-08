package testScripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import genricLibrary.BaseClass;
import objectReprostory.BookPage;
import objectReprostory.HomePage;

public class BookTest extends BaseClass {
	
	@Test
	public void verifyBookPage_001() {
		HomePage homePage=new HomePage(driver);
		BookPage bookPage=new BookPage(driver);
		Reporter.log("verify books page displayed",true);
		
		//Click on BOOKS Link
		homePage.getBooksLink().click();
		test.log(LogStatus.INFO, "clicked on book link");
		
		String pageHeading=bookPage.getBooksPageHeading().getText();
		try {
			Assert.assertEquals(pageHeading, "Books","Books is not displayed");
			test.log(LogStatus.PASS, "Test case completed");
		} catch (Exception e) {
			String path=getScreenshotOfWebpage(driver);
			test.log(LogStatus.FAIL,test.addScreenCapture(path));
		}
		
		
		Reporter.log("Test case Completed and It passed",true);
	}
     
	@Test
	public void sortBookByNameAndPrice_002() throws InterruptedException {
		HomePage homePage=new HomePage(driver);
		BookPage bookPage=new BookPage(driver);
		
		//Click on Books Link
		homePage.getBooksLink().click();
		
		//sort the books from Z to A
		selectOptionByIndex(bookPage.getSortByDropdown(), 2);
		Thread.sleep(2000);
		
		selectOptionByVisibleText(bookPage.getSortByDropdown(), "Created on");
		Thread.sleep(2000);
	}
	 
	@Test
	public void sortBookByPageSize_003() throws InterruptedException {
		HomePage homePage=new HomePage(driver);
		BookPage bookPage=new BookPage(driver);
		
		//Click on Books Link
		homePage.getBooksLink().click();
		
		//sort the books from Z to A
		selectOptionByIndex(bookPage.getSortByDropdown(), 2);
		Thread.sleep(2000);
		
		switchToWindowByTitle(driver, "flipkart");
		switchToWindowByURL(driver, "https://flipkart.com");
	}
	
	//aravinth

	
	
	
	
	
	
}
