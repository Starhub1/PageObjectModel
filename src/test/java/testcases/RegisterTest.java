package testcases;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import init.TestBase;
import pages.HomePage;
import utils.PropReader;

public class RegisterTest extends TestBase {
	
	
	
	@Test
	public void testNewRegistrationThenLogin() {
		/*Faker data = new Faker();
		String userName = data.name().firstName();
		String password = data.internet().password();*/
		
		HomePage homePage = new HomePage();
		
		homePage.open().clickRegister().Register("test","password").clickSignIn().LoginAs("test","password");
		
	}
	
}
