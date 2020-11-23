package theproject.trial.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dbutil {
	private static Connection con=null;//
	private static ResultSet rs=null;
	private static void getConnection() {
		try { 
			Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectf?user=root&password=root");
		
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	// update, insert, delete
	private static void  update(String sql) throws SQLException {
		getConnection();
		Statement stmt= con.createStatement();
		stmt.execute(sql);
		
	}
	
	//for select,the result should be scalar
	public static Object executeScalar(String sql) throws Exception
	{
		getConnection();
		Statement stmt=con.createStatement();
		rs=stmt.executeQuery(sql);
		rs.next();
		Object o=rs.getObject(2);
		return o;
	}

	
	//for select,the result should be resultSet
	
	public static ResultSet executeResultSet(String sql) throws Exception
	{
		getConnection();
		Statement stmt=con.createStatement();
		rs=stmt.executeQuery(sql);
		return rs;
		
	}
	
	public static void close()
	{
		if(con!=null)
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(rs!=null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	
		String sql="select * from users";
		
		System.out.println(executeScalar(sql));
		System.out.print(rs.getInt(1)+rs.getString(2)+rs.getString(3)+rs.getString(4));
		
		
        close();
	}

}
