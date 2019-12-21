package bpb.dataprovider;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import bpb.dblogic.DBExtract3;
import bpb.listeners.MyListener1;
import bpb.listeners.MyListener2;



public class KeywordProvider {

	static Object[][] testKeywords = null;
	@DataProvider(name="keywords")
	public static Object[][] keywords(ITestContext itestContext){
		int row = 0;
		int rows = 0;
		try {
		String[] group = itestContext.getIncludedGroups();
		System.out.println("Group passed as parameter "+group[0]);
		CachedRowSet crs = DBExtract3.extractRecords(group[0]);
		ResultSetMetaData rsmd = crs.getMetaData();
		System.out.println("Framework Driver Logic started");
		
		crs.next();
		while (!crs.isAfterLast()) {
			row=row+1;
			crs.next();
		}
		System.out.println("Rows: "+row);
		testKeywords = new Object[row][rsmd.getColumnCount()];
		crs.beforeFirst();
		crs.next();
		while (!crs.isAfterLast()) {
			String testcaseid = crs.getString("TestCaseID");
			String teststepid = crs.getString("TestStepID");
			
			String actionKey = crs.getString("ActionKey");
			String xpath = crs.getString("XPath");
			String datakey = crs.getString("DataKey");
//			System.out.println("Outside dataKey "+datakey);
			for (int j1 = 1; j1 <= rsmd.getColumnCount(); j1++) {
//				System.out.println("Column in FrameworkDriver: " + rsmd.getColumnName(j1));
//				System.out.println("Value in FrameworkDriver: "
//						+ crs.getString(rsmd.getColumnName(j1)));
				testKeywords[rows][j1-1] = crs.getString(rsmd.getColumnName(j1));
//				System.out.println("Keywords: "+testKeywords[rows][j1-1]);
				

			}
			rows = rows+1;
			crs.next();
		}
	} catch (SQLException e) {
			e.printStackTrace();
	}
		System.out.println("Framework Driver Logic ended");
		return testKeywords;
	}
	
	@Test(dataProvider="keywords", groups= {"GroupA","GroupB","GroupC"})
	public void testKeywords(String testcaseID, String teststepID,String actionKey,String xPath,String dataKey) {
		System.out.println("TestCaseID: "+testcaseID);
		System.out.println("TestStepID: "+teststepID);
		System.out.println("ActionKey: "+actionKey);
		System.out.println("xPath: "+xPath);
		System.out.println("dataKey: "+dataKey);
	}
	}

