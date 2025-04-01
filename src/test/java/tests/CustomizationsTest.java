package tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.BaseTest;
import constant.AppConstant;
import pages.CustomizationsPage;
import pages.LoginPage;

public class CustomizationsTest extends BaseTest {
	CustomizationsPage customizationsPage;
	private String data = "Selenuim Automation";

	@BeforeClass
	public void login() {
		LoginTest loginTC = new LoginTest();
		loginTC.loginWithValidCredentials();
	}

	@Test(priority = 1)
	public void addSkills() {
		customizationsPage = new CustomizationsPage(driver, wait);
		customizationsPage.clickOnSideMenu("Admin");
		customizationsPage.clickOnSideSubMenu("Customizations");
		customizationsPage.clickOnSubMenu("Skills");
		customizationsPage.addCustomizations(data);
		assertEquals(LoginPage.toastMeassage(), AppConstant.SKILL_ADD);
	}

	@Test(dependsOnMethods = "addSkills")
	public void editSkills() {
		customizationsPage = new CustomizationsPage(driver, wait);
		customizationsPage.clickOnSideMenu("Admin");
		customizationsPage.clickOnSideSubMenu("Customizations");
		customizationsPage.clickOnSubMenu("Skills");
		customizationsPage.editCustomizations(data);
		assertEquals(LoginPage.toastMeassage(), AppConstant.SKILL_UPDATE);
	}

	@Test(dependsOnMethods = "editSkills")
	public void deleteSkills() {
		customizationsPage = new CustomizationsPage(driver, wait);
		customizationsPage.clickOnSideMenu("Admin");
		customizationsPage.clickOnSideSubMenu("Customizations");
		customizationsPage.clickOnSubMenu("Skills");
		customizationsPage.deleteCustomizations(data);
		assertEquals(LoginPage.toastMeassage(), AppConstant.SKILL_DELETE);
	}
}