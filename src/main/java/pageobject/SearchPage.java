/**
 * 
 */
package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import actiondriver.Action;
import base.BaseClass;
import utility.Log;

/**
 * 
 */
public class SearchPage extends BaseClass{
	
	@FindBy(name="field-keywords")
	WebElement searchBox;
	
	@FindBy(id="nav-search-submit-button")
	WebElement searchBoxsymbol;
	
	@FindBy(xpath = "//*[text()='Showing results for']")
	WebElement Showingresultsfor ;
	
	@FindBy(xpath = "(//*[@class='a-color-state a-text-bold'])/parent::div")
	WebElement SearchResultProductTitle;
	
	
	@FindBy(xpath = "(//*[@class='a-color-state a-text-bold'])")
	WebElement SearchResultProductTitle1;
	
	
	
	
	@FindBy(xpath = "//*[text()='Results']")
	WebElement SearchResultText;
	
	
	
	
	//***************Constructor*******************
	
		public SearchPage() {
			PageFactory.initElements( getDriver(), this);
		}
		
		//*********************************************
		
		
		
		public void clickOnSearchBox() {
			 Action.click( getDriver(), searchBox);
			 return;
		}
		
		public boolean SearchProduct(String ProductName) {
			Log.info("Verify user is going to click on Search Box");
			 Action.click( getDriver(), searchBox);
			 Action.fluentWait( getDriver(), searchBox, 10);
			boolean product = Action.type(searchBox, ProductName);
			Log.info("Verify user is going to click on Search symbol");
			Action.click( getDriver(), searchBoxsymbol);
			Action.fluentWait( getDriver(), searchBoxsymbol, 10);
			return product;
		}
		
		public AddToCartPage SearchResult() {
			
			boolean productTitle = Action.isDisplayed( getDriver(), SearchResultProductTitle);
			String titleofSearchResult1 = SearchResultProductTitle1.getText();
			String titleofSearchResult = SearchResultProductTitle.getText();
			String resultText = SearchResultText.getText();
			System.out.println("Title od Search Result :"+titleofSearchResult);
			Log.info("Verify user is able to check Product title");
			Assert.assertTrue(productTitle);               //Headphone text Assert
			return new AddToCartPage();
			
//			Action.scrollByVisibilityOfElement(driver, AddToCartButtonOnProduct1);
//			boolean AddTocart1 = Action.isDisplayed(driver, AddToCartButtonOnProduct1);
//			Action.scrollByVisibilityOfElement(driver, AddToCartButtonOnProduct2);
//			boolean AddTocart2 = Action.isDisplayed(driver, AddToCartButtonOnProduct2);
			

		}
		

		
}
