package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdateTest {
@Test
public void sampleJDBCExecuteUpdate() throws SQLException {
	Connection con=null;
	try{
		//register the database

	Driver driverRef=new Driver();
	DriverManager.registerDriver(driverRef);
	//get connection to the database
	//issue create statement
	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
	 System.out.println("connection established");
	//issue create statement
	Statement state = con.createStatement();
	//execute a query
	//insert into student values (648,neeraj,male)
	int result = state.executeUpdate("insert into student values(648,'neeraj','MALE');");
	//int result = state.executeUpdate("delete from student where student_name='neeraj';");
	if(result==1) {
		System.out.println("data added successfully");
	}
	else {
	System.out.println("data not added");
	}
}
 catch(Exception e) {
	// TODO Auto-generated method stub

}
	finally {
	con.close();
	System.out.println("connection closed");
	}
}
}