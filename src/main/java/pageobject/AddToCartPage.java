package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import actiondriver.Action;
import base.BaseClass;
import utility.Log;

public class AddToCartPage extends BaseClass {
	
	
	@FindBy(id="a-autoid-1-announce")
	WebElement AddToCartButton1;
	
	
	@FindBy(id="a-autoid-2-announce")
	WebElement AddToCartButton2;
	
	
	@FindBy(xpath = "//*[@id='nav-cart-count']")
	WebElement CartCount;
	
	
	@FindBy(xpath = "//*[@class='nav-cart-icon nav-sprite']")
	WebElement AddTocartIcon;
	
	
	@FindBy(xpath = "(//*[contains(text(),'Shopping Cart')])[2]")
	WebElement ShoppingCartText;
	
	
	@FindBy(xpath = "(//*[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold'])[1]")
	WebElement PriceOfProduct1;
	
	@FindBy(xpath = "(//*[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold'])[2]")
	WebElement PriceOfProduct2;
	
	
	@FindBy(xpath = "(//*[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap'])[1]")
	WebElement TotalPrice;
	
	
	
	//***************Constructor*******************
	
	public AddToCartPage() {
		PageFactory.initElements( getDriver(), this);
	}
	
	//*********************************************
		
	
	public void clickOnAddToCart() throws InterruptedException {
		 Action.scrollByVisibilityOfElement( getDriver(), AddToCartButton1);
		 Log.info("Verify User is going to click on Add to Cart Button 1");
		 Action.click( getDriver(), AddToCartButton1);
		 Action.fluentWait( getDriver(), AddToCartButton1, 10);
		 Action.scrollByVisibilityOfElement( getDriver(), AddToCartButton2);
		 Log.info("Verify User is going to click on Add to Cart Button 2");
		 Action.click( getDriver(), AddToCartButton2);
		 Action.fluentWait( getDriver(), AddToCartButton2, 10);
		 System.out.println("click on add to cart Button2");
		 Thread.sleep(30);
		 return;
	}
	
	public boolean CountInMyCart() throws InterruptedException {
		
		Action.scrollByVisibilityOfElement( getDriver(), AddTocartIcon);
		boolean count = Action.isDisplayed( getDriver(), CartCount);
		 Log.info("Verify User is able to count product in My Cart");
		Assert.assertTrue(count);
		String CountInMyCart = CartCount.getText(); 
		System.out.println("Total count of product display in My cart = " +CountInMyCart);
		return count;
	}
	
	
	public boolean verifyAndClickOnMyCart() throws InterruptedException {
		
		Action.scrollByVisibilityOfElement( getDriver(), AddTocartIcon);
		 Log.info("Verify User is going to click on Add to Cart Icon");
		 Action.click( getDriver(), AddTocartIcon);
		 Action.fluentWait( getDriver(), ShoppingCartText, 10);
		 boolean shoppingCart = Action.isDisplayed( getDriver(), ShoppingCartText);
         Assert.assertTrue(shoppingCart);
                
		return shoppingCart;
	}
	
	public double checkProduct1() {
		String Priceproductgettext1 = PriceOfProduct1.getText();
        System.out.println("Price Of Product 1 = "+Priceproductgettext1);
		String Product1AfterRemSy = Priceproductgettext1.replaceAll("[^A-Za-z0-9]", "");    //remove spacial charactor= $41.34= 4134
		double FinalProduct1 = Double.parseDouble(Product1AfterRemSy);      //4134= convert 41.34
		return FinalProduct1/100;

	}
	
	public double checkProduct2() {
		String Priceproductgettext2 = PriceOfProduct2.getText();
        System.out.println("Price Of Product 2 = "+Priceproductgettext2);
		String Product2AfterRemSy = Priceproductgettext2.replaceAll("[^A-Za-z0-9]", "");    //remove spacial charactor= $41.34= 4134
		double FinalProduct2 = Double.parseDouble(Product2AfterRemSy);      //4134= convert 41.34
		return FinalProduct2/100;


	}
	
	public double getTotalPrice() {
		String TotalPricegettext = TotalPrice.getText();
        System.out.println("Total Price Of Products = "+TotalPricegettext);
    	String totalPriceOfProduct = TotalPricegettext.replaceAll("[^A-Za-z0-9]", "");    //remove spacial charactor= $41.34= 4134
		double FinalTotalPrice = Double.parseDouble(totalPriceOfProduct);      //4134= convert 41.34
		return FinalTotalPrice/100;
	}
	
//	public double checkOurProductPrice1() {
//		String Priceproductgettext1 = PriceOfProduct1.getText();
//        System.out.println("before Price Of Product 1 = "+Priceproductgettext1);
//		String Product1AfterRemSy = Priceproductgettext1.replaceAll("[^A-Za-z0-9]", "");    //remove spacial charactor= $41.34= 4134
//		double FinalProduct1 = Double.parseDouble(Product1AfterRemSy)/100;      //4134= convert 41.34
//
//		
//		String Priceproductgettext2 = PriceOfProduct2.getText();
//        System.out.println("before Price Of Product 2 = "+Priceproductgettext2);
//		String Product2AfterRemSy = Priceproductgettext2.replaceAll("[^A-Za-z0-9]", "");    //remove spacial charactor= $41.34= 4134
//		double FinalProduct2 = Double.parseDouble(Product1AfterRemSy)/100;      //4134= convert 41.34
//
//		
//		String TotalPricegettext = TotalPrice.getText();
//        System.out.println("Total Price Of Products = "+TotalPricegettext);
//		double Total=FinalProduct1+FinalProduct2;
//		System.out.println("Total price of product after addition of Both the Product = "+Total);
//		return Total;
//	}
//	
	
}
