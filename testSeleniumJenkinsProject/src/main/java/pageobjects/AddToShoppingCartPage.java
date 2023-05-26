/*This is the Page Object class, here all the methods are 
 * defined to search for different products and add to the shopping cart
 * Even Methods are defined to validate the added items in the shopping cart
 * These methods can be re-used to avoid the code duplication and speed up the automation testing.
 */

package pageobjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import java.lang.reflect.Method;
import Report.ReportLog;
import basicsetup.BaseClass;
public class AddToShoppingCartPage extends BaseClass{
	public static WebElement element = null;
	
	public static void enterProductToSearch(WebDriver driver, String product) {
		element = driver.findElement(By.id("twotabsearchtextbox"));
		element.clear();
		element.sendKeys(product);
	}
	
	public static void clickSearchButton(WebDriver driver) throws IOException {
		logger.logInfo("clickSearchButton for test case 1= ");
		try {
			driver.findElement(By.xpath("//input[@class='nav-input']")).click();	
		}
		catch(Exception e) {
			logger.logFail(e.getMessage());
		}
		
	}
	
	public static void addToShoppingCart(WebDriver driver) throws IOException {
		logger.logPass("addToShoppingCart");
		driver.findElement(By.id("add-to-cart-button")).click();
	}
	
	public static void clickOnShoppingCart(WebDriver driver) throws IOException {
		logger.logPass("clickOnShoppingCart");
		driver.findElement(By.id("nav-cart-count")).click();
	}

	public static void clickOnProceedCheckout(WebDriver driver) throws IOException {
		logger.logPass("clickOnProceedCheckout");
		driver.findElement(By.xpath("//input[@name='proceedToCheckout']")).click();
	}
	
	
	//Product1: locator for Head first java book search
	public static void clickOnProduct1(WebDriver driver) throws IOException {
		logger.logPass("clickOnProduct1");
		driver.findElement(By.xpath("//h2[@data-attribute='Head First Java, 2nd Edition']")).click();
	}
	
	//Product2: locator for Head first python book search
	public static void clickOnProduct2(WebDriver driver) throws IOException {
		logger.logFail("clickOnProduct2");
		driver.findElement(By.xpath("//h2[@data-attribute='Head First Python: A Brain-Friendly Guide']")).click();
	}
	
	

	
//	Method to search and add products to shopping cart
	public static void addProductToShoppingCart(WebDriver driver, String product1, String product2 ) throws IOException {
//		To add product1 : Head first java book to the shopping cart
		//logger.startTest(m.getName());
		logger.startTest("addProductToShoppingCart");
		
		//Reporter.log("Searching for head first java book", true);
		logger.logInfo("Searching for head first java book");
		enterProductToSearch(driver, product1);
		clickSearchButton(driver);
		clickOnProduct1(driver);
		addToShoppingCart(driver);
		//Reporter.log("Searched head first java book and added to the shopping cart", true);
		logger.logInfo("Searched head first java book and added to the shopping cart");
//		To add product2 : Head first python book to the shopping cart
		Reporter.log("Searching for head first python book", true);
		logger.logInfo("Searching for head first python book");
		enterProductToSearch(driver, product2);
		clickSearchButton(driver);
		clickOnProduct2(driver);
		addToShoppingCart(driver);
		Reporter.log("Searched head first python book and added to the shopping cart", true);
		logger.logInfo("Searched head first python book and added to the shopping cart");
		logger.endTest();
	}
	
//	Method to validate the shopping cart
	public static void validateShoppingCart(WebDriver driver) throws IOException {
		logger.startTest("validateShoppingCart");
		Reporter.log("Checking for items in the shopping cart", true);
		logger.logInfo("Checking for items in the shopping cart");
		clickOnShoppingCart(driver);
		clickOnProceedCheckout(driver);
		Reporter.log("found items in shopping cart and clicked on proceed to check out", true);
		logger.logInfo("found items in shopping cart and clicked on proceed to check out");
		logger.endTest();
	}
}






