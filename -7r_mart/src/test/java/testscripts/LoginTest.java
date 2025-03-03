package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constant;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class LoginTest extends Base {
	@Test(description = "Testing Whether The Admin Can Login With Valid Credentials")
	public void verifyIfTheAdminCanLoginWithValidCredentials1() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "Login_Page");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "Login_Page");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSigninButton();
		Boolean isDashboardLoaded = loginpage.ifDashboardLoaded();
		Assert.assertTrue(isDashboardLoaded, Constant.LOGIN1);

	}

	@Test(description = "Testing Whether The Admin Can Login With Invalid Username And Valid Password ")
	public void verifyTheUserIsAbleToLoginUsingInvalidCredentials2() throws IOException {

		// String usernamevalue = ExcelUtility.getStringData(2, 0, "Login_Page");
		FakerUtility fakerutility = new FakerUtility();
		String usernamevalue = fakerutility.creatARandomFirstName();
		String passwordvalue = ExcelUtility.getStringData(2, 1, "Login_Page");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSigninButton();
		Boolean isredalertdisplayed = loginpage.isAlertDisplayed();
		Assert.assertTrue(isredalertdisplayed, Constant.LOGIN2);

	}

	@Test(description = "Testing Whether The Admin Can Login With Valid Username And Invalid Password")
	public void verifyTheUserIsAbleToLoginUsingInvalidCredentials3() throws IOException {

		String usernamevalue = ExcelUtility.getStringData(3, 0, "Login_Page");
		String passwordvalue = ExcelUtility.getStringData(3, 1, "Login_Page");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSigninButton();
		Boolean isredalertdisplayed = loginpage.isAlertDisplayed();
		Assert.assertTrue(isredalertdisplayed, Constant.LOGIN2);
	}

	@Test(dataProvider = "LoginProvider", description = "Testing Whether The Admin Can Login With Invalid Credentials")
	public void verifyTheUserIsAbleToLoginUsingInvalidCredentials4(String newusernamevalue, String newpasswordvalue)
			throws IOException {

		String usernamevalue = ExcelUtility.getStringData(4, 0, "Login_Page");
		String passwordvalue = ExcelUtility.getStringData(4, 1, "Login_Page");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSigninButton();
		Boolean isredalertdisplayed = loginpage.isAlertDisplayed();
		Assert.assertTrue(isredalertdisplayed, Constant.LOGIN2);
	}

	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() throws IOException {
		return new Object[][] {
				{ ExcelUtility.getStringData(4, 0, "Login_Page"), ExcelUtility.getStringData(4, 1, "Login_Page") } };

	}

}
