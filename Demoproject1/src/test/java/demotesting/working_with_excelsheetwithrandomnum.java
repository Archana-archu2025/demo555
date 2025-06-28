package demotesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class working_with_excelsheetwithrandomnum {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		
		//handling excel file
         FileInputStream fis1=new FileInputStream("C:\\Users\\santhosh\\eclipse-workspace\\teypyramidpractice\\Testdata\\testdata1.xlsx");
        Workbook wb = WorkbookFactory.create(fis1);
        String data = wb.getSheet("ORG").getRow(1).getCell(2).getStringCellValue();
        
        //create random number
        Random r=new Random();
        int rn = r.nextInt(1000);
        
        //handling property file
        FileInputStream fis=new FileInputStream("C:\\Users\\santhosh\\eclipse-workspace\\teypyramidpractice\\Testdata\\browser firefox.properties");
        Properties p=new Properties();
        p.load(fis);
      String browser = p.getProperty("browser");
      String un = p.getProperty("username");
      String pw=p.getProperty("password");
      String url = p.getProperty("url");
     
      
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
      
      //write back to excel sheet
      wb.getSheet("ORG").getRow(1).getCell(3).setCellValue("pass");
      FileOutputStream fos=new FileOutputStream("C:\\Users\\santhosh\\eclipse-workspace\\teypyramidpractice\\Testdata\\testdata1.xlsx");
      wb.write(fos);
       // Actions a=new Actions(driver);
        //WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
        //a.moveToElement(ele).perform();
      
        driver.findElement(By.linkText("Sign Out")).click();
        

	}

}
