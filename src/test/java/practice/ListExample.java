package practice;

import java.util.ArrayList;
import java.util.List;

public class ListExample {
	
	public static void main(String[] args) {

		List<String> list = new ArrayList();
		list.add("Taner");
		list.add("Tar�k");
		list.add("Esin");
		list.add("R�ya");
		//[ ---means it is a collection [Taner,Tar�k,Esin,R�ya]
		System.out.println(list);
	
		//enhance for loop/advance for loop
		for(String element:list) {
		System.out.println(element);
		}
	
	
	
	}

}
