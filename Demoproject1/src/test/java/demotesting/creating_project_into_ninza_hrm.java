package demotesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.jdbc.Driver;

public class creating_project_into_ninza_hrm {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException, SQLException, InterruptedException {
		WebDriver driver=null;
		JSONParser parse=new JSONParser();
		Object obj = parse.parse(new FileReader("C:\\Users\\santhosh\\eclipse-workspace\\teypyramidpractice\\Testdata\\createproject.json"));
		JSONObject map=(JSONObject) obj;

		Random r=new Random();
		int r1 = r.nextInt(10000, 99999);
		int r2 = r.nextInt(10000, 99999);
		FileInputStream fis1=new FileInputStream("C:\\Users\\santhosh\\eclipse-workspace\\teypyramidpractice\\Testdata\\testdata3.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		String data1 = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		System.out.println(data1);
		String data2 = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		System.out.println(data2);
		String projectname=data1+r1;
		System.out.println(projectname);
		String projectcreater=data2+r2;
		System.out.println(projectcreater);

		String browser = map.get("browser").toString();
		String username = map.get("username").toString();
		String password = map.get("password").toString();
		String url = map.get("url").toString();
		String timeout = map.get("timeout").toString();
		int i = Integer.parseInt(timeout);
	
		if(browser.contains("chrome"))
		{
			driver=new ChromeDriver();
		}	
		else if(browser.contains("firefox")) {
			driver=new FirefoxDriver();
		}else
		{
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(i));
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("inputPassword")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(projectname);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys(projectcreater);
		
		WebElement dd = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		
		Select s=new Select(dd);
		s.selectByVisibleText("Created");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		System.out.println("project has created");

		Thread.sleep(5000);
		Connection connection=null;
		try {

			Driver driverref=new Driver();
			DriverManager.registerDriver(driverref);
			connection = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
			System.out.println("database connected successfuly");

			Statement state = connection.createStatement();
			String exeres=projectcreater;

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

			connection.close();
		}


	}



}



