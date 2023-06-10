package selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MultipleWidows {

	public static void main(String[] args) {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		String parentWindowId = driver.getWindowHandle();
		System.out.println(parentWindowId);
		WebElement newTab = driver.findElement(By.id("tabButton"));
		newTab.click();
		Set<String> allWindowsId = driver.getWindowHandles();// to get id of all windows
		System.out.println(allWindowsId);
		for (String childWindow : allWindowsId) {
			if (!parentWindowId.equals(childWindow)) {
				driver.switchTo().window(childWindow);
				WebElement text = driver.findElement(By.id("sampleHeading"));
				String s = text.getText();
				System.out.println(s);
			}
		}
		driver.switchTo().window(parentWindowId);//to get control back to parentwindow
	}
}
