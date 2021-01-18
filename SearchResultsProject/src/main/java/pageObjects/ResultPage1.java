package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultPage1 {

	public WebDriver driver;
	
		By originAirport=By.xpath("//div[@data-placeholder='From']");
		
		public ResultPage1(WebDriver driver) {
			// TODO Auto-generated constructor stub
			this.driver=driver;
		}

		public WebElement getoriginAirport() {
			return driver.findElement(originAirport);
		}
}
