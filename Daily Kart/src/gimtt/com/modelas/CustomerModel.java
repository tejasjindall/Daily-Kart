package gimtt.com.modelas;

public class CustomerModel implements IDModel {
	private int id ;
	private String Name ;
	private String Email_ID ;
	private Long PhoneNO ;
	private String Address ;
	public int getId() {
		return id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail_ID() {
		return Email_ID;
	}
	public void setEmail_ID(String email_ID) {
		Email_ID = email_ID;
	}
	public Long getPhoneNO() {
		return PhoneNO;
	}
	public void setPhoneNO(Long phoneNO) {
		PhoneNO = phoneNO;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public void setId(int id) {
		this.id = id;
	}

}

	
