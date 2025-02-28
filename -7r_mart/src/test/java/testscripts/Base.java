package testscripts;

	import java.io.FileInputStream;
	import java.io.IOException;
	import java.time.Duration;
	import java.util.Properties;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.ITestResult;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Parameters;

	import constants.Constant;
	import utilities.ScreenShotUtility;
	import utilities.WaitUtility;

	public class Base {
		WebDriver driver;
		public Properties properties;
		FileInputStream fileinputstream;
		ScreenShotUtility scrshot;

		@BeforeMethod(alwaysRun = true)
		@Parameters("browser")

		public void initializeBrowser(String browser) throws Exception {

			{
				try {
					properties = new Properties();
					fileinputstream = new FileInputStream(Constant.CONFIGFILE);
					properties.load(fileinputstream);
				} catch (Exception e) {
					System.out.println("ERROR!");
				}
				if (browser.equalsIgnoreCase("chrome")) {
					driver = new ChromeDriver();
				} else if (browser.equalsIgnoreCase("edge")) {
					driver = new EdgeDriver();
				} else if (browser.equalsIgnoreCase("firefox")) {
					driver = new FirefoxDriver();
				} else {
					throw new Exception("Invalid Browser");
				}
				driver = new ChromeDriver();
				//driver.get("https://groceryapp.uniqassosiates.com/admin");
				driver.get(properties.getProperty("url"));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));
				driver.manage().window().maximize();
			}
		}

		@AfterMethod(alwaysRun = true)

		public void browserQuit(ITestResult iTestResult) throws IOException {
			if (iTestResult.getStatus() == ITestResult.FAILURE) {
				scrshot = new ScreenShotUtility();
				scrshot.getScreenshot(driver, iTestResult.getName());
			}
			/*
			 public void quitAndClose() { driver.quit(); //driver.close(); } }
			 */
		
	}
	}


