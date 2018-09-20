package init;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentTest;

import reports.ReportManager;
import utils.DriverFactory;

public class TestBase {
	
	private static ThreadLocal<EventFiringWebDriver> driver= new ThreadLocal<>();
	protected static ThreadLocal<ExtentTest> logger = new ThreadLocal<>();
	public static WebDriver getDriver() {
		return driver.get();
	}

	@BeforeSuite
	public void beforeSuite() {
		ReportManager.init();
	}

	@AfterSuite
	public void afterSuite() {

	}

	@BeforeMethod()
	public void setUp(ITestResult it) {
		driver.set(new DriverFactory().getDriver());
	}

	@AfterMethod()
	public void tearDown() {
		driver.get().quit();
		driver.remove();
		ReportManager.endTest(logger.get());
	}
}
