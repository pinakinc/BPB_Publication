package bpb.dblogic;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONObject;

public class DBExtract {

	private static String pageID;
	private static String objectID;
	private static String xPath;

	public static void main(String[] args) {
		ResultSet resultSet = null;
		ResultSetMetaData rsmd = null;
		JSONArray test = new JSONArray();
		JSONArray OR = new JSONArray();

		JSONObject j = null;
		JSONObject Object_Repository = null;
		JSONObject Full_Object_Repository = null;
/******Create Connection, Statement and Resultset objects and execute SQL Query and fetch metadata******/
		try {
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/selenium_framework", "root",
					"Pc9121975!");
			Statement stmt = conn.createStatement();
			resultSet = stmt
					.executeQuery("SELECT B.PageID as PageID,B.ObjectID   as ObjectID,B.XPath as XPath FROM selenium_framework.object_repository B,selenium_framework.testcases A where A.ORID=B.ORID;");
			rsmd = resultSet.getMetaData();

			resultSet.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
/***Iterate over Resultset and create our JSON Object***/
		try {

			while (!resultSet.isAfterLast()) {
				pageID = resultSet.getString("PageID");
				objectID = resultSet.getString("ObjectID");
				xPath = resultSet.getString("XPath");
				j = new JSONObject();
				for (int j1 = 1; j1 <= rsmd.getColumnCount(); j1++) {
					System.out.println("Column: " + rsmd.getColumnName(j1));
					System.out.println("Value: "
							+ resultSet.getString(rsmd.getColumnName(j1)));
					if (!rsmd.getColumnName(j1).equalsIgnoreCase("pageid")) {
						j.put(rsmd.getColumnName(j1),
								resultSet.getString(rsmd.getColumnName(j1)));
					}

				}
				test.put(j);
				resultSet.next();
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}
		Object_Repository = new JSONObject();
		Object_Repository.put("pageID", pageID);
		Object_Repository.put("Objects", test);
		OR = new JSONArray();
		OR.put(Object_Repository);
		System.out.println(OR);
		Full_Object_Repository = new JSONObject();
		Full_Object_Repository.put("OR", OR);
		System.out.println(Full_Object_Repository);
	} 
}
