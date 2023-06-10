package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebElementBasics {

	public static void main(String args[]) {

		 WebDriver driver = new ChromeDriver();
		// WebDriver driver = new EdgeDriver();
		// WebDriver driver = new FirefoxDriver();
//		ChromeOptions ops = new ChromeOptions();
//		ops.addArguments("--remote-allow-origins=*");
//		WebDriver driver = new ChromeDriver(ops);

		driver.get("https://www.qabible.in/payrollapp/site/login");
		driver.manage().window().maximize();
		WebElement userName = driver.findElement(By.id("loginform-username"));
		userName.sendKeys("hello");//to input the text
		WebElement password = driver.findElement(By.id("loginform-password"));
		password.sendKeys("hi");
		WebElement login=driver.findElement(By.xpath("//button[@name='login-button']"));
		login.click();
		userName.clear();// to clear text
		String text=login.getText();
		System.out.println(text);//to get visible text
		String font=login.getCssValue("background-color");//to verify styles
		System.out.println(font);
		String style=login.getCssValue("font-family");
		System.out.println(style);
		String tagName=login.getTagName();
		System.out.println(tagName);
		
		
	}
}