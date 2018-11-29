package levykauppa.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import levykauppa.dao.ArtistDao;
import levykauppa.database.ChinookDatabase;
import levykauppa.models.Artist;

@WebServlet("/artist")
public class ArtistServlet extends HttpServlet {

    private ArtistDao artistDao = new ArtistDao(new ChinookDatabase());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));

        Artist a = artistDao.findArtist(id);
        // resp.getWriter().println(a.getName());

        req.setAttribute("artist", a);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/artist.jsp");
        dispatcher.include(req, resp);
    }
}