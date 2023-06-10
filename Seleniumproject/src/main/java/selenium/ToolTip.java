package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ToolTip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		WebElement allToolTip=driver.findElement(By.id("searchDropdownBox"));
		String toolTipMsg=allToolTip.getAttribute("title");
		System.out.println(toolTipMsg);
	}

}
