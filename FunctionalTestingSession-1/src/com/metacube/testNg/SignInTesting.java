package com.metacube.testNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Test class to perform automatic testing in Firefox
 * 
 * @author Udit Saxena
 *
 */
public class SignInTesting {
	private WebDriver driver;

	@BeforeTest
	public void setUp() throws InterruptedException {
		driver = new FirefoxDriver();
	}

	@Test
	public void signinTest() {
		driver.get("http://automationpractice.com/");
		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email")).sendKeys("abc@xyz.com");
		driver.findElement(By.id("passwd")).sendKeys("testing123");
		driver.findElement(By.id("SubmitLogin")).click();
	}

	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(10000);
		driver.quit();
	}
}