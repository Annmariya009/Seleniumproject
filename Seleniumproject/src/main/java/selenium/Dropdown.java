package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {
	public static void main(String args[]) {

		// WebDriver driver = new ChromeDriver();
		// WebDriver driver = new EdgeDriver();
		// WebDriver driver = new FirefoxDriver();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://selenium.obsqurazone.com/select-input.php");
		driver.manage().window().maximize();
		WebElement singleSelection = driver.findElement(By.id("single-input-field"));
		Select obj = new Select(singleSelection);
		obj.selectByIndex(1);
		// obj.selectByVisibleText("yellow");
		// obj.selectByValue("Green");
		WebElement selectElement = obj.getFirstSelectedOption();
		String text = selectElement.getText();
		System.out.println(text);
		WebElement multiSelect = driver.findElement(By.id("multi-select-field"));
		Select obj1 = new Select(multiSelect);
		// obj1.selectByIndex(1);
		// obj1.selectByValue("Red");
		List<WebElement> list1 = obj1.getAllSelectedOptions();
		for (int i = 0; i < list1.size(); i++) {
			String s = list1.get(i).getText();
			System.out.println(s);

		}

	}
}
