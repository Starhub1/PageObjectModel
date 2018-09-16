package init;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import utils.DriverFactory;

public class TestBase {
	
	public static ThreadLocal<EventFiringWebDriver> driver= new ThreadLocal<>();

	public static WebDriver getDriver() {
		return driver.get();
	}

	@BeforeSuite
	public void beforeSuite() {

	}

	@AfterSuite
	public void afterSuite() {

	}

	@BeforeMethod(alwaysRun=true)
	public void setUp() {
		driver.set(new DriverFactory().getDriver());
	}

	@AfterMethod()
	public void tearDown() {
		driver.get().quit();
		driver.remove();
	}
}
