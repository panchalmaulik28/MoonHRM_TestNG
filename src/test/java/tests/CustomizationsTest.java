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
		LoginPage.toastInvisible();
	}

	@Test(dependsOnMethods = "addSkills")
	public void editSkills() {
		customizationsPage = new CustomizationsPage(driver, wait);
		customizationsPage.clickOnSideMenu("Admin");
		customizationsPage.clickOnSideSubMenu("Customizations");
		customizationsPage.clickOnSubMenu("Skills");
		customizationsPage.editCustomizations(data);
		assertEquals(LoginPage.toastMeassage(), AppConstant.SKILL_UPDATE);
		LoginPage.toastInvisible();
	}

	@Test(dependsOnMethods = "editSkills")
	public void deleteSkills() {
		customizationsPage = new CustomizationsPage(driver, wait);
		customizationsPage.clickOnSideMenu("Admin");
		customizationsPage.clickOnSideSubMenu("Customizations");
		customizationsPage.clickOnSubMenu("Skills");
		customizationsPage.deleteCustomizations(data);
		assertEquals(LoginPage.toastMeassage(), AppConstant.SKILL_DELETE);
		LoginPage.toastInvisible();
	}

	@Test(priority = 2)
	public void addDepartment() {
		customizationsPage = new CustomizationsPage(driver, wait);
		customizationsPage.clickOnSideMenu("Admin");
		customizationsPage.clickOnSideSubMenu("Customizations");
		customizationsPage.clickOnSubMenu("Departments");
		customizationsPage.addCustomizations(data);
		assertEquals(LoginPage.toastMeassage(), AppConstant.DEPARTMENT_ADD);
		LoginPage.toastInvisible();
	}

	@Test(dependsOnMethods = "addDepartment")
	public void editDepartment() {
		customizationsPage = new CustomizationsPage(driver, wait);
		customizationsPage.clickOnSideMenu("Admin");
		customizationsPage.clickOnSideSubMenu("Customizations");
		customizationsPage.clickOnSubMenu("Departments");
		customizationsPage.editCustomizations(data);
		assertEquals(LoginPage.toastMeassage(), AppConstant.DEPARTMENT_UPDATE);
		LoginPage.toastInvisible();
	}

	@Test(dependsOnMethods = "editDepartment")
	public void deleteDepartment() {
		customizationsPage = new CustomizationsPage(driver, wait);
		customizationsPage.clickOnSideMenu("Admin");
		customizationsPage.clickOnSideSubMenu("Customizations");
		customizationsPage.clickOnSubMenu("Departments");
		customizationsPage.deleteCustomizations(data);
		assertEquals(LoginPage.toastMeassage(), AppConstant.DEPARTMENT_DELETE);
		LoginPage.toastInvisible();
	}

	@Test(priority = 3)
	public void addPlatform() {
		customizationsPage = new CustomizationsPage(driver, wait);
		customizationsPage.clickOnSideMenu("Admin");
		customizationsPage.clickOnSideSubMenu("Customizations");
		customizationsPage.clickOnSubMenu("Platforms");
		customizationsPage.addCustomizations(data);
		assertEquals(LoginPage.toastMeassage(), AppConstant.PLATFORM_ADD);
		LoginPage.toastInvisible();
	}

	@Test(dependsOnMethods = "addPlatform")
	public void editPlatform() {
		customizationsPage = new CustomizationsPage(driver, wait);
		customizationsPage.clickOnSideMenu("Admin");
		customizationsPage.clickOnSideSubMenu("Customizations");
		customizationsPage.clickOnSubMenu("Platforms");
		customizationsPage.editCustomizations(data);
		assertEquals(LoginPage.toastMeassage(), AppConstant.PLATFORM_UPDATE);
		LoginPage.toastInvisible();
	}

	@Test(dependsOnMethods = "editPlatform")
	public void deletePlatform() {
		customizationsPage = new CustomizationsPage(driver, wait);
		customizationsPage.clickOnSideMenu("Admin");
		customizationsPage.clickOnSideSubMenu("Customizations");
		customizationsPage.clickOnSubMenu("Platforms");
		customizationsPage.deleteCustomizations(data);
		assertEquals(LoginPage.toastMeassage(), AppConstant.PLATFORM_DELETE);
		LoginPage.toastInvisible();
	}

}