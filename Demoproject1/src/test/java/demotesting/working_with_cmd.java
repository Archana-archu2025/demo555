package demotesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.Duration;
import java.util.Iterator;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;



public class working_with_cmd {
	WebDriver driver=null;
        @Test
        public void eleniumwithcmd() throws Exception
        {
        	String url = System.getProperty("url");
        	String browser = System.getProperty("browser");
        	String username = System.getProperty("username");
        	String password = System.getProperty("password");
        	String timeout = System.getProperty("timeout");
        	int i=Integer.parseInt(timeout);
        	
        	 FileInputStream fis1=new FileInputStream("C:\\Users\\santhosh\\eclipse-workspace\\teypyramidpractice\\Testdata\\testdata1.xlsx");
             Workbook wb = WorkbookFactory.create(fis1);
             String data = wb.getSheet("ORG").getRow(1).getCell(2).getStringCellValue();
        	
        	
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
            int rn = r.nextInt(1000);
            driver.findElement(By.name("accountname")).sendKeys(data+rn);
            driver.findElement(By.name("button")).click();
            
            
        }
	
			
		}

