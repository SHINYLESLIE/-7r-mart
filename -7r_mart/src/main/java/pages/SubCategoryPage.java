package pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtilities;

public class SubCategoryPage {
	WebDriver driver;

	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category'and@class='small-box-footer']")
	private WebElement MoreInfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Subcategory/add']")
	private WebElement NewButton;
	@FindBy(xpath = "//select[@id='cat_id']")
	private WebElement CategoryDropDown;
	@FindBy(xpath = "//input[@id='subcategory']")
	private WebElement SubCategoryField;
	@FindBy(xpath = "//button[@name='create']")
	private WebElement SaveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement GreenAlert;

	public void clickMoreInfo() {
		MoreInfo.click();
	}

	public void clickNewButton() {
		NewButton.click();
	}

	public void selectCategoryDropDown() {
		PageUtilities pageutilities = new PageUtilities();
		pageutilities.selectByVisibleText(CategoryDropDown, "Toys");
		// Select select= new Select(CategoryDropDown);
		// select.selectByVisibleText("Toys");
	}

	public void addInSubCategoryField(String description) {
		SubCategoryField.sendKeys(description);
	}

	public void uploadImage() throws AWTException {
		FileUploadUtility fileuploadutility = new FileUploadUtility();
		fileuploadutility.fileUploadByRobotClass(CategoryDropDown, Constant.TOYCARIMAGEFILE);
	}

	public void clickSaveButton() {
		SaveButton.click();
	}

	public boolean ifGreenAlertDisplayed() {
		return GreenAlert.isDisplayed();
	}

}
