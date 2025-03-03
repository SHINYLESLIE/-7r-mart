package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;

public class AdminUsersPage {
	WebDriver driver;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'and@class='small-box-footer']")
	private WebElement admoreinfo;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement adnewbutton;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement adusernamefield;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement adpasswordfield;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement adusertypefield;
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement adsavebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement adgreenalert;
	@FindBy(xpath = "//i[@class='fa fa-save']")
	private WebElement adsavebutton2;

	public void clickOnMoreInfo() {
		admoreinfo.click();
	}

	public void clickOnNewButton() {
		adnewbutton.click();
	}

	public void enterNewUserName(String newusernamevalue) {
		adusernamefield.sendKeys(newusernamevalue);
	}

	public void enterNewPassWord(String newpasswordvalue) {
		adpasswordfield.sendKeys(newpasswordvalue);
	}

	public void selectUserType() {
		// Select select= new Select(adusertypefield);
		// select.selectByIndex(4);

		PageUtilities pageutility = new PageUtilities();
		pageutility.selectByIndex(adusertypefield, 4);
	}

	public void clickOnSaveButton() {
		adsavebutton.click();
	}

	public boolean isGreenAlertDisplayed() {
		return adgreenalert.isDisplayed();
	}

	public boolean isSaveButtonDisplayed() {
		return adsavebutton2.isDisplayed();
	}

}
