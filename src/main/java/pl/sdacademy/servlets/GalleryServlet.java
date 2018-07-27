package pl.sdacademy.servlets;

import pl.sdacademy.model.enums.GalleryDisplayType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

@WebServlet(name = "GalleryServlet", urlPatterns = {"/gallery"})
public class GalleryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        URL fileUrl = HomeServlet.class.getResource("../../../plik.txt");
        FileReader reader = null;
        List<String> imagesURLs = new ArrayList<>();
        try {
            reader = new FileReader(new File(fileUrl.toURI()));
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                imagesURLs.add(scanner.nextLine());
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        request.setAttribute("urls", imagesURLs);
        request.setAttribute("display_type", GalleryDisplayType.ONE_COLUMN);

        request.getRequestDispatcher("gallery.jsp").forward(request, response);
    }
}
