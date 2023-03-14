package controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import services.PageService;

import java.io.IOException;

@WebServlet(name = "Home", value = "/Home")
public class Home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        if(page.isBlank()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        switch (page) {
            case "about":
                PageService.goToPage(request, response, "views/home/about.jsp", "- Про сайт", null);
                break;
            case "contacts":
                PageService.goToPage(request, response, "views/home/contacts.jsp", "- Контакти", null);
                break;
            case "feedback":
                PageService.goToPage(request, response, "views/home/feedback.jsp", "- Feedback", null);
                break;
            default:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
