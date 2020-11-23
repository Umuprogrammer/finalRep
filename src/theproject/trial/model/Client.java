package theproject.trial.model;

import theproject.trial.Bll.Functionalities;
import theproject.trial.UserDataAccess.ClientODA;

public class Client  extends Functionalities{
	private String id;
	private String username;
	private String email;
	private String pwd;
	public static  boolean loggedIn;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public static void signIn(String username,String password) throws Exception {
		
		ClientODA.signIn(username, password);
	}
	public static void signUp(String username,String password,String email) {
		
	}
	public Client() {
		
		this.id=new String();
		this.email=new String();
		this.username = new String();
		this.pwd=new String();
		loggedIn= false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
