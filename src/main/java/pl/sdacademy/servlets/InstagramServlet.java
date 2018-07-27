package pl.sdacademy.servlets;

import org.json.JSONArray;
import org.json.JSONObject;
import pl.sdacademy.model.enums.GalleryDisplayType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

@WebServlet(name = "InstagSeramrvlet", value = "/instagram")
public class InstagramServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("instagram.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String instagramUser = request.getParameter("instUserName");
       String numberOfPhotos = request.getParameter("noOfImages");
       int numberInt = Integer.parseInt(numberOfPhotos);
        String url = "https://instagram.com/"+instagramUser;
        URL instagramURL = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) instagramURL.openConnection();

        InputStream inputStream = connection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line = "";
        StringBuilder responseBuilder = new StringBuilder();
        while ((line = bufferedReader.readLine()) !=null){
            responseBuilder.append(line);
        }

        String pageSource = responseBuilder.toString();
        pageSource = pageSource.split(">window._sharedData = ")[1];
        pageSource = pageSource.split(";</script>")[0];

        JSONObject mainObject = new JSONObject(pageSource);
        JSONArray mainArray = mainObject.getJSONObject("entry_data")
                .getJSONArray("ProfilePage")
                .getJSONObject(0)
                .getJSONObject("graphql")
                .getJSONObject("user")
                .getJSONObject("edge_owner_to_timeline_media")
                .getJSONArray("edges");
        List<String> picturesList = new ArrayList<>();
        for (int i = 0 ; i<mainArray.length();i++){
            JSONObject nodeObject = mainArray.getJSONObject(i).getJSONObject("node");
                picturesList.add(nodeObject.getString("display_url"));
        }
        request.setAttribute("urls", picturesList);
        request.setAttribute("display_type", GalleryDisplayType.TWO_COLUMNS);
        request.getRequestDispatcher("gallery.jsp").forward(request, response);
    }
}
