package selenium;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

	public static void main(String[] args) {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://www.qabible.in/payrollapp/site/login");
		// driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));//implicit
		// wait
		driver.manage().window().maximize();
		WebElement userName = driver.findElement(By.id("loginform-username"));
		userName.sendKeys("carol");
		WebElement password = driver.findElement(By.id("loginform-password"));
		password.sendKeys("1q2w3e4r");
		WebElement submit = driver.findElement(By.name("login-button"));
		submit.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));// Explicit wait
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Clients")));
		// wait.until(ExpectedConditions.textToBe(By.xpath("ddd","Login")));
		// wait.until(ExpectedConditions.alertIsPresent();
		// wait.until(ExpectedConditions.attributeToBe(null, null, null));
		// wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(null)
		WebElement client = driver.findElement(By.linkText("Clients"));
		client.click();
		//FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)// fluentwait
				//.withTimeout(Duration.ofSeconds(30L))// max timeout
				//.pollingEvery(Duration.ofSeconds(5L))// polling interval
				//.ignoring(NoSuchElementException.class);

		//WebElement foo = fluentWait.until(new Function<WebDriver, WebElement>() {
			//public WebElement apply(WebDriver driver) {
				//return driver.findElement(By.id("foo"));
		//	}
		//});

	}

}
