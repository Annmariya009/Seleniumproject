package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DynamicTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://selenium.obsqurazone.com/table-pagination.php");
		driver.manage().window().maximize();
		List<WebElement> FirstColumnElements = driver
				.findElements(By.xpath("//table[@id='dtBasicExample']//tbody//tr//td[1]"));
		String locator = null;
		for (int i = 0; i < FirstColumnElements.size(); i++) {

			if (FirstColumnElements.get(i).getText().equals("Garrett Winters")) {

				locator = "//table[@id='dtBasicExample']//tbody//tr[" + (i + 1) + "]//td[4]";
				break;

			}
		}
		WebElement ageCellValue = driver.findElement(By.xpath(locator));
		System.out.println(ageCellValue.getText());
		

	}
}
