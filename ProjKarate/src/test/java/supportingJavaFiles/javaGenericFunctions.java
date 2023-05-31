package supportingJavaFiles;

//import org.openqa.selenium.WebDriver;
import com.intuit.karate.driver.chrome.Chrome;
import com.intuit.karate.driver.firefox.GeckoWebDriver;

public class javaGenericFunctions {
	//public static WebDriver driver;
	public static String fnPopUpGetText(Chrome driver) throws InterruptedException
	//public static String fnPopUpGetText()
	{
		//driver.screenshot();
		//return "srinivasan";
		//driver.focus("//button[text()='Try it']");
		//return  driver.exists("//button[text()='Try it']");//
		//driver.click("//button[text()='Try it']");
		//Thread.sleep(300);
		String strresult;
		strresult = driver.getDialogText().toString();
		return strresult;//.attribute("//button[text()='Try it']", "type").toString();//
		//return driver.getTitle().toString();
		//return driver.getUrl().toString();
	}
	
	public static String fnGetTitle(GeckoWebDriver driver) throws InterruptedException
	//public static String fnGetTitle(Chrome driver) throws InterruptedException
	//public static String fnPopUpGetText()
	{
		//driver.screenshot();
		//return "srinivasan";
		//driver.focus("//button[text()='Try it']");
		//return  driver.exists("//button[text()='Try it']");//
		//driver.click("//button[text()='Try it']");
		//Thread.sleep(300);
		String strresult;
		strresult = driver.getTitle().toString();
		return strresult;//.attribute("//button[text()='Try it']", "type").toString();//
		//return driver.getTitle().toString();
		//return driver.getUrl().toString();
	}
}
