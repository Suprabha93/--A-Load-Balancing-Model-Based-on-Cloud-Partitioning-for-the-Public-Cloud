import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private static Connection con;

	static Connection getConnection() {

		try {

			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:balancer");

			System.out.println("connected ");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return con;
	}
}
