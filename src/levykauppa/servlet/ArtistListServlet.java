package levykauppa.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import levykauppa.dao.ArtistDao;
import levykauppa.database.ChinookDatabase;
import levykauppa.models.Artist;

@WebServlet("/artists")
public class ArtistListServlet extends HttpServlet {
    private ArtistDao artistDao = new ArtistDao(new ChinookDatabase());

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Artist> artists = artistDao.getAllArtists();

        req.setAttribute("artists", artists);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/ArtistList.jsp");
        dispatcher.include(req, resp);

    }
}