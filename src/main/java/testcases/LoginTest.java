package testcases;

import org.testng.annotations.Test;

import init.TestBase;
import pages.HomePage;

public class LoginTest extends TestBase{
	
	@Test(dataProvider="loginData",dataProviderClass=testdata.Login.class)
	public void Login(String userName, String password) {
		HomePage homepage = new HomePage();
		homepage.Login(userName, password);
	}
	
	@Test(dataProvider="loginData",dataProviderClass=testdata.Login.class)
	public void Login1(String userName, String password) {
		HomePage homepage = new HomePage();
		homepage.Login(userName, password);
	}
}
