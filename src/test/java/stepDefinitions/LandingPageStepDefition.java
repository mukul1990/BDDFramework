package stepDefinitions;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.w3c.dom.Text;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;


public class LandingPageStepDefition {
public WebDriver driver;
public String homeProductName;
public TestContextSetup testContextSetup;
//public PageObjectManager pageObjectManager;
//public LandingPage lp;
//public LandingPage landingpage;
public LandingPageStepDefition(TestContextSetup testContextSetup)
{
	this.testContextSetup=testContextSetup;
}
	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() throws IOException {
		
		testContextSetup.driver.get(testContextSetup.testbase.getGlobalProperty("url"));
	}
	@When("^user search with short productName (.+) and actual product is found on home page$")
	public void user_search_with_short_product_name_and_actual_product_is_found_on_home_page(String productName) throws InterruptedException {
		//LandingPage lp= new LandingPage(testContextSetup.driver);
		//pageObjectManager=new PageObjectManager(testContextSetup.driver);
		System.out.println(testContextSetup.driver.getTitle());
		LandingPage landingpage=testContextSetup.pageObjectManager.getLandingPage();
		//testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(productName);
		
		 landingpage.searchProductName(productName);
		Thread.sleep(1000);
	   // testContextSetup.homeProductName= testContextSetup.driver.findElement(By.cssSelector(".products h4")).getText().split("-")[0].trim();
		testContextSetup.homeProductName=landingpage.getProductName().split("-")[0].trim();
		System.out.println("HomeProductName:"+testContextSetup.homeProductName);
	}
	
	
	
}
