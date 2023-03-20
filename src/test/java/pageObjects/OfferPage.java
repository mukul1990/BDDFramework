package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPage {

	
	public OfferPage(WebDriver driver)
	  {
		  this.driver=driver;
	  }
	
private By search=By.id("search-field");
private By productName=By.xpath("//tbody/tr/td[1]");

public WebDriver driver;


public void searchProductName(String name)
{
	  driver.findElement(search).sendKeys(name);
}
public String getProductName()
{
	  return driver.findElement(productName).getText();
}
}
