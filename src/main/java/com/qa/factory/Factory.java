package com.qa.factory;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Factory {

	static WebDriver driver;
	Properties prop;

	public WebDriver initBrowser(Properties properties) {
		String url = (String) properties.get("url");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies(); 
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}

	public Properties properties() {
		try {
			prop = new Properties();
			FileReader file = new FileReader(".\\src\\test\\resources\\properties\\config.properties");
			prop.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	
	
	
}
