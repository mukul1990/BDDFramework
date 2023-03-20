package stepDefinitions;


import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import utils.TestContextSetup;

public class Hooks {

	public TestContextSetup testContextSetup;
	public Hooks(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
	}
	
	@Before
	public   void Setup()
	{
		
		testContextSetup.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@After
	public void TearDown()
	{
		testContextSetup.driver.quit();
	}
	
	@AfterStep
	public void AddScreenshot(io.cucumber.java.Scenario scenario)
	{
		WebDriver driver=testContextSetup.driver;
		TakesScreenshot ts =((TakesScreenshot)driver);
		if(scenario.isFailed())
		{
			byte[] source=ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(source, "image/png", "image");
		}
	}
}
