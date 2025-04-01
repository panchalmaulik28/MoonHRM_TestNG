
package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import constant.AppConstant;
import pages.LoginPage;
import utilities.ConfigRead;

public class LoginTest extends BaseTest {

	@Test(priority = 1)
	public void loginWithEmail() {
		loginPage = new LoginPage(driver, wait);
		loginPage.doLogin(ConfigRead.properties("email"), "");
		Assert.assertEquals(loginPage.passwordValidation(), AppConstant.LOGIN_PASSWORDVALIDATION);
	}

	@Test(priority = 2)
	public void loginWithInValidCredentials() {
		loginPage = new LoginPage(driver, wait);
		loginPage.doLogin(ConfigRead.properties("email"), ConfigRead.properties("password") + 1);
		Assert.assertEquals(loginPage.snackBarVisibleAndGetText(), AppConstant.LOGIN_INVALID);
		loginPage.snackBarInvisible();
	}

	@Test(priority = 3)
	public void loginWithValidCredentials() {
		loginPage = new LoginPage(driver, wait);
		loginPage.doLogin(ConfigRead.properties("email"), ConfigRead.properties("password"));
		Assert.assertEquals(loginPage.snackBarVisibleAndGetText(), AppConstant.LOGIN_SUCCESS);
		loginPage.snackBarInvisible();
	}
}