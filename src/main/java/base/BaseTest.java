package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pages.LoginPage;
import utilities.ConfigRead;
import utilities.DriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static LoginPage loginPage;
	
	@BeforeTest
	public void init() {
		String URL = ConfigRead.properties("url");
		String browserName = ConfigRead.properties("browser");
		driver = DriverManager.initBrowser(browserName);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.get(URL);
		loginPage = new LoginPage(driver, wait);
	}

	@AfterTest
	public void close() {
		DriverManager.quit();
	}
}
