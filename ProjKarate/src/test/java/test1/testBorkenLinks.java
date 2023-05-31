package test1;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class testBorkenLinks {
	public static int invalidLink;
	String currentLink;
	public static String temp;
	public static WebDriver driver = new FirefoxDriver();
	//public static WebDriver driver = new EdgeDriver();
	//public static WebDriver driver = new ChromeDriver();
	
	//@BeforeMethod
	public static void main(String[] args) 
	//public static void stepup() throws Exception
	{
		System.setProperty("webdriver.gecko.driver", "F:\\Selenium\\BrowserDrivers\\geckodriver-v0.32.0-win64\\geckodriver.exe");
		//System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\BrowserDrivers\\chromedriver_win32\\chromedriver.exe");
		//System.setProperty("webdriver.edge.driver", "F:\\Selenium\\BrowserDrivers\\edgedriver_win64\\msedgedriver.exe");
		//* configure driver = { type: 'msedgedriver', executable: 'F:\\Selenium\\BrowserDrivers\\edgedriver_win64\\msedgedriver.exe', webDriverSession: { capabilities: { browserName: 'edge' } } }
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.get("http://www.odishaestore.com/signup?_RETURN=http%3A%2F%2Fwww.odishaestore.com%2Fcheckout");
    	driver.get("http://search.maven.org/#search|ga|1|a");
        
        driver.manage().window().maximize();
        try {
			testBrokenLinks();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//@Test
	public static void testBrokenLinks() throws Exception {
		FileOutputStream fout = new FileOutputStream ("C://broken_links.txt", true);
		invalidLink=0;
		List<WebElement> collinks =  driver.findElements(By.tagName("a"));
		int linkcount = collinks.size();
		new PrintStream(fout).println("links count : " + linkcount);
		new PrintStream(fout).println("--------------------------------------------");

		for(WebElement cl : collinks){
			int statusCode=0;				
	    	temp=cl.getAttribute("href");//.toString()have to check for this as well to String conversoin
	    	//temp = selenium.getEval(currentLink + ".href");
	   
	    	statusCode=getResponseCode(temp);
	    	if (statusCode==404)
	    	{
	    		new PrintStream(fout).println("ERROR --> "+"link name : "+cl.getText()+" : "+" --> link URL : " + cl.getAttribute("href") + " : statusCode : "+ statusCode);
	    		invalidLink++; 
	    	}
	    	else
	    		new PrintStream(fout).println("link name : "+cl.getText()+" : "+" --> link URL : " + cl.getAttribute("href") + " : statusCode : "+ statusCode);
		}
		new PrintStream(fout).println("Total broken Links = " + invalidLink);
		new PrintStream(fout).println(" ");
		fout.close();		 
	}
	
	public static int getResponseCode(String urlString) throws MalformedURLException, IOException {
	   URL u = new URL(urlString); 
	   HttpURLConnection huc =  (HttpURLConnection)  u.openConnection(); 
	   huc.setRequestMethod("GET"); 
	   huc.connect(); 
	   return huc.getResponseCode();
	}
	
	//@AfterTest
	public void tearDown()
	{
		System.out.println("inside tear down");
		driver.close();	
	}
	   
}