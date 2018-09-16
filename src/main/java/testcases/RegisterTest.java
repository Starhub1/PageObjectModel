package testcases;

import org.testng.annotations.Test;

import init.TestBase;
import pages.HomePage;

public class RegisterTest extends TestBase {
	
	
	
	@Test
	public void testNewRegistrationThenLogin() {
		HomePage homePage = new HomePage();
		homePage.
		open().
		clickRegister()
		.Register("test", "password").clickSignIn().Login("test", "password");
		
	}
	
}
