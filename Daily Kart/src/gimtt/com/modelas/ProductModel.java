package gimtt.com.modelas;

public class ProductModel implements IDModel{
	
	private String id;
	private String catFk;
	private String shopfk ;
	private String name;
	private String brand;
	private int price;
	public String getId() {
		return id; 

}

	public String getCatFk() {
		return catFk;
	}
	public void setCatFk(String catFk) {
		this.catFk = catFk;
	}
	public String getShopfk() {
		return shopfk;
	}
	public void setShopfk(String shopfk) {
		this.shopfk = shopfk;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}