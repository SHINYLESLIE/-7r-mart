package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver)

	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@name='username']")
	private WebElement usernameField;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signin;
	@FindBy(xpath = "//p[text()='Dashboard']")
	private WebElement dashboard;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement redalert;

	public void enterUserName(String usernamevalue) {
		usernameField.sendKeys(usernamevalue);

	}

	public void enterPassword(String passwordvalue) {
		passwordField.sendKeys(passwordvalue);
	}

	public void clickOnSigninButton() {
		/*
		 * WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		 * wait.until(ExpectedConditions.elementToBeClickable(signin)); signin.click();
		 */

		/*
		 * Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
		 * .withTimeout(Duration.ofSeconds(30)) .pollingEvery(Duration.ofSeconds(5))
		 * .ignoring(NoSuchElementException.class);
		 * fluentWait.until(ExpectedConditions.elementToBeClickable(signin));
		 */

		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForClick(driver, signin);
		signin.click();
	}

	public boolean ifDashboardLoaded() {
		return dashboard.isDisplayed();

	}

	public boolean isAlertDisplayed() {
		return redalert.isDisplayed();
	}

}
