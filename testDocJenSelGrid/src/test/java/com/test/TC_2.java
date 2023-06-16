//package com.test;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import com.google.common.util.concurrent.Uninterruptibles;
//
//public class TC_2 {
//	@BeforeSuite
//	public void setup() {
//		testcmd.commandTest("docker-compose up -d");
//	}
//	@Test(dataProvider="getData")
//	//public void localtest(String browser,String port) throws Exception {
//	public void localtest(String browser) throws Exception {
//		String nodeURL = "http://localhost:4444/wd/hub";
//	    DesiredCapabilities caps = new DesiredCapabilities();
//	    caps.setBrowserName(browser);
//	    System.out.println("aaaa");
//	    WebDriver driver = new RemoteWebDriver(new URL(nodeURL), caps);
//	    System.out.println("bbb");
//		driver.manage().window().maximize();
//		System.out.println("ccc");
//		driver.get("https://www.saucedemo.com/");
//		System.out.println("browser : "+browser+", website launched : "+driver.getTitle());
//		//Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
//		driver.quit();
//	}
//	@DataProvider(parallel=true)
//	public Object[][] getData()
//	{
//		return new Object[][]
//				//{{"chrome"}};
//				//{{"chrome"},{"firefox"}};
//				//{{"chrome","4444"},{"firefox","4444"},{"MicrosoftEdge","4444"}};
//				{{"chrome"},{"firefox"},{"MicrosoftEdge"}};
//				//{{"chrome"},{"MicrosoftEdge"}};
//	}
//	@AfterSuite
//	public void stopContainer() {
//		//testcmd.commandTest("docker-compose down");
//	}
//}
