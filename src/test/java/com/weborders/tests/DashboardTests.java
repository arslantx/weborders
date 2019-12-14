package com.weborders.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.weborders.common.TestBase;
import com.weborders.pages.DashboardPage;
import com.weborders.pages.LoginPage;

public class DashboardTests extends TestBase {
	@Test(groups = { "dashboard", "regression" })
	public void verifyUsersNameOnDashboardMatches() {
		new LoginPage().login("Tester", "test");
		String usersNameOnDashboard = new DashboardPage().getUsersNameFromDashboard();
		Assert.assertTrue(usersNameOnDashboard.contains("Tester"));
	}
	
	@Test(groups = { "dashboard", "regression" })
	public void verifyUserCanLogout() {
		LoginPage loginPage = new LoginPage();
		loginPage.login("Tester", "test");
		new DashboardPage().logout();
		boolean isLoginButtonDisplayed = loginPage.isLoginButtonDisplayed();
		Assert.assertTrue(isLoginButtonDisplayed);
	}
	
	@Test(groups = { "dashboard", "regression" })
	public void verifyDeleteRowFunctionality() throws InterruptedException {
		new LoginPage().login("Tester", "test");
		DashboardPage dashboardPage = new DashboardPage();
		int initialNumberOfRows = dashboardPage.getNumberOfRowsOnTable();
		dashboardPage.deleteFirstRow();
		int finalNumberOfRows = dashboardPage.getNumberOfRowsOnTable();
		Assert.assertEquals(finalNumberOfRows, initialNumberOfRows - 1);
	}
}