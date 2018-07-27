package pl.sdacademy.servlets;

import pl.sdacademy.model.Person;
import pl.sdacademy.model.enums.Sex;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.stream.Collectors;

@WebServlet(name = "AboutServlet", value = "/about")
public class AboutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person piotr = new Person("Piotr", "Zietek", 1992, 793522944, Sex.MALE);
        Person ania = new Person("Anna", "Kowalska", 1982, 123456789, Sex.FEMALE);
        Person jan = new Person("Jan", "Kowalski", 1975, 600100200, Sex.MALE);
        Person kasia = new Person("Katarzyna", "Malinowska", 1987, 100200300, Sex.FEMALE);

        ArrayList<Person> people = new ArrayList<>();
        people.add(piotr);
        people.add(jan);
        people.add(ania);
        people.add(kasia);

        request.setAttribute("people", people);
        request.getRequestDispatcher("about.jsp").forward(request, response);
    }
}
