package testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class SearchButton {
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
		// hard assertion
		// Assert.assertEquals(actual, expected, ".........Search button text is not
		// expected");

//		//soft assertion or Verify
//		SoftAssert softAssert=new SoftAssert();
//		softAssert.assertEquals(actual, expected,"not matching");
//		System.out.println("************************************************");
//		softAssert.assertAll();
//		
	}

	@Test
	public void verifyWorkersTab() {
		WebElement workersTab = driver.findElement(By.linkText("Workers"));
		workersTab.click();
		WebElement deleteToolTip = driver.findElement(
				By.xpath("//table[@class='table table-striped table-bordered']//tbody//tr[1]//td[8]//a[3]"));
		String expectedResult = "Delete";
		String actualResult = deleteToolTip.getAttribute("title");
		Assert.assertEquals(actualResult, expectedResult, ".......Tooltip of Delete Icon is not expected");
		System.out.println(actualResult);
		WebElement searchBackground = driver.findElement(By.xpath("//button[text()='Search']"));
		String expected = "rgba(51, 122, 183, 1)";
		String actual = searchBackground.getCssValue("background-color");
		Assert.assertEquals(actual, expected, ".........Search button backgroung color is not as expected result");
		System.out.println(actual);

	}

	@Test(enabled = false)
	public void verifyClientsTabDropDown() {
		WebElement clientsTab = driver.findElement(By.linkText("Clients"));
		clientsTab.click();
		WebElement createClientsTab = driver.findElement(By.linkText("Create Client"));
		createClientsTab.click();
		WebElement invoiceOrder = driver.findElement(By.id("client-invoice_order"));
		Select obj = new Select(invoiceOrder);
		obj.selectByIndex(1);
		WebElement selectedElement = obj.getFirstSelectedOption();
		String expected = "Single timesheet per client";
		String actual = selectedElement.getText();
		System.out.println(actual);
		Assert.assertEquals(actual, expected);

	}

	@Test(enabled = false)
	public void verifyClientsCheckBox() {
		WebElement clientsTab = driver.findElement(By.linkText("Clients"));
		clientsTab.click();
		WebElement createClientsTab = driver.findElement(By.linkText("Create Client"));
		createClientsTab.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("client-require_po")));
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement checkBox = driver.findElement(By.xpath("//input[@id='client-require_po']"));
		// js.executeScript("arguments[0].value='1';", checkBox);
		// Actions action = new Actions(driver);
		// action.moveToElement(checkBox).click().perform();
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
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(ops);
		} else if (browser.equals("edge")) {
			WebDriver driver = new EdgeDriver();

		}
		driver.get("https://www.qabible.in/payrollapp/site/login");
		driver.manage().window().maximize();
//		WebElement userName = driver.findElement(By.id("loginform-username"));
//		userName.sendKeys("carol");
//		WebElement password = driver.findElement(By.id("loginform-password"));
//		password.sendKeys("1q2w3e4r");
//		WebElement login = driver.findElement(By.name("login-button"));
//		login.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
