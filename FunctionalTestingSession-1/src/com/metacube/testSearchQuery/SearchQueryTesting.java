package com.metacube.testSearchQuery;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * The Class SearchQueryTesting.
 * 
 * @author Udit Saxena
 */
public class SearchQueryTesting {

	/**
	 * The main method send the data to search bar and search by click on it
	 * then close the page after 6 second.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		try {
			WebDriver driver = new InternetExplorerDriver();
			driver.get("http://automationpractice.com/index.php");
			driver.findElement(By.id("search_query_top")).click();
			driver.findElement(By.id("search_query_top")).sendKeys("Faded");
			driver.findElement(By.name("submit_search")).click();
			Thread.sleep(6000);
			driver.quit();
		} catch (InterruptedException e) {
			System.out.println("Error: " + e);
		}
	}
}