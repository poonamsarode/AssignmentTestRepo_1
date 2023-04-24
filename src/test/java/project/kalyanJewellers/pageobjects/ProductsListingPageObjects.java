package project.kalyanJewellers.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsListingPageObjects {
	

	  private static final Logger logger = LogManager.getLogger(ProductsListingPageObjects.class);
	    
	    //sec1 declare a driver object 
	    private WebDriver driver ;
	    private WebDriverWait webDriverWait;
		
		//Sec2 parametrize the constructor 
	    public ProductsListingPageObjects( WebDriver driver,WebDriverWait webDriverWait) {
	   	this.driver = driver; 
	   	this.webDriverWait = webDriverWait;
	   	 
	    }  
	    
	
	 	public void validateSearchResult(String productName) {	 
	 
	 		WebDriverWait webDriverWait1 = new WebDriverWait(driver,20);
	 	    logger.info("WebDriverWait time out set to ->" + 20);

	 	    webDriverWait1.until(ExpectedConditions.titleIs("Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store"));

	 	    //Assertion for Page Title
	 	    Assert.assertEquals("Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store", driver.getTitle());
	 	    logger.info("Assertion for expected condition title is ");

 	   }	 	
	 	
	 	
	 	
}
