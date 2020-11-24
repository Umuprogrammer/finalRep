package theproject.trial.UserDataAccess;


import java.sql.ResultSet;


import theproject.trial.model.Client;
import theproject.trial.util.Dbutil;

public class ClientODA {
	//
	
	public static Client signIn(String username, String password) throws Exception {
		String sql="select * from users where (username='"+username+ "' or email='"+username+"' ) and pwd='"+ password+"'";
		 
		ResultSet rs=Dbutil.executeResultSet(sql);
	
		int a=0;
		String id=new String();		
		String email=new String();
		
		while(rs.next()) {
			a++;
			id=rs.getString("id");
			email=rs.getString(2);
			
		}
			 if( a==1) {
			
			Client user= Client.signOut();	
			user.setId(id);
			user.setUsername(username);
			user.setEmail(email);		
			user.changePassword( password);
			user.setLoggedIn(true);
			
			Dbutil.close();
			
			return user;
			//System.out.println(id+" "+username+" "+email+"  "+password);
		}
		else {
			Dbutil.close();
			return Client.signOut();
			//System.out.println("wrong username or password");
		}
		
			 
			
	}
	public static Client signUp(String username,String email, String password) throws Exception {
		String sql="insert into users  (username, email,pwd) values ('"+username+"', '"+email+"', '"+password+"');";
		String sql1="select count(*) from users where username='"+username+ "' or email='"+email+"'";
		String rows= Dbutil.executeScalar(sql1).toString(),i= "0";//number of rows must be 0
		if( rows.equals(i)) {
		Dbutil.update(sql);
		return signIn(username, password);
		}
		else {
			Dbutil.close();
			return Client.signOut();
			//System.out.println("the username has been used   "+rows);
			
		}
		
		
	}
	public static String changePassword(Client c,String newPassword) throws Exception
	{if (c.isLoggedIn()) {
		String sql="update users set pwd='"+newPassword+"' where id='"+c.getId()+"'";
		Dbutil.update(sql);
		Dbutil.close();
		return newPassword;
		}
	else {
		return c.getPwd();
	}
	}
	public static void main(String[] args) throws Exception {
		
		
		
		Client currentUser=signIn("test11@test.test","123");
		System.out.println(currentUser.getId());
		
		
		currentUser=Client.signOut();
		System.out.println(currentUser.getId() + "signOut " + currentUser.isLoggedIn());
		
		//currentUser=signUp("test5","test5@test.test","123");
		//System.out.println(currentUser.getId() + "after signup " + currentUser.isLoggedIn());
		
		currentUser=signUp("test2","test2@test.test","123");
		System.out.println(currentUser.getId() + "signup with an exist account " + currentUser.isLoggedIn());
		
		currentUser=signIn("test@test.test","1234");
		System.out.println(currentUser.getId() + "change password test  " + currentUser.isLoggedIn()+ "original "+ currentUser.getPwd() );
		currentUser.changePassword("12345");
		System.out.println(currentUser.getId() + "new pasword " + currentUser.isLoggedIn()+ " "+ currentUser.getPwd() );
		currentUser=Client.signOut();
		System.out.println(currentUser.getId() + "while signedOut " + currentUser.isLoggedIn()+ " "+ currentUser.getPwd() );
		
	}
}
