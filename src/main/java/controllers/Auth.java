package controllers;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import services.AuthService;
import services.PageService;

@WebServlet(name = "Auth", value = "/Auth")
public class Auth extends HttpServlet {
    private AuthService authService;
    public Auth() {
        super();
        authService = new AuthService();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var page = request.getParameter("page");
        switch (page) {
            case "signup":
                PageService.goToPage(request, response, "views/auth/signup.jsp", "- Реєстрація", null);
                break;
            case "signin":
                PageService.goToPage(request, response, "views/auth/signin.jsp", "- Авторизація", null);
                break;
            case "signout":
                break;
            case "profile":
                break;
            case "confirm":
                break;
            case "ajax_signup":
                break;
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var page = request.getParameter("page");
        switch (page) {
            case "signup":
                authService.handleSignup(request, response);
                break;
            case "signin":
                authService.handleSignin(request, response);
                break;
        }
    }
}