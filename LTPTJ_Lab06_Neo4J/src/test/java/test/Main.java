/**
 * 
 */
package test;

import java.net.URI;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Session;

/**
 * @author  Trần Nguyên Vũ, Trần Ngọc Phát, Mai Nhật Hào, Trần Thanh Vy
 * @version 1.0
 * @created 10-Oct-2023 13:36:00
 */
public class Main {
	public static void main(String[] args) {
		URI uri = URI.create("neo4j://localhost:7687");
		String username = "neo4j";
		String password = "12345678";
		Driver driver = GraphDatabase.driver(uri, AuthTokens.basic(username, password));
		
		Session session = driver.session();
		System.out.println(session.isOpen());
	}
}
