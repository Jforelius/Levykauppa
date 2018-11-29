package levykauppa.examples;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import levykauppa.database.ChinookDatabase;

public class PrintTitles {

	public static void main(String[] args) throws SQLException {
		
		
	        String sql = "SELECT * FROM Album WHERE ArtistId = (SELECT ArtistId FROM Artist WHERE Name = ?)";

	        Scanner scanner = new Scanner(System.in);
	        ChinookDatabase db = new ChinookDatabase();

	        Connection conn = db.connect();
	        PreparedStatement statement = conn.prepareStatement(sql);

	        System.out.print("Kirjoita artisti: ");
	        String artistName = scanner.nextLine();

	        statement.setString(1, artistName);
	        ResultSet results = statement.executeQuery();

	        System.out.println("Löytyi seuraavat albumit:");
	        while (results.next()) {
	            System.out.println(results.getString("Title"));
	        }

	        db.close(results, statement, conn);
	        scanner.close();
	    }

	}
