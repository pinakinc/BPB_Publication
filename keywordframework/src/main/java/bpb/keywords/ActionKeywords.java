package bpb.keywords;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import bpb.Singleton.SingletonDriver;
import bpb.events.MyEventListener;
import bpb.events.MyEventListener2;

public class ActionKeywords {

    
	EventFiringWebDriver event = null;
	WebDriver driver = null;
	MyEventListener2 list = new MyEventListener2();

	public ActionKeywords() {
		try {
			SingletonDriver.getInstance().setDriver("chrome", "windows", "windows");
			driver = SingletonDriver.getInstance().getDriver();
			event = new EventFiringWebDriver(driver);
			event.register(list);
			event.manage().window().maximize();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * public void openBrowser(String browser) { try { //
	 * driver.setDriver("chrome", "windows", "windows"); // event =
	 * (EventFiringWebDriver) driver.getDriver(); // event.register(list); //
	 * event.manage().window().maximize(); } catch (Exception e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 * 
	 * }
	 */
	public void clickElement(String xpath) {
		
		event.findElement(By.xpath(xpath)).click();
	}

	public void handleExplicitWait(long time) {
		WebDriverWait wdWait = new WebDriverWait(event, time);

	}

	public void handleAlert() {
		// driver.getDriver().switchTo().d
		Alert alert = SingletonDriver.getInstance().getDriver().switchTo().alert();
		alert.accept();
		alert.dismiss();
		String alertText = alert.getText();
		alert.sendKeys("Hi");
	}

	public void navigateURL(String URL) {
		event.get(URL);
	}
}
