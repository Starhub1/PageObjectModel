package utils;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import init.TestBase;
import reports.ReportManager;

public class TestListener extends TestListenerAdapter {

	private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger("TestListener");
	String message;

	@Override
	public void onTestSuccess(ITestResult tr) {
		message = String.format("[%s] : %s", tr.getInstance().getClass(),
				"############# TestCase PASSED ###############");
		logger.info(message);

		TestBase.getLogger().get().log(LogStatus.PASS, "TestCase Passed");
	}

	@Override
	public void onTestFailure(ITestResult tr) {

		message = String.format("[%s] : %s", tr.getInstance().getClass(),
				"############# EXCEPTION THROWN ###############");
		logger.info(message, tr.getThrowable());

		ExtentTest report = TestBase.getLogger().get();
		WebDriver driver = TestBase.getDriver();
		String image = null;

		if (driver != null) {
			image = Commonlibs.takeScreenShot(tr.getName(), driver);
			System.out.println("The report name is " + report + "test name is " + tr.getName());
			report.log(LogStatus.ERROR, tr.getName(), "Screenshot" + report.addScreenCapture(image));
			report.log(LogStatus.FAIL, tr.getThrowable().getMessage());
		}

		
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		message = String.format("[%s] : %s", tr.getInstance().getClass(),
				"############# TestCase SKIPPED ###############");
		logger.info(message, tr.getThrowable());

		ExtentTest report = TestBase.getLogger().get();
		WebDriver driver = TestBase.getDriver();
		String image = null;

		if (driver != null) {
			image = Commonlibs.takeScreenShot(tr.getName(), driver);
		}

		report.log(LogStatus.SKIP, tr.getName(), "Screenshot" + report.addScreenCapture(image));
		report.log(LogStatus.SKIP, tr.getThrowable().getMessage());
	}

	@Override
	public void onTestStart(ITestResult result) {
		message = String.format("[%s] : %s", result.getInstance().getClass(),
				"Testing " + result.getName() + " ###############");
		logger.info(message);
		TestBase.getLogger().set(ReportManager.startTest(result.getName()));
		System.out.println("Started tc "+ result.getName());

	}

	@Override
	public void onConfigurationFailure(ITestResult itr) {
		/*
		 * message = String.format("[%s] : %s", itr.getInstance().getClass(),
		 * "############# Configuration Failed ###############");
		 * logger.info(message,itr.getThrowable());
		 */
	}

	@Override
	public void onConfigurationSkip(ITestResult itr) {
		/*
		 * message = String.format("[%s] : %s", itr.getInstance().getClass(),
		 * "############# Configuration SKIPPED ###############");
		 * logger.info(message,itr.getThrowable());
		 */
	}

	@Override
	public void onConfigurationSuccess(ITestResult itr) {
		/*
		 * message = String.format("[%s] : %s", itr.getInstance().getClass(),
		 * "############# Configuration Success ###############"); logger.info(message);
		 */
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public void onStart(ITestContext testContext) {
		super.onStart(testContext);
	}

	@Override
	public void onFinish(ITestContext testContext) {
		super.onFinish(testContext);
	}

}
