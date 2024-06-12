/**
 * 
 */
package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pageobject.AddToCartPage;
import pageobject.HomePage;
import pageobject.SearchPage;
import utility.Log;

/**
 *   Sagar
 */
public class AddToCartTest extends BaseClass{
	HomePage index;
	SearchPage search;
	AddToCartPage cart;
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}
	
	@AfterMethod
	public void teardown() {
		 getDriver().quit();
	}
	
	@Test(priority = 1)
	public void verifyClickOnAddtoCart() throws InterruptedException {
		Log.startTestCase("verifyClickOnAddtoCart");
		cart=new AddToCartPage();
		search=new SearchPage();
		search.SearchProduct("headphones");
		cart.clickOnAddToCart();
		Log.endTestCase("verifyClickOnAddtoCart");

	}
	
	@Test(priority = 2)
	public void verifyCountInMyCart() throws InterruptedException {
		Log.startTestCase("verifyCountInMyCart");
		cart=new AddToCartPage();
		search=new SearchPage();
		search.SearchProduct("headphones");
		cart.clickOnAddToCart();
		cart.CountInMyCart();
		Log.endTestCase("verifyCountInMyCart");

	}
	
	
	@Test(priority = 3)
	public void verifyShoppingInMyCart() throws InterruptedException {
		Log.startTestCase("verifyShoppingInMyCart");
		cart=new AddToCartPage();
		search=new SearchPage();
		search.SearchProduct("headphones");
		cart.clickOnAddToCart();
		cart.verifyAndClickOnMyCart();
		double product1 = cart.checkProduct1();
		double product2 = cart.checkProduct2();
		double ExpectedTotalPrice = cart.getTotalPrice();
		double AcualTotalPrice=(product1+product2);
		Log.info("verify User is able to check Total price and Acual price Match or Not");
		Assert.assertEquals(AcualTotalPrice, ExpectedTotalPrice);
		Log.info("verify User is able to check Total price and Acual price Match is Match");
		Log.endTestCase("verifyShoppingInMyCart");


	}


	
	
}
