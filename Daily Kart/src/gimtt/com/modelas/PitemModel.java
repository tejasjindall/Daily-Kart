package gimtt.com.modelas;

public class PitemModel implements IDModel{
	private int id;
	private String productfk;
	private int orderFk ;
	public int getOrderFk() {
		return orderFk;
	}
	public void setOrderFk(int orderFk) {
		this.orderFk = orderFk;
	}
	private int useridfk;
	private int quantity;
	private int price;
	private int total;
	public int getId() {
		return id; 

}
	public String getProductfk() {
		return productfk;
	}
	public void setProductfk(String productfk) {
		this.productfk = productfk;
	}
	 
	public int getUseridfk() {
		return useridfk;
	}
	public void setUseridfk(int useridfk) {
		this.useridfk = useridfk;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTotal() {
		return total;
	}
	public void calculateTotal() {
		this.total = this.quantity* this.price;
	}
	public void setId(int id) {
		this.id = id;
	}
}