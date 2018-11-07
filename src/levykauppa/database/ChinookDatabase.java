package levykauppa.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChinookDatabase {
	private static final String URL = "jdbc:sqlite:M:\\\\public_html\\\\chinook\\\\Chinook_Sqlite.sqlite";
	
	public Connection connect() {
		try {
			Class.forName("org.sqlite.JDBC");
			return DriverManager.getConnection(URL);
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}


}