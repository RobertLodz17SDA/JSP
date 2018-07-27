package pl.sdacademy.servlets;

import pl.sdacademy.utils.CheckCookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    public static final String userName = "admin";
    public static final String userPWD = "admin";


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginName = request.getParameter("name");
        String loginPWD = request.getParameter("password");
        if (loginName.equals(userName)) {
            Cookie cookie = new Cookie(loginName, "1234");
            cookie.setMaxAge(60);
            response.addCookie(cookie);
            response.sendRedirect("index.jsp");
        } else {
            request.setAttribute("logInfo", CheckCookies.checkCookies(request.getCookies()));
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
