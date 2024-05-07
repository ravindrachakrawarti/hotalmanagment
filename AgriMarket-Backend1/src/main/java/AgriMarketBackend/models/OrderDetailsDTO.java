package AgriMarketBackend.models;

import org.springframework.beans.BeanUtils;

import AgriMarketBackend.Entity.OrderDetails;
import AgriMarketBackend.Entity.Product;



public class OrderDetailsDTO {
	
	private int id;
	private Product product;
	private int qty;
	private String selectedItem;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}


	


	public String getSelectedItem() {
		return selectedItem;
	}


	public void setSelectedItem(String selectedItem) {
		this.selectedItem = selectedItem;
	}


	public static OrderDetailsDTO fromEntity(OrderDetails entity) {
		OrderDetailsDTO dto = new OrderDetailsDTO();
		BeanUtils.copyProperties(entity, dto);		
		return dto;
	}
}
