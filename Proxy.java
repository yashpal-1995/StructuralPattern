package practice.lld.machine.structural;

/**
 * proxy means filtering : whenever you need filtering you can use this pattern 
 * in below Example: you want to allow only admin users to execute delete query on DB
 * { Access control }
 * @author Yash
 *
 */
interface DatabaseExecutor{
	public void executeDatabase(String query) throws Exception;
}
class DatabaseExecutorImpl implements DatabaseExecutor{

	@Override
	public void executeDatabase(String query) {
		// TODO Auto-generated method stub
		System.out.println("going to execute query : "+query);
	}
	
}
// Proxy class : it allows only admin users to execute delete query otherwise throw Exception
class DatabaseExecutorProxy implements DatabaseExecutor{
    
	boolean isAdmin;
	DatabaseExecutor dbExecutor;
	
	public DatabaseExecutorProxy(String username,String password){
		if(username.equals("Admin") && password.equals("Admin@123")){
			this.isAdmin = true;
			dbExecutor = new DatabaseExecutorImpl();
		}
	}
	@Override
	public void executeDatabase(String query) throws Exception {
		// TODO Auto-generated method stub
		if(isAdmin){
			dbExecutor.executeDatabase(query);
		}else{
			if(query.equals("DELETE")){
				throw new Exception("DELETE not allowed for non-admin users");
			}else{
				dbExecutor.executeDatabase(query);
			}
		}
	}
	
}
public class Proxy {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
          
		DatabaseExecutor adminExecutor = new DatabaseExecutorProxy("Admin","Admin@123");
		adminExecutor.executeDatabase("DELETE");
		
		DatabaseExecutor nonAdminExecutor = new DatabaseExecutorProxy("nonAdmin","Admin@123");
		nonAdminExecutor.executeDatabase("DELETE");
		
	}

}
