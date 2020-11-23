package theproject.trial.model;

public class Client {
	private String username;
	private String email;
	private String pwd;
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
	public Client(String username,String pwd) {
		super();
		
		this.email=new String();
		this.username = new String();
		this.pwd=new String();
	}
	public Client() {
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
