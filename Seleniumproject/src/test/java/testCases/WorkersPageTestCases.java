package testCases;

import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.WorkersPage;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class WorkersPageTestCases {
	WebDriver driver;
	LoginPage lp;
	WorkersPage wp;

	@Test
	public void verifyDeleteToolTip() {
		lp = new LoginPage(driver);
		lp.enterUserName("carol");
		lp.enterPassword("1q2w3e4r");
		lp.clickLoginButton();
		wp = new WorkersPage(driver);
		wp.clickWorkersTab();
		String expected = "Delete";
		String actual = wp.deleteToolTip();
		Assert.assertEquals(actual, expected, "not matching");
	}
	@Test
	public void verifyWorkersTabSearchButtonText() {
		lp = new LoginPage(driver);
		lp.enterUserName("carol");
		lp.enterPassword("1q2w3e4r");
		lp.clickLoginButton();
		wp = new WorkersPage(driver);
		wp.clickWorkersTab();
		String actualText = wp.verifyWorkersTabSearchButtonText();
		String expectedText = "Search";
		Assert.assertEquals(actualText, expectedText, "not matching");
	}

	@Test
	public void verifyWorkersTabBackgroundColor() {
		lp = new LoginPage(driver);
		lp.enterUserName("carol");
		lp.enterPassword("1q2w3e4r");
		lp.clickLoginButton();
		wp = new WorkersPage(driver);
		wp.clickWorkersTab();
		String expectedColor = "rgba(51, 122, 183, 1)";
		String actualColor = wp.verifyWorkersTabBackgroundColor();
		Assert.assertEquals(actualColor, expectedColor, "not matching");

	}

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.get("https://www.qabible.in/payrollapp/site/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
