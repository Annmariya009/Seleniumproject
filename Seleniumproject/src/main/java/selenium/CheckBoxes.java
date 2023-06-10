package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CheckBoxes {
	public static void main(String args[]) {

		// WebDriver driver = new ChromeDriver();
		// WebDriver driver = new EdgeDriver();
		// WebDriver driver = new FirefoxDriver();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
		driver.manage().window().maximize();
		WebElement check=driver.findElement(By.id("gridCheck"));
		check.click();
		boolean check1=check.isSelected();
		System.out.println(check1);//

}
}