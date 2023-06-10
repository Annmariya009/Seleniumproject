package elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//By userName=By.id("loginform-username");elements without page factory
	@FindBy(id="loginform-username") //with  page factory
	WebElement userName;
	//By password=By.id("loginform-password");
	@FindBy(id="loginform-password")
	WebElement password;
	//By login=By.name("login-button");
	@FindBy(name="login-button")
	WebElement login;
	public void enterUserName(String UsernameEnter)
	{
	//driver.findElement(userName).sendKeys();
		userName.sendKeys(UsernameEnter);//with pagefactory
		
	}
	public void enterPassword(String passwordEnter)
	{
		//driver.findElement(password).sendKeys(passwordEnter);
		password.sendKeys(passwordEnter);
	}
	public void clickLoginButton()
	{
		//driver.findElement(login).click();
		login.click();
	}
	

		
	
	


}
