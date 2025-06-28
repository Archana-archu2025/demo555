package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class databaseutility {
	
	
	public void getconnection() throws SQLException {
		 Driver driver=new Driver();
    	 DriverManager.registerDriver(driver);
    	Connection con = DriverManager.getConnection("jdbc:mysql:http://49.249.28.218:3333/ninza_hrm","root","root");
	}
     public String getdatafrondatabase(String Quary,String excepted,int num) throws SQLException {
    	 String res =null;
    	 Driver driver=new Driver();
    	 DriverManager.registerDriver(driver);
    	Connection con = DriverManager.getConnection("jdbc:mysql:http://49.249.28.218:3333/ninza_hrm","root","root");
    	 Statement statement = con.createStatement();
    	 ResultSet result = statement.executeQuery(Quary);
    	 while(result.next()) {
    		 String data = result.getString(num);
    		 
    		 if(excepted.equals(data)) {
    			  res = result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4)+"\t"+result.getString(5)+"\t"+result.getString(6); 
    		 }
    	 }
		return res;
    	 
     }
}
