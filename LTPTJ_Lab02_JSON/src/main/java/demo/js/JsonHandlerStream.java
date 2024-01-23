package demo.js;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import demo.entity.Address;
import demo.entity.Person;
import demo.entity.PhoneNumber;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonValue;
import jakarta.json.stream.JsonGenerator;
import jakarta.json.stream.JsonParser;
import jakarta.json.stream.JsonParser.Event;

public class JsonHandlerStream {
	
	public static void toJsonFile(List<Person> persons, String fileName) {
		
		try(JsonGenerator gen = Json.createGenerator(new FileWriter(fileName))){
			
			gen.writeStartArray();
			
			persons.forEach(p -> {
				
				Address add = p.getAddress();
				
				gen.writeStartObject()
				.write("firstName", p.getFirstName())
				.write("age", p.getAge());
				
				if(add !=null) {
					gen.writeKey("address")
					.writeStartObject()
					.write("city", add.getCity())
					
					.writeEnd();
				}
				
				gen.writeEnd();
			});
			
			gen.writeEnd();
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Person readFromFile(String fileName) {

		Person p = null;
		List<PhoneNumber> phones = null;
		String keyName = "";
		Address add = null;
		
		try(JsonParser parser = Json.createParser(new FileReader(fileName));){

			while(parser.hasNext()) {
				Event event = parser.next();
				switch (event) {
				case START_OBJECT :
					if(keyName.equals("address"))
						add = new Address();
					else
						p = new Person();
					break;
				case START_ARRAY:
					phones = new ArrayList<>();
					JsonArray ja = parser.getArray();
					for(JsonValue jv: ja) {
						JsonObject joPh = (JsonObject) jv;
						phones.add(new PhoneNumber(joPh.getString("type"), joPh.getString("number")));
					}
					break;
				case KEY_NAME:
					keyName = parser.getString();
					break;

				case VALUE_STRING:
					break;

				case VALUE_NUMBER:
					break;

//				case VALUE_FALSE:
//					break;
//					
//				case VALUE_NULL:
//					break;
//					
//				case VALUE_TRUE:
//					break;
//					
				case END_OBJECT:
					p.setAddress(add);
					p.setPhoneNumbers(phones);
					break;
				case END_ARRAY:
					break;
				default:
					break;
				}
			}

		}catch (IOException e) {
			e.printStackTrace();
		}

		return p;
	}
}
