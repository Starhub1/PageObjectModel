package testcases;

import org.testng.annotations.Test;

import init.TestBase;
import pages.HomePage;

public class RegisterTest extends TestBase {
	
	
	//RegisterPage registerPage= new RegisterPage();
	
	@Test
	public void testNewRegistrationThenLogin() {
		HomePage homePage = new HomePage();
		homePage.
		clickRegister()
		.Register("test", "password").clickSignIn().Login("test", "password");
		
	}
	
}
