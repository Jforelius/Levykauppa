package levykauppa.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import levykauppa.dao.AlbumDao;
import levykauppa.dao.ArtistDao;

import levykauppa.database.ChinookDatabase;
import levykauppa.models.Album;
import levykauppa.models.Artist;

@WebServlet("/artist")
public class ArtistServlet extends HttpServlet {

    private ArtistDao artistDao = new ArtistDao(new ChinookDatabase());
    private AlbumDao albumDao = new AlbumDao(new ChinookDatabase());


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));

        Artist a = artistDao.findArtist(id);
        List <Album> albums = albumDao.findAlbum(id);
        

        req.setAttribute("artist", a);
        req.setAttribute("albums", albums); 

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/Artist.jsp");
        dispatcher.include(req, resp);
    }
}