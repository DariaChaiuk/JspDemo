package services;

import com.google.inject.internal.Nullable;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;

import java.io.IOException;

public class PageService {
    public static void goToPage(
            @NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull String pagePath,
            @NotNull String pageTittle, @Nullable Object service) throws ServletException, IOException {
        request.setAttribute("title", pageTittle);
        request.setAttribute("service", service);
        RequestDispatcher dispatcher = request.getRequestDispatcher(pagePath);
        dispatcher.forward(request, response);
    }

    public static void goToAuthResult(HttpServletRequest request, HttpServletResponse response,
            String pageTitle, String resultMessage, boolean resultSuccess)
            throws ServletException, IOException {

        var color = "";
        var message = resultMessage;
        if(resultSuccess) {
            color = "green";
        }
        else {
            color = "red";
        }

        request.setAttribute("title", pageTitle);
        request.setAttribute("color", color);
        request.setAttribute("message", message);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/auth/signup_res.jsp");
        dispatcher.forward(request, response);
    }
}
