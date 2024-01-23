/*
    @description
    @author: Tran Nguyen Vu
    @date: 23/01/2024
    @version: 1.0
*/

package demo.jom;

import demo.entity.Person;

public class Demo5 {
    public static void main(String[] args) {
        Person p = JsonHandler.fromFile("data/person.json");
        System.out.println(p);
    }
}
