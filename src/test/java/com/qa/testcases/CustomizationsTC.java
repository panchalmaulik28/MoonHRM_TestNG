package com.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.base.Base;
import com.qa.constant.AppConstant;
import com.qa.page.CustomizationsPage;
import com.qa.page.LoginPage;

public class CustomizationsTC extends Base{

	CustomizationsPage customizationsPage;
	private String data = "Hello World";
	
	@Test(priority = 1)
	public void addSkills() {
		loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
		Assert.assertEquals(loginPage.snackBarVisibleAndGetText(), AppConstant.LOGIN_SUCCESS);
		customizationsPage = new CustomizationsPage(driver, wait);
		customizationsPage.navigateToAdminSettings("Customizations");
		customizationsPage.clickOnSubMenu("Skills");
		customizationsPage.addCustomizations(data);
		assertEquals(LoginPage.toastMeassage(), AppConstant.SKILL_ADD);
	}

	@Test(dependsOnMethods = "addSkills")
	public void editSkills() {
		loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
		Assert.assertEquals(loginPage.snackBarVisibleAndGetText(), AppConstant.LOGIN_SUCCESS);
		customizationsPage = new CustomizationsPage(driver, wait);
		customizationsPage.navigateToAdminSettings("Customizations");
		customizationsPage.clickOnSubMenu("Skills");
		customizationsPage.editCustomizations(data);
		assertEquals(LoginPage.toastMeassage(), AppConstant.SKILL_UPDATE);
	}
	
	@Test(dependsOnMethods = "editSkills")
	public void deleteSkills() {
		loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
		Assert.assertEquals(loginPage.snackBarVisibleAndGetText(), AppConstant.LOGIN_SUCCESS);
		customizationsPage = new CustomizationsPage(driver, wait);
		customizationsPage.navigateToAdminSettings("Customizations");
		customizationsPage.clickOnSubMenu("Skills");
		customizationsPage.deleteCustomizations(data);
		assertEquals(LoginPage.toastMeassage(), AppConstant.SKILL_DELETE);	
	}
}