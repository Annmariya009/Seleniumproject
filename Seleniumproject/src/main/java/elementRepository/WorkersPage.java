package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class WorkersPage {
	private static final int i = 0;
	WebDriver driver;

	public WorkersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText = "Workers")
	WebElement workersTab;
	@FindBy(xpath = "//table[@class='table table-striped table-bordered']//tbody//tr//td[2]")
	List<WebElement> ColumnElements;
	@FindBy(xpath = "//button[text()='Search']")
	WebElement workersTabSearch;

	public void clickWorkersTab() {
		workersTab.click();
	}

	public String deleteToolTip() {
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
		String title = deleteToolTip.getAttribute("title");
		return title;
		// String expected = "Delete";
		// Assert.assertEquals(actual, expected, "********not matching with expected
		// result");
	}

	public String verifyWorkersTabSearchButtonText() {
		String text = workersTabSearch.getText();
		return text;
	}

	public String verifyWorkersTabBackgroundColor() {
		String backgroundColor = workersTabSearch.getCssValue("background-color");
		return backgroundColor;
	}
}
