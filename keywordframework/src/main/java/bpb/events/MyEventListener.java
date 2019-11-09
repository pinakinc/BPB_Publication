package bpb.events;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class MyEventListener implements WebDriverEventListener{

	@Override
	public void beforeAlertAccept(WebDriver driver) {
		System.out.println("Before Alert Accept: "+driver.getCurrentUrl());
		
	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		System.out.println("After Alert Accept: "+driver.getCurrentUrl());
		
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		System.out.println("After Alert Dismiss: "+driver.getCurrentUrl());
		
	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		System.out.println("Before Alert Dismiss: "+driver.getCurrentUrl());
		
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigating to "+url+" for URL: "+driver.getCurrentUrl());
		
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigated to "+url+" for URL: "+driver.getCurrentUrl());
		
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating back from "+driver.getCurrentUrl());
		
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated back from "+driver.getCurrentUrl());
		
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Navigating forward from "+driver.getCurrentUrl());
		
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated foward from "+driver.getCurrentUrl());
		
	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		System.out.println("Before Navigate Refresh "+driver.getCurrentUrl());
		
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		System.out.println("After Navigate Refresh "+driver.getCurrentUrl());
		
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Finding element by XPATH"+by.toString());
		
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found "+element.toString());
		
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Before clicking "+element.toString());
		
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("After clicking "+element.toString());
		
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("Before changing value of "+element.toString());
		
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("After changing value of "+element.toString());
		
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		System.out.println("Before script "+script);
		
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		System.out.println("After script "+script);
		
	}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println("Before switching "+windowName);
		
	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println("After switching "+windowName);
		
	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		System.out.println("Exception thrown "+throwable.getMessage());
		
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		System.out.println("Before taking screenshot "+target.toString());
		
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		System.out.println("After taking screenshot "+target.toString());
		
	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
		System.out.println("Before fetching text "+element.toString());
		
	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		System.out.println("After fetching text "+element.toString());
		
	}

}
