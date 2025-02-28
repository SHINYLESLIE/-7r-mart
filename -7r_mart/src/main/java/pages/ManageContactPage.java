package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;

public class ManageContactPage {
	WebDriver driver;

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact'and@class='small-box-footer']")
	private WebElement MoreInfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1']")
	private WebElement EditButton;
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement PhoneNumberField;
	@FindBy(xpath = "//textarea[@name='del_time']")
	private WebElement DeliveryTimeField;
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

	public void editPhoneNumberField(String phonenumber) {
		PhoneNumberField.clear();
		PhoneNumberField.sendKeys(phonenumber);
	}

	public void editDeliveryTime(String deliverytime) {
		DeliveryTimeField.clear();
		DeliveryTimeField.sendKeys(deliverytime);
	}

	public void clickUpdateButton() {

		// UpdateButton.click();
		PageUtilities pageutilities = new PageUtilities();
		pageutilities.clickJavaScriptExecutorTest(driver, UpdateButton);
	}

	public boolean isGreenAlertDisplayed() {
		return GreenAlert.isDisplayed();
	}

	public boolean isUpdateButtonEnabled() {
		return UpdateButton.isEnabled();
	}
}
