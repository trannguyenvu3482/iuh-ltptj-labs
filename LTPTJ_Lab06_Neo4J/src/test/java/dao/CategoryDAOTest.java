/**
 * 
 */
package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fit.iuh.dao.CategoryDAO;
import fit.iuh.entity.Category;
import fit.iuh.util.AppUtil;

/**
 * @author Trần Nguyên Vũ, Trần Ngọc Phát, Mai Nhật Hào, Trần Thanh Vy
 * @version 1.0
 * @created 5 Mar 2024
 */
class CategoryDAOTest {
	private static final String DB_NAME = "neo4j";
	private CategoryDAO categoryDAO;

	@BeforeEach
	public void setup() {
		categoryDAO = new CategoryDAO(AppUtil.initDriver(), DB_NAME);
	}

	@Test
	void testAddCategory() {
		Category category = new Category("9", "Toys", "Toys for kids", "0x00000000");
		String id = categoryDAO.addCategory(category);
		assertNotNull(id);
		String expectedId = "9";
		assertEquals(expectedId, id);
	}

	@Test
	void testFindCategory() {
		Category category = categoryDAO.findCategoryById("1");
		assertNotNull(category);
		String expectedName = "Beverages";
		assertEquals(expectedName, category.getCategoryName());
	}
}
