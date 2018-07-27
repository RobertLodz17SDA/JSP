package pl.sdacademy.servlets;

import pl.sdacademy.model.Person;
import pl.sdacademy.model.enums.Sex;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShowPersonServlet", value = "/showPerson")
public class ShowPersonsServlet extends HttpServlet{

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            List<Person> peopleList = new ArrayList<>();
            
            Connection connection = null;
            ResultSet resultSet = null;
            PreparedStatement preparedStatement = null;

            try {
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection("jdbc:sqlite://home/robert-dell/peopleDB.db");
                String query = "SELECT * FROM people;";
                System.out.println("Query :");
                System.out.println(query);
                preparedStatement = connection.prepareStatement(query);
                resultSet = preparedStatement.executeQuery();
                try {
                    while (resultSet.next()) {
                        String name = resultSet.getString(1);
                        String surname = resultSet.getString(2);
                        int year = resultSet.getInt(3);
                        int phone = resultSet.getInt(4);
                        Sex sex = Sex.valueOf(resultSet.getString(5));
                        Person person = new Person(name,surname,year,phone,sex);
                        System.out.println(person.toString());
                        peopleList.add(person);
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }

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
                try {
                    resultSet.close();
                } catch (SQLException | NullPointerException e) {
                    e.printStackTrace();
                }
            }

            
            request.setAttribute("peopleList", peopleList);
            request.getRequestDispatcher("showPersons.jsp").forward(request, response);
        }
    }
