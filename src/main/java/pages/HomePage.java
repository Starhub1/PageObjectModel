package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import init.TestBase;
import utils.PropReader;

public class HomePage {
	EventFiringWebDriver driver = TestBase.getDriver();
	WebDriverWait wait= new WebDriverWait(driver, 30);;
	ExtentTest report=TestBase.getLogger().get();
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='REGISTER']")
	private WebElement lnkRegister;
	
	@FindBy(name="userName")
	private WebElement txtUserName;
	
	@FindBy(name="password")
	private WebElement txtPassword;
	
	@FindBy(name="login")
	private WebElement btnSignIn; 
	
	public HomePage open() {
		String url =PropReader.get("./config/app.properties", "url");
		System.out.println("The report is "+report);
		try {
		driver.get(url);
		}catch(TimeoutException t) {
			System.out.println(t.getMessage());
		}
		report.log(LogStatus.PASS,"Navigate to the URL "+url, "Successfully navigated to the url "+ url);
		return this;
		
	}
	
	public HomePage typeUserName(String txt) {
		wait.until(ExpectedConditions.visibilityOf(txtUserName));
		txtUserName.sendKeys(txt);
		report.log(LogStatus.PASS, "Enter the username "+txt, "Successfully entered the username "+ txt);
		return this;
	}
	
	public HomePage typePassword(String txt) {
		txtPassword.sendKeys(txt);
		report.log(LogStatus.PASS, "Enter the password "+txt, "Successfully entered the password "+ txt);
		return this;
	}
	
	public HomePage clickLogin() {
		btnSignIn.click();
		report.log(LogStatus.PASS, "Click on the button Login ", "Successfully Clicked the button login");
		return this;
	}
	
	public void LoginAs(String userName, String Password) {
		typeUserName(userName).typePassword(Password).clickLogin();
	}
	
	public RegisterPage clickRegister() {
		lnkRegister.click();
		report.log(LogStatus.PASS, "Click on the Register Link ", "Successfully Clicked on the element Register");
		return new RegisterPage();
	}
}
