package practiceDB;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import utils.DBUtils;

public class StoringDataUtils {
	
	
	
	@Test
	public void getDataFromDB() {
		
		DBUtils.getConnection();
		List<Map<String,String>> listData = new ArrayList<>();
		listData = DBUtils.storeDataFromDB("SELECT * FROM signalt_classicmodels.employees LIMIT 5;");
		System.out.println(listData);
		DBUtils.closeConnection();
	}

}
