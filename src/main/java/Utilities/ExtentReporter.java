package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
	static ExtentReports Reports;
	
	public static ExtentReports getExtentReport() {
		
		String ExtentReportPath = System.getProperty("user.dir") + "\\reports\\ExtentReports.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(ExtentReportPath);
		reporter.config().setReportName("TutorialsNinja Login Automation Report");
		reporter.config().setDocumentTitle("Test Results");
		
		Reports = new ExtentReports();
		Reports.attachReporter(reporter);
		Reports.setSystemInfo("Operating System", "Windows 10");
		Reports.setSystemInfo("Tested By", "Viswa Teja");
		
		return Reports;
		
	}

}
