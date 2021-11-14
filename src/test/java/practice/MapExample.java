package practice;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
	
	public static void main(String[] args) {
		
	Map<String,String> map = new HashMap<>();
	
	map.put("firstname", "Taner");
	map.put("lastname", "Demir");
	map.put("age", "37");
	
	System.out.println(map.get("firstname"));
		
		
		
	}

}
