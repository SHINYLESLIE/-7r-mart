package testscripts;

	import java.io.IOException;

	import org.testng.Assert;
	import org.testng.annotations.Test;

	import constants.Constant;
	import pages.LoginPage;
	import pages.ManageNewsPage;
	import utilities.ExcelUtility;

	public class ManageNewsTest extends Base {

		@Test(description= "Testing Whether The Admin Can Create A New News Successfully")
		public void verifyThatUserCanCreateNewsSuccessfully() throws IOException {

			String usernamevalue = ExcelUtility.getStringData(1, 0, "Login_Page");
			String passwordvalue = ExcelUtility.getStringData(1, 1, "Login_Page");

			String news = ExcelUtility.getStringData(1, 0, "ManageNews_Page");

			LoginPage loginpage = new LoginPage(driver);
			loginpage.enterUserName(usernamevalue);
			loginpage.enterPassword(passwordvalue);
			loginpage.clickOnSigninButton();

			ManageNewsPage managenewspage = new ManageNewsPage(driver);
			managenewspage.clickManageNewsMoreInfo();
			managenewspage.clickNewButton();
			managenewspage.newsContent(news);
			managenewspage.clickSaveButton();
			Boolean isalertdisplayed = managenewspage.isgreenAlertDisplay();
			Assert.assertTrue(isalertdisplayed, Constant.MANAGENEWS);

		}
	}


