package project.kalyanJewellers.pageobjects;

import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsDisPageObjects {


	  private static final Logger logger = LogManager.getLogger(ProductsDisPageObjects.class);
	    
	    //sec1 declare a driver object 
	    private WebDriver driver ;
	    private WebDriverWait webDriverWait;
		
		//Sec2 parametrize the constructor 
	    public ProductsDisPageObjects( WebDriver driver,WebDriverWait webDriverWait) {
	   	this.driver = driver; 
	   	this.webDriverWait = webDriverWait;
	   	 
	    }  
	    
	  	private By ProdName  = By.xpath("//div[text()='Majestic Solitaire Diamond Ring']");


public void clickingOnProduct(String productName) {
	   WebElement ProductsName = driver.findElement(By.xpath("//div[text()='Majestic Solitaire Diamond Ring']"));
	   logger.info("Waiting for waibElement -> ProductsName to be clickable ");

	   ProductsName.click();
	   logger.info("Clicking on a product ");
	
	}

public void prodDesDisplayedInNewTab() {
    
    Set<String> handles = driver.getWindowHandles();// get all the open windows
    Iterator<String> it = handles.iterator(); // get the iterator to iterate the elements in set
 //   String original = it.next();//gives the parent window id
    String prodDescp = it.next();//gives the child window id
    driver.switchTo().window(prodDescp);
    logger.info("Product Description is displayed in new tab ");


}

public void SelectSizeOfProd() {
	
 	WebElement sizeDropDwn = driver.findElement(By.xpath("//select[@Class='type_select']"));
	Select size = new Select( sizeDropDwn);
	size.selectByVisibleText("18");
	Assert.assertEquals(true, sizeDropDwn.isDisplayed());
    logger.info("user is select Ring size ");
}

public void NotificationIsDisplyed(String string) {
	WebElement notificationText = driver.findElement(By.xpath("//div[text()='Price updated']"));
//	webDriverWait.until(ExpectedConditions.visibilityOf(notificationText));
	Assert.assertEquals(false,notificationText .isDisplayed());
    logger.info("Price updated Notification is displyed after selecting the size -> " + notificationText);


}
}