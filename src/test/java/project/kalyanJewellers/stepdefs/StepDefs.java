package project.kalyanJewellers.stepdefs;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs {

	
	 private static final Logger logger = LogManager.getLogger(StepDefs.class);
		
	 WebDriver driver;
	 String base_url = "https://www.candere.com/";
	 int implicit_wait_timeout_in_sec = 20;
	 Scenario scn;
	
	 @Before 
	 public void setUp(Scenario scn){
		    this.scn = scn;
	        driver = new ChromeDriver();
	        logger.info("Browser got set");
	        driver.manage().window().maximize();
	        logger.info("Browser got maximize");
	        driver.manage().timeouts().implicitlyWait(implicit_wait_timeout_in_sec, TimeUnit.SECONDS);
	        logger.info("Browser implicit time out set to -> " + implicit_wait_timeout_in_sec);

	        scn.log("Browser got invoked");
	    }
	 
	 @After
	    public void tearDwon()
	 {
	        driver.quit();
	        logger.info("Browser got closed");

	        scn.log("Browser got closed");
	    }

/*@Given("User opean the browser")
public void user_opean_the_browser() {
	  driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(implicit_wait_timeout_in_sec, TimeUnit.SECONDS);
    }*/


@Given("User navigated to the home application url")
public void user_navigated_to_the_home_application_url() {
	 driver.get(base_url);
     logger.info("Browser got invoked with URL as -> " + base_url );
     String expected = "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store";
     String actual =driver.getTitle();
     Assert.assertEquals("Page Title validation",expected,actual);
     logger.info("Assertion for Page Title validation is passed with expected as -> " + expected + "and actual as ->" + actual);

     
     scn.log("User navigated to the home application url");
   
}

@Given("Application title is {string}")
public void application_title_is(String string) {
   
     String expected = "Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store";
     String actual =driver.getTitle();
     Assert.assertEquals("Page Title validation",expected,actual);
     logger.info("Assertion for Application title is passed with expected as -> " + expected + "and actual as ->" + actual);

     scn.log("Application title is");
        
}

@When("User search for a product {string}")
public void user_search_for_a_product(String productName) {
	
	 WebDriverWait webDriverWait = new WebDriverWait(driver,20);
	 logger.info("WebDriverWait time out set to ->" + 20);

     WebElement elementSearchBox = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("search")));
     logger.info("Waiting for waibElement -> elementSearchBox to be clickable ");


     elementSearchBox.sendKeys(productName);
     logger.info("sending keys into webElement ->  elementSearchBox ");

     driver.findElement(By.xpath("//div[@class='form-search']")).click();
     logger.info("Clicking on a search button");

    scn.log("User search for a product");
}

@Then("Search result is displyed")
public void search_result_is_displyed() {
	WebDriverWait webDriverWait1 = new WebDriverWait(driver,20);
    logger.info("WebDriverWait time out set to ->" + 20);

    webDriverWait1.until(ExpectedConditions.titleIs("Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store"));

    //Assertion for Page Title
    Assert.assertEquals("Online Jewellery Shopping India | Candere By Kalyan Jewellers | Most Trusted Online Jewellery Store", driver.getTitle());
    logger.info("Assertion for expected condition title is ");

    scn.log("Search result is displyed");
}
   
@When("User Click on product {string}")
public void user_click_on_product(String string) {
	 List<WebElement> listOfProducts = driver.findElements(By.xpath("//div[text()='Majestic Solitaire Diamond Ring']"));
     logger.info("Waiting for list of waibElement -> listOfProducts to be clickable ");

	 listOfProducts.get(0).click();
     logger.info("Clicking on a product ");

	 scn.log("User Click on product");

}

@Then("Product Description is displayed in new tab")
public void product_description_is_displayed_in_new_tab() {
    
	  Set<String> handles = driver.getWindowHandles();// get all the open windows
      Iterator<String> it = handles.iterator(); // get the iterator to iterate the elements in set
      String original = it.next();//gives the parent window id
      String prodDescp = it.next();//gives the child window id
      driver.switchTo().window(prodDescp);
      scn.log("Product Description is displayed in new tab");
      
 	
}
@Then("Select the size drop down")
public void select_the_size_drop_down() {
	
 	WebElement sizeDropDwn = driver.findElement(By.xpath("//select[@Class='type_select']"));
	Select size = new Select( sizeDropDwn);
	size.selectByVisibleText("13");
	scn.log("Select the size drop down");
	
}

}


