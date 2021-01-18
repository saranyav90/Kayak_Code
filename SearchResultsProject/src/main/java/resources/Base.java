package resources;

import java.io.File;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Parameters;

public class Base {
	public WebDriver driver;
	public Properties prop;
	
	//method to initialise and return WebDriver Object as per which browser
	@Parameters("browser")
	public WebDriver initializeDriver(String browser) throws IOException {
		
		prop=new Properties();
		FileInputStream fis=new FileInputStream("/Users/saranya.vazhampatta/eclipse-workspace/SearchResultsProject/src/main/java/resources/data.properties");
		prop.load(fis);
		//String browserName=prop.getProperty("browser");
		String urlName=prop.getProperty("url");
		//System.out.println(browserName);
		System.out.println(urlName);
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "//Users//saranya.vazhampatta//Downloads//chromedriver");//The propertyName represents the name of the browser-specific driver, 
																												//and the value points to the path of that browser driver.
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			// Firefox initialisation
		}
		else if(browser.equalsIgnoreCase("IE")) {
			//// IE initialisation
		}
		
		else if(browser.equalsIgnoreCase("safari")) {
			//Safari initialisation
			System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
			driver = new SafariDriver();
		}
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+ "//reports//"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
	}
	
	
	
	
	
	
}
