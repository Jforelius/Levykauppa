package levykauppa.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import levykauppa.database.ChinookDatabase;
import levykauppa.models.Artist;

public class ArtistDao {

	public List<Artist> getAllArtist() {
		ArrayList<Artist> list = new ArrayList<>();
		
		ChinookDatabase db = new ChinookDatabase();
		Connection conn = db.connect();
		PreparedStatement statement = null;
		ResultSet results = null;
		
		try {
			statement = conn.prepareStatement("SELECT * FROM Artist ORDER BY Artist;");
			results = statement.executeQuery();
		} catch (SQLException e) {
			
		}
		return list;
	}
	
	
	
	
	
}
