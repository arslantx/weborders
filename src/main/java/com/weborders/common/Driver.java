package com.weborders.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	
	public static WebDriver driver;
	
	public static WebDriver getDriver() {
		if (driver == null) {
			setUpDriver();
		}
		return driver;
	}
	
	public static void setUpDriver() {
		if (driver == null) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
	}
	
	public static void closeDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
