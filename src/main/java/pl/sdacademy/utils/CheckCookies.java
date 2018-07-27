package pl.sdacademy.utils;

import pl.sdacademy.servlets.LoginServlet;

import javax.servlet.http.Cookie;

public class CheckCookies {

    public static String checkCookies(Cookie[] cookie) {
        for (int i = 0; i < cookie.length; i++) {
            if (cookie[i].getName().equals(LoginServlet.userName)) {
                return "Użytkownik : " + cookie[i].getName() + " jest zalogowany";
            }
        }
        return "Zaloguj się :-)";
    }
}
