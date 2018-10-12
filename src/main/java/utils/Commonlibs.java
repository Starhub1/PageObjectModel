package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import reports.ReportManager;

public class Commonlibs {
	
	public synchronized static String takeScreenShot(String methodName, WebDriver driver) {

		Path path =Paths.get(ReportManager.getPath()).getParent();	
		path = path.resolve("Screenhshots");
		if (!path.toFile().exists()){
			try {
				FileUtils.forceMkdir(path.toFile());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		path = path.resolve(methodName + "/" + methodName + ".png");
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile,path.toFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path.toAbsolutePath().toString();
	}
}

