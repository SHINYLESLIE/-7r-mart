package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageProductPage {
	WebDriver driver;

	public ManageProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product'and@class='small-box-footer']")
	private WebElement MoreInfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Product/delete?del=525&page_ad=1']")
	private WebElement DeleteButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement GreenAlert;

	public void clickMoreInfo() {
		MoreInfo.click();
	}

	public void clickDeleteButton() {
		DeleteButton.click();
		driver.switchTo().alert().accept();

	}

	public boolean isGreenAlertDisplayed() {
		return GreenAlert.isDisplayed();
	}

}
