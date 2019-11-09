package keywordframework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import bpb.Singleton.SingletonDriver;
import bpb.WaitLogic.WaitClass;
import bpb.events.MyEventListener;
import bpb.events.MyEventListener2;

public class ListenerTest {

	public static void main(String[] args) {
		
	//	System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		try {
			SingletonDriver.getInstance().setDriver("chrome","Windows","Windows");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebDriver driver = SingletonDriver.getInstance().getDriver();
		WaitClass wdWait = new WaitClass();
		EventFiringWebDriver event = new EventFiringWebDriver(driver);
		MyEventListener listen = new MyEventListener();
		MyEventListener2 listen2 = new MyEventListener2();
//		event.register(listen);
		event.register(listen2);
		event.get("http://www.freecrm.com");
		event.findElement(By.xpath("//*[@href='https://ui.freecrm.com']")).click();
		wdWait.waitForClickable("//div[text()='Login']");
		event.findElement(By.xpath("//div[text()='Login']")).getText();
//		event.unregister(listen);
		event.unregister(listen2);

	}

}
