package selenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class WaitAssignment {

	public static void main(String[] args) {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://www.qabible.in/payrollapp/site/login");
		 driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		driver.manage().window().maximize();
		WebElement userName = driver.findElement(By.id("loginform-username"));
		userName.sendKeys("carol");
		WebElement password = driver.findElement(By.id("loginform-password"));
		password.sendKeys("1q2w3e4r");
		WebElement submit = driver.findElement(By.name("login-button"));
		submit.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));// Explicit wait
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Workers")));
		WebElement workers = driver.findElement(By.xpath("//a[text()='Workers']"));
		workers.click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMillis(10000));
		wait1.until(ExpectedConditions.textToBe(By.xpath("//button[@type='submit']"), "Search"));
		WebElement search = driver.findElement(By.xpath("//button[@type='submit']"));
		search.click();
		WebElement deleteWorker = driver.findElement(
				By.xpath("//table[@class='table table-striped table-bordered']//tbody//tr[2]//td[8]//a[3]//span"));
		deleteWorker.click();
		WebDriverWait waitAlert = new WebDriverWait(driver, Duration.ofMillis(5000));
		waitAlert.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}

}
