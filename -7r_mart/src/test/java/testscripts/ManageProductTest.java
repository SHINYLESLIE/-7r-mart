package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.LoginPage;
import pages.ManageProductPage;
import utilities.ExcelUtility;

public class ManageProductTest extends Base {

	@Test(description = "Testing Whether Admin Can Delete A Product From ManageProduct Page")
	public void checkThatAdminCanDeleteAProduct() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "Login_Page");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "Login_Page");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSigninButton();

		ManageProductPage manageproductpage = new ManageProductPage(driver);
		manageproductpage.clickMoreInfo();
		manageproductpage.clickDeleteButton();
		Boolean whetherGreenAlertDisplayed = manageproductpage.isGreenAlertDisplayed();
		Assert.assertTrue(whetherGreenAlertDisplayed, Constant.MANAGEPRODUCT);

	}
}
