package com.test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.pages.BaseClass1;

public class TestCase1 extends BaseClass1{
	@Test
	public void searchNow() {
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		System.out.println("Entered value successfully..and searched");
	}
}
