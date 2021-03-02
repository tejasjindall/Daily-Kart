package gimtt.com;

public class CartModel {
	
	private String qty;
	private String itemid;
	private int price;
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	 
	private String itemName;
	 
	
	private int totalAmount;
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	
	public void calculateAmount(){
		int lqty = Integer.parseInt(this.qty);
		this.totalAmount= lqty* this.price;
		
	}

}
