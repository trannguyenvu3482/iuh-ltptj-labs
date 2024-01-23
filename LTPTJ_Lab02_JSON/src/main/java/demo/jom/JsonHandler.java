package demo.jom;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import demo.entity.Address;
import demo.entity.Person;
import demo.entity.PhoneNumber;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;
import jakarta.json.JsonWriter;

public class JsonHandler {

	public static String toJson(Person p) {

		StringWriter sw = null;
		try (JsonWriter writer = Json.createWriter(sw = new StringWriter())) {
			JsonObjectBuilder oBuilder = Json.createObjectBuilder();

			// Address
			Address address = p.getAddress();
			JsonObject joAddress = oBuilder.add("streetAddress", address.getStreetAddress())
					.add("city", address.getCity()).add("state", address.getState())
					.add("postalCode", address.getPostalCode()).build();

			// Phone Number array
			JsonArrayBuilder aBuilderPhone = Json.createArrayBuilder();
			p.getPhoneNumbers().forEach(phone -> {
				JsonObject joPhone = oBuilder.add("type", phone.getType()).add("number", phone.getNumber())
						.build();
				aBuilderPhone.add(joPhone);
			});
			JsonArray jaPhone = aBuilderPhone.build();

			// Person
			JsonObject jo = oBuilder.add("firstName", p.getFirstName()).add("lastName", p.getLastName())
					.add("age", p.getAge()).add("address", joAddress).add("phoneNumbers", jaPhone).build();

			writer.writeObject(jo);
		}

		return sw.toString();
	}

	public static String toJson(List<Person> persons) {
		JsonArrayBuilder aBuilder = Json.createArrayBuilder();
		JsonObjectBuilder oBuilder = Json.createObjectBuilder();

		persons.forEach(p -> {
			try {
				// Address
				Address address = p.getAddress();
				JsonObject joAddress = oBuilder.add("streetAddress", address.getStreetAddress())
						.add("city", address.getCity()).add("state", address.getState())
						.add("postalCode", address.getPostalCode()).build();

				// Phone Number array
				JsonArrayBuilder aBuilderPhone = Json.createArrayBuilder();
				p.getPhoneNumbers().forEach(phone -> {
					JsonObject joPhone = oBuilder.add("type", phone.getType()).add("number", phone.getNumber())
							.build();
					aBuilderPhone.add(joPhone);
				});
				JsonArray jaPhone = aBuilderPhone.build();

				// Person
				JsonObject jo = oBuilder.add("firstName", p.getFirstName()).add("lastName", p.getLastName())
						.add("age", p.getAge()).add("address", joAddress).add("phoneNumbers", jaPhone).build();

				aBuilder.add(jo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		return aBuilder.build().toString();
	}

	public static List<Person> fromJsonArray(String json) {
		List<Person> persons = new ArrayList<>();

		try (JsonReader reader = Json.createReader(new StringReader(json))) {
			JsonArray ja = reader.readArray();
			ja.forEach(item -> {
				JsonObject jo = (JsonObject) item;
				if (jo != null) {
					Person p = new Person();
					p.setFirstName(jo.getString("firstName"));
					p.setLastName(jo.getString("lastName"));
					p.setPhoneNumbers(jo.getJsonArray("phoneNumbers").stream().map(phone -> {
						JsonObject joPhone = (JsonObject) phone;
						return new PhoneNumber(joPhone.getString("type"), joPhone.getString("number"));
					}).toList());

					Address add = new Address();
					add.setStreetAddress(jo.getJsonObject("address").getString("streetAddress"));
					add.setCity(jo.getJsonObject("address").getString("city"));
					add.setState(jo.getJsonObject("address").getString("state"));
					add.setPostalCode(jo.getJsonObject("address").getInt("postalCode"));

					p.setAddress(add);
					p.setAge(jo.getInt("age"));
					persons.add(p);
				}
			});
		}

		return persons;
	}

	public static Person fromJsonObject(String json) {

		Person p = null;

		try (JsonReader reader = Json.createReader(new StringReader(json))) {

			JsonObject jo = reader.readObject();
			if (jo != null) {
				p = new Person();
				p.setFirstName(jo.getString("firstName"));
				p.setLastName(jo.getString("lastName"));
				p.setAge(jo.getInt("age"));

				JsonObject joAdd = jo.getJsonObject("address");
				if (joAdd != null) {
					Address add = new Address();
					add.setStreetAddress(joAdd.getString("streetAddress"));
					add.setCity(joAdd.getString("city"));
					add.setState(joAdd.getString("state"));
					add.setPostalCode(joAdd.getInt("postalCode"));
					p.setAddress(add);
				}

				JsonArray ja = jo.getJsonArray("phoneNumbers");
				if (ja != null) {
					List<PhoneNumber> phones = new ArrayList<>();
					for (JsonValue jv : ja) {
						JsonObject joPh = (JsonObject) jv;
						PhoneNumber ph = new PhoneNumber(joPh.getString("type"), joPh.getString("number"));
						phones.add(ph);
					}
					p.setPhoneNumbers(phones);
				}
			}

		}

		return p;
	}

	public static Person fromFile(String fileName) {

		Person p = null;

		Address add = null;

		try (JsonReader reader = Json.createReader(new FileReader(fileName));) {

			JsonObject jo = reader.readObject();
			if (jo != null) {
				p = new Person();
				p.setFirstName(jo.getString("firstName"));
				p.setLastName(jo.getString("lastName"));
				p.setAge(jo.getInt("age"));

				JsonObject joAdd = jo.getJsonObject("address");

				add = new Address();
				add.setStreetAddress(joAdd.getString("streetAddress"));

				p.setAddress(add);

				JsonArray ja = jo.getJsonArray("phoneNumbers");
				List<PhoneNumber> phones = new ArrayList<>();

				for (JsonValue jv : ja) {
					JsonObject joPh = (JsonObject) jv;
					PhoneNumber ph = new PhoneNumber(joPh.getString("type"), joPh.getString("number"));
					phones.add(ph);
				}

				p.setPhoneNumbers(phones);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return p;

	}

	public static void toJsonFile(List<Person> persons, String fileName) {
		try (JsonWriter writer = Json.createWriter(new FileWriter(fileName));) {

			JsonArrayBuilder aBuilder = Json.createArrayBuilder();
			JsonObjectBuilder oBuilder = Json.createObjectBuilder();

			for (Person p : persons) {

				Address add = p.getAddress();
				JsonObject joAdd = oBuilder.add("name", add.getStreetAddress()).add("city", add.getCity()).add("state",
						add.getState()).add("postalCode", add.getPostalCode()).build();

				JsonArrayBuilder aBuilderPhone = Json.createArrayBuilder();
				p.getPhoneNumbers().forEach(phone -> {
					JsonObject joPhone = oBuilder.add("type", phone.getType()).add("number", phone.getNumber())
							.build();
					aBuilderPhone.add(joPhone);
				});
				JsonArray jaPhone = aBuilderPhone.build();

				JsonObject joPhone = oBuilder.add("phoneNumbers", jaPhone).build();

				JsonObject jo = oBuilder.add("firstName", p.getFirstName()).add("lastName", p.getLastName())
						.add("age", p.getAge()).add("address", joAdd).add("phoneNumbers", joPhone).build();

				aBuilder.add(jo);
			}

			JsonArray ja = aBuilder.build();
			writer.write(ja);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}