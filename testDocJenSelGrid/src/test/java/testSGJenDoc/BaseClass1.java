package testSGJenDoc;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.google.common.util.concurrent.Uninterruptibles;
import Report.ReportLog;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass1 {
	public WebDriver driver;
	public static ReportLog logger;
	public static String runmode,url,gridURL,fdriverpath,fdrivertype,cdriverpath,cdrivertype,edriverpath,edrivertype;
	
	@BeforeSuite
	public void setUp() throws IOException, InterruptedException 
	{
		String path = "./src/test/java/test.properties";
  		//Creating object of Properties class
  		Properties prop = new Properties();
  	    //Creating object of FileInputStream class and providing the properties file path to the object
  		FileInputStream fs = new FileInputStream(path);
  		prop.load(fs);
  		
  		runmode=prop.getProperty("runmode");
  		url=prop.getProperty("url");
  		gridURL=prop.getProperty("gridURL");
  		fdriverpath=prop.getProperty("fdriverpath");
  		fdrivertype=prop.getProperty("fdrivertype");
  		cdriverpath=prop.getProperty("cdriverpath");
  		cdrivertype=prop.getProperty("cdrivertype");
  		edriverpath=prop.getProperty("edriverpath");
  		edrivertype=prop.getProperty("edrivertype");
  		
		if (runmode.equalsIgnoreCase("local")) {
			System.out.println("in beforesuite --- local");
			System.out.println("out beforesuite --- local");
		}
		else if(runmode.equalsIgnoreCase("remote"))
		{
//			Runtime rt = Runtime.getRuntime();
			Process process = Runtime.getRuntime().exec("cmd.exe /c cd /d C:\\SS\\Selenium\\testDocJenSelGrid && docker-compose up -d");
	        process.waitFor();
	        Thread.sleep(10000);
		}
	}
	
	@BeforeTest
	@Parameters({"browser"})
	//public WebDriver setUp() throws IOException {
	public void setUp(String browser) throws IOException, InterruptedException 
	{
//		if (runmode.equalsIgnoreCase("local")) 
//		{			
//			if(browser.equals("chrome")) 
//			{
//				WebDriverManager.chromedriver().setup();
//				driver = new ChromeDriver();
//				Reporter.log("Running test on chrome browser");
//			}
//			if(browser.equals("firefox")) 
//			{
//				WebDriverManager.firefoxdriver().setup();
//				driver = new FirefoxDriver();
//				Reporter.log("Running test on Firefox browser");
//			}
//			if(browser.equals("edge")) 
//			{
//				WebDriverManager.edgedriver().setup();
//				driver = new EdgeDriver();
//				Reporter.log("Running test on MSEdge browser");
//			}
//		}
		if (runmode.equalsIgnoreCase("local")) 
		{			
			if(browser.equals("chrome")) {
				//chrome driver type and driver path setting
				System.setProperty(cdrivertype, cdriverpath);
				driver = new ChromeDriver();
				Reporter.log("Running test on chrome browser");
			}
			if(browser.equals("firefox")) {
				//firefox driver type and driver path setting
				System.setProperty(fdrivertype, fdriverpath);
				driver = new FirefoxDriver();
				Reporter.log("Running test on Firefox browser");
			}
			if(browser.equals("edge")) {
				//edge driver type and driver path setting
				System.setProperty(edrivertype, edriverpath);
				driver =new EdgeDriver();
				Reporter.log("Running test on edge browser");
			}
			
			driver.manage().window().maximize();
			driver.get(url);
			//System.out.println(System.getProperty("url")+" : website launched");
			logger= new ReportLog(driver);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			logger.startTest("Executing setUp BeforeTest---> LOCAL");
			//logger.logInfo("Openned website on : "+prop.getProperty("browser").toString());
			logger.logInfo("Openned website : "+System.getProperty("url")+" on browser : "+System.getProperty("browser"));
		} 
		else if(runmode.equalsIgnoreCase("remote")) {
			System.out.println("setUp-1");
			String nodeURL = gridURL;
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setBrowserName(browser);
	        System.out.println("1111");
	        System.out.println(nodeURL + "; "+browser);
	        driver = new RemoteWebDriver(new URL(nodeURL), caps);
			driver.manage().window().maximize();
			System.out.println("2222");
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			logger= new ReportLog(driver);
			logger.startTest("Executing setUp BeforeTest---> REMOTE");
			System.out.println("3333");
			System.out.println("website launched : "+driver.getTitle());
			logger.logInfo("Openned website : "+System.getProperty("url")+" on browser : "+System.getProperty("browser"));
			Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
			//driver.quit();
//			logger= new ReportLog(driver);
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			logger.startTest("Executing setUp BeforeTest");
//			//logger.logInfo("Openned website on : "+prop.getProperty("browser").toString());
//			logger.logInfo("Openned website : saucedemo on browser : chrome");
//			logger.endTest();
//			Thread.sleep(5000);
		}
	}
 
	
	@AfterTest
	public void testClose() throws IOException {
		logger.endTestSuite();
		//driver.quit();
	}
	@AfterSuite
	public void tearDown() throws IOException, InterruptedException
	{
		if(runmode=="remote") 
		{
//			Runtime rt = Runtime.getRuntime();
			Process process = Runtime.getRuntime().exec("cmd.exe /c cd /d C:\\SS\\Selenium\\testDocJenSelGrid && docker-compose down");
	        process.waitFor();
	        Thread.sleep(10000);
		}
	}
}
