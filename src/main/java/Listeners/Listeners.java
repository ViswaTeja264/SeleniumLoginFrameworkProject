package Listeners;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.Base;
import Utilities.ExtentReporter;


public class Listeners extends Base implements ITestListener{
	
	ExtentReports extentReport = ExtentReporter.getExtentReport();
	ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();
	ExtentTest extentTest;
	String testResult;

	@Override
	public void onTestStart(ITestResult result) {
		
		testResult = result.getName();
		extentTest = extentReport.createTest(testResult);
		extentTestThread.set(extentTest);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		testResult = result.getName();
		//extentTest.log(Status.PASS, testResult + " Got Passed");
		extentTestThread.get().log(Status.PASS, testResult + " Got Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		//extentTest.fail(result.getThrowable());
		extentTestThread.get().fail(result.getThrowable());
		
		WebDriver driver = null;
		
		String testName = result.getName();
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		
		try {
			String ScreenshotFilePath = takeScreenShots(testName,driver);
			extentTestThread.get().addScreenCaptureFromPath(ScreenshotFilePath, testName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extentReport.flush();
		
	}
	
	

}
