package project.kalyanJewellers.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LandingPageObjects {
	
	  private static final Logger logger = LogManager.getLogger(LandingPageObjects.class);
	    
	    //sec1 declare a driver object 
	    private WebDriver driver ;
	    private WebDriverWait webDriverWait;
		
		//Sec2 parametrize the constructor 
	    public LandingPageObjects( WebDriver driver,WebDriverWait webDriverWait) {
	   	this.driver = driver; 
	   	this.webDriverWait = webDriverWait;
	   	 
	    }
	    
	  //sec3 Define the locaters 
	    private By searchBoxElement = By.id("search");
		private By searchButtonElement =(By.xpath( "//div[@class='form-search']"));  
	
		
	 //sec4 Write Business Methods (method to be exposed ) agent 
	public void searchproduct(String productName) {
			
	 WebDriverWait webDriverWait = new WebDriverWait(driver,20);
	 logger.info("WebDriverWait time out set to ->" + 20);
	 WebElement elementSearchBox = webDriverWait.until(ExpectedConditions.elementToBeClickable(searchBoxElement));
	 logger.info("Waiting for waibElement -> elementSearchBox to be clickable ");
	 driver.findElement(searchBoxElement).sendKeys(productName);
	 logger.info("sending keys into webElement ->  searchBoxElement ");
     driver.findElement(searchButtonElement).click();
	 logger.info("Clicking on a search button");
	     
	}
	
	 public void validateUserIsOnLandingPage(String base_url)
     {
		 driver.get(base_url);
	     logger.info("Browser got invoked with URL as -> " + base_url );
	     String expected = "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store";
	     String actual =driver.getTitle();
	     Assert.assertEquals("Page Title validation",expected,actual);
	     logger.info("Assertion for Page Title validation is passed with expected as -> " + expected + "and actual as ->" + actual);    
	     		 
     }
	 
	 public void applicationTitleIs(String string) {
		   
     String expected = "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store";
     String actual =driver.getTitle();
     Assert.assertEquals("Page Title validation",expected,actual);
     logger.info("Assertion for Application title is passed with expected as -> " + expected + "and actual as ->" + actual);

}

}