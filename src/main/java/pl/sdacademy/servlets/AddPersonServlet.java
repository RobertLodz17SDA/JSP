package pl.sdacademy.servlets;

import pl.sdacademy.model.enums.Sex;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "AddPersonServlet", value = "/addPerson")
public class AddPersonServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        int bornYear = Integer.parseInt(request.getParameter("bornYear"));
        int phone = Integer.parseInt(request.getParameter("phone"));
        String sex = request.getParameter("sex");

        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite://home/robert-dell/peopleDB.db");
//            String query = "INSERT INTO people VALUES (\""+name+"\",\""+surname+"\","+bornYear+","+ phone+",\""+ sex+"\")";
            preparedStatement = connection.prepareStatement("INSERT INTO people VALUES (?,?,?,?,?)");
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,surname);
            preparedStatement.setInt(3,bornYear);
            preparedStatement.setInt(4,phone);
            preparedStatement.setString(5,sex);
            System.out.println("Query :");
            System.out.println(preparedStatement);
     //       preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();

        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException | NullPointerException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException | NullPointerException e) {
                e.printStackTrace();
            }
        }

        request.getRequestDispatcher("addPerson.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("addPerson.jsp").forward(request, response);
    }

}