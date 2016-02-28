package browserSearch;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FailScreenshot {
	
	public WebDriver driver;
	
	@BeforeClass
	public void loggingIn() throws InterruptedException
	{
		driver = new FirefoxDriver();
		driver.get("http://www.gmail.com");
		driver.findElement(By.id("Email")).sendKeys("dksmailbox@gmail.com");
		driver.findElement(By.id("next")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("Passwd")).sendKeys("Password");
		driver.findElement(By.id("signIn")).click();
	}
	
	@Test
	public void getScreenshot() throws IOException, InterruptedException
	{
		Thread.sleep(1000);
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with name "screenshot.png"
           FileUtils.copyFile(scrFile, new File("E:\\screenshot.png"));
	}

}
