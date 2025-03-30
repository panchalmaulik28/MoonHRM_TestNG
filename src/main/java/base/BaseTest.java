package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigRead;
import utilities.DriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static WebDriverWait wait;

	@BeforeMethod
	public WebDriver init() {
		String URL = ConfigRead.properties("url");
		String browserName = ConfigRead.properties("browser");
		driver = DriverManager.initBrowser(browserName);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.get(URL);
		return  driver;
	}

	@AfterMethod
	public void close() {
		DriverManager.quit();
	}
}
