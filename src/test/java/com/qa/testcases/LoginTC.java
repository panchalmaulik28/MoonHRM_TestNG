
package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.base.Base;
import com.qa.constant.AppConstant;

public class LoginTC extends Base {
 
	@Test(priority = 1)
	public void loginWithEmail() { 
		loginPage.doLogin(prop.getProperty("email"), "");
		Assert.assertEquals(loginPage.passwordValidation(), AppConstant.LOGIN_PASSWORDVALIDATION);
	}

	@Test(priority = 2)
	public void loginWithInValidCredentials() {
		loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password") + 1);
		Assert.assertEquals(loginPage.snackBarVisibleAndGetText(), AppConstant.LOGIN_INVALID);
		loginPage.snackBarInvisible();
	}

	@Test(priority = 3)
	public void loginWithValidCredentials() {
		loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
		Assert.assertEquals(loginPage.snackBarVisibleAndGetText(), AppConstant.LOGIN_SUCCESS);
		loginPage.snackBarInvisible();
	
	}
}