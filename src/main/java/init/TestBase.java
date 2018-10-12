package init;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentTest;

import reports.ReportManager;
import utils.DriverFactory;
import utils.PropReader;

public class TestBase {
	
	private static final ThreadLocal<EventFiringWebDriver> driver= new ThreadLocal<>();
	protected static final ThreadLocal<ExtentTest> logger = new ThreadLocal<>();
	
	public static ThreadLocal<ExtentTest> getLogger() {
		return logger;
	}

	public static EventFiringWebDriver getDriver() {
		return driver.get();
	}

	@BeforeSuite(alwaysRun=true)
	public void beforeSuite() {
		System.out.println("Before Suite: "+ Thread.currentThread().getId());
		ReportManager.init();
	}

	@AfterSuite(alwaysRun=true)
	public void afterSuite() {
		System.out.println("After Suite: "+ Thread.currentThread().getId());
	}

	@BeforeMethod(alwaysRun=true)
	public void setUp(ITestResult it) {
		System.out.println("Before Method: "+ Thread.currentThread().getId());
		driver.set(new DriverFactory().getDriver());
	}

	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		System.out.println("After Method: "+ Thread.currentThread().getId());
		driver.get().quit();
		driver.remove();
		ReportManager.endTest(logger.get());
	}
}
