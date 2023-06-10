package elementRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClientsPage {
	WebDriver driver;

	public ClientsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// By client = By.xpath("//a[@href='/payrollapp/client/index']");
	@FindBy(xpath = "//a[@href='/payrollapp/client/index']")
	WebElement client;
	//By searchButton = By.xpath("//button[text()='Search']");
	@FindBy(xpath="//button[text()='Search']")
	WebElement searchButton;
	
	@FindBy(linkText  = "Create Client")
	WebElement createClient;
	@FindBy(id = "client-invoice_order")
	WebElement invoiceOrder;
	@FindBy(xpath = "//input[@id='client-require_po']")
	WebElement checkBox;

	public void clickClient() {
		// driver.findElement(client).click();
		client.click();
	}

	public String verifySearchButtonText() {
		//String text = driver.findElement(searchButton).getText();
		String text=searchButton.getText();
		return text;

	}

	public void clickCreateClient() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)", "");

		createClient.click();
	}

	public String selectInvoiceOrder() {
		Select obj = new Select(invoiceOrder);
		obj.selectByIndex(1);
		WebElement selectedValue = obj.getFirstSelectedOption();
		String text = selectedValue.getText();
		return text;

	}

	public void clickCheckBox() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)", "");
		checkBox.click();
		
	}

	public boolean isSelectedCheckBox() {
		boolean checkBoxSelected = checkBox.isSelected();
		return checkBoxSelected;

	}
}
