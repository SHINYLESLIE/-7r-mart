package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterTextPage {
	WebDriver driver;

	public ManageFooterTextPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext'and@class='small-box-footer']")
	private WebElement MoreInfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1']")
	private WebElement EditButton;
	@FindBy(xpath = "//textarea[@id='content']")
	private WebElement AddressField;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement EmailField;
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement PhoneNumberField;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement UpdateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement GreenAlert;

	public void clickMoreInfo() {
		MoreInfo.click();
	}

	public void clickEditButton() {
		EditButton.click();
	}

	public void editAddressField(String address) {
		AddressField.clear();
		AddressField.sendKeys(address);
	}

	public void editEmailField(String email) {
		EmailField.clear();
		EmailField.sendKeys(email);
	}

	public void editPhoneNumberField(String phonenumber) {
		PhoneNumberField.clear();
		PhoneNumberField.sendKeys(phonenumber);
	}

	public void clickUpdateButton() {
		UpdateButton.click();
	}

	public boolean isGreenAlertDisplayed() {
		return GreenAlert.isDisplayed();
	}

	public boolean isUpdateButtonPresent() {
		return UpdateButton.isDisplayed();
	}
}



