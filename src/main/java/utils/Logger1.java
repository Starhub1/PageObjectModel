package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logger1 {
	private static final Logger LOGGER = LogManager.getLogger(Logger1.class.getName());

	public static Logger getLogger() {
		return LOGGER;
	}
}
