package selenium;

import java.awt.desktop.OpenFilesHandler;
import java.io.File;
import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {

	public static void main(String[] args) throws IOException {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://selenium.obsqurazone.com/table-pagination.php");
		driver.manage().window().maximize();
		//Interface & method for Capture Screenshot 
		  TakesScreenshot scrShot =(TakesScreenshot)driver;
		  File screenShot = scrShot.getScreenshotAs(OutputType.FILE);//screenshot will store in temporary path
		  File finalDestination=new File("C:\\Users\\Maru\\Documents\\screenshot\\screenshot.png");
		 FileHandler.copy(screenShot, finalDestination);

		
	}

}
