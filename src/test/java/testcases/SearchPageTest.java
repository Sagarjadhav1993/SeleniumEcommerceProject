package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pageobject.HomePage;
import pageobject.SearchPage;
import utility.Log;

public class SearchPageTest  extends BaseClass{
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
	public void verifyClickOnSearchBox() {
		Log.startTestCase("verifyClickOnSearchBox");
		search=new SearchPage();
		search.clickOnSearchBox();
		Log.endTestCase("verifyClickOnSearchBox");

	}
	
	@Test(priority = 2)
	public void VerifySearchProduct() {
		Log.startTestCase("VerifySearchProduct");
		search=new SearchPage();
		boolean product = search.SearchProduct("headphones");
		Assert.assertTrue(product);
		Log.endTestCase("VerifySearchProduct");

	}
	
	@Test(priority = 3)
	public void VerifySearchResult() {
		Log.startTestCase("VerifySearchResult");
		search=new SearchPage();
		boolean product = search.SearchProduct("headphones");
		search.SearchResult();
		Log.endTestCase("VerifySearchResult");

	}
  
}
