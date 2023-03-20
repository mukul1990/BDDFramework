package pageObjects;

import org.openqa.selenium.WebDriver;

import utils.TestContextSetup;

public class PageObjectManager {

	public LandingPage landingpage;
	public OfferPage offerpage;
	public CheckOutPage checkoutPage;
	public WebDriver driver;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver= driver;
	}
	
	public LandingPage getLandingPage()
	{
		landingpage= new LandingPage(this.driver);
		return landingpage;
	}
	
	public OfferPage getOfferPage()
	{
		offerpage= new OfferPage(this.driver);
		 return offerpage;
	}
	
	public CheckOutPage getcheckoutPage()
	{
		checkoutPage= new CheckOutPage(this.driver);
		return checkoutPage;
	}
}
