package com.weborders.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.weborders.common.Driver;
import com.weborders.common.TestBase;
import com.weborders.pages.DashboardPage;
import com.weborders.pages.LoginPage;
import com.weborders.reporters.ExtentTestReporter;

public class LoginTests extends TestBase {
	
	@Test(groups = { "login", "regression" })
	public void verifyUserCanLoginWithCorrectCredentials() {
        LoginPage loginPage = new LoginPage();
        ExtentTestReporter.logInfo("Logging with credentials: Tester/test.");
        loginPage.login("Tester", "test");
        ExtentTestReporter.logInfo("Waiting for Dashboard page to load.");
		new DashboardPage().waitForPageToLoad();
		Assert.assertEquals(Driver.getDriver().getCurrentUrl()
				, "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/default.aspx");
	}
	
	@Test(groups = { "login", "regression" })
	public void verifyUserWithIncorrectPasswordIsShownErrorMessage() {
        LoginPage loginPage = new LoginPage();
        ExtentTestReporter.logInfo("Logging with invalid credentials: Tester/fdksdflkdsjflk.");
        loginPage.login("Tester", "fdksdflkdsjflk");
        ExtentTestReporter.logInfo("Getting error message from login page.");
		String errorMessageText = loginPage.getErrorMessageText();
		Assert.assertEquals(errorMessageText, "Invalid Login or Password.");
	}
	
}