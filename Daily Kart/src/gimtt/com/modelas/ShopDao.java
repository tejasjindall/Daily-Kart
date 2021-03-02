package gimtt.com.modelas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ShopDao implements IDAO{
	
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

	public IDModel[] getShops (String catID){
		try {

			Connection conn = getDBConnection();
			Statement stmt =conn.createStatement();
			String query = "select * from shops where category_fk = '"+catID+"'";
			ResultSet rs =stmt.executeQuery(query);
			
			ArrayList<ShopModel> collection = new ArrayList<ShopModel>();
			
			while(rs.next()) {
				String id = rs.getString(1);
				String catFk = rs.getString(2);
				String name = rs.getString(3);
				int scoNo = rs.getInt(4);
				String owner = rs.getString(5);
				Long contact = rs.getLong(6);
				
				ShopModel model = new ShopModel();
				model.setId(id);
				model.setCatFk(catFk);
				model.setName(name);
				model.setScoNo(scoNo);
				model.setOwner(owner);
				model.setContactNo(contact);
		
				collection.add(model);
			}
			int len = collection.size();
			ShopModel models[] = new ShopModel[len];
			collection.toArray(models);
			return models;

		} catch (Exception e) {
		 return null;
		}
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
