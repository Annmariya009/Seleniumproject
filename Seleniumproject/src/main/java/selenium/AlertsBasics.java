package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AlertsBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// WebDriver driver = new ChromeDriver();
		// WebDriver driver = new EdgeDriver();
		// WebDriver driver = new FirefoxDriver();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);

		driver.get("https://selenium.obsqurazone.com/javascript-alert.php");
		driver.manage().window().maximize();
		WebElement clickMe = driver.findElement(By.xpath("//button[@class='btn btn-warning']"));
		clickMe.click();
		// driver.switchTo().alert().accept();//to click ok of alert pop-up
		String text = driver.switchTo().alert().getText();
		System.out.println(text);//to get text of alert pop-up
		driver.switchTo().alert().dismiss();//to click dismiss

	}

}
