package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

	public class ManageContactTest extends Base {

		@Test(groups= {"Regression"}, description= "Testing Whether Admin Can Edit Details In ManageContactPage")
		public void verifyThatAdminCanEditManageContactDetails() throws IOException {
			
			String usernamevalue = ExcelUtility.getStringData(1, 0, "Login_Page");
			String passwordvalue = ExcelUtility.getStringData(1, 1, "Login_Page");

			String phonenumber = ExcelUtility.getIntegerData(1, 0, "ManageContact_Page");
			String deliverytime = ExcelUtility.getIntegerData(1, 1, "ManageContact_Page");

			LoginPage loginpage = new LoginPage(driver);
			loginpage.enterUserName(usernamevalue);
			loginpage.enterPassword(passwordvalue);
			loginpage.clickOnSigninButton();

			ManageContactPage managecontactpage = new ManageContactPage(driver);
			managecontactpage.clickMoreInfo();
			managecontactpage.clickEditButton();
			managecontactpage.editPhoneNumberField(phonenumber);
			managecontactpage.editDeliveryTime(deliverytime);
			managecontactpage.clickUpdateButton();
			Boolean whetherGreenAlertDisplayed = managecontactpage.isGreenAlertDisplayed();
			Assert.assertTrue(whetherGreenAlertDisplayed, Constant.MANAGECONTACTEDIT);
		}

		@Test(description= "Testing Whether The Update Button is Enabled")
		public void checkWhetherUpdateButtonIsEnabled() throws IOException {
			String usernamevalue = ExcelUtility.getStringData(1, 0, "Login_Page");
			String passwordvalue = ExcelUtility.getStringData(1, 1, "Login_Page");

			LoginPage loginpage = new LoginPage(driver);
			loginpage.enterUserName(usernamevalue);
			loginpage.enterPassword(passwordvalue);
			loginpage.clickOnSigninButton();

			ManageContactPage managecontactpage = new ManageContactPage(driver);
			managecontactpage.clickMoreInfo();
			managecontactpage.clickEditButton();
			Boolean whetherUpdateButtonEnabled = managecontactpage.isUpdateButtonEnabled();
			Assert.assertTrue(whetherUpdateButtonEnabled, Constant.MANAGECONTACTUPDATEBUTTON);
		}
	}

