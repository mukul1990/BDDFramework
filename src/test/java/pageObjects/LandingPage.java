package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	 
	public LandingPage(WebDriver driver)
	  {
		  this.driver=driver;
	  }
	
 private By search=By.xpath("//input[@type='search']");
  private By productName=By.cssSelector(".products h4");
  private By topDeal=By.linkText("Top Deals");
  private By increament=By.cssSelector(".product a:nth-child(3)");
  private By addToCart=By.xpath("//button[contains(text(),'ADD TO CART')]");
  
  public WebDriver driver;
 
  public void searchProductName(String name)
  {
	  driver.findElement(search).sendKeys(name);
  }
  
  public String getProductName()
  {
	  return driver.findElement(productName).getText();
  }
  
  public void navigateToDealPage()
  {
  	  driver.findElement(topDeal).click();
  }

  public void AddItemToCart(int quantity)
  {
	  int i=quantity;
	  while(i>0)
	  {
		  driver.findElement(increament).click();
		  i--;
	  }
	  driver.findElement(addToCart).click();
  }
  
}
