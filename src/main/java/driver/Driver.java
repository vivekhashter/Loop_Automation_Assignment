package driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.base.Objects;

import config.ConfigFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	public static WebDriver driver;

	public static void initDriver() {
		
		
		WebDriverManager.chromedriver().setup();
		DriverManager.setDriver(driver);
		driver = new ChromeDriver();
		driver.get(ConfigFactory.getConfig().url());
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	

	public static void quitDriver() {
		if(driver!=null) {
		driver.quit();
	}
	}
}
