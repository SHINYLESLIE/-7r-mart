package testscripts;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtility;

public class SubCategoryTest extends Base {

	@Test(description = "Testing Whether Admin Can Add A Product Successfully")
	public void verifyThatTheAdminCanAddProduct() throws IOException, AWTException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "Login_Page");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "Login_Page");

		String description = ExcelUtility.getStringData(1, 0, "SubCategory_Page");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSigninButton();

		SubCategoryPage subcategorypage = new SubCategoryPage(driver);
		subcategorypage.clickMoreInfo();
		subcategorypage.clickNewButton();
		subcategorypage.selectCategoryDropDown();
		subcategorypage.addInSubCategoryField(description);
		subcategorypage.uploadImage();
		subcategorypage.clickSaveButton();
		Boolean isGreenAlertDisplayed = subcategorypage.ifGreenAlertDisplayed();
		Assert.assertTrue(isGreenAlertDisplayed, Constant.SUBCATEGORY);
	}
}
