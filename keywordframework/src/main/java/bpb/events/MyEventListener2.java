package bpb.events;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class MyEventListener2 extends AbstractWebDriverEventListener {
	Logger log = Logger.getLogger(MyEventListener2.class);
	public MyEventListener2() {
		super();
		PropertyConfigurator.configure("log4j.properties");;
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		//System.out.println("MyEventListener2 Navigating to "+url+" for URL: "+driver.getCurrentUrl());
		log.info("MyEventListener2 Navigating to "+url);
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		//System.out.println("MyEventListener2 Navigated to "+url+" for URL: "+driver.getCurrentUrl());
		log.info("MyEventListener2 Navigated to "+url+" for URL: "+driver.getCurrentUrl());
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		//System.out.println("MyEventListener2 Finding element by XPATH"+by.toString());
		log.info("MyEventListener2 Finding element by XPATH"+by.toString());
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		//System.out.println("MyEventListener2 Found "+element.toString());
		log.info("MyEventListener2 Found "+element.toString());
		
	}
	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		//System.out.println("MyEventListener2 Before clicking "+element.toString());
		log.info("MyEventListener2 Before clicking "+element.toString());
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		//System.out.println("MyEventListener2 After clicking "+element.toString());
		log.info("MyEventListener2 After clicking "+element.toString());
	}
	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
		//System.out.println("MyEventListener2 Before fetching text "+element.toString());
		log.info("MyEventListener2 Before fetching text "+element.toString());
		
	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		//System.out.println("MyEventListener2 After fetching text "+text);
		log.info("MyEventListener2 After fetching text "+text);
		
	}


}
