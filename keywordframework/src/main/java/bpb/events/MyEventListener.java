package bpb.events;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class MyEventListener implements WebDriverEventListener{

	public void beforeAlertAccept(WebDriver driver) {
		System.out.println("Before Alert Accept: "+driver.getCurrentUrl());
		
	}

	public void afterAlertAccept(WebDriver driver) {
		System.out.println("After Alert Accept: "+driver.getCurrentUrl());
		
	}

	public void afterAlertDismiss(WebDriver driver) {
		System.out.println("After Alert Dismiss: "+driver.getCurrentUrl());
		
	}

	public void beforeAlertDismiss(WebDriver driver) {
		System.out.println("Before Alert Dismiss: "+driver.getCurrentUrl());
		
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigating to "+url+" for URL: "+driver.getCurrentUrl());
		
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigated to "+url+" for URL: "+driver.getCurrentUrl());
		
	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating back from "+driver.getCurrentUrl());
		
	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated back from "+driver.getCurrentUrl());
		
	}

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Navigating forward from "+driver.getCurrentUrl());
		
	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated foward from "+driver.getCurrentUrl());
		
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		System.out.println("Before Navigate Refresh "+driver.getCurrentUrl());
		
	}

	public void afterNavigateRefresh(WebDriver driver) {
		System.out.println("After Navigate Refresh "+driver.getCurrentUrl());
		
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Finding element by XPATH"+by.toString());
		
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found "+element.toString());
		
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Before clicking "+element.toString());
		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("After clicking "+element.toString());
		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("Before changing value of "+element.toString());
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("After changing value of "+element.toString());
		
	}

	public void beforeScript(String script, WebDriver driver) {
		System.out.println("Before script "+script);
		
	}

	public void afterScript(String script, WebDriver driver) {
		System.out.println("After script "+script);
		
	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println("Before switching "+windowName);
		
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println("After switching "+windowName);
		
	}

	public void onException(Throwable throwable, WebDriver driver) {
		System.out.println("Exception thrown "+throwable.getMessage());
		
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		System.out.println("Before taking screenshot "+target.toString());
		
	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		System.out.println("After taking screenshot "+target.toString());
		
	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		System.out.println("Before fetching text "+element.toString());
		
	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
		System.out.println("After fetching text "+element.toString());
		
	}

}
