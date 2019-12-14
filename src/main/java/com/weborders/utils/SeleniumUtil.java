package com.weborders.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.weborders.common.Driver;

public class SeleniumUtil {
	
	private final long SHORT_EXPLICIT_WAIT_TIME = 5;
	
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
	
	public List<WebElement> findElements(By locator) {
		return Driver.getDriver().findElements(locator);
	}
	
	public void waitForVisibility(By locator) {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), SHORT_EXPLICIT_WAIT_TIME);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}
