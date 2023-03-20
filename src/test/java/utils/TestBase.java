package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;

public class TestBase {

	public WebDriver driver;
	
	public WebDriver WebDriverManager() throws IOException
	{
		if(getGlobalProperty("browser").equalsIgnoreCase("chrome"))
		{
		  System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
			//WebDriverManager.chromedriver().setup();
		    ChromeOptions options = new ChromeOptions();
		    options.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(options);
		}
		
		 if(getGlobalProperty("browser").equalsIgnoreCase("firefox"))
		 {
			io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		 }
		return driver;
	}

	public String getGlobalProperty(String name) throws IOException
	{
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties");
		Properties prop= new Properties();
		prop.load(fis);
		if(name.equalsIgnoreCase("browser"))
		{
			String prop_browser=prop.getProperty(name);
			String system_browser=System.getProperty("browser");
			String browser=system_browser!=null?system_browser:prop_browser;
			return browser;
		}
		else
		return prop.getProperty(name);
	}
}
