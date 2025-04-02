package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private static WebDriverWait wait;

	public LoginPage(WebDriver driver, WebDriverWait wait) {
		LoginPage.wait = wait;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='email']")
	WebElement emailTxt;

	@FindBy(xpath = "//form[contains(@class,'position_relative ')]/mat-form-field[1]/div[2]/div/mat-error")
	WebElement emailValidation;

	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordTxt;

	@FindBy(xpath = "//form[contains(@class,'position_relative ')]/mat-form-field[2]/div[2]/div/mat-error")
	WebElement passwordValidation;

	@FindBy(css = "button#login_click")
	WebElement loginBtn;

	@FindBy(xpath = "//simple-snack-bar[contains(@class,'mat-mdc-simple-snack-bar')]/div")
	WebElement simpleSnackBarToast;

	@FindBy(xpath = "//div[contains(@class,'toast-message')]")
	static WebElement toastMessages;

	By snackBar = By.xpath("//simple-snack-bar[contains(@class,'mat-mdc-simple-snack-bar')]/div");
	
	public void doLogin(String email, String password) {
		emailTxt.clear();
		emailTxt.sendKeys(email);
		passwordTxt.clear();
		passwordTxt.sendKeys(password);
		loginBtn.click();
	}

	public String snackBarVisibleAndGetText() {
		wait.until(ExpectedConditions.presenceOfElementLocated(snackBar));
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
		wait.until(ExpectedConditions.visibilityOf(toastMessages));
		return toastMessages.getText();
	}

	public static void toastInvisible() {
		wait.until(ExpectedConditions.invisibilityOf(toastMessages));
	}
}