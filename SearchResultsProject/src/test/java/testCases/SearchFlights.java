package testCases;

import org.testng.annotations.Test;

import excelUtils.DataDriver;

import org.testng.Assert;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.FlightsPage;
import pageObjects.LandingPage;
import pageObjects.ResultPage1;
import resources.Base;

public class SearchFlights extends Base {
	
	public static org.apache.logging.log4j.Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	ArrayList<String> data;
	
	@BeforeTest
	@Parameters("browser")
	public void initialise(String browser) throws IOException {
		driver=initializeDriver(browser);
		log.info("Driver is initialised");
		String urlName=prop.getProperty("url");
		driver.get(urlName);
		log.info("Navigated to Home Page ");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		
	}
	
	@Test
	public void searchFlights() throws IOException, InterruptedException {
		LandingPage lp=new LandingPage(driver);
		lp.getflightsTab().click();
		FlightsPage fp=new FlightsPage(driver);
		
		DataDriver dd=new DataDriver();
		data=dd.getData("sample1");
		
		//FROM CITY
		fp.getOriginAirport().click();
		fp.getOriginAirport().sendKeys(Keys.BACK_SPACE);
		fp.getOriginAirport().sendKeys(Keys.BACK_SPACE);
		fp.getOrigin().click();
		fp.getOrigin().sendKeys(data.get(1));
		fp.getOrigin().sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		String sourceCity=fp.getOrigin().getText();
		
		// TO CITY
		fp.getdestinationAirport().click();
		fp.getdestinationAirport().sendKeys(Keys.BACK_SPACE);
		fp.getdestinationAirport().sendKeys(Keys.BACK_SPACE);
		fp.getDestination().click();
		fp.getDestination().sendKeys(data.get(2));
		Thread.sleep(2000);
		fp.getDestination().sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		String destinationCity=fp.getDestination().getText();
		
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		fp.getSearchButton().submit();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);	
		
		//Assertion for comparison of cities
		Assert.assertTrue(( data.get(1)).contains(sourceCity),"The source cities do not match");
		Assert.assertTrue(( data.get(2)).contains(destinationCity),"The destination cities do not match");
		log.info("Successfully validated match.");
		
	}
	
	/*
	@DataProvider
	public  ArrayList getDataInputs() throws IOException{
		DataDriver dd=new DataDriver();
		data=dd.getData("sample1");
		
		return data;
	}
	*/	
	/*
	@DataProvider
	public Object[][] getDataInputs(){
		Object[][] data=new Object [3][2];
		data [0][0]="EWR";
		data [0][1]="BLR";
		data [1][0]="EWR";
		data [1][1]="BLR";
		data [2][0]="BLR";
		data [2][1]="EWR";
	
		return data;
		
	}
	*/
	
	@AfterTest(description = "Closes your driver after each test")
	public void closeBrowser() throws InterruptedException {
		driver.close();
	}
}


