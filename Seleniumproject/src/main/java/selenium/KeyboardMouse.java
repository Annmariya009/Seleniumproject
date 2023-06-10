package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class KeyboardMouse {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// WebDriver driver = new ChromeDriver();
		// WebDriver driver = new EdgeDriver();
		// WebDriver driver = new FirefoxDriver();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);

		driver.get("https://demoqa.com/buttons");
		driver.manage().window().maximize();
		WebElement doubleClick = driver.findElement(By.id("doubleClickBtn"));
		Actions obj=new Actions(driver);
		obj.doubleClick(doubleClick).perform();
		WebElement rightClick = driver.findElement(By.id("rightClickBtn"));
		obj.contextClick(rightClick).perform();// to right click on the webelement
		//obj.contextClick().perform();//to rightclick anywhere
		obj.moveToElement(rightClick).perform();//to hover the elt
		obj.sendKeys(Keys.ARROW_DOWN).perform();//to perform action in keyboard using the class Keys(static)

}
}
