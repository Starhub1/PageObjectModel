package testcases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import init.TestBase;
import pages.HomePage;
import reports.ReportManager;

public class RegisterTest extends TestBase {
	
	
	
	@Test()
	public void testNewRegistrationThenLogin() {
		
		logger.set(ReportManager.startTest("testNewRegistrationThenLogin"));
		HomePage homePage = new HomePage();
		
		homePage
		.open()
		.clickRegister()
		.Register("test", "password").clickSignIn().Login("test", "password");
		
	}
	
}
