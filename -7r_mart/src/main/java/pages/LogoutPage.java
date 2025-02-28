package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	WebDriver driver;

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	private WebElement AdminIcon;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout'and@class='dropdown-item']")
	private WebElement LogoutIcon;
	@FindBy(xpath = "//p[@class='login-box-msg']")
	private WebElement LoginBox;

	public void clickAdminIcon() {
		AdminIcon.click();
	}

	public void clickLogoutIcon() {

		LogoutIcon.click();
	}

	public boolean isLoginBoxDisplayed() {
		return LoginBox.isDisplayed();
	}
}
