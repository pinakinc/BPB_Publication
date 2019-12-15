package bpb.driver;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import bpb.Singleton.SingletonDriver;
import bpb.WaitLogic.WaitClass;
import bpb.dblogic.DBExtract2;
import bpb.dblogic.DBExtract3;
import bpb.events.MyEventListener;
import bpb.events.MyEventListener2;
import bpb.keywords.ActionKeywords;

public class Framework_Driver {

	public static void main(String[] args) {

	//	ActionKeywords act = new ActionKeywords();
		ResultSet resultSet = null;
		
		try {
		CachedRowSet crs = DBExtract3.extractRecords("GroupA");	
		ResultSetMetaData rsmd = crs.getMetaData();
		System.out.println("Framework Driver Logic started");
		crs.next();
		while (!crs.isAfterLast()) {
			String testcaseid = crs.getString("TestCaseID");
			String teststepid = crs.getString("TestStepID");
		
			String actionKey = crs.getString("ActionKey");
			String xpath = crs.getString("XPath");
			String datakey = crs.getString("DataKey");
			
			for (int j1 = 1; j1 <= rsmd.getColumnCount(); j1++) {
				System.out.println("Column in FrameworkDriver: " + rsmd.getColumnName(j1));
				System.out.println("Value in FrameworkDriver: "
						+ crs.getString(rsmd.getColumnName(j1)));

			}
			crs.next();
		}
	} catch (SQLException e) {
			e.printStackTrace();
	}
		System.out.println("Framework Driver Logic ended");
	}
}
