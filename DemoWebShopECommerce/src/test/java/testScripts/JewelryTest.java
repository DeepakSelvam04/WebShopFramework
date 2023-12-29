package testScripts;

import org.testng.annotations.Test;

import genricLibrary.BaseClass;
import objectReprostory.HomePage;
import objectReprostory.JewelryPage;

public class JewelryTest extends BaseClass{
	
	@Test
	public void diamonHeartTest_001() {
		HomePage homePage=new HomePage(driver);
		JewelryPage jewelryPage=new JewelryPage(driver);
		
		//Teke screenshot of webpage
		getScreenshotOfWebpage(driver);
		
		//click on Jewelry
		
		clickElement(homePage.getJewlryLink());
		
		//Take screenshot of Diamond heart
		getScreenshotOfWebElement(jewelryPage.getBlackAndWhiteDiamondHeartImage());
		
		String str="hi";
		//dee
		
		
		
	}
	
	

}
