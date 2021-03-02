package gimtt.com.modelas;

public interface IDAO {
	public IDModel getModel(String id);
	public IDModel[] getAll();
	public IDModel save(IDModel model);
	public IDModel update(IDModel model);
	public boolean deletion(int id);
	
	

}
