package practiceDB;

import utils.ConfigsReader;
import utils.Constants;

public class DB {

	public static void main(String[] args) {
		
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		System.out.println(ConfigsReader.getProperty("dbUrl"));
	}
}
