/**
 * 
 */
package fit.iuh.entity;

/**
 * @author Trần Nguyên Vũ, Trần Ngọc Phát, Mai Nhật Hào, Trần Thanh Vy
 * @version 1.0
 */
public class Product {
	private String productId;
	private String productName;
	private String categoryId;
	private String supplierId;
	private String quantityPerUnit;
	private double unitPrice;
	private int unitsInStock;
	private int unitsOnOrder;
	private int reorderLevel;
	private boolean discontinued;

	public Product() {

	}

	public Product(String productId, String productName, String categoryId, String supplierId, String quantityPerUnit,
			double unitPrice, int unitsInStock, int unitsOnOrder, int reorderLevel, boolean discontinued) {
		this.productId = productId;
		this.productName = productName;
		this.categoryId = categoryId;
		this.supplierId = supplierId;
		this.quantityPerUnit = quantityPerUnit;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsInStock;
		this.unitsOnOrder = unitsOnOrder;
		this.reorderLevel = reorderLevel;
		this.discontinued = discontinued;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getQuantityPerUnit() {
		return quantityPerUnit;
	}

	public void setQuantityPerUnit(String quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public int getUnitsOnOrder() {
		return unitsOnOrder;
	}

	public void setUnitsOnOrder(int unitsOnOrder) {
		this.unitsOnOrder = unitsOnOrder;
	}

	public int getReorderLevel() {
		return reorderLevel;
	}

	public void setReorderLevel(int reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public boolean isDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", categoryId=" + categoryId
				+ ", supplierId=" + supplierId + ", quantityPerUnit=" + quantityPerUnit + ", unitPrice=" + unitPrice
				+ ", unitsInStock=" + unitsInStock + ", unitsOnOrder=" + unitsOnOrder + ", reorderLevel=" + reorderLevel
				+ ", discontinued=" + discontinued + "]";
	}

}
