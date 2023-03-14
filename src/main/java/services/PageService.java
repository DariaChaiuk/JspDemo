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
        //request.setAttribute("service", service);
        RequestDispatcher dispatcher = request.getRequestDispatcher(pagePath);
        dispatcher.forward(request, response);
    }
}
