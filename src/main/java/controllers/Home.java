package controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Home", value = "/Home")
public class Home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        switch (page) {
            case "about":
                goToPageAndSetTitle(request, response, "views/home/about.jsp", "- Про сайт");
                break;
            case "contacts":
                goToPageAndSetTitle(request, response, "views/home/contacts.jsp", "- Контакти");
                break;
            case "feedback":
                goToPageAndSetTitle(request, response, "views/home/feedback.jsp", "- Feedback");
                break;
            default:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
    private void goToPageAndSetTitle(HttpServletRequest request, HttpServletResponse response, String pagePath, String pageTittle) throws ServletException, IOException{
        request.setAttribute("title", pageTittle);
        RequestDispatcher dispatcher = request.getRequestDispatcher(pagePath);
        dispatcher.forward(request, response);
    }
}
