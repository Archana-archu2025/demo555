package demotesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import com.mysql.jdbc.Driver;

public class working_with_DataBase_update {

	public static void main(String[] args) throws SQLException {
		
		Random r=new Random();
		int r1 = r.nextInt(10000,99999);
		int r2 = r.nextInt(10000,99999);
		
               Driver driver=new Driver();
               DriverManager.registerDriver(driver);
               Connection connection = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
               Statement state = connection.createStatement();
               String expectedres = "qspider"+r1;
               String insertdata = "'qspider"+r1+"','san1111','29/05/2025','abcd"+r2+"','open','10'";
               System.out.println(insertdata);
               
              //to update the data to database
               int update = state.executeUpdate("insert into project values("+insertdata+");");
               System.out.println(update);
               
            //to print the date getting from database based on condition
               ResultSet result = state.executeQuery("select * from project");
               while(result.next()) {
            	   String actualres = result.getString(1);
            	   if(actualres.equals(expectedres)) {
            		 System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4)+"\t"+result.getString(5)+"\t"+result.getString(6)); 
            	   }
               }
               connection.close();
	}

}
