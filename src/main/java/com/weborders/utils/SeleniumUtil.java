package com.weborders.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.weborders.common.Driver;

public class SeleniumUtil {
	
	public WebElement findElement(By locator) {
		return Driver.getDriver().findElement(locator);
	}
	
	public void sendKeys(By locator, String text) {
		clear(locator);
		findElement(locator).sendKeys(text);
	}
	
	public void clear(By locator) {
		findElement(locator).clear();
	}
	
	public void click(By locator) {
		findElement(locator).click();
	}
	
	public String getText(By locator) {
		return findElement(locator).getText();
	}
	
	public boolean isDisplayed(By locator) {
		return findElement(locator).isDisplayed();
	}
}
