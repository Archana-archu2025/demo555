package demotesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class work_with_mainmethod {

	public static void main(String[] args) {
		String browser=null;
		String url=null;
		String un=null;
		String pw=null;
		for(String a:args) {
			if(a.contains("chrome")) {
				browser="chrome";
			}
			else if (a.contains("firefox")) {
				browser="firefox";
			}
			else if(a.contains("http://49.249.28.218:8888")) {
				url="http://49.249.28.218:8888";
			}
			else if(a.contains("admin")) {
				un="admin";
				pw="admin";
			}
		}
		WebDriver driver=null;
		if(browser.contains("chrome"))
				{
			driver=new ChromeDriver();
		}
		else if(browser.contains("firefox")) {
			driver=new FirefoxDriver();
		}

	}

}
