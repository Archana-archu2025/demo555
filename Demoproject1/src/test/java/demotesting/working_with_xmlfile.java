package demotesting;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class working_with_xmlfile {
   @Test
   public void simpletest(XmlTest test) {
	   
	   String browser = test.getParameter("browser");
	      String un = test.getParameter("username");
	      String pw=test.getParameter("password");
	      String url = test.getParameter("url");
	      String data = test.getParameter("data");
	      
	      Random r=new Random();
	        int rn = r.nextInt(1000);
	      
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
	      driver.findElement(By.name("accountname")).sendKeys(data+rn);
	      driver.findElement(By.name("button")).click();
   }
}
