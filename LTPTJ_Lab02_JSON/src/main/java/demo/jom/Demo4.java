/*
    @description
    @author: Tran Nguyen Vu
    @date: 23/01/2024
    @version: 1.0
*/

package demo.jom;

import demo.entity.Person;

import java.util.List;

public class Demo4 {
    public static void main(String[] args) {
        String jsonArr = "[\r\n"
                + "    {\r\n"
                + "        \"firstName\": \"John\",\r\n"
                + "        \"lastName\": \"Smith\",\r\n"
                + "        \"age\": 25,\r\n"
                + "        \"address\": {\r\n"
                + "            \"streetAddress\": \"21 2nd Street\",\r\n"
                + "            \"city\": \"New York\",\r\n"
                + "            \"state\": \"NY\",\r\n"
                + "            \"postalCode\": 10021\r\n"
                + "        },\r\n"
                + "        \"phoneNumbers\": [\r\n"
                + "            {\r\n"
                + "                \"type\": \"home\",\r\n"
                + "                \"number\": \"212 555-1234\"\r\n"
                + "            },\r\n"
                + "            {\r\n"
                + "                \"type\": \"fax\",\r\n"
                + "                \"number\": \"646 555-4567\" \r\n"
                + "            }\r\n"
                + "        ] \r\n"
                + "    },\r\n"
                + "    {\r\n"
                + "        \"firstName\": \"John\",\r\n"
                + "        \"lastName\": \"Smith\",\r\n"
                + "        \"age\": 25,\r\n"
                + "        \"address\": {\r\n"
                + "            \"streetAddress\": \"21 2nd Street\",\r\n"
                + "            \"city\": \"New York\",\r\n"
                + "            \"state\": \"NY\",\r\n"
                + "            \"postalCode\": 10021\r\n"
                + "        },\r\n"
                + "        \"phoneNumbers\": [\r\n"
                + "            {\r\n"
                + "                \"type\": \"home\",\r\n"
                + "                \"number\": \"212 555-1234\"\r\n"
                + "            },\r\n"
                + "            {\r\n"
                + "                \"type\": \"fax\",\r\n"
                + "                \"number\": \"646 555-4567\" \r\n"
                + "            }\r\n"
                + "        ] \r\n"
                + "    }\r\n"
                + "]";

        List<Person> persons = JsonHandler.fromJsonArray(jsonArr);
        persons.forEach(System.out::println);
    }
}
