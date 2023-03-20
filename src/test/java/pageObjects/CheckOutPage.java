package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {

	 public WebDriver driver;
	public CheckOutPage(WebDriver driver)
	  {
		  this.driver=driver;
	  }
	
	private	By cart=By.cssSelector(".cart-icon img");
	private	By checkout= By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	private	By promocode=By.cssSelector(".promocode");
	private	By apply=By.cssSelector(".promoBtn");
	private	By placeOrder=By.xpath("//button[contains(text(),'Place Order')]");
	private By promoInfo=By.cssSelector(".promoInfo");
		public void checkoutProduct()
		{
			driver.findElement(cart).click();
			driver.findElement(checkout).click();
		}
		
		public void verifyPromoCode(String promoCode)
		{
			driver.findElement(promocode).sendKeys(promoCode);
			driver.findElement(apply).click();
		}
		
		public void placeOrder()
		{
			driver.findElement(placeOrder).click();
		}
		
		public String getPromoMessage()
		{
			return driver.findElement(promoInfo).getText();
		}
}
