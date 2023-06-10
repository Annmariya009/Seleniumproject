package selenium;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class DynamicTableAssign {
	public static void main(String[] args) {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://selenium.obsqurazone.com/table-pagination.php");
		driver.manage().window().maximize();
		List<WebElement> FirstColumnElements = driver
				.findElements(By.xpath("//table[@id='dtBasicExample']//tbody//tr//td[1]"));
		String locator = null;
		for (int i = 0; i < FirstColumnElements.size(); i++) {
			if (FirstColumnElements.get(i).getText().equals("Cedric Kelly")) {
				locator = "//table[@id='dtBasicExample']//tbody//tr[" + (i + 1) + "]//td";
				break;
			}
		}
		System.out.println("Row values corresponds to  Cedric Kelly");
		List<WebElement> allRowValues = driver.findElements(By.xpath(locator));
		for (int i = 0; i < allRowValues.size(); i++) {
			String rowValues = allRowValues.get(i).getText();
			System.out.println(rowValues);
		}
		List<WebElement> FirstColumnElement = driver
				.findElements(By.xpath("//table[@id='dtBasicExample']//tbody//tr//td[1]"));
		String locator1 = null;
		for (int i = 0; i < FirstColumnElement.size(); i++) {
			if (FirstColumnElement.get(i).getText().equals("Herrod Chandler")) {
				locator1 = "//table[@id='dtBasicExample']//tbody//tr[" + (i + 1) + "]//td[3]";
				break;
			}
		}
		System.out.println("Office of Herrod Chandler  is in");
		WebElement officeCellValue = driver.findElement(By.xpath(locator1));
		System.out.println(officeCellValue.getText());
	}
}
