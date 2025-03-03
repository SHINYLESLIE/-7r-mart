package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constant;
import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUsersTest extends Base {

	@Test(description = "Testing Whether A New Admin User Can Be Added With Valid Username And Valid Password")
	public void verifyIfNewAdminUserCanBeAddedWithValidCredentials() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "Login_Page");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "Login_Page");

		String newusernamevalue = ExcelUtility.getStringData(1, 0, "AdminUsers_Page");
		String newpasswordvalue = ExcelUtility.getStringData(1, 1, "AdminUsers_Page");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSigninButton();

		AdminUsersPage adminuserspage = new AdminUsersPage(driver);
		adminuserspage.clickOnMoreInfo();
		adminuserspage.clickOnNewButton();
		adminuserspage.enterNewUserName(newusernamevalue);
		adminuserspage.enterNewPassWord(newpasswordvalue);
		adminuserspage.selectUserType();
		adminuserspage.clickOnSaveButton();
		Boolean isalertdisplayed = adminuserspage.isGreenAlertDisplayed();
		Assert.assertTrue(isalertdisplayed, Constant.ADMINUSER);

	}

}
