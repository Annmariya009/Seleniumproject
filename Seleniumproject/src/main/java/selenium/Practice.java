package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Practice {

	public static void main(String[] args) {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
		driver.manage().window().maximize();
		WebElement firstName=driver.findElement(By.name("firstname"));
		firstName.click();
		firstName .sendKeys("Ann");
		WebElement lastName=driver.findElement(By.name("lastname"));
		lastName.sendKeys("Mariya");
		WebElement femaleButton=driver.findElement(By.id("sex-1"));
		femaleButton.click();
		WebElement singleSelection = driver.findElement(By.id("selenium_commands"));
		Select obj = new Select(singleSelection);
		obj.selectByIndex(1);
		

	}

}
