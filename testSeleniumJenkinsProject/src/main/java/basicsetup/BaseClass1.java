package basicsetup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Report.ReportLog;

public class BaseClass1 {
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
		if (System.getProperty("browser").equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
			Reporter.log("Running test on chrome browser");
		} else if (System.getProperty("browser").equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			Reporter.log("Running test on Firefox browser");
		} else if (System.getProperty("browser").equalsIgnoreCase("edge")) {
			driver =new EdgeDriver();
			Reporter.log("Running test on edge browser");
		}
		driver.manage().window().maximize();
		driver.get(System.getProperty("url"));
		
		logger= new ReportLog(driver);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
	}

	
	@AfterTest
	public void tearDown() throws IOException {
		logger.endTestSuite();
		driver.quit();
	}
}
