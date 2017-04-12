package Utils;
import java.sql.*;

public class DBUtil {
	public static String classname = "com.mysql.jdbc.Driver";
	public static String url = "jdbc:mysql://localhost:3306/city"
					+"?useUnicode=true&characterEncoding=utf8&";
	public static String username = "root";
	public static String password = "";
	
	
	static {
		try {	
			Class.forName( classname );
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	public static Connection getConnection() throws SQLException{
		Connection conn = 
			DriverManager.getConnection(url,username,password);
		return conn;
	}
	
	public static void close( Connection conn ){
		if( conn!=null ){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws SQLException {
		Connection conn = DBUtil.getConnection();
		System.out.println( conn );
		DBUtil.close(conn);
	}
}