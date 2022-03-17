package com.crm.GenericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
/**
 * this class contain generic method to read data from db
 * @author eppys
 *
 */
public class DataBaseUtility {
	Connection con;
/**
 * this method will register the driver and establish connection with database	
 * @throws Throwable
 */
public void connectiondb() throws Throwable {
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	con=DriverManager.getConnection(IPathConstant.dbUrl, IPathConstant.dbUserName, IPathConstant.dbPassword);
}
/**
 * this method will close the database
 * @throws SQLException
 */
public void closeDB() throws SQLException {
	con.close();
}
/**
 * this method will execute query and return the matching data to the user
 * @param query
 * @param columnIndex
 * @param expectedData
 * @return
 * @throws Throwable
 */
public String executeQueryAndGetData(String query,int columnIndex,String expectedData) throws Throwable {
	String data=null;
	boolean flag=false;
	ResultSet result = con.createStatement().executeQuery(query);
	while(result.next()) {
		data=result.getString(columnIndex);
		if(data.equalsIgnoreCase(data)) {
			flag=true;
			break;
		}
	}
	if(flag) {
		System.out.println(data+"-------> data verified");
		return expectedData;
	}
	else {
		System.out.println("data not verified");
		return "";
	}

}
}
