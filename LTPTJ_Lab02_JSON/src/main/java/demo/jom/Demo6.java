/*
    @description
    @author: Tran Nguyen Vu
    @date: 23/01/2024
    @version: 1.0
*/

package demo.jom;

import demo.entity.Address;
import demo.entity.Person;
import demo.entity.PhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class Demo6 {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        Person p1 = new Person("Vu", "Tran", 30, new Address("120 Nguyen Van Bao", "HCM", "VN", 70000));
        p1.setPhoneNumbers(List.of(new PhoneNumber("home", "0123456789"), new PhoneNumber("mobile", "0987654321")));
        persons.add(p1);

        Person p2 = new Person("Ha", "Tran", 18, new Address("250 Tran Van Bao", "HCM", "VN", 70000));
        p2.setPhoneNumbers(List.of(new PhoneNumber("home", "0123456789"), new PhoneNumber("mobile", "0987654321")));
        persons.add(p2);

        JsonHandler.toJsonFile(persons, "data/persons.json");
    }
}
