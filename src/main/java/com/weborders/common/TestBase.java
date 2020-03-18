package com.weborders.common;

import java.lang.reflect.Method;
import com.weborders.reporters.ExtentTestReporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase extends Base {
	
	@BeforeSuite (alwaysRun = true)
	public void beforeSuite() {
        ExtentTestReporter.createReport();
		Driver.setUpDriver();
	}
	
	@BeforeMethod (alwaysRun = true)
	public void beforeMethod(Method method) {
        ExtentTestReporter.createTest(method.getName());
        ExtentTestReporter.logInfo("Starting test: " + method.getName());
		Driver.getDriver();
	}
	
	@AfterMethod (alwaysRun = true)
	public void afterMethod() {
        Driver.closeDriver();
        ExtentTestReporter.endTest();
	}
	
	@AfterSuite (alwaysRun = true)
	public void afterSuite() {
        
	}
}
