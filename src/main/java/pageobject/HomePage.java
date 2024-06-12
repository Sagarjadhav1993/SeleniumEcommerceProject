package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actiondriver.Action;
import base.BaseClass;

public class HomePage extends BaseClass {

	@FindBy(name="field-keywords")
	WebElement searchBox;
	
	@FindBy(id="nav-search-submit-button")
	WebElement searchBoxsymbol;

	
	@FindBy(id="nav-logo-sprites")
	WebElement logo;
	
	//***************Constructor*******************
	
	public HomePage() {
		PageFactory.initElements( getDriver(), this);
	}
	
	//*********************************************
	
	public SearchPage ValidateSearchBox() {
		Action.isDisplayed( getDriver(), searchBox);
		return new SearchPage();
	}
	

	public boolean validateLogo() {
		return Action.isDisplayed( getDriver(), logo);
	}
	

	
}