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
	private String name = "Selenuim Automation";
	private String roleType = "Dev";
	private String roleTypeUpdate = "TL";
	private String managerName = "CEO CEO";
	private String managerNameUpdate = "Maulik Panchal";

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
		customizationsPage.addSkillDepartmentPlatform(name);
		assertEquals(LoginPage.toastMeassage(), AppConstant.SKILL_ADD);
		LoginPage.toastInvisible();
	}

	@Test(dependsOnMethods = "addSkills")
	public void editSkills() {
		customizationsPage = new CustomizationsPage(driver, wait);
		customizationsPage.clickOnSideMenu("Admin");
		customizationsPage.clickOnSideSubMenu("Customizations");
		customizationsPage.clickOnSubMenu("Skills");
		customizationsPage.editSkillDepartmentPlatform(name);
		assertEquals(LoginPage.toastMeassage(), AppConstant.SKILL_UPDATE);
		LoginPage.toastInvisible();
	}

	@Test(dependsOnMethods = "editSkills")
	public void deleteSkills() {
		customizationsPage = new CustomizationsPage(driver, wait);
		customizationsPage.clickOnSideMenu("Admin");
		customizationsPage.clickOnSideSubMenu("Customizations");
		customizationsPage.clickOnSubMenu("Skills");
		customizationsPage.deleteSkillDepartmentPlatform(name);
		assertEquals(LoginPage.toastMeassage(), AppConstant.SKILL_DELETE);
		LoginPage.toastInvisible();
	}

	@Test(priority = 2)
	public void addDepartment() {
		customizationsPage = new CustomizationsPage(driver, wait);
		customizationsPage.clickOnSideMenu("Admin");
		customizationsPage.clickOnSideSubMenu("Customizations");
		customizationsPage.clickOnSubMenu("Departments");
		customizationsPage.addSkillDepartmentPlatform(name);
		assertEquals(LoginPage.toastMeassage(), AppConstant.DEPARTMENT_ADD);
		LoginPage.toastInvisible();
	}

	@Test(dependsOnMethods = "addDepartment")
	public void editDepartment() {
		customizationsPage = new CustomizationsPage(driver, wait);
		customizationsPage.clickOnSideMenu("Admin");
		customizationsPage.clickOnSideSubMenu("Customizations");
		customizationsPage.clickOnSubMenu("Departments");
		customizationsPage.editSkillDepartmentPlatform(name);
		assertEquals(LoginPage.toastMeassage(), AppConstant.DEPARTMENT_UPDATE);
		LoginPage.toastInvisible();
	}

	@Test(dependsOnMethods = "editDepartment")
	public void deleteDepartment() {
		customizationsPage = new CustomizationsPage(driver, wait);
		customizationsPage.clickOnSideMenu("Admin");
		customizationsPage.clickOnSideSubMenu("Customizations");
		customizationsPage.clickOnSubMenu("Departments");
		customizationsPage.deleteSkillDepartmentPlatform(name);
		assertEquals(LoginPage.toastMeassage(), AppConstant.DEPARTMENT_DELETE);
		LoginPage.toastInvisible();
	}

	@Test(priority = 3)
	public void addPlatform() {
		customizationsPage = new CustomizationsPage(driver, wait);
		customizationsPage.clickOnSideMenu("Admin");
		customizationsPage.clickOnSideSubMenu("Customizations");
		customizationsPage.clickOnSubMenu("Platforms");
		customizationsPage.addSkillDepartmentPlatform(name);
		assertEquals(LoginPage.toastMeassage(), AppConstant.PLATFORM_ADD);
		LoginPage.toastInvisible();
	}

	@Test(dependsOnMethods = "addPlatform")
	public void editPlatform() {
		customizationsPage = new CustomizationsPage(driver, wait);
		customizationsPage.clickOnSideMenu("Admin");
		customizationsPage.clickOnSideSubMenu("Customizations");
		customizationsPage.clickOnSubMenu("Platforms");
		customizationsPage.editSkillDepartmentPlatform(name);
		assertEquals(LoginPage.toastMeassage(), AppConstant.PLATFORM_UPDATE);
		LoginPage.toastInvisible();
	}

	@Test(dependsOnMethods = "editPlatform")
	public void deletePlatform() {
		customizationsPage = new CustomizationsPage(driver, wait);
		customizationsPage.clickOnSideMenu("Admin");
		customizationsPage.clickOnSideSubMenu("Customizations");
		customizationsPage.clickOnSubMenu("Platforms");
		customizationsPage.deleteSkillDepartmentPlatform(name);
		assertEquals(LoginPage.toastMeassage(), AppConstant.PLATFORM_DELETE);
		LoginPage.toastInvisible();
	}

	@Test(priority = 4)
	public void addDesignations() {
		customizationsPage = new CustomizationsPage(driver, wait);
		customizationsPage.clickOnSideMenu("Admin");
		customizationsPage.clickOnSideSubMenu("Customizations");
		customizationsPage.clickOnSubMenu("Designations");
		customizationsPage.addDesignationsTeamsGroups(name, roleType);
		assertEquals(LoginPage.toastMeassage(), AppConstant.DESIGNATION_ADD);
		LoginPage.toastInvisible();
	}

	@Test//(dependsOnMethods = "addDesignations")
	public void editDesignations() {
		customizationsPage = new CustomizationsPage(driver, wait);
		customizationsPage.clickOnSideMenu("Admin");
		customizationsPage.clickOnSideSubMenu("Customizations");
		customizationsPage.clickOnSubMenu("Designations");
		customizationsPage.editDesignationsTeamsGroups(name, roleTypeUpdate);
		assertEquals(LoginPage.toastMeassage(), AppConstant.DESIGNATION_UPDATE);
		LoginPage.toastInvisible();
	}

	@Test(dependsOnMethods = "editDesignations")
	public void deleteDesignations() {
		customizationsPage = new CustomizationsPage(driver, wait);
		customizationsPage.clickOnSideMenu("Admin");
		customizationsPage.clickOnSideSubMenu("Customizations");
		customizationsPage.clickOnSubMenu("Designations");
		customizationsPage.deleteDesignationsTeamsGroups(name);
		assertEquals(LoginPage.toastMeassage(), AppConstant.DESIGNATION_DELETE);
		LoginPage.toastInvisible();
	}

	@Test(priority = 5)
	public void addTeams() {
		customizationsPage = new CustomizationsPage(driver, wait);
		customizationsPage.clickOnSideMenu("Admin");
		customizationsPage.clickOnSideSubMenu("Customizations");
		customizationsPage.clickOnSubMenu("Teams");
		customizationsPage.addDesignationsTeamsGroups(name, managerName);
		assertEquals(LoginPage.toastMeassage(), AppConstant.TEAM_ADD);
		LoginPage.toastInvisible();
	}

	@Test(dependsOnMethods = "addTeams")
	public void editTeams() {
		customizationsPage = new CustomizationsPage(driver, wait);
		customizationsPage.clickOnSideMenu("Admin");
		customizationsPage.clickOnSideSubMenu("Customizations");
		customizationsPage.clickOnSubMenu("Teams");
		customizationsPage.editDesignationsTeamsGroups(name, managerNameUpdate);
		assertEquals(LoginPage.toastMeassage(), AppConstant.TEAM_UPDATE);
		LoginPage.toastInvisible();
	}

	@Test(dependsOnMethods = "editTeams")
	public void deleteTeams() {
		customizationsPage = new CustomizationsPage(driver, wait);
		customizationsPage.clickOnSideMenu("Admin");
		customizationsPage.clickOnSideSubMenu("Customizations");
		customizationsPage.clickOnSubMenu("Teams");
		customizationsPage.deleteDesignationsTeamsGroups(name);
		assertEquals(LoginPage.toastMeassage(), AppConstant.TEAM_DELETE);
		LoginPage.toastInvisible();
	}

	@Test(priority = 6)
	public void addGroups() {
		customizationsPage = new CustomizationsPage(driver, wait);
		customizationsPage.clickOnSideMenu("Admin");
		customizationsPage.clickOnSideSubMenu("Customizations");
		customizationsPage.clickOnSubMenu("Groups");
		customizationsPage.addDesignationsTeamsGroups(name, managerName);
		assertEquals(LoginPage.toastMeassage(), AppConstant.GROUP_ADD);
		LoginPage.toastInvisible();
	}

	@Test(dependsOnMethods = "addGroups")
	public void editGroups() {
		customizationsPage = new CustomizationsPage(driver, wait);
		customizationsPage.clickOnSideMenu("Admin");
		customizationsPage.clickOnSideSubMenu("Customizations");
		customizationsPage.clickOnSubMenu("Groups");
		customizationsPage.editDesignationsTeamsGroups(name, managerName);
		assertEquals(LoginPage.toastMeassage(), AppConstant.GROUP_UPDATE);
		LoginPage.toastInvisible();
	}

	@Test(dependsOnMethods = "editGroups")
	public void deleteGroups() {
		customizationsPage = new CustomizationsPage(driver, wait);
		customizationsPage.clickOnSideMenu("Admin");
		customizationsPage.clickOnSideSubMenu("Customizations");
		customizationsPage.clickOnSubMenu("Groups");
		customizationsPage.deleteDesignationsTeamsGroups(name);
		assertEquals(LoginPage.toastMeassage(), AppConstant.GROUP_DELETE);
		LoginPage.toastInvisible();
	}
}