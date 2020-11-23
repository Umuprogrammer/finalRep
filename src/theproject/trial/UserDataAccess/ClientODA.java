package theproject.trial.UserDataAccess;


import java.sql.ResultSet;

import theproject.trial.model.Client;
import theproject.trial.util.Dbutil;

public class ClientODA {
	public static  boolean loggedIn;
	public static Client currentuser=new Client();
	public static void signIn(Client user) throws Exception {
		String sql="select * from users where (username='"+user.getUsername()+ "' or email='"+user.getEmail()+"' ) and pwd='"+ user.getPwd()+"'";
		 
		ResultSet data = null,rs=Dbutil.executeResultSet(sql);
		int row= rs.getRow();
		int a=0;
		
		while(rs.next()) {
			a++;
			
			System.out.println(rs.getString(2));
			
		}
				
		if( a==1) {
			
			loggedIn=true;
			currentuser.setEmail(rs.getString(2));
			currentuser.setUsername(rs.getString(3));
			
			System.out.println(currentuser.getEmail());
			System.out.println(currentuser.getUsername());
		}
		System.out.println(a);
		
		
			
	}
	public static void main(String[] args) throws Exception {
		Client me=new Client();
		me.setUsername("root");
		me.setPwd("root");
		signIn(me);
		
	}
}
