package reports;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.io.FileUtils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.NetworkMode;

public class ReportManager {
	
	private static ExtentReports reports;
	

	public static void init() {
	 
		if (reports == null) {
			String fileName = "./test reports/Excecution Report " + getCurrentDateTime() + "/index.html";		
			try {
				FileUtils.touch(new File(fileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
			reports = new ExtentReports(fileName, true, NetworkMode.ONLINE, new Locale("en-US"));
			reports.loadConfig(new File(("config.xml")));
		}
	}

	public static ExtentTest startTest(String testcaseName) {
		return reports.startTest(testcaseName);
	}

	public static void endTest(ExtentTest test) {
		reports.endTest(test);
		reports.flush();
	}
	
	public static String getCurrentDateTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MMM.yyyy hh-mm-ss");
		return sdf.format(date);

	}

}
