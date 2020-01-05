package keywordframework;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import bpb.Singleton.SingletonDriver;
import bpb.WaitLogic.WaitClass;
import bpb.assertions.Assertions;
import bpb.dataprovider.KeywordProvider;
import bpb.dblogic.DBExtract3;
import bpb.keywords.Action_Keywords;



public class TestClass2 extends BaseClass{
	
	Action_Keywords actKeywords = new Action_Keywords();
	Assertions assertions = new Assertions();
	WaitClass wdWait = null;
	ExtentReports report = null;
	ExtentHtmlReporter reporter=null;
	ExtentTest test = null;
//	String btnLogin = "//a[@href='https://ui.freecrm.com']";
//	String uNameXPath = "//input[@name='email']";
//	String passwordXPath = "//input[@name='password']";
//	String btnSubmit = "//div[text()='Login']";
//	String logoutParent = "//div[@class='ui buttons']/div";
//	String btnLogout ="//span[text()='Log Out']";
//	String callQueue = "//span[text()='Call Queue']";
	String contactHeader = "(//div[@class='header'])[1]";
	
	public TestClass2() {
		System.out.println("Constructor called");
	}
	
	@BeforeTest(groups= {"GroupA","GroupB","GroupC"})
	@Parameters({"browser","environment","platform"})
	public void setUp(String browser,String environment,String platform) {
		actKeywords.openBrowser(browser,environment,platform);
		wdWait = new WaitClass();
		wdWait.waitImplicitely();
		reporter = new ExtentHtmlReporter("report.html");
		report = new ExtentReports();
		report.attachReporter(reporter);
		//SingletonDriver.getInstance().getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	@Test(groups= "GroupA")
	@Parameters({ "param1" })
	public void test1(String param1) {
		System.out.println("Before starting test1");
		test = report.createTest("test1","First Test");
//		actKeywords.navigateURL("http://www.freecrm.com");
//		actKeywords.clickElement(btnLogin);
//		actKeywords.enterText(uNameXPath, "chaubalpinakin@gmail.com");
//		actKeywords.enterText(passwordXPath, "Pc9121975!");
//		actKeywords.clickElement(btnSubmit);
		ResultSet resultSet = null;
		
		try {
		CachedRowSet crs = DBExtract3.extractRecords("GroupA");	
		ResultSetMetaData rsmd = crs.getMetaData();
		//System.out.println("Framework Driver Logic started");
		crs.next();
		while (!crs.isAfterLast()) {
			String testcaseid = crs.getString("TestCaseID");
			String teststepid = crs.getString("TestStepID");
		
			String actionKey = crs.getString("ActionKey");
			System.out.println("ActionKey"+actionKey);
			String xpath = crs.getString("XPath");
			System.out.println("XPath"+xpath);
			String datakey = crs.getString("DataKey");
			System.out.println("DataKey"+datakey);
			String verifyText = crs.getString("Expected");
			System.out.println("DataKey"+verifyText);

			switch(actionKey) {
				case "navigate":
					actKeywords.navigateURL("http://www.freecrm.com");
					break;
				case "click":
					actKeywords.clickElement(xpath);
					break;
				case "entertext":
					actKeywords.enterText(xpath, datakey);
					break;
				case "verifyText":
					assertions.assertEqualsSA(SingletonDriver.getInstance().getDriver().findElement(By.xpath(contactHeader)).getText(), verifyText);
					test.log(Status.PASS, "The test has passed");
					break;
				

			}
			
			
		//	for (int j1 = 1; j1 <= rsmd.getColumnCount(); j1++) {
		//		System.out.println("Column in FrameworkDriver: " + rsmd.getColumnName(j1));
		//		System.out.println("Value in FrameworkDriver: "
		//				+ crs.getString(rsmd.getColumnName(j1)));
				
		//	}
			crs.next();
		}
	} catch (SQLException e) {
			e.printStackTrace();
	}
		System.out.println("After completing test1");
	}

		
//		System.out.println("After completing test1");
		//try {
		//	Thread.sleep(3000);
		//} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		//wdWait.waitForClickable(logoutParent);
		//wdWait.waitForClickable(btnLogout);
		
//	}

	@Test(groups= "GroupB")
	@Parameters({ "param2" })
	public void test2(String param2) {
		System.out.println("Before starting test2");
//		actKeywords.navigateURL("http://www.freecrm.com");
//		actKeywords.clickElement(btnLogin);
//		actKeywords.enterText(uNameXPath, "chaubalpinakin@gmail.com");
//		actKeywords.enterText(passwordXPath, "Pc9121975!");
//		actKeywords.clickElement(btnSubmit);
		ResultSet resultSet = null;
		
		try {
		CachedRowSet crs = DBExtract3.extractRecords("GroupB");	
		ResultSetMetaData rsmd = crs.getMetaData();
		//System.out.println("Framework Driver Logic started");
		crs.next();
		while (!crs.isAfterLast()) {
			String testcaseid = crs.getString("TestCaseID");
			String teststepid = crs.getString("TestStepID");
		
			String actionKey = crs.getString("ActionKey");
			String xpath = crs.getString("XPath");
			String datakey = crs.getString("DataKey");
			switch(actionKey) {
			case "navigate":
				actKeywords.navigateURL("http://www.freecrm.com");
				break;
			case "click":
				actKeywords.clickElement(xpath);
				break;
			case "entertext":
				actKeywords.enterText(xpath, datakey);
				break;
			

		}
			
		//	for (int j1 = 1; j1 <= rsmd.getColumnCount(); j1++) {
		//		System.out.println("Column in FrameworkDriver: " + rsmd.getColumnName(j1));
		//		System.out.println("Value in FrameworkDriver: "
		//				+ crs.getString(rsmd.getColumnName(j1)));

		//	}
			crs.next();
		}
	} catch (SQLException e) {
			e.printStackTrace();
	}

		System.out.println("After completing test2");
		
		
	}

	@Test(groups= "GroupC",dataProvider="keywords",dataProviderClass=KeywordProvider.class)
	@Parameters({ "param3" })
	public void test3(String testcaseID, String teststepID,String actionKey,String xPath,String dataKey) {
		System.out.println("Before starting test3");
//		actKeywords.navigateURL("http://www.freecrm.com");
//		actKeywords.clickElement(btnLogin);
//		actKeywords.enterText(uNameXPath, "chaubalpinakin@gmail.com");
//		actKeywords.enterText(passwordXPath, "Pc9121975!");
//		actKeywords.clickElement(btnSubmit);
//		System.out.println("After completing test3");
		ResultSet resultSet = null;
		
		try {
		//CachedRowSet crs = DBExtract3.extractRecords("GroupC");	
		//ResultSetMetaData rsmd = crs.getMetaData();
		//System.out.println("Framework Driver Logic started");
		//crs.next();
		//while (!crs.isAfterLast()) {
		//	String testcaseid = crs.getString("TestCaseID");
		//	String teststepid = crs.getString("TestStepID");
		
		//	String actionKey = crs.getString("ActionKey");
		//	String xpath = crs.getString("XPath");
		//	String datakey = crs.getString("DataKey");
			switch(actionKey) {
			case "navigate":
				actKeywords.navigateURL("http://www.freecrm.com");
				break;
			case "click":
				actKeywords.clickElement(xPath);
				break;
			case "entertext":
				actKeywords.enterText(xPath, dataKey);
				break;

		}
			
		//	for (int j1 = 1; j1 <= rsmd.getColumnCount(); j1++) {
			//	System.out.println("Column in FrameworkDriver: " + rsmd.getColumnName(j1));
		//		System.out.println("Value in FrameworkDriver: "
		//				+ crs.getString(rsmd.getColumnName(j1)));

		//	}
		//	crs.next();
		//}
	} catch (Exception e) {
			e.printStackTrace();
	}
		System.out.println("After completing test3");
		
		
	}

	@AfterTest(groups= {"GroupA","GroupB","GroupC"})
	public void tearDown() {
	//	actKeywords.clickElement(logoutParent);
	//	actKeywords.clickElement(btnLogout);
		actKeywords.closeBrowser();
		assertions.assertAll();
		report.flush();
		
	}

}
