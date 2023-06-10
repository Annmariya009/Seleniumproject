package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class SelenuimClass {
	
	public static void main(String args[]) {
		
		
		//WebDriver driver = new ChromeDriver();
		// WebDriver driver = new EdgeDriver();
		// WebDriver driver = new FirefoxDriver();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		
		
		driver.get("https://www.amazon.com.au/");
		String title = driver.getTitle();
		System.out.println(title);
		String currentUrl = driver.getCurrentUrl();//will wait to get page reloaded fully
		System.out.println(currentUrl);
		String pageHtml = driver.getPageSource();//displays html code
		System.out.println(pageHtml);
		driver.manage().window().maximize();
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.navigate().back();
		//driver.navigate().to("https://www.amazon.com.au/");// will not wait to get page reloaded 
		//driver.close();//current focused  window get closed
		//driver.quit();//all window get closed including web driver instance
	}
}
