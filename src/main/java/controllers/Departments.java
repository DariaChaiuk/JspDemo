package controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import services.DepsService;
import services.PageService;

import java.io.IOException;

@WebServlet(name = "Departments", value = "/Departments")
public class Departments extends HttpServlet {

    private DepsService depsService;
    public Departments() {
        super();
        depsService = new DepsService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        if(page.isBlank()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        switch (page) {
            case "admin":
                PageService.goToPage(request, response, "views/deps/admin.jsp", "- Департаменти", depsService);
                break;
            default:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
