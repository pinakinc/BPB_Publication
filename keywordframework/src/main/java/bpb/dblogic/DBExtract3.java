package bpb.dblogic;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import org.json.JSONArray;
import org.json.JSONObject;

public class DBExtract3 {

		private static String pageID;
		private static String objectID;
		private static String xPath;
		private static Connection conn;
		private static CachedRowSet cachedRowset;
		private static Statement stmt;

		@SuppressWarnings("finally")
		public static CachedRowSet extractRecords(String group) {
			ResultSet resultSet = null;
			ResultSetMetaData rsmd = null;
			Properties prop = new Properties();
			InputStream iStream = null;
			String dbURL=null;
			String dbUName=null;
			String dbPwd=null;
			System.out.println("Group is: "+group);
	/******Create Connection, Statement and Resultset objects and execute SQL Query and fetch metadata******/
			try {
				iStream=DBExtract2.class.getClassLoader().getResourceAsStream("dbconfig.properties");
				prop.load(iStream);
				dbURL=prop.getProperty("DB_URL");
				dbUName=prop.getProperty("DB_UNAME");
				dbPwd=prop.getProperty("DB_PASSWORD");
				conn = DriverManager.getConnection(
						dbURL, dbUName,
						dbPwd);
				stmt = conn.createStatement();
				resultSet = stmt
						.executeQuery("select A.TestCaseID,A.TestStepID,A.ActionKey,B.XPath,C.DataKey,A.Expected from testcases A left outer join object_repository B on A.ORID=B.ORID left outer join testdata C on A.TestCaseID=C.TestCaseID and A.TestStepID=C.TestStepID where A.TestCaseID in (select TestCaseID from testconfig TC where TC.Execute='Y' and TC.Group='"+group+"') order by A.TestStepID asc");
				rsmd = resultSet.getMetaData();
				
				RowSetFactory rsFactory = RowSetProvider.newFactory();
				cachedRowset = rsFactory.createCachedRowSet();
				cachedRowset.populate(resultSet);
			//	resultSet.next();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					System.out.println("Closing Connection");
					stmt.close();
					resultSet.close();
					
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	/***Iterate over Resultset and print individual values***/
	/*		try {

/*				while (!resultSet.isAfterLast()) {
					String testcaseid = resultSet.getString("A.TestCaseID");
					String teststepid = resultSet.getString("A.TestStepID");
				
					String actionKey = resultSet.getString("A.ActionKey");
					String xpath = resultSet.getString("B.XPath");
					String datakey = resultSet.getString("C.DataKey");
					for (int j1 = 1; j1 <= rsmd.getColumnCount(); j1++) {
						System.out.println("Column: " + rsmd.getColumnName(j1));
						System.out.println("Value: "
								+ resultSet.getString(rsmd.getColumnName(j1)));

					}
					resultSet.next();
				}*/
			
			
			return cachedRowset;
			
			
		} 
	}
}


