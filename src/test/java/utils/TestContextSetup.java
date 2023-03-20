package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.LandingPage;
import pageObjects.OfferPage;
import pageObjects.PageObjectManager;

public class TestContextSetup {

	public String homeProductName;
	public WebDriver driver;
	public PageObjectManager pageObjectManager;
	public TestBase testbase;
	public GenericUtils generic;
	public TestContextSetup() throws IOException
	{		
		testbase=new TestBase();
		driver=testbase.WebDriverManager();
		generic=new GenericUtils(driver);
		this.pageObjectManager=new PageObjectManager(driver);
	}
	
	
}
