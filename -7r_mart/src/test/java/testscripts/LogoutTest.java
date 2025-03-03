package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;

public class LogoutTest extends Base {

	@Test(description = "TEST FOR CHECKING WHETHER THE ADMIN CAN LOGOUT SUCCESSFULLY")
	public void checkWhetherAdminCanLogoutSuccessfully() throws IOException

	{
		String usernamevalue = ExcelUtility.getStringData(1, 0, "Login_Page");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "Login_Page");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSigninButton();

		LogoutPage logoutpage = new LogoutPage(driver);
		logoutpage.clickAdminIcon();
		logoutpage.clickLogoutIcon();
		Boolean whetherLoginBoxDisplayed = logoutpage.isLoginBoxDisplayed();
		Assert.assertTrue(whetherLoginBoxDisplayed, Constant.LOGOUT);
	}

}
