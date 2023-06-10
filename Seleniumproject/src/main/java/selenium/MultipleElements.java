package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MultipleElements {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// WebDriver driver = new ChromeDriver();
		// WebDriver driver = new EdgeDriver();
		// WebDriver driver = new FirefoxDriver();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);

		driver.get("https://selenium.obsqurazone.com/select-input.php");
		driver.manage().window().maximize();
		List<WebElement> list = driver.findElements(By.xpath("//select[@id='single-input-field']//option"));
		for(int i=0;i<list.size();i++)
		{
		String s=list.get(i).getText();
		System.out.println(s);
		}

}
}
