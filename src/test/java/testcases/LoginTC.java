
package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import constant.AppConstant;
import page.LoginPage;
import utilities.ConfigRead;

public class LoginTC extends BaseTest {
	static LoginPage loginPage;

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
	//	Assert.assertEquals(loginPage.snackBarVisibleAndGetText(), AppConstant.LOGIN_SUCCESS);
	//	loginPage.snackBarInvisible();
	}
}