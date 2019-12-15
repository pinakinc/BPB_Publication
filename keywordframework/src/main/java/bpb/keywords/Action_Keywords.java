package bpb.keywords;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import bpb.Singleton.SingletonDriver;
import bpb.events.MyEventListener;
import bpb.events.MyEventListener2;

public class Action_Keywords {

    
	WebDriver driver = null;
	MyEventListener2 list = new MyEventListener2();

	public Action_Keywords() {
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void openBrowser(String browser) { try { 
	 SingletonDriver.getInstance().setDriver("chrome", "windows", "windows"); 
	 SingletonDriver.getInstance().getDriver(); 
	 SessionId session = ((RemoteWebDriver)SingletonDriver.getInstance().getDriver()).getSessionId();
	 System.out.println("Session is "+session);
	 SingletonDriver.getInstance().getDriver().manage().window().maximize(); } catch (Exception e) { // TODO
	 e.printStackTrace(); }
	  
	  }
	 
	public void clickElement(String xpath) {
		
		SingletonDriver.getInstance().getDriver().findElement(By.xpath(xpath)).click();
	}

	public void enterText(String xpath, String text) {
		
		SingletonDriver.getInstance().getDriver().findElement(By.xpath(xpath)).sendKeys(text);
	}

	public void handleExplicitWait(long time) {
		WebDriverWait wdWait = new WebDriverWait(SingletonDriver.getInstance().getDriver(), time);

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
		SingletonDriver.getInstance().getDriver().get(URL);
	}

	public void closeBrowser() {
		SingletonDriver.getInstance().getDriver().close();
		SingletonDriver.getInstance().getDriver().quit();
	}

}
