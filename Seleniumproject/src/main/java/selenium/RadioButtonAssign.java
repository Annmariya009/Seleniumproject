package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RadioButtonAssign {
	public static void main(String args[]) {

		// WebDriver driver = new ChromeDriver();
		// WebDriver driver = new EdgeDriver();
		// WebDriver driver = new FirefoxDriver();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://selenium.obsqurazone.com/radio-button-demo.php");
		driver.manage().window().maximize();
		WebElement femaleButton = driver.findElement(By.id("inlineRadio2"));
		femaleButton.click();
		boolean verify=femaleButton.isSelected();
		System.out.println(verify);
		WebElement showButton = driver.findElement(By.xpath("//button[@id='button-one']"));
		boolean display=showButton.isDisplayed();//to verify presence of button
		System.out.println(display);
		boolean enable=showButton.isEnabled();//to find whether the element is enabled or disabled
		System.out.println(enable);

		String tagName=showButton.getTagName();
		System.out.println(tagName);
		WebElement maleButton = driver.findElement(By.id("inlineRadio1"));
		String tagName1=maleButton.getTagName();
		System.out.println(tagName1);
		maleButton.click();
		showButton.click();
		String showButtonText=showButton.getText();
		System.out.println( showButtonText);
		boolean verifyMaleButton=maleButton.isSelected();
		System.out.println(verifyMaleButton);
		
		
	
		

		
		

	}
}
