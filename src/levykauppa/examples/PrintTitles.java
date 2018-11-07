package levykauppa.examples;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import levykauppa.database.ChinookDatabase;

public class PrintTitles {

	public static void main(String[] args) throws SQLException {
		
		System.out.println("kaikkien albumien nimet");
		ChinookDatabase db = new ChinookDatabase();
			
		Connection conn = db.connect();
		PreparedStatement statement = conn.prepareStatement("SELECT Title FROM Album ORDER BY Title ASC;");
		ResultSet results = statement.executeQuery();

		while (results.next()) {
			String title = results.getString("Title");
			System.out.println(title);
		}

		results.close();
		statement.close();
		conn.close();
	}
}