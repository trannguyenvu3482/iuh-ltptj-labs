package demo.js;

import java.util.List;

import demo.entity.Address;
import demo.entity.Person;

public class StreamAPIDemo2 {
	
	public static void main(String[] args) {
		
		List<Person> list = List.of(
				new Person("Ti", "Le", 20),
				new Person("Le", "Le", 23, new Address("12455 nguyen Van Bao", "P4", "GV HCM", 10000))
			);
	
		
		JsonHandlerStream.toJsonFile(list, "data/abc.json");
		System.out.println("Done!");
	}
	
}
