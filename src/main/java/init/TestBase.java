package init;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import utils.DriverFactory;

public class TestBase {
	
	public static ThreadLocal<WebDriver> driver= new ThreadLocal<>();

	public static WebDriver getDriver() {
		return driver.get();
	}

	@BeforeSuite
	public void beforeSuite() {

	}

	@AfterSuite
	public void afterSuite() {

	}

	@BeforeMethod
	public void setUp() {
		driver.set(new DriverFactory().getDriver());
	}

	@AfterMethod
	public void tearDown() {
		driver.get().quit();
		driver.remove();
	}
}
