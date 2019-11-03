package com.weborders.pages;

import org.openqa.selenium.By;

import com.weborders.common.Driver;
import com.weborders.common.PageBase;

public class DashboardPage extends PageBase {
	
	private By usersNameLocator = By.cssSelector(".login_info");
	private By logoutLinkLocator = By.linkText("Logout");
	
	public String getUsersNameFromDashboard() {
		String text = Driver.getDriver().findElement(usersNameLocator).getText();
		return text;
	}
	
	public void logout() {
		Driver.getDriver().findElement(logoutLinkLocator).click();
	}

	@Override
	public void waitForPageToLoad() {
		
		
	}
}
