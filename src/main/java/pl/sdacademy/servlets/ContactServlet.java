package pl.sdacademy.servlets;

import pl.sdacademy.utils.EmailSender;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ContactServlet", value = "/contact")
public class ContactServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String user = name + " " + surname;
        String email = request.getParameter("email");
        String message = request.getParameter("message");

        message = message.replace("\n", "<br>");

        EmailSender emailSender = new EmailSender(user, email, message);
        emailSender.send();

        request.setAttribute("user", user);
        request.setAttribute("email", email);
        request.setAttribute("message", message);

        request.getRequestDispatcher("sendMessage.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("contact.jsp").forward(request, response);
    }
}
