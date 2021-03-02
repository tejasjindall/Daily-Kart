package gimtt.com.modelas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

public class CategoryDao  implements IDAO {
 public CategoryDao() {
	// TODO Auto-generated constructor stub
}

 	 
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
	try{
		Connection conn = getDBConnection();
		String query = "select * from category";
//		PreparedStatement stmt = conn.prepareCall(arg0)
//		ResultSet rs =stmt.executeQuery(query);
		
	} catch (Exception e){
	 	
	}
		
		return null;
	}
	
	@Override
	public IDModel[] getAll() {
		Connection conn = getDBConnection();
		try {
			Statement stmt =conn.createStatement();
			String query = "select * from category";
			ResultSet rs =stmt.executeQuery(query);
			
			ArrayList<CategoryModels> collection = new ArrayList<CategoryModels>();
			
			while(rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				CategoryModels model = new CategoryModels();
				model.setId(id);
				model.setProduct_type(name);
				collection.add(model);
			}
			int len = collection.size();
			CategoryModels models[] = new CategoryModels[len];
			collection.toArray(models);
			return models;
			
			
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
