package testdata;

import org.testng.annotations.DataProvider;

import utils.ExcelReader;

public class Login {
	
	@DataProvider(name="loginData",parallel=true)
	public static String[][] loginData() {
		return ExcelReader.readTestData(System.getProperty("user.dir")+"\\test data\\Login\\login.xlsx", "Sheet1");
	}
}
