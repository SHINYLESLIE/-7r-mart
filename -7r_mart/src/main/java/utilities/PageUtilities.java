package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtilities {
	public void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void selectByVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);

	}

	public void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void clickJavaScriptExecutorTest(WebDriver driver, WebElement element) {
		JavascriptExecutor clickjs = (JavascriptExecutor) driver;
		clickjs.executeScript("arguments[0].click();", element);
	}

	public void doubleClick(WebElement dragableItem, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.doubleClick(dragableItem).perform();

	}

	public void showMessagejavaScriptExecutor(WebDriver driver, WebElement element) {
		JavascriptExecutor showmessagejs = (JavascriptExecutor) driver;
		showmessagejs.executeScript("arguments[0].value='message';", element);
		showmessagejs.executeScript("arguments[0].click();", element);

	}

	public void scrollingjavaScriptExecutor(WebDriver driver, WebElement element) {
		JavascriptExecutor scrollingjs = (JavascriptExecutor) driver;
		scrollingjs.executeScript("window.scrollBy(value1,value2)", "");
		scrollingjs.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
	}

}
