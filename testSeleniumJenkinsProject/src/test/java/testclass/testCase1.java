package testclass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Reporter;
import org.testng.annotations.Test;
import basicsetup.BaseClass1;
public class testCase1 extends BaseClass1 {

	@Test
	public void test1() {
		Reporter.log("Executing Testcase testcase1..");
		driver.findElement(By.id("input")).sendKeys("Sriram");
		driver.findElement(By.id("input")).sendKeys(Keys.ENTER);
	}
}
