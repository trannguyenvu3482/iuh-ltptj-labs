/**
 * 
 */
package fit.iuh.util;

import java.net.URI;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;

/**
 * @author Trần Nguyên Vũ, Trần Ngọc Phát, Mai Nhật Hào, Trần Thanh Vy
 * @version 1.0
 */
public class AppUtil {

	public static Driver initDriver() {
		URI uri = URI.create("neo4j://localhost:7687");
		String username = "neo4j";
		String password = "12345678";
		return GraphDatabase.driver(uri, AuthTokens.basic(username, password));
	}
}
