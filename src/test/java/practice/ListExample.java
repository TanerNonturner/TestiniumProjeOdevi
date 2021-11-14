package practice;

import java.util.ArrayList;
import java.util.List;

public class ListExample {
	
	public static void main(String[] args) {

		List<String> list = new ArrayList();
		list.add("Taner");
		list.add("Tarýk");
		list.add("Esin");
		list.add("Rüya");
		//[ ---means it is a collection [Taner,Tarýk,Esin,Rüya]
		System.out.println(list);
	
		//enhance for loop/advance for loop
		for(String element:list) {
		System.out.println(element);
		}
	
	
	
	}

}
