//package test123;
//
//import java.net.URL;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//
//public class TestsuiteSetup 
//{
//	@BeforeSuite
//	public void SuiteSetup()
//	{
//		if(runmode=="remote") 
//		{
//			Runtime rt = Runtime.getRuntime();
//	//      Runtime.getRuntime().exec(new String[] {"cmd.exe", "/C", "cd \""+path+"\" && "+command});
//			rt.exec("cmd.exe /c cd \C:\\SS\\Selenium\\testDocJenSelGrid docker-compose up -d");
//		}
//	}
//	@AfterSuite
//	public void tearDown()
//	{
//		if(runmode=="remote") 
//		{
//			Runtime rt = Runtime.getRuntime();
//		//      Runtime.getRuntime().exec(new String[] {"cmd.exe", "/C", "cd \""+path+"\" && "+command});
//			rt.exec("cmd.exe /c cd \C:\\SS\\Selenium\\testDocJenSelGrid docker-compose down -d");
//		}
//	}
//	@BeforeTest
//	@Parameters({"browser"})
//	public void TestSetup(String browser)
//	{
//		
//		if(runmode.equalsIgnoreCase("local"))
//		{
//			if(browser.equalsIgnoreCase("chrome"))
//			{
//				WebDriverManager.chromedriver().setup();
//				WebDriver driver = new ChromeDriver();
//			}
//			if(browser.equalsIgnoreCase("firefox"))
//			{
//				WebDriverManager.firefoxdriver().setup();
//				WebDriver driver = new FirefoxDriver();
//			}
//		}
//		else if (runmode.equalsIgnoreCase("remote"))
//		{
//			String nodeURL = "http://localhost:4444/wd/hub";  // will be passed from config.properties file
//		    DesiredCapabilities caps = new DesiredCapabilities();
//		    caps.setBrowserName(browser);
//		    System.out.println("aaaa");
//		    WebDriver driver = new RemoteWebDriver(new URL(nodeURL), caps);
//			System.out.println("ccc");
//		}
//
//	    driver.manage().window().maximize();
//		// Navigate to the demoqa website
//		driver.get(testURL); //testURL from config.properties file 	
//	}
//	
//	@AfterTest
//	public void TestSetup(String browser)
//	{
//		driver.quit();
//	}
//}
