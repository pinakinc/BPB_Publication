package bpb.WaitLogic;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bpb.Singleton.SingletonDriver;

public class WaitClass {
	WebDriverWait explicitWait = null;

	// constructor
	public WaitClass() {
		explicitWait = new WebDriverWait(SingletonDriver.getInstance()
				.getDriver(), 60);
	}

	public void switchToFrame(String xpath) {
		explicitWait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(SingletonDriver.getInstance()
						.getDriver().findElement(By.xpath(xpath))));

	}

	public void waitForClickable(String xpath) {
		explicitWait.until(ExpectedConditions
				.elementToBeClickable(SingletonDriver.getInstance().getDriver()
						.findElement(By.xpath(xpath))));

	}

	public void waitForPageToLoad(String xpath) {
		explicitWait.until(ExpectedConditions
				.elementToBeClickable(SingletonDriver.getInstance().getDriver()
						.findElement(By.xpath(xpath))));

	}
	
	public void waitImplicitely() {
		SingletonDriver.getInstance().getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	public void waitForVisibility(String xpath) {
		explicitWait.until(ExpectedConditions
				.visibilityOf(SingletonDriver.getInstance().getDriver()
						.findElement(By.xpath(xpath))));

	}

}
