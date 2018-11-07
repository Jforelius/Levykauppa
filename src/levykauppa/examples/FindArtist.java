package levykauppa.examples;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import levykauppa.database.ChinookDatabase;

public class FindArtist {

	
	public static void main(String[] args) throws SQLException {
		
		ChinookDatabase db = new ChinookDatabase();
		Connection conn = db.connect();
		
		PreparedStatement statement = conn.prepareStatement("SELECT * FROM Album WHERE ArtistID = (SELECT ArtistID FROM Artist WHERE Name = ?);");
		
		
		String input = "AC/DC";
		statement.setString(1, input);
		
		ResultSet results = statement.executeQuery();	
		while (results.next()) {
			
			System.out.println(results.getString("Title"));
		}
		
		results.close();
		statement.close();
		conn.close();
		
	}
}
