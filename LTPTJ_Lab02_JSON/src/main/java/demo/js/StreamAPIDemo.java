package demo.js;

import demo.entity.Person;

public class StreamAPIDemo {
	
	public static void main(String[] args) {
		
		Person p = JsonHandlerStream.readFromFile("data/person.json");
		
		System.out.println(p);
		
	}
	
}
