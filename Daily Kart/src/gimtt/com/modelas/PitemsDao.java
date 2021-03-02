package gimtt.com.modelas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PitemsDao implements IDAO {
	private Connection getDBConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/DailyKart","root","root");
			return conn;
			    } catch (Exception e) {
				System.out.println("Excdeptio"+e.getMessage());
			}
			// TODO Auto-generated method stub
			return null;
		} 
	@Override
	public IDModel getModel(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDModel[] getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDModel save(IDModel model) {
PitemModel cm = (PitemModel)model;
		
		try {

			Connection conn = getDBConnection();
			String query = "insert into purchased_items (Product_fk, order_fk, User_ID_fk, Quantity, Price, Total) values ('" +cm.getProductfk()+"', " +cm.getOrderFk()+" ," +cm.getUseridfk()+", "+cm.getQuantity()+ ", "+cm.getPrice()+ ", "+cm.getTotal()+ ")";
			
			Statement stmt =conn.createStatement();
 
			int returnLastInsertId =stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			if(returnLastInsertId==1) {
			    ResultSet rs = stmt.getGeneratedKeys();
			    rs.next();
			    cm.setId(rs.getInt(1));
			} 
			return cm;
		}
		
		
			
		
		catch (Exception e) {
		 return null;
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public IDModel update(IDModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deletion(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
