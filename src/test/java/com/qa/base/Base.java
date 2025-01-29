package com.qa.base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.factory.Factory;
import com.qa.page.LoginPage;

public class Base {

	Factory factory;
	public static Properties prop;
	public static WebDriver driver;
	protected static WebDriverWait wait;
	public static LoginPage loginPage;

	@BeforeMethod
	public void init() {
		factory = new Factory();
		prop = factory.properties();
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver = factory.initBrowser(prop);
		loginPage = new LoginPage(driver, wait);
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}
}
