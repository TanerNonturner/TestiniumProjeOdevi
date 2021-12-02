package practice;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Log {
	// to create logger class we use the same class name
	static Logger logger = Logger.getLogger(Log.class);
	// I must achieve log4j.xml file

	public Log() {
		DOMConfigurator.configure("log4j.xml");
	}

	public void info(String message) {
		// we write info into logger
		logger.info(message);

	}

	public void warn(String message) {

		logger.warn(message);
	}

	public void error(String message) {
		
		logger.error(message);
	}
	
	
	
	
	
	
	
	
	
}
