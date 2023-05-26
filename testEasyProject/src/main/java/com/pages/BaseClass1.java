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

public class BaseClass1 {
	public WebDriver driver;
	
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
			System.out.println("Running test on chrome browser");
		}
		if (System.getProperty("browser").equalsIgnoreCase("Firefox")) {
	    //else if(prop.getProperty("browser").equals("firefox")) {
			driver = new FirefoxDriver();
			System.out.println("Running test on Firefox browser");
		}
		if (System.getProperty("browser").equalsIgnoreCase("Edge")) {
		//else if(prop.getProperty("browser").equals("edge")) {
			driver =new EdgeDriver();
			System.out.println("Running test on edge browser");
		}
		driver.manage().window().maximize();
		driver.get(System.getProperty("url"));
		//driver.get("https://www.saucedemo.com/");
		//System.out.println(System.getProperty("url")+" : website launched");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
	}

	
	@AfterTest
	public void tearDown() throws IOException {
		//driver.quit();
	}
}
