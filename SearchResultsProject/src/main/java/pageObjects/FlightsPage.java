package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlightsPage {
	
	
	public WebDriver driver;
	

	By originAirport=By.xpath("//div[@data-placeholder='From?']");
	By destinationAirport=By.xpath("//div[@data-placeholder='To?']");
	
	By origin=By.xpath("//input[@placeholder='From?']");
	By destination=By.xpath("//input[@placeholder='To?']");
	
	By searchButton=By.xpath("//button[@title='Search flights']");

	public WebElement getOriginAirport() {
		return driver.findElement(originAirport);
	}
	
	public WebElement getdestinationAirport() {
		return driver.findElement(destinationAirport);
	}
	
	public WebElement getOrigin()
	{
		return driver.findElement(origin);
	}
	
	public WebElement getDestination() {
		return driver.findElement(destination);
	}
	
	public WebElement getSearchButton() {
		return driver.findElement(searchButton);
	}
	
	// Constructor 
	public FlightsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
}
