package controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import services.DepsService;
import services.PageService;
import services.ProductService;

import java.io.IOException;

@WebServlet(name = "Products", value = "/Products")
public class Products extends HttpServlet {

    private ProductService productService;
    public Products() {
        super();
        productService = new ProductService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        if(page.isBlank()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        switch (page) {
            case "products":
                PageService.goToPage(request, response, "views/products/products.jsp", "- Продукти", productService);
                break;
            default:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
