package selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class FileUpload {

	public static void main(String[] args) throws AWTException {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		driver.get("http://demo.guru99.com/selenium/upload/");
		driver.manage().window().maximize();
		Robot robot = new Robot();
		// robot.keyPress(KeyEvent.VK_CONTROL);
		// robot.keyRelease(KeyEvent.VK_CONTROL);
		WebElement fileUpload = driver.findElement(By.id("uploadfile_0"));
		Actions action = new Actions(driver);
		action.moveToElement(fileUpload).click().perform();
		// fileUpload.click();
		// copy path to your system clipboard
		StringSelection ss = new StringSelection("C:\\Users\\Maru\\Documents\\Selenium");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		WebElement submitButton = driver.findElement(By.id("submitbutton"));
		submitButton.click();

	}

}
