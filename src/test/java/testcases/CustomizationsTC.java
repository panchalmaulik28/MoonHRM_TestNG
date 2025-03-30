package testcases;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import base.BaseTest;
import constant.AppConstant;
import page.CustomizationsPage;
import page.LoginPage;

public class CustomizationsTC extends BaseTest {
	LoginTC loginTC = new LoginTC();
	static LoginPage loginPage;
	static CustomizationsPage customizationsPage;
	private String data = "Selenuim Automation";

	@Test(priority = 1)
	public void addSkills() {
		loginTC.loginWithValidCredentials();
		customizationsPage = new CustomizationsPage(driver, wait);
		customizationsPage.clickOnSideMenu("Admin");
		customizationsPage.clickOnSideSubMenu("Customizations");
		customizationsPage.clickOnSubMenu("Skills");
		customizationsPage.addCustomizations(data);
		assertEquals(LoginPage.toastMeassage(), AppConstant.SKILL_ADD);
	}

	@Test(dependsOnMethods = "addSkills")
	public void editSkills() {
		loginTC.loginWithValidCredentials();
		customizationsPage = new CustomizationsPage(driver, wait);
		customizationsPage.clickOnSideMenu("Admin");
		customizationsPage.clickOnSideSubMenu("Customizations");
		customizationsPage.clickOnSubMenu("Skills");
		customizationsPage.editCustomizations(data);
		assertEquals(LoginPage.toastMeassage(), AppConstant.SKILL_UPDATE);
	}

	@Test(dependsOnMethods = "editSkills")
	public void deleteSkills() {
		loginTC.loginWithValidCredentials();
		customizationsPage = new CustomizationsPage(driver, wait);
		customizationsPage.clickOnSideMenu("Admin");
		customizationsPage.clickOnSideSubMenu("Customizations");
		customizationsPage.clickOnSubMenu("Skills");
		customizationsPage.deleteCustomizations(data);
		assertEquals(LoginPage.toastMeassage(), AppConstant.SKILL_DELETE);
	}
}