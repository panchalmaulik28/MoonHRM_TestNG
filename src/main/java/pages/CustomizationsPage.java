package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomizationsPage {

	static WebDriver driver;
	static WebDriverWait wait;

	public CustomizationsPage(WebDriver driver, WebDriverWait wait) {
		CustomizationsPage.driver = driver;
		CustomizationsPage.wait = wait;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[contains(@class,'menu-button')]")
	WebElement menuBtn;

	@FindBy(xpath = "//button[contains(@class,'action-button two')]")
	WebElement menuAddBtn;

	@FindBy(xpath = "//input[@formcontrolname='name']")
	WebElement nameTxt;

	@FindBy(xpath = "//div[contains(@class,'popup_footer_div')]/button[2]")
	WebElement saveBtn;

	@FindBy(xpath = "//div[@role='menu']/div/button[1]")
	WebElement editBtn;

	@FindBy(xpath = "//div[@role='menu']/div/button[2]")
	WebElement deleteBtn;

	@FindBy(xpath = "//tbody[@role='rowgroup']")
	WebElement table;

	@FindBy(xpath = "//div[contains(@class,'popup_body_div')] //mat-select[@role='combobox']")
	WebElement userRoledropdown;

	By sideMenuList = By.xpath("//span[contains(@class,'mat-mdc-list-item-unscoped-content')]/span");
	By sideMenuDDList = By.xpath("//mat-expansion-panel-header[@role='button']/span/mat-panel-title/span");
	By subMenuList = By.xpath("//div[@class='list_item']/ul/li");
	By customiztionNameList = By.xpath("//tbody[@role='rowgroup']/tr/td[1]");
	By customiztionListAction = By.xpath("//tbody[@role='rowgroup']/tr[10]/td/button");
	By listValue = By.xpath("//mat-option[@role='option']/span");

	public void clickOnSideMenu(String value) {
		List<WebElement> list = driver.findElements(sideMenuDDList);
		if (list.size() != 0) {
			for (WebElement e : list) {
				if (e.getText().trim().equals(value)) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView();", e);
					e.click();
					break;
				}
			}
		} else {
			clickOnSideMenu(value);
		}
	}

	public void clickOnSideSubMenu(String value) {
		List<WebElement> list = driver.findElements(sideMenuList);
		if (list.size() != 0) {
			for (WebElement e : list) {
				if (e.getText().trim().equals(value)) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView();", e);
					e.click();
					break;
				}
			}
		} else {
			clickOnSideSubMenu(value);
		}
	}

	public void clickOnSubMenu(String listMenu) {
		List<WebElement> list = driver.findElements(subMenuList);
		for (WebElement e : list) {
			if (e.getText().trim().contains(listMenu.trim())) {
				e.click();
				break;
			}
		}
	}

	public void addSkillDepartmentPlatform(String name) {
		wait.until(ExpectedConditions.elementToBeClickable(menuBtn));
		menuBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(menuAddBtn));
		menuAddBtn.click();
		nameTxt.sendKeys(name);
		saveBtn.click();
	}

	public void editSkillDepartmentPlatform(String data) {
		int editActionTemp = 0;
		List<WebElement> list = driver.findElements(customiztionNameList);
		if (list.size() != 0) {
			for (WebElement e : list) {
				if (e.getText().trim().equalsIgnoreCase(data.trim())) {
					editActionTemp = list.indexOf(e) + 1;
					int scrollto = list.indexOf(e) - 2;
					WebElement x = driver
							.findElement(By.xpath("//tbody[@role='rowgroup']/tr[" + scrollto + "]/td/button/mat-icon"));
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView();", x);
					WebElement y = driver
							.findElement(By.xpath("//tbody[@role='rowgroup']/tr[" + editActionTemp + "]/td/button/mat-icon"));
					wait.until(ExpectedConditions.elementToBeClickable(y));
					y.click();
					editBtn.click();
					wait.until(ExpectedConditions.textToBePresentInElementValue(nameTxt, data));
					nameTxt.clear();
					nameTxt.sendKeys(data + " Update");
					saveBtn.click();
					break;
				}
			}
		} else {
			editSkillDepartmentPlatform(data);
		}
	}

	public void deleteSkillDepartmentPlatform(String data) {
		wait.until(ExpectedConditions.visibilityOf(table));
		int editActionTemp = 0;
		List<WebElement> list = driver.findElements(customiztionNameList);
		if (list.size() != 0) {
			for (WebElement e : list) {
				if (e.getText().trim().equalsIgnoreCase(data.trim() + " Update")) {
					editActionTemp = list.indexOf(e) + 1;
					int scrollto = list.indexOf(e) - 2;
					WebElement x = driver.findElement(By.xpath("//tbody[@role='rowgroup']/tr[" + scrollto + "]/td/button/mat-icon"));
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView();", x);
					WebElement y = driver.findElement(By.xpath("//tbody[@role='rowgroup']/tr[" + editActionTemp + "]/td/button/mat-icon"));
					wait.until(ExpectedConditions.elementToBeClickable(y));
					y.click();
					deleteBtn.click();
					saveBtn.click();
					break;
				}
			}
		} else {
			deleteSkillDepartmentPlatform(data);
		}
	}

	public void addDesignationsTeamsGroups(String designationName, String roleType) {
		wait.until(ExpectedConditions.elementToBeClickable(menuBtn));
		menuBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(menuAddBtn));
		menuAddBtn.click();
		nameTxt.sendKeys(designationName);
		wait.until(ExpectedConditions.elementToBeClickable(userRoledropdown));
		userRoledropdown.click();
		List<WebElement> list = driver.findElements(listValue);
		for (WebElement e : list) {
			if (e.getText().trim().equals(roleType.trim())) {
				e.click();
				break;
			}
		}
		wait.until(ExpectedConditions.invisibilityOfElementLocated(listValue));
		saveBtn.click();
	}

	public void editDesignationsTeamsGroups(String name, String roleTypeUpdate) {
		int editActionTemp = 0;
		List<WebElement> list = driver.findElements(customiztionNameList);
		if (list.size() != 0) {
			for (WebElement e : list) {
				if (e.getText().trim().contentEquals(name.trim())) {
					editActionTemp = list.indexOf(e) + 1;
					int scrollto = list.indexOf(e) - 2;
					WebElement x = driver.findElement(By.xpath("//tbody[@role='rowgroup']/tr[" + scrollto + "]/td/button"));
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView();", x);
					WebElement y = driver.findElement(By.xpath("//tbody[@role='rowgroup']/tr[" + editActionTemp + "]/td/button"));
					wait.until(ExpectedConditions.elementToBeClickable(y));
					y.click();
					editBtn.click();
					wait.until(ExpectedConditions.textToBePresentInElementValue(nameTxt, name));
					nameTxt.clear();
					nameTxt.sendKeys(name + " Update");
					userRoledropdown.click();
					wait.until(ExpectedConditions.elementToBeClickable(userRoledropdown));
					List<WebElement> rolelist = driver.findElements(listValue);
					for (WebElement f : rolelist) {
						if (f.getText().trim().equals(roleTypeUpdate.trim())) {
							f.click();
							break;
						}
					}
					wait.until(ExpectedConditions.invisibilityOfElementLocated(listValue));
					saveBtn.click();
					break;
				}
			}
		} else {
			editDesignationsTeamsGroups(name, roleTypeUpdate);
		}
	}

	public void deleteDesignationsTeamsGroups(String name) {
		int editActionTemp = 0;
		List<WebElement> list = driver.findElements(customiztionNameList);
		if (list.size() != 0) {
		   for (WebElement e : list) {
				if (e.getText().trim().contentEquals(name.trim() + " Update")) {
					editActionTemp = list.indexOf(e) + 1;
					//int scrollto = list.indexOf(e) - 2;
					WebElement x = driver.findElement(By.xpath("//tbody[@role='rowgroup']/tr[" + editActionTemp + "]/td/button"));
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView();", x);
					WebElement y = driver.findElement(By.xpath("//tbody[@role='rowgroup']/tr[" + editActionTemp + "]/td/button"));
					wait.until(ExpectedConditions.elementToBeClickable(y));
					y.click();
					deleteBtn.click();
					saveBtn.click();
					break;
				}
			}
		} else {
			deleteDesignationsTeamsGroups(name);
		}
	}

}