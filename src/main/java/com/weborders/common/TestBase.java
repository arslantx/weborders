package com.weborders.common;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase extends Base {
	
	@BeforeSuite (alwaysRun = true)
	public void beforeSuite() {
		Driver.setUpDriver();
	}
	
	@BeforeMethod (alwaysRun = true)
	public void beforeMethod() {
		Driver.getDriver();
	}
	
	@AfterMethod (alwaysRun = true)
	public void afterMethod() {
		Driver.closeDriver();
	}
	
	@AfterSuite (alwaysRun = true)
	public void afterSuite() {
		
	}
}
