package levykauppa.dao;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import levykauppa.database.ChinookDatabase;
import levykauppa.models.Album;
import levykauppa.models.Artist;


public class AlbumDao {
	private ChinookDatabase db;
	
    public AlbumDao(ChinookDatabase db) {
        this.db = db;
    }
	
    public List <Album> findAlbum(long id) {
        ArrayList<Album> albumlist = new ArrayList<Album>();
    	Connection connection = db.connect();
        PreparedStatement statement = null;
        ResultSet results = null;
        
        try {
            statement = connection.prepareStatement("SELECT AlbumId, Title, ArtistId FROM Album WHERE ArtistId = ?");
            statement.setLong(1, id);
            results = statement.executeQuery();  
            
            while (results.next()) {
				long artistId = results.getLong("ArtistId");
				String title = results.getString("Title");
				long albumId = results.getLong("AlbumId");
				albumlist.add(new Album (albumId, title, artistId));
				
			} 
           
        }    catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.close(results, statement, connection);
        }
        return albumlist;
    }
	
}
