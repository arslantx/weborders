package com.weborders.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.weborders.common.TestBase;
import com.weborders.pages.DashboardPage;
import com.weborders.pages.LoginPage;
import com.weborders.reporters.ExtentTestReporter;

public class DashboardTests extends TestBase {
	@Test(groups = { "dashboard", "regression" })
	public void verifyUsersNameOnDashboardMatches() {
        ExtentTestReporter.logInfo("Logging with credentials: Tester/test.");
        new LoginPage().login("Tester", "test");
        ExtentTestReporter.logInfo("Getting user's name displayed on dashboard.");
		String usersNameOnDashboard = new DashboardPage().getUsersNameFromDashboard();
		Assert.assertTrue(usersNameOnDashboard.contains("Tester"));
	}
	
	@Test(groups = { "dashboard", "regression" })
	public void verifyUserCanLogout() {
        LoginPage loginPage = new LoginPage();
        ExtentTestReporter.logInfo("Logging with credentials: Tester/test.");
        loginPage.login("Tester", "test");
        ExtentTestReporter.logInfo("Logging out of user's account.");
		new DashboardPage().logout();
		boolean isLoginButtonDisplayed = loginPage.isLoginButtonDisplayed();
		Assert.assertTrue(isLoginButtonDisplayed);
	}
	
	@Test(groups = { "dashboard", "regression" })
	public void verifyDeleteRowFunctionality() throws InterruptedException {
        ExtentTestReporter.logInfo("Logging with credentials: Tester/test.");
		new LoginPage().login("Tester", "test");
		DashboardPage dashboardPage = new DashboardPage();
        int initialNumberOfRows = dashboardPage.getNumberOfRowsOnTable();
        ExtentTestReporter.logInfo("Deleting first row on dashboard.");
		dashboardPage.deleteFirstRow();
		int finalNumberOfRows = dashboardPage.getNumberOfRowsOnTable();
		Assert.assertEquals(finalNumberOfRows, initialNumberOfRows - 1);
	}
}