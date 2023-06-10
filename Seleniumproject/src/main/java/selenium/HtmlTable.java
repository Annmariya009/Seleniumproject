package selenium;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class HtmlTable {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// WebDriver driver = new ChromeDriver();
		// WebDriver driver = new EdgeDriver();
		// WebDriver driver = new FirefoxDriver();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://selenium.obsqurazone.com/table-pagination.php");
		driver.manage().window().maximize();
		List<WebElement> header = driver.findElements(By.xpath("//table[@id='dtBasicExample']//thead"));
		for (int i = 0; i < header.size(); i++) {
			String s = header.get(i).getText();
			System.out.println(s);
		}
		List<WebElement> row1 = driver.findElements(By.xpath("//table[@id='dtBasicExample']//tbody//tr[1]"));
		for (int i = 0; i < row1.size(); i++) {
			String s1 = row1.get(i).getText();
			System.out.println(s1);
		}
	}

}
