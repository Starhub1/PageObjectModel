package testcases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import init.TestBase;
import pages.HomePage;
import reports.ReportManager;

public class RegisterTest extends TestBase {
	
	
	
	@Test(testName="testldfjdls")
	public void testNewRegistrationThenLogin() {
		logger.get().log(LogStatus.INFO, "Addin a testcase");
		
		HomePage homePage = new HomePage();
		homePage.
		open().
		clickRegister()
		.Register("test", "password").clickSignIn().Login("test", "password");
		
	}
	
}
