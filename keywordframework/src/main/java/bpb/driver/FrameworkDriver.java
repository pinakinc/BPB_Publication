package bpb.driver;

import java.sql.ResultSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import bpb.Singleton.SingletonDriver;
import bpb.WaitLogic.WaitClass;
import bpb.dblogic.DBExtract2;
import bpb.events.MyEventListener;
import bpb.events.MyEventListener2;
import bpb.keywords.ActionKeywords;

public class FrameworkDriver {

	public static void main(String[] args) {

		ActionKeywords act = new ActionKeywords();
		ResultSet resultSet = null;
		try {
		//	SingletonDriver.getInstance().setDriver("chrome", "Windows","Windows");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//SingletonDriver.getInstance().getDriver().get("http://www.freecrm.com");
		// act.openBrowser("chrome");
//		WebDriver driver = SingletonDriver
//		 .getInstance().getDriver();
//		EventFiringWebDriver event = new EventFiringWebDriver(driver);
	//	MyEventListener2 myListener2 = new MyEventListener2();
//		 event.register(myListener2);
		 act.navigateURL("http://www.freecrm.com");
		WaitClass wdWait = new WaitClass();
		wdWait.waitForClickable("//*[@href='https://ui.freecrm.com']");
//		event
//		.findElement(By.xpath("//*[@href='https://ui.freecrm.com']")).click();
		//WebDriverWait wdWait = new
		// WebDriverWait(SingletonDriver.getInstance()
		// .getDriver(), 30);
//		act.navigateURL("http://www.freecrm.com");
		// By by = null;
		WebElement elem = SingletonDriver.getInstance().getDriver()
				.findElement(By.xpath("//*[@href='https://ui.freecrm.com']"));
		act.clickElement("//*[@href='https://ui.freecrm.com']");
		//act.clickElement(by,"//*[@href='https://ui.freecrm.com']");
	}
}
