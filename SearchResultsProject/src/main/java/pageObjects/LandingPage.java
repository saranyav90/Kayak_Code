package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	By flightsTab=By.xpath("//div[contains(text(),'Flights')]");
	
	public WebElement getflightsTab() {
		return driver.findElement(flightsTab);
	}
	
	// Constructor
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}
}
