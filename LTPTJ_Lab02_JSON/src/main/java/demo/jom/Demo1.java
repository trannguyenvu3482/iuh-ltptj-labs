package demo.jom;

import demo.entity.Address;
import demo.entity.Person;
import demo.entity.PhoneNumber;

import java.util.List;

public class Demo1 {
	public static void main(String[] args) {

		Person p = new Person("Vu", "Tran", 30, new Address("120 Nguyen Van Bao", "HCM", "VN", 70000));
		p.setPhoneNumbers(List.of(new PhoneNumber("home", "0123456789"), new PhoneNumber("mobile", "0987654321")));
		String json = JsonHandler.toJson(p);
		System.out.println(json);
		
	}
}
