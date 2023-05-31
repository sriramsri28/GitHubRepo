package com.test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.pages.BaseClass1;

public class TestCase1 extends BaseClass1{
	@Test(priority=1)
	public void Login() throws IOException {
	
		logger.startTest("Enter into login page of saucedemo website..");
		logger.logInfo("Executing searchNow...");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		logger.logInfo("Entering username");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		logger.logInfo("Entering password");
		driver.findElement(By.id("login-button")).click();
		logger.logInfo("clicking on login button");
		logger.logPass("Test passed");
		logger.endTest();
		System.out.println("Entered value successfully..and searched..");	
		
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
