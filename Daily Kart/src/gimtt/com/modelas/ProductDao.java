package gimtt.com.modelas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
 

public class ProductDao implements IDAO{
	
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

	public IDModel[] getProducts (String shopID){
		try {

			Connection conn = getDBConnection();
			Statement stmt =conn.createStatement();
			String query = "select * from products where shop_fk = '"+shopID+"'";
			ResultSet rs =stmt.executeQuery(query);
			
			ArrayList<ProductModel> collection = new ArrayList<ProductModel>();
			
			while(rs.next()) {
				String id = rs.getString(1);
				String catFk = rs.getString(2);
				String shopFk = rs.getString(3);
				String name = rs.getString(4);
				String brand = rs.getString(5);
				int price = rs.getInt(6);
			
				
				ProductModel model = new ProductModel();
				model.setId(id);
				model.setCatFk(catFk);
				model.setShopfk(shopFk);
				model.setName(name);
				model.setBrand(brand);
				model.setPrice(price);
		
		
				collection.add(model);
			}
			int len = collection.size();
			ProductModel models[] = new ProductModel[len];
			collection.toArray(models);
			return models;

		} catch (Exception e) {
		 return null;
		}
	
	}

	@Override
	public IDModel getModel(String id) {
		try {

			Connection conn = getDBConnection();
			String query = "select * from products where product_id = '"+id +"'";
			
			Statement stmt =conn.prepareStatement(query);
			//stmt.setString(1, id);
			ResultSet rs =stmt.executeQuery(query);
			 
			rs.next();
			ProductModel pmodel = new ProductModel();
			pmodel.setId(rs.getString(1));
			pmodel.setName(rs.getString(2));
			pmodel.setPrice(rs.getInt(6));
			return pmodel;
		}catch(Exception e){
			return null; 
		}
		 
	
	}

	@Override
	public IDModel[] getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDModel save(IDModel model) {
		// TODO Auto-generated method stub
		return null;
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
