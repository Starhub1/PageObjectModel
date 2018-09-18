package utils;

import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import init.TestBase;
import reports.AppLogger;

public class TestListener extends TestListenerAdapter{

	@Override
	public void onTestSuccess(ITestResult tr) {
		AppLogger.logInfo(tr.getInstance().getClass(), "TestCase PASSED");
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		AppLogger.logFatal(tr.getInstance().getClass(), "EXCEPTION Thrown",tr.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		AppLogger.logInfo(tr.getInstance().getClass(), "TestCase SKIPPED");
	}

	
	@Override
	public void onTestStart(ITestResult result) {
		
		AppLogger.logInfo(result.getInstance().getClass(), "Testing "+result.getName()+"....................................................");
		super.onTestStart(result);
	}


	@Override
	public void onConfigurationFailure(ITestResult itr) {
		AppLogger.logInfo(itr.getInstance().getClass(), "Configuration FAILED");
	}


	@Override
	public void onConfigurationSkip(ITestResult itr) {
		AppLogger.logInfo(itr.getInstance().getClass(), "Configuration SKIPPED");
	}

	@Override
	public void onConfigurationSuccess(ITestResult itr) {
		AppLogger.logInfo(itr.getInstance().getClass(), "Configuration SUCCESS");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	@Override
	public void onStart(ITestContext testContext) {
		// TODO Auto-generated method stub
		super.onStart(testContext);
	}

	@Override
	public void onFinish(ITestContext testContext) {
		// TODO Auto-generated method stub
		super.onFinish(testContext);
	}

}
