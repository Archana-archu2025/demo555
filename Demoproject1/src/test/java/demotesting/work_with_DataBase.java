package demotesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class work_with_DataBase {

	public static void main(String[] args) throws SQLException {
		Connection connection=null;
		try {
			
		
		//step1: load/register the database driver
             Driver driverref=new Driver();
             DriverManager.registerDriver(driverref);
             
        //step2: connect to data base
                connection = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
             System.out.println("database connected successfuly");
        //step3: create sql statement 
             Statement state = connection.createStatement();
               String exeres="akash";
        //step4: Execute select Query and get result
             ResultSet result = state.executeQuery("select* from project");
             while(result.next()) {
            	 String data = result.getString(2);
          
            	 if(exeres.equals(data)) {
            		 System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4)+"\t"+result.getString(5)+"\t"+result.getString(6)); 

            		 
            	 }
             }
             }
		catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			//step5: close the connection
       	 connection.close();
		}
            	 
        
             }
	}


