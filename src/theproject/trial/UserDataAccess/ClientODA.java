package theproject.trial.UserDataAccess;


import java.sql.ResultSet;

import theproject.trial.model.Client;
import theproject.trial.util.Dbutil;

public class ClientODA {
	//
	
	public static void signIn(String username, String password) throws Exception {
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
			
			Client user= new Client();	
			user.setId(id);
			user.setUsername(username);
			user.setEmail(email);		
			user.setPwd(password);
			user.loggedIn=true;
			
			
			System.out.println(id+" "+username+" "+email+"  "+password);
			
		}
		else {
			System.out.println("wrong username or password");
		}
		
			 Dbutil.close();
			
	}
	public static void signUp(String username,String email, String password) throws Exception {
		String sql="insert into users  (username, email,pwd) values ('"+username+"', '"+email+"', '"+password+"')";
		String sql1="select count(*) from users where (username='"+username+ "' or email='"+username+"' ) and pwd='"+ password+"'";
		if(Dbutil.executeScalar(sql1)==(Object)0) {
		Dbutil.update(sql);
		signIn(username, password);
		}
		Dbutil.close();
	}
	public static void main(String[] args) throws Exception {
		Client me=new Client();
		me.setUsername("root");
		me.setPwd("root");
		System.out.println(me.getUsername());
		signIn("test@test.test","123");
		me=new Client();
		System.out.println(me.getUsername());
	}
}
