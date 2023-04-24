package project.kalyanJewellers.stepdefs;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import project.kalyanJewellers.core.WebDriverFactory;
import project.kalyanJewellers.pageobjects.LandingPageObjects;
import project.kalyanJewellers.pageobjects.ProductsDisPageObjects;
import project.kalyanJewellers.pageobjects.ProductsListingPageObjects;

public class StepDefs {

	
	 private static final Logger logger = LogManager.getLogger(StepDefs.class);

	private static final String String = null;
		
	 WebDriver driver;
	 String base_url = "https://www.candere.com/";
	 int implicit_wait_timeout_in_sec = 20;
	 WebDriverWait webDriverWait;
	 Scenario scn;
	
	 LandingPageObjects landingPageObjects;
	 ProductsListingPageObjects productsListingPageObjects;
	 ProductsDisPageObjects productsDisPageObjects;
	 
	 @Before 
	 public void setUp(Scenario scn) throws Exception{
		    this.scn = scn;
		    String browserName = WebDriverFactory.getBrowserName();
		    driver = WebDriverFactory.getWebDriverForBrowser(browserName);

	        
//	         Initialize class Objects
	        landingPageObjects = new LandingPageObjects(driver, webDriverWait);
	        productsListingPageObjects = new ProductsListingPageObjects(driver, webDriverWait);
	        productsDisPageObjects = new ProductsDisPageObjects(driver, webDriverWait);
	    }
	 
	 @After (order=1)
	    public void tearDwon()
	 {     
		 WebDriverFactory.quitDriver();
	        scn.log("Browser got closed");
	    }
	 
	 @After(order=2)
	  public void captureScreenShot(Scenario scn)
	  {
			    if (scn.isFailed()) {
			    	TakesScreenshot  scrnShot = (TakesScreenshot )driver;
			        byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
			        scn.attach(data, "image/png","Failed Step Name: " + scn.getName());
			    }else{
			        scn.log("Test case is passed, no screen shot captured");
			    }
	  }			    


@Given("User navigated to the home application url")
public void user_navigated_to_the_home_application_url() {
	 landingPageObjects.validateUserIsOnLandingPage(base_url);
     scn.log("User navigated to the home application url");
   
}

@Given("Application title is {string}")
public void application_title_is(String string) {
	landingPageObjects.applicationTitleIs(string);
	scn.log("Application title is");
        
}

@When("User search for a product {string}")
public void user_search_for_a_product(String productName) throws InterruptedException {
	landingPageObjects.searchproduct(productName);
    scn.log("User search for a product");
    Thread.sleep(2000);
}


@Then("Search result is displyed {string}")
public void search_result_is_displyed(String productName) throws InterruptedException {
	productsListingPageObjects.validateSearchResult(productName);
    scn.log("Search result is displyed");
    Thread.sleep(2000);
}
   
@When("User Click on product {string}")
public void user_click_on_product(String string) throws InterruptedException {
	productsDisPageObjects.clickingOnProduct(string);
	 scn.log("User Click on product");
	 Thread.sleep(2000);

}

@Then("Product Description is displayed in new tab")
public void product_description_is_displayed_in_new_tab() throws InterruptedException {
	  productsDisPageObjects.prodDesDisplayedInNewTab();
      scn.log("Product Description is displayed in new tab");

      Thread.sleep(2000);
      
 	
}
@Then("Select the size drop down")
public void select_the_size_drop_down() throws InterruptedException {
	productsDisPageObjects.SelectSizeOfProd();
	scn.log("Select the size drop down");
	Thread.sleep(2000);
}

@Then("Notification is displyed {string}")
public void notification_is_displyed(String string) {
	productsDisPageObjects.NotificationIsDisplyed(string);
	scn.log("Notification text is generated After select price");

}


@When("user scroll dwon to the button landing page of the application")
public void user_scroll_dwon_to_the_button_landing_page_of_the_application() throws InterruptedException {
	WebElement aboutUsElement = driver.findElement(By.xpath("//p[text()='ABOUT US']"));

/*	JavascriptExecutor js = ((JavascriptExecutor) driver);
	Thread.sleep(2000); 
	js.executeScript("arguments[0].scrollIntoView();", aboutUsElement);
	Thread.sleep(2000); 
	logger.info("page scroll down till about us");*/

	  
   }

@When("the categories having the option {string}")
public void the_categories_having_the_option(String string) throws InterruptedException {
	WebElement aboutUsElement = driver.findElement(By.xpath("//p[text()='ABOUT US']"));
	Assert.assertEquals(true, aboutUsElement.getText());
	logger.info("Assertion passed about us section validated");
	scn.log("Validating  about us section Section");
	
	 Thread.sleep(2000);
   
}
@Then("under the about us category below options are visible")
public void under_the_about_us_category_below_options_are_visible(List<String> expectedaboutUsOptionsElement) throws InterruptedException {
	List<WebElement> aboutUsElement = driver.findElements(By.xpath("//a[@class='second our_compamy__']//parent::nav/a"));

	for (int i = 0; i<expectedaboutUsOptionsElement.size(); i++)
	{
		if(expectedaboutUsOptionsElement.get(i).equals(aboutUsElement.get(i).getText()))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
		logger.info("List of About us validated");
		scn.log("List of About us validated");
		
		 Thread.sleep(2000);
	}
	   
	}


@Then("Browser is closed")
public void browser_is_closed() throws InterruptedException {
	driver.quit();
  Thread.sleep(2000);
}



@When("validate the follow us option with social media icons")
public void validate_the_follow_us_option_with_social_media_icons() throws InterruptedException {
	WebElement followUsElement = driver.findElement(By.xpath("//p[text()='FOLLOW US']"));
	Assert.assertEquals(true, followUsElement.getText());
	logger.info("Assertion passed FOLLOW US section validated");
	scn.log("Validating FOLLOW US Section");
	
	 Thread.sleep(2000);
   
}

@When("click on social media icons {string}")
public void click_on_social_media_icons(String string) {
	WebElement FBIcon = driver.findElement(By.xpath("//a[@class='social_icons__ fb']"));
	FBIcon.click();
	
	WebElement InstaIcon = driver.findElement(By.xpath("//a[@class='social_icons__ insta']"));
	InstaIcon.click();
	
	WebElement TwiterIcon = driver.findElement(By.xpath("//a[@class='social_icons__ twitter']"));
	TwiterIcon.click();
	
	
	
	
	
	
	//h1[text()='Candere by Kalyan Jewellers']fb
	//h2[text()='canderejewellery']      insta
	//span[@class='css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0']//span[text()='Candere By Kalyan Jewellers'] twitter
	
   
}

























}




