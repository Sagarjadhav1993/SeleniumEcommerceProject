package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pageobject.HomePage;
import pageobject.SearchPage;
import utility.Log;

public class HomePageTest extends BaseClass {
	HomePage index;
	SearchPage search;
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}
	
	@AfterMethod
	public void teardown() {
		 getDriver().quit();
	}
	
	@Test(priority = 1)
	public void verifyLogo() {
		Log.startTestCase("verifyLogo");
		index=new HomePage();
		Log.info("User Is able to see Logo of Amazon");
		boolean result = index.validateLogo();
		Log.info("Verify Logo");
		Assert.assertTrue(result);
		Log.endTestCase("verifyLogo");
	}
	
	@Test(priority = 2)
	public void verifySearchBox() {
		Log.startTestCase("verifySearchBox");
		index=new HomePage();
		Log.info("Verify Search Box");
		search=index.ValidateSearchBox();	    //interlinking the pages
		Log.endTestCase("verifySearchBox");
	}	

}
