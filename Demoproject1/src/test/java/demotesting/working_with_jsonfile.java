package demotesting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class working_with_jsonfile {
      public static void main(String[] args) throws ParseException, FileNotFoundException, IOException {
    	  //create object for json parser class for access the parser method 
		JSONParser parser=new JSONParser();
		
		//through parse method get the object of physical file
		Object obj = parser.parse(new FileReader("C:\\Users\\santhosh\\eclipse-workspace\\teypyramidpractice\\Testdata\\testjsondata.json"));
		
		//in order to get the data from json file we have do downcast because of accessing the get method
	JSONObject map=(JSONObject)obj;
	 
	//get the data from the json file
	//the return type is object to convert string type we using tostring method
	String browser = map.get("browser").toString();
	//one more way is typecasting
	String url = (String) map.get("url");
	String username = map.get("username").toString();
	String password = map.get("password").toString();
	String timeout = map.get("timeout").toString();
	int i=Integer.parseInt(timeout);
	String org=map.get("org").toString();
	
	 WebDriver driver=null;
     
     if(browser.contains("chrome")) {
   	  driver=new ChromeDriver();
     }
     else if(browser.contains("firefox")) {
   	  driver=new FirefoxDriver();
     }
     
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(i));
    
     driver.get(url);
     
     driver.findElement(By.name("user_name")).sendKeys(username);
     driver.findElement(By.name("user_password")).sendKeys(password);
     driver.findElement(By.id("submitButton")).click();
     driver.findElement(By.linkText("Organizations")).click();
     driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
     Random r=new Random();
     int rn=r.nextInt(1000); 
     driver.findElement(By.name("accountname")).sendKeys(org+rn);
     driver.findElement(By.name("button")).click();
	
	
	

	
	}
}
