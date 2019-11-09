package bpb.WaitLogic;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bpb.Singleton.SingletonDriver;

public class WaitClass {
	WebDriverWait explicitWait = null;

	// constructor
	public WaitClass() {
		explicitWait = new WebDriverWait(SingletonDriver.getInstance()
				.getDriver(), 30);
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

}
