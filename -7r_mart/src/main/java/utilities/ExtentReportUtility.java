package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	public static final ExtentReports extentreports = new ExtentReports();

	public synchronized static ExtentReports createExtentReports() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
		reporter.config().setReportName("7r-mart");
		extentreports.attachReporter(reporter);
		extentreports.setSystemInfo("Organisation", "obsqura");
		extentreports.setSystemInfo("Name", "Shiny");
		return extentreports;
	}

}
