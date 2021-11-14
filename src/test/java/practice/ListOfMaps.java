package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListOfMaps {

	public static void main(String[] args) {
		
		List<Map<String,String>> listOfMaps = new ArrayList<>();
		
		Map<String,String> map1 = new HashMap<>();
		map1.put("firstname", "Taner");
		map1.put("lastname", "Demir");
		map1.put("age","38");
		
		Map<String,String> map2 = new HashMap<>();
		map2.put("firstname", "Esin");
		map2.put("lastname", "Demirkazan");
		map2.put("age", "42");
		
		listOfMaps.add(map1);
		listOfMaps.add(map2);
		System.out.println(listOfMaps);
		
	}
	
}
