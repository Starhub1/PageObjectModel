package testcases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import init.TestBase;
import pages.HomePage;
import utils.PropReader;

public class LoginTest extends TestBase{
	
	
	
	@Test(groups= {"Link_Sprint22"},dataProvider="loginData",dataProviderClass=testdata.Login.class)
	public void Login(String userName, String password) {
		HomePage homepage = new HomePage();
		homepage.open().LoginAs(userName, password);
	}
	
	@Test(dataProvider="loginData",dataProviderClass=testdata.Login.class)
	public void Login1(String userName, String password) {
		throw new SkipException("method skipped");
		
	}
}
