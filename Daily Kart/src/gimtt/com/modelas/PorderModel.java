package gimtt.com.modelas;

import java.sql.Date;

public class PorderModel implements IDModel {
	private int id;
	private int useridfk;
	private Date date ;
	private int total;
	public int getId() {
		return id; 
	}
	public int getUseridfk() {
		return useridfk;
	}
	public void setUseridfk(int useridfk) {
		this.useridfk = useridfk;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public void setId(int id) {
		this.id = id;
	}

}
