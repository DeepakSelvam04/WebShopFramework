package genricLibrary;

import java.io.File;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class WebDriverUtility implements FrameworkConstants {
	public static Actions action;
	public static JavascriptExecutor je;
	public static ExtentReports report;
	public static ExtentTest test;
	
	
	public static void selectOptionByIndex(WebElement dropdown,int index) {
		Select select=new Select(dropdown);
		select.selectByIndex(index);
	}
	
	public static void selectOptionByValue(WebElement dropdown,String value) {
		Select select=new Select(dropdown);
		select.selectByValue(value);
	}
	
	public static void selectOptionByVisibleText(WebElement dropdown,String text) {
		Select select=new Select(dropdown);
		select.selectByVisibleText(text);
	}
	
	
	//Switch to window using title
	  public static void switchToWindowByTitle(WebDriver driver,String title) {
		  Set<String> allWindows = driver.getWindowHandles();
		  for (String window : allWindows) {
			  driver.switchTo().window(window);
			  if(driver.getTitle().contains(title)) {
				  break;
			  }
		}
	  }
	
	//Switch to window using URL
	  public static void switchToWindowByURL(WebDriver driver,String url) {
		  Set<String> allWindows = driver.getWindowHandles();
		  for (String window : allWindows) {
			  driver.switchTo().window(window);
			  if(driver.getTitle().contains(url)) {
				  break;
			  }
		}
	  }
	 
	  //switch to frame using index
	  public static void switchToFrameByIndex(WebDriver driver,int index) {
		  driver.switchTo().frame(index);
	  }
	  
	  //switch to frame using name or id
	  public static void switchToFrameByNameOrId(WebDriver driver,String nameOrId) {
		  driver.switchTo().frame(nameOrId);
	  }
	  
	  //switch to frame using webelement
	  public static void switchToFrameByWebElement(WebDriver driver,WebElement frameElement) {
		  driver.switchTo().frame(frameElement);
	  }
	  
	  //all webDriver methods
	  public static void clickElement(WebElement element) {
		  element.click();
	  }
	  
	  public static void enterText(WebElement element,String text) {
		  element.sendKeys(text);
	  }
	  
	  
	  public static String getScreenshotOfWebpage(WebDriver driver) {
		  TakesScreenshot ts=(TakesScreenshot) driver;
		  File temp=ts.getScreenshotAs(OutputType.FILE);
		  String imagePath=SCREENSHOT_PATH+getSystemDate()+".png";
		  
		  File perm=new File(imagePath);
		  
		  try {
			  FileHandler.copy(temp, perm);
			
		  } catch (IOException e) {
			
			e.printStackTrace();
		}
		  return "."+imagePath;
	  }
       
	  public static String getScreenshotOfWebElement(WebElement element) {
          File temp=element.getScreenshotAs(OutputType.FILE);
          String imagepath=SCREENSHOT_PATH+getSystemDate()+".png";
		  File perm=new File(imagepath);
		  
		  
		  try {
			  FileHandler.copy(temp, perm);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		  return "."+imagepath;
	  }
	  
	  //method to handle alert
	  public static void switchToAlretAndAccept(WebDriver driver) {
		  driver.switchTo().alert().accept();
	  }
	  public static void switchToAlretAndDismiss(WebDriver driver) {
		  driver.switchTo().alert().dismiss();
	  }
	  public static void switchToAlretAndGetText(WebDriver driver) {
		  driver.switchTo().alert().getText();
	  }
	  public static void switchToAlretAndSendkeys(WebDriver driver, String text) {
		  driver.switchTo().alert().sendKeys(text);
	  }
	  
	  //method to handle mouse actions
	  public static void mouseHover(WebDriver driver, WebElement element) {
		  Actions action=new Actions(driver);
		  action.moveToElement(element).perform();
	  }
	  public static void mouseClick(WebDriver driver, WebElement element) {
		  Actions action=new Actions(driver);
		  action.click(element).perform();
	  }
	  public static void rightClick(WebDriver driver, WebElement element) {
		  Actions action=new Actions(driver);
		  action.contextClick(element).perform();
	  }
	  
	  //Get the system data and time
	  public static String getSystemDate() {
		  return LocalDateTime.now().toString().replace(":", "_").replace("-", "_");
	  }
	  
	  /**
	   * Method to handle Hidden or Disabled button
	   */
	  public static void clickOnHiddenOrDisabledElement(WebDriver driver,WebElement element) {
		  
		  JavascriptExecutor je=(JavascriptExecutor) driver;
		  je.executeScript("arguments[0].click();",element);
	  }
	  
	  /**
	   * Method to handle Hidden or Disabled text field
	   */
      public static void enterTextHiddenOrDisabledElement(WebDriver driver,WebElement element,String value ) {
		  
		  JavascriptExecutor je=(JavascriptExecutor) driver;
		  je.executeScript("arguments[0].value='"+value+"'",element);
	  }
	  
}
