package com.weborders.pages;

import org.openqa.selenium.By;

import com.weborders.common.Driver;
import com.weborders.common.PageBase;

public class DashboardPage extends PageBase {
	
	private By usersNameLocator = By.cssSelector(".login_info");
	private By logoutLinkLocator = By.linkText("Logout");
	private By firstCheckboxLocator = By.id("ctl00_MainContent_orderGrid_ctl02_OrderSelector");
	private By deleteButtonLocator = By.id("ctl00_MainContent_btnDelete");
	private By tableRowLocator = By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td/..");
	
	public String getUsersNameFromDashboard() {
		String text = Driver.getDriver().findElement(usersNameLocator).getText();
		return text;
	}
	
	public void logout() {
		Driver.getDriver().findElement(logoutLinkLocator).click();
	}
	
	public void checkFirstCheckbox() {
		seleniumUtil.click(firstCheckboxLocator);
	}
	
	public void clickDeleteButton() {
		seleniumUtil.click(deleteButtonLocator);
	}
	
	public int getNumberOfRowsOnTable() {
		return seleniumUtil.findElements(tableRowLocator).size();
	}
	

	@Override
	public void waitForPageToLoad() {
	}
}
