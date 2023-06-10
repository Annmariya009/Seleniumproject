package selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebElmntAssign {
	public static void main(String args[]) {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
		driver.manage().window().maximize();
		WebElement enterName = driver.findElement(By.id("single-input-field"));
		enterName.sendKeys("Marks");
		WebElement showMsg = driver.findElement(By.xpath("//button[@id='button-one']"));
		showMsg.click();
		WebElement valueA = driver.findElement(By.id("value-a"));
		valueA.sendKeys("10");
		WebElement valueB = driver.findElement(By.id("value-b"));
		valueB.sendKeys("20");
		WebElement getTotal = driver.findElement(By.xpath("//button[@id='button-two']"));
		getTotal.click();//
		String textShow = showMsg.getText();
		System.out.println(textShow);
		String textGet = getTotal.getText();
		System.out.println(textGet);
		String background = showMsg.getCssValue("background");
		System.out.println(background);
		String fontColor = showMsg.getCssValue("color");
		System.out.println(fontColor);

		String classVerify = showMsg.getAttribute("class");
		System.out.println(classVerify);
		String idVerify = showMsg.getAttribute("id");// getAtrribute returns the value of the web element's attribute as a string. 
		System.out.println(idVerify);

	}
}
