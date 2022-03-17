package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.xdevapi.Result;

public class SampleJDBCExecuteQueryTest {
@Test
public void sampleJDBCExecuteQuery() throws SQLException
{
	//step1:register the database
	Driver driverRef=new Driver();
	DriverManager.registerDriver(driverRef);
	//step2:get connection to the database
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
	
	//step3:issue create statement
	Statement state = con.createStatement();
	//step4:execute Query--provide table name
	ResultSet result = state.executeQuery("select * from student;");
	while(result.next()) {
		System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
	}
	//step5:close the database
	con.close();
}
}
