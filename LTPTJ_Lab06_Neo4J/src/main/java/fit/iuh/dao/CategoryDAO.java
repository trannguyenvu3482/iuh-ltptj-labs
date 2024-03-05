/**
 * 
 */
package fit.iuh.dao;

import java.util.Map;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.types.Node;

import fit.iuh.entity.Category;

/**
 * @author Trần Nguyên Vũ, Trần Ngọc Phát, Mai Nhật Hào, Trần Thanh Vy
 * @version 1.0
 * @created 5 Mar 2024
 */
public class CategoryDAO {
	private Driver driver;
	private SessionConfig sessionConfig;

	public CategoryDAO(Driver driver, String dbName) {
		this.driver = driver;
		sessionConfig = SessionConfig.builder().withDatabase(dbName).build();
	}

	/**
	 * Add a new category to the database
	 * 
	 * @param categoryName
	 * @return the added category ID
	 */
	public String addCategory(Category category) {
		String query = "CREATE (c:Category {categoryID: $categoryID, categoryName: $categoryName, description: $description, picture: $picture}) RETURN c.categoryID";

		Map<String, Object> params = Map.of("categoryID", category.getCategoryId(), "categoryName",
				category.getCategoryName(), "description", category.getDescription(), "picture", category.getPicture());

		try (Session session = driver.session(sessionConfig)) {
			return session.executeWrite(tx -> {
				Result result = tx.run(query, params);
				return result.single().get("c.categoryID").asString();
			});
		}
	}

	/**
	 * Update the category
	 * 
	 * @param oldCategory
	 * @param newCategory
	 * @return void
	 */
	public void updateCategory(Category oldCategory, Category newCategory) {
		String query = "MATCH (c:Category {categoryName: $oldCategoryName}) SET c.categoryName = $newCategoryName, c.description = $description, c.picture = $picture, c.categoryID = $categoryID";
		Map<String, Object> params = Map.of("oldCategoryName", oldCategory.getCategoryName(), "newCategoryName",
				newCategory.getCategoryName(), "description", newCategory.getDescription(), "picture",
				newCategory.getPicture(), "categoryID", newCategory.getCategoryId());

		try (Session session = driver.session(sessionConfig)) {
			session.executeWrite(tx -> tx.run(query, params).consume());
		}
	}

	/**
	 * Delete the category
	 * 
	 * @param category
	 * @return void
	 */
	public void deleteCategory(Category category) {
		String query = "MATCH (c:Category {categoryId: $categoryId}) DETACH DELETE c";
		Map<String, Object> params = Map.of("categoryId", category.getCategoryId());

		try (Session session = driver.session(sessionConfig)) {
			session.executeWrite(tx -> tx.run(query, params).consume());
		}
	}

	/**
	 * Get the category
	 * 
	 * @param categoryId
	 * @return Category
	 */
	public Category findCategoryById(String categoryId) {
		String query = "MATCH (c:Category) WHERE (c.categoryID = $categoryId) RETURN c";
		Map<String, Object> params = Map.of("categoryId", categoryId);

		try (Session session = driver.session(sessionConfig)) {
			return session.executeRead(tx -> {
				Result result = tx.run(query, params);
				Record record = result.single();
				Node node = record.get("c").asNode();
				return new Category(node.get("categoryId").asString(), node.get("categoryName").asString(),
						node.get("description").asString(), node.get("picture").asString());
			});
		}
	}
}
