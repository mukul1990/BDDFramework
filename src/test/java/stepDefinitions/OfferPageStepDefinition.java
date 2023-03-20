package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OfferPage;
import pageObjects.PageObjectManager;
import pageObjects.OfferPage;
import utils.TestContextSetup;

public class OfferPageStepDefinition {
	public String offerProductName;
	public TestContextSetup testContextSetup;
	public OfferPage offerpage;
	public LandingPage landingpage1;
	public PageObjectManager pageObjectManager1;
	public OfferPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
	}
	
	@When("^user search with short productName (.+) and actual product is found on Offer page$")
	public void user_search_with_short_product_name_and_actual_product_is_found_on_offer_page(String productName) throws InterruptedException {
	   /* testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
	    switchToWindow();
	    testContextSetup.driver.findElement(By.id("search-field")).sendKeys(productName);
	    offerProductName = testContextSetup.driver.findElement(By.xpath("//tbody/tr/td[1]")).getText();*/
		//pageObjectManager1=new PageObjectManager(testContextSetup.driver);
		switchToWindow();
		//OfferPage op = new OfferPage(testContextSetup.driver);
		
		
		//offerpage=pageObjectManager1.getOfferPage();
		testContextSetup.pageObjectManager.getOfferPage().searchProductName(productName);
		//offerpage.searchProductName(productName);
		//offerProductName=offerpage.getProductName();
		offerProductName=testContextSetup.pageObjectManager.getOfferPage().getProductName();
	    System.out.println("offerProductName:"+offerProductName);
	}
	
	public void switchToWindow() throws InterruptedException
	{
		//LandingPage lp1= new LandingPage(testContextSetup.driver);
		//lp1.navigateToDealPage();
//		 landingpage1=pageObjectManager1.getLandingPage();
//		 landingpage1.navigateToDealPage();
//		 testContextSetup.generic.switchWindowToChild();
		 testContextSetup.pageObjectManager.getLandingPage().navigateToDealPage();
		 testContextSetup.generic.switchWindowToChild();
//		Set<String>windows=testContextSetup.driver.getWindowHandles();
//	    Iterator<String>it=windows.iterator();
//	    String parent=it.next();
//	    String child=it.next();
//	    testContextSetup.driver.switchTo().window(child);
	}
	@Then("Verify that productName from offer page is matching with the productName from offer page")
	public void verify_that_product_name_from_offer_page_is_matching_with_the_product_name_from_offer_page() {
	    Assert.assertEquals(offerProductName,testContextSetup.homeProductName);
}
}