/* Base class: Generic class that can be used to invoke the browser with given url, test level setup and test level tear down.
 * This class can be re used to pass driver instance to any other class to run the tests.
 * Here driver instance is created based on the input provided from properties file "testdata.properties".
 * Test level set up and tear down methods are defined.
 * 1)@BeforeTest : Test level set up method that reads input data like properties file path, 
 *   driver type, driver path, browser type and url from properties file "testdata.properties" to invoke the browser with given url.
 * 2)@AfterTest : Test level tear down method is defined to tear down the test once test is completed.
 * No hard coding except the properties file path.
 */

package basicsetup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import Report.ReportLog;

public class BaseClass {
	public WebDriver driver;
	public static ReportLog logger;
	
	@BeforeTest
	//public WebDriver setUp() throws IOException {
	public void setUp() throws IOException, InterruptedException {
		
		//Properties file path
  		String path = "C:/SS/Selenium/testSeleniumJenkinsProject/src/test/java/testdata.properties";
  		
  		//Creating object of Properties class
  		Properties prop = new Properties();
  		
  	    //Creating object of FileInputStream class and providing the properties file path to the object
  		FileInputStream fs = new FileInputStream(path);
  		
  		prop.load(fs);
  		
  		//firefox driver type and driver path setting
		System.setProperty(prop.getProperty("fdrivertype"), prop.getProperty("fdriverpath"));
		
		//chrome driver type and driver path setting
		System.setProperty(prop.getProperty("cdrivertype"), prop.getProperty("cdriverpath"));
		
		//edge driver type and driver path setting
		System.setProperty(prop.getProperty("edrivertype"), prop.getProperty("edriverpath"));
		//Invoking the browser based on the input provided from the properties file
		if(prop.getProperty("browser").equals("firefox"))
		{
			driver = new FirefoxDriver();
			Reporter.log("Running test on Firefox browser");
		}
		else if(prop.getProperty("browser").equals("chrome"))
		{
			driver = new ChromeDriver();
			Reporter.log("Running test on chrome browser");
		}
		else if(prop.getProperty("browser").equals("edge"))
		{
			driver =new EdgeDriver();
			Reporter.log("Running test on edge browser");
		}
		logger= new ReportLog(driver);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get(prop.getProperty("url"));
		Thread.sleep(5000);
		//return driver;
	}
	
	
	@AfterTest
	public void tearDown() throws IOException {
		logger.endTestSuite();
		driver.quit();
	}
	
}
