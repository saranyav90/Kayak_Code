package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import resources.Base;

public class CheckHomePageTitle extends Base{
	
	public static org.apache.logging.log4j.Logger log = LogManager.getLogger(Base.class.getName());
	
	@Test(description="Checks if title of the Landing page is as expected")
	@Parameters("browser")
	public void checkTitle(String browser) throws IOException {
		driver=initializeDriver(browser);
		log.info("Driver is initialised");
		driver.get("https://www.kayak.com/");
		log.info("Navigated to Home Page ");
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "Search Flights, Hotels & Rental Cars | KAYAK");
		log.info("Successfully validated title.");
		
	}
	
	@AfterTest(description = "Closes your driver after each test")
	public void closeBrowser() throws InterruptedException {
		driver.close();
		log.info("Closed browser");
	}
}
