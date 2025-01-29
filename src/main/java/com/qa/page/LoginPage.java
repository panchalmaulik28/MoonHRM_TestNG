package com.qa.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private static WebDriverWait wait;
	private static WebDriver driver;
	
	public LoginPage(WebDriver driver, WebDriverWait wait) {
		LoginPage.wait = wait;
		LoginPage.driver= driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='email']")
	WebElement emailTxt;

	@FindBy(xpath = "//mat-error[@id='mat-error-3']")
	WebElement emailValidation;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordTxt;
	
	@FindBy(xpath = "//mat-error[@id='mat-error-0']")
	WebElement passwordValidation;
	
	@FindBy(css = "button#login_click")
	WebElement loginBtn;

	@FindBy(xpath = "//simple-snack-bar[contains(@class,'mat-simple-snackbar')]/span")
	WebElement simpleSnackBarToast;
	
	@FindBy(xpath = "//div[contains(@class,'toast-message')]")
	static WebElement toastMessageRes;

	public void doLogin(String email, String password) {
		emailTxt.sendKeys(email);
		passwordTxt.sendKeys(password);
		loginBtn.click();
	}
	
	public String snackBarVisibleAndGetText() {
		wait.until(ExpectedConditions.visibilityOf(simpleSnackBarToast));
		return simpleSnackBarToast.getText().trim();
	}
	
	public void snackBarInvisible() {
		wait.until(ExpectedConditions.invisibilityOf(simpleSnackBarToast));
	}
	
	public String emailValidation() {
		wait.until(ExpectedConditions.visibilityOf(emailValidation));
		return emailValidation.getText();
	}

	public String passwordValidation() {
		wait.until(ExpectedConditions.visibilityOf(passwordValidation));
		return passwordValidation.getText();
	}
	
	public static String toastMeassage() {
		wait.until(ExpectedConditions.visibilityOf(toastMessageRes));
		return toastMessageRes.getText();
	}
}