package bpb.Singleton;

import java.net.URL;
import java.util.Map;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

@SuppressWarnings("varargs")
public class SingletonDriver {
	// local variables
	private static SingletonDriver instance = null;
	private String browserHandle = null;
	private static final int IMPLICIT_TIMEOUT = 0;
	public static final String USERNAME = "pinakinchaubal1";
	public static final String AUTOMATE_KEY = "2igoYXZ1GCa3Yc7JyWFp";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";

	private ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	private ThreadLocal<String> sessionId = new ThreadLocal<String>();
	private ThreadLocal<String> sessionBrowser = new ThreadLocal<String>();
	private ThreadLocal<String> sessionPlatform = new ThreadLocal<String>();
	private ThreadLocal<String> sessionVersion = new ThreadLocal<String>();
	private String getEnv = null;
	public WebDriver getDriver() {
		return webDriver.get();
	}

	@SafeVarargs
	public final void setDriver(String browser, String environment,
			String platform, Map<String, Object>... optPref) throws Exception {
		DesiredCapabilities caps = null;
		FirefoxOptions firefoxopt = null;
		ChromeOptions chromeopt = null;
		InternetExplorerOptions ieopt = null;
		SafariOptions safariopt = null;
		EdgeOptions edgeopt = null;
		String localHub = "http://127.0.0.1:4723/wd/hub";
		String getPlatform = null;
		String ffVersion = "55.0";
		String chromeVersion = "79.0";
		String remoteHubURL = "http://192.168.0.73:2222/wd/hub";
		switch (browser) {
		case "firefox":
			caps = DesiredCapabilities.firefox();
			if (environment.equalsIgnoreCase("local")) {
			firefoxopt = new FirefoxOptions();
			webDriver.set(new FirefoxDriver(firefoxopt));
			break;
			} else if (environment.equalsIgnoreCase("remote")) {
				   

				        caps.setCapability("browserName", browser);
				        caps.setCapability("version", ffVersion);
				        caps.setCapability("platform", platform);
				        caps.setCapability("applicationName",
				                            platform.toUpperCase() + "-" +
				                            browser.toUpperCase());

				        webDriver.set(new RemoteWebDriver(
				                      new URL(remoteHubURL), caps));

				        ((RemoteWebDriver) webDriver.get()).setFileDetector(
				        new LocalFileDetector());
				        break;
			} else {
		        caps.setCapability("browserName", System.getProperty("browser",browser));
		        caps.setCapability("version", ffVersion);
		        caps.setCapability("platform", platform);
		        caps.setCapability("applicationName",
		                            platform.toUpperCase() + "-" +
		                            browser.toUpperCase());
		        
		        webDriver.set(new RemoteWebDriver(
		                      new URL(URL), caps));

		        ((RemoteWebDriver) webDriver.get()).setFileDetector(
		        new LocalFileDetector());
		        break;
			}
		case "chrome":
			caps = DesiredCapabilities.chrome();
			if (environment.equalsIgnoreCase("local")) {
			chromeopt = new ChromeOptions();
			webDriver.set(new ChromeDriver(chromeopt));
			break;
			} else {
		        caps.setCapability("browserName", browser);
		        caps.setCapability("version", chromeVersion);
		        caps.setCapability("platform", Platform.WIN10);
		        caps.setCapability("applicationName",
		                            platform.toUpperCase() + "-" +
		                            browser.toUpperCase());

		        webDriver.set(new RemoteWebDriver(
		                      new URL(remoteHubURL), caps));

		        ((RemoteWebDriver) webDriver.get()).setFileDetector(
		        new LocalFileDetector());

			}
		case "internet explorer":
			ieopt = new InternetExplorerOptions();
			webDriver.set(new InternetExplorerDriver(ieopt));

			break;
		case "safari":
			safariopt = new SafariOptions();
			webDriver.set(new SafariDriver(safariopt));

			break;
		case "microsoftedge":
			edgeopt = new EdgeOptions();
			webDriver.set(new EdgeDriver(edgeopt));

			break;
		}
	}

	// constructor
	private SingletonDriver() {
	}

	/**
	 * getInstance method to return active driver instance
	 *
	 * @return CreateDriver
	 */
	public static SingletonDriver getInstance() {
		if (instance == null) {
			instance = new SingletonDriver();
		}
		return instance;
	}
}
