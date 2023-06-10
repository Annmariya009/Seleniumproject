package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AssertionsAssignment {
	WebDriver driver;
	@Test
	public void VerifySearchText() {
		WebElement userName = driver.findElement(By.id("loginform-username"));
		userName.sendKeys("carol");
		WebElement password = driver.findElement(By.id("loginform-password"));
		password.sendKeys("1q2w3e4r");
		WebElement login = driver.findElement(By.name("login-button"));
		login.click();
		WebElement client = driver.findElement(By.xpath("//a[@href='/payrollapp/client/index']"));
		client.click();
		WebElement search = driver.findElement(By.xpath("//button[text()='Search']"));
		String expected = "Search";
		String actual = search.getText();
		Assert.assertEquals(actual, expected, "not matching");
				 
	}

	@Test
	public void VerifyToolTipofWorkersTabDeleteIcon() {
		WebElement userName = driver.findElement(By.id("loginform-username"));
		userName.sendKeys("carol");
		WebElement password = driver.findElement(By.id("loginform-password"));
		password.sendKeys("1q2w3e4r");
		WebElement login = driver.findElement(By.name("login-button"));
		login.click();
		WebElement workersTab = driver.findElement(By.linkText("Workers"));
		workersTab.click();
		List<WebElement> ColumnElements = driver
				.findElements(By.xpath("//table[@class='table table-striped table-bordered']//tbody//tr//td[2]"));
		String locator = null;
		for (int i = 0; i < ColumnElements.size(); i++) {
			if (ColumnElements.get(i).getText().equals("Dennis Benny")) {
				locator = "//table[@class='table table-striped table-bordered']//tbody//tr[" + (i + 1)
						+ "]//td[8]//a[3]";
				break;
			}
		}
		WebElement deleteToolTip = driver.findElement(By.xpath(locator));
		String actual = deleteToolTip.getAttribute("title");
		System.out.println(actual);
		String expected = "Delete";
		Assert.assertEquals(actual, expected, "********not matching with expected result");
	}

	@Test
	public void VerifyWorkersTabSearchButtonText() {
		WebElement userName = driver.findElement(By.id("loginform-username"));
		userName.sendKeys("carol");
		WebElement password = driver.findElement(By.id("loginform-password"));
		password.sendKeys("1q2w3e4r");
		WebElement login = driver.findElement(By.name("login-button"));
		login.click();
		WebElement workersTab = driver.findElement(By.linkText("Workers"));
		workersTab.click();
		WebElement search = driver.findElement(By.xpath("//button[text()='Search']"));
		String expected = "Search";
		String actual = search.getText();
		System.out.println(actual);
		Assert.assertEquals(actual, expected, "********not matching with expected result");
	}

	@Test
	public void VerifyWorkersTabBackgroundColor() {
		WebElement userName = driver.findElement(By.id("loginform-username"));
		userName.sendKeys("carol");
		WebElement password = driver.findElement(By.id("loginform-password"));
		password.sendKeys("1q2w3e4r");
		WebElement login = driver.findElement(By.name("login-button"));
		login.click();
		WebElement workersTab = driver.findElement(By.linkText("Workers"));
		workersTab.click();
		WebElement searchBackground = driver.findElement(By.xpath("//button[text()='Search']"));
		String expected = "rgba(51, 122, 183, 1)";
		String actual = searchBackground.getCssValue("background-color");
		Assert.assertEquals(actual, expected, "********not matching with expected result");
	}

	@Test
	public void VerifyCreateClientsTabInvoiceOrderDropdown() {
		WebElement userName = driver.findElement(By.id("loginform-username"));
		userName.sendKeys("carol");
		WebElement password = driver.findElement(By.id("loginform-password"));
		password.sendKeys("1q2w3e4r");
		WebElement login = driver.findElement(By.name("login-button"));
		login.click();
		WebElement client = driver.findElement(By.xpath("//a[@href='/payrollapp/client/index']"));
		client.click();
		WebElement createClientsTab = driver.findElement(By.linkText("Create Client"));
		createClientsTab.click();
		WebElement invoiceOrder = driver.findElement(By.id("client-invoice_order"));
		Select obj = new Select(invoiceOrder);
		obj.selectByIndex(1);
		WebElement selectedElement = obj.getFirstSelectedOption();
		String expected = "Single timesheet per client";
		String actual = selectedElement.getText();
		System.out.println(actual);
		Assert.assertEquals(actual, expected, "********not matching with expected result");
	}

	@Test
	public void VerifyCreateClientsTabRequirePoCheckBox() {
		WebElement userName = driver.findElement(By.id("loginform-username"));
		userName.sendKeys("carol");
		WebElement password = driver.findElement(By.id("loginform-password"));
		password.sendKeys("1q2w3e4r");
		WebElement login = driver.findElement(By.name("login-button"));
		login.click();
		WebElement client = driver.findElement(By.xpath("//a[@href='/payrollapp/client/index']"));
		client.click();
		WebElement createClientsTab = driver.findElement(By.linkText("Create Client"));
		createClientsTab.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)", "");
		WebElement checkBox = driver.findElement(By.xpath("//input[@id='client-require_po']"));
		checkBox.click();
		boolean expected = true;
		boolean actual = checkBox.isSelected();
		Assert.assertEquals(actual, expected, "...Require pro check box selection is not as expected");
		System.out.println(actual);

	}

	@BeforeMethod
	@Parameters("browser")
	public void beforeMethod(String browser) {
		if (browser.equals("chrome")) {
			//ChromeOptions ops = new ChromeOptions();
			//ops.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			//EdgeOptions ops = new EdgeOptions();
			//ops.addArguments("--remote-allow-origins=*");
			driver = new EdgeDriver();

		}

		driver.get("https://www.qabible.in/payrollapp/site/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();

	}

}
