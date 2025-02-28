package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	private WebElement moreinfo;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newbutton;
	@FindBy(xpath = "//textarea[@id='news']")
	private WebElement newsfield;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	private WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement greenalert;

	public void clickManageNewsMoreInfo() {
		moreinfo.click();
	}

	public void clickNewButton() {
		newbutton.click();
	}

	public void newsContent(String news) {
		newsfield.sendKeys(news);
	}

	public void clickSaveButton() {
		savebutton.click();
	}

	public boolean isgreenAlertDisplay() {
		return greenalert.isDisplayed();

	}


}
