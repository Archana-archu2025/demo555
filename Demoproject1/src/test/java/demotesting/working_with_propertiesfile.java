package demotesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class working_with_propertiesfile {
	public static void main(String[] args) throws IOException {
		 FileInputStream fis=new FileInputStream("C:\\Users\\santhosh\\Desktop\\browser firefox.properties");
           Properties p=new Properties();
           p.load(fis);
         String browser = p.getProperty("browser");
         String un = p.getProperty("username");
         String pw=p.getProperty("password");
         String url = p.getProperty("url");
         String on = p.getProperty("orgname");
         
         WebDriver driver=null;
         
         if(browser.contains("chrome")) {
       	  driver=new ChromeDriver();
         }
         else if(browser.contains("firefox")) {
       	  driver=new FirefoxDriver();
         }
         
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
         driver.get(url);
         
         driver.findElement(By.name("user_name")).sendKeys(un);
         driver.findElement(By.name("user_password")).sendKeys(pw);
         driver.findElement(By.id("submitButton")).click();
         driver.findElement(By.linkText("Organizations")).click();
         driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
         driver.findElement(By.name("accountname")).sendKeys(on);
         driver.findElement(By.name("button")).click();
         
	}


}
