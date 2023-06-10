package testCases;

import org.testng.annotations.Test;

import elementRepository.ClientsPage;
import elementRepository.LoginPage;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class ClientsPageTestCases {
	WebDriver driver;
	LoginPage lp;
	ClientsPage cp;

	@Test
	public void verifySearchButtontext()  {
		lp = new LoginPage(driver);
		lp.enterUserName("carol");
		lp.enterPassword("1q2w3e4r");
		lp.clickLoginButton();
		cp = new ClientsPage(driver);
		cp.clickClient();
		String expected = "Search";
		String actual = cp.verifySearchButtonText();
		Assert.assertEquals(actual, expected, "not matching");
	}
	@Test
	public void VerifyCreateClientsTabInvoiceOrderDropdown()
		
		{
		lp = new LoginPage(driver);
		lp.enterUserName("carol");
		lp.enterPassword("1q2w3e4r");
		lp.clickLoginButton();
		cp = new ClientsPage(driver);
		cp.clickClient();
		cp.clickCreateClient();
		String expectedResult = "Single timesheet per client";
		String actualResult = cp.selectInvoiceOrder();
		Assert.assertEquals(actualResult, expectedResult, "not matching");
		}
	@Test
	public void VerifyCreateClientsTabRequirePoCheckBox()
	
	{ 
		lp = new LoginPage(driver);
		lp.enterUserName("carol");
		lp.enterPassword("1q2w3e4r");
		lp.clickLoginButton();
		cp = new ClientsPage(driver);
		cp.clickClient();
		cp.clickCreateClient();
		cp.clickCheckBox();
		boolean expectedValue=true;
		boolean actualValue=cp.isSelectedCheckBox();
		Assert.assertEquals(actualValue, expectedValue,"not matching");
		
		
		
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
