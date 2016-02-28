package browserSearch;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GmailLogin {
	
	public static WebDriver driver;
	
	@BeforeClass	
	public static Properties getProp() throws IOException  {		
		
		FileInputStream fis1 = new FileInputStream("E:\\Google\\google.properties");
			Properties pAndCust = new Properties();
			pAndCust.load(fis1);
			return pAndCust;
	}
	
	@Test
	public void gmailLogin() throws IOException, InterruptedException{
		driver = new FirefoxDriver();
		//String userName = null;
		driver.get(getProp().getProperty("url"));
		driver.findElement(By.id("Email")).sendKeys(getProp().getProperty("userName"));
		driver.findElement(By.id("next")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("Passwd")).sendKeys(getProp().getProperty("passWord"));
		driver.findElement(By.id("signIn")).click();
	}

	
}
