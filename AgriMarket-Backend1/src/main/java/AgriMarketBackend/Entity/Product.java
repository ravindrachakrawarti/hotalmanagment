package AgriMarketBackend.Entity;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.apache.tomcat.util.codec.binary.Base64;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="addedproduct")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prodid;
	private String pname;
	private String descr;
	@ManyToOne
	@JoinColumn(name = "cat_id")
	private Category category;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private Seller seller;
	
	private int price;
	private String selectedItem;
	
	@Transient
	private String productImgUtility;

	public static final int maxContentSize = 2097152;
	
	@Lob
	@Column(length=maxContentSize)
	private byte[] photo;
	private int qty;
	private LocalDateTime createdOn;
	
	public Product() {
		this.createdOn=LocalDateTime.now();
	}
	
	public Product(int prodid) {
		this.prodid=prodid;
	}
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	
	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public int getProdid() {
		return prodid;
	}
	public void setProdid(int prodid) {
		this.prodid = prodid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getProductImgUtility() throws UnsupportedEncodingException {
		
		byte[] encodeBase64 = Base64.encodeBase64(getPhoto(),true);
		String base64Encoded = new String(encodeBase64, "UTF-8");
		return base64Encoded;
	}

	public void setProductImgUtility(String productImgUtility) {
		this.productImgUtility = productImgUtility;
	}
	
	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
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

	@Override
	public String toString() {
		return "Product [prodid=" + prodid + ", pname=" + pname + ", descr=" + descr + ", category=" + category
				+ ", seller=" + seller + ", price=" + price + ", selectedItem=" + selectedItem + ", productImgUtility="
				+ productImgUtility + ", photo=" + Arrays.toString(photo) + ", qty=" + qty + ", createdOn=" + createdOn
				+ "]";
	}

	
	
	
	
}
