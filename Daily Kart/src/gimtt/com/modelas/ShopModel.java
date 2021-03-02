package gimtt.com.modelas;

public class ShopModel  implements IDModel{
	
	private String id;
	private String catFk;
	private String name;
	private int scoNo;
	private String owner;
	private Long contactNo;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCatFk() {
		return catFk;
	}
	public void setCatFk(String catFk) {
		this.catFk = catFk;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScoNo() {
		return scoNo;
	}
	public void setScoNo(int scoNo) {
		this.scoNo = scoNo;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public Long getContactNo() {
		return contactNo;
	}
	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

}
