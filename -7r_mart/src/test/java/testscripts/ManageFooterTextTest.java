package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtility;

public class ManageFooterTextTest extends Base {

	@Test(description = "Testing Whether Admin Can Edit Details In ManageFooterText Page")
	public void verifyThatAdminCanEditTheDetails() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "Login_Page");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "Login_Page");

		String address = ExcelUtility.getStringData(1, 0, "ManageFooterText_Page");
		String email = ExcelUtility.getStringData(1, 1, "ManageFooterText_Page");
		String phonenumber = ExcelUtility.getIntegerData(1, 2, "ManageFooterText_Page");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSigninButton();

		ManageFooterTextPage managefootertextpage = new ManageFooterTextPage(driver);
		managefootertextpage.clickMoreInfo();
		managefootertextpage.clickEditButton();
		managefootertextpage.editAddressField(address);
		managefootertextpage.editEmailField(email);
		managefootertextpage.editPhoneNumberField(phonenumber);
		managefootertextpage.clickUpdateButton();
		boolean whetherGreenAlertDisplayed = managefootertextpage.isGreenAlertDisplayed();
		Assert.assertTrue(whetherGreenAlertDisplayed);

	}

	@Test(description = "Testing Whether Update Button Is Present In ManageFooterText Page")
	public void checkWhetherUpdateButtonIsPresent() throws IOException {
		String usernamevalue = ExcelUtility.getStringData(1, 0, "Login_Page");
		String passwordvalue = ExcelUtility.getStringData(1, 1, "Login_Page");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usernamevalue);
		loginpage.enterPassword(passwordvalue);
		loginpage.clickOnSigninButton();

		ManageFooterTextPage managefootertextpage = new ManageFooterTextPage(driver);
		managefootertextpage.clickMoreInfo();
		managefootertextpage.clickEditButton();
		Boolean whetherUpdateButtonPresent = managefootertextpage.isUpdateButtonPresent();
		Assert.assertTrue(whetherUpdateButtonPresent);
	}
}
