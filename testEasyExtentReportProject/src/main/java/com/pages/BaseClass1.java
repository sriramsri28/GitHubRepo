package com.pages;

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
  		//String path = "./src/test/java/testdata.properties";
		String path = "./src/test/java/test.properties";
  		
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
		//if(prop.getProperty("browser").equals("chrome")) {
			driver = new ChromeDriver();
			Reporter.log("Running test on chrome browser");
		}
		if (System.getProperty("browser").equalsIgnoreCase("Firefox")) {
	    //if(prop.getProperty("browser").equals("firefox")) {
			driver = new FirefoxDriver();
			Reporter.log("Running test on Firefox browser");
		}
		if (System.getProperty("browser").equalsIgnoreCase("Edge")) {
		//if(prop.getProperty("browser").equals("edge")) {
			driver =new EdgeDriver();
			Reporter.log("Running test on edge browser");
		}
		
		driver.manage().window().maximize();
		driver.get(System.getProperty("url"));
		
		//driver.get("https://www.saucedemo.com/");
		//System.out.println(System.getProperty("url")+" : website launched");
		logger= new ReportLog(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.startTest("Executing setUp BeforeTest");
		//logger.logInfo("Openned website on : "+prop.getProperty("browser").toString());
		logger.logInfo("Openned website : "+System.getProperty("url")+" on browser : "+System.getProperty("browser"));
		logger.endTest();
		Thread.sleep(5000);
	}

	
	@AfterTest
	public void tearDown() throws IOException {
		logger.endTestSuite();
		//driver.quit();
	}
}
