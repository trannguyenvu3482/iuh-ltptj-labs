/**
 * 
 */
package fit.iuh.dao;

import java.util.Map;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;

import fit.iuh.entity.Product;

/**
 * @author Trần Nguyên Vũ, Trần Ngọc Phát, Mai Nhật Hào, Trần Thanh Vy
 * @version 1.0
 * @created 5 Mar 2024
 */
public class ProductDAO {
	private Driver driver;
	private SessionConfig sessionConfig;

	public ProductDAO(Driver driver, String dbName) {
		this.driver = driver;
		sessionConfig = SessionConfig.builder().withDatabase(dbName).build();
	}

	/**
	 * Add a new product to the database
	 * 
	 * @param product
	 * @return the added product ID
	 */
	public String addProduct(Product product) {
		String query = "CREATE (p:Product {productID: $productID, productName: $productName, supplierID: $supplierID, categoryID: $categoryID, quantityPerUnit: $quantityPerUnit, unitPrice: $unitPrice, unitsInStock: $unitsInStock, unitsOnOrder: $unitsOnOrder, reorderLevel: $reorderLevel, discontinued: $discontinued}) RETURN p.productID";

		Map<String, Object> params = Map.of("productID", product.getProductId(), "productName",
				product.getProductName(), "supplierID", product.getSupplierId(), "categoryID", product.getCategoryId(),
				"quantityPerUnit", product.getQuantityPerUnit(), "unitPrice", product.getUnitPrice(), "unitsInStock",
				product.getUnitsInStock(), "unitsOnOrder", product.getUnitsOnOrder(), "reorderLevel",
				product.getReorderLevel(), "discontinued", product.isDiscontinued());

		try (Session session = driver.session(sessionConfig)) {
			return session.executeWrite(tx -> {
				Result result = tx.run(query, params);
				return result.single().get("p.productID").asString();
			});
		}
	}
}
