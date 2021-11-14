package practice;

import java.util.ArrayList;
import java.util.List;

public class ListOfPerson {
	
	public static void main(String[] args) {
	
		List<Person> listOfPeople = new ArrayList();
		listOfPeople.add(new Person("Taner",36));
		listOfPeople.add(new Person("Ahmet",34));
		listOfPeople.add(new Person("Tarýk",39));
		//System.out.println(listOfPeople);
		for(Person element: listOfPeople) {
			System.out.println("Person's name is "+element.name+" and "+" Age is "+element.age);
		}
	}

}

 class Person{
	 
	 String name;
	 int age;
	 
	 public Person(String name,int age) {
		 this.name = name;
		 this.age = age;
		 
	 }
	
}