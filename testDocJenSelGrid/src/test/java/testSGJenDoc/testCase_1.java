package testSGJenDoc;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

//import testSGJenDoc.BaseClass1;

public class testCase_1 extends BaseClass1{
	@Test(priority=1)
	public void Login() throws IOException {
		System.out.println("inside test 1");
		logger.startTest("Enter into login page of saucedemo website..");
		System.out.println("inside test 2");
		logger.logInfo("Executing searchNow...");
		System.out.println("inside test 3");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		System.out.println("inside test 4");
		logger.logInfo("Entering username");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		logger.logInfo("Entering password");
		driver.findElement(By.id("login-button")).click();
		logger.logInfo("clicking on login button");
		logger.logPass("Test passed");
		logger.endTest();
		System.out.println("Entered value successfully..and searched");	
		
	}
	@Test(priority=2)
	public void searchNow() throws IOException {
		logger.startTest("Enter into home page of saucedemo website..");
		try {
			throw new Exception();
		}
		catch(Exception e) {
			logger.logFail("Test searchNow failed..");	
		}
		logger.endTest();
	}
}
