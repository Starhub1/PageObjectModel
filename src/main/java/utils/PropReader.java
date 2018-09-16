package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropReader {

	public static String get(String path, String... property) {
		
		String res = null;
		
		try (FileInputStream fis = new FileInputStream(new File(path))) {
			Properties prop = new Properties();
			prop.load(fis);
			res=prop.getProperty(property[0]);
			if (res.isEmpty())
				res = property[1];
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}
}
