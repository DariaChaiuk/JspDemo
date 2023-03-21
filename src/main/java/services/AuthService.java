package services;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuthService {
    private UsersService usersService;
    public AuthService() {
        usersService = new UsersService();
    }
    public void handleSignup (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var inputLogin = request.getParameter("login");
        var inputPass1 = request.getParameter("password1");
        var inputEmail = request.getParameter("email");

        String hashPassword = getMD5Hash(inputPass1);
        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        var now = LocalDateTime.now();
        var regdate = formatter.format(now);
        var resultSuccess = usersService.addUser(inputLogin, hashPassword, inputEmail, regdate, 1, 1);

        String message;
        if(resultSuccess){
            message = "Ви успішно зареєстровані";
            request.getSession().setAttribute("currentUser",
                    new User(1,inputLogin,hashPassword, inputEmail, regdate, 1, 1, 0));
        } else {
            message = "Помилка реєстрації";
            request.getSession().setAttribute("currentUser", null);
        }
        PageService.goToAuthResult(request, response, "- Звіт про реєстрацію",
                message,resultSuccess);
    }

    public void handleSignin (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        var inputLogin = request.getParameter("login");
        var inputPass = request.getParameter("password");
        String hashPassword = getMD5Hash(inputPass);
        var user = usersService.getUser(inputLogin, hashPassword);
        String message;
        if(user!=null){
            message = "Ви успішно авторизовані";
            request.getSession().setAttribute("currentUser", user);
        } else {
            message = "Користувача з такими параметрами не зареєстровано";
            request.getSession().setAttribute("currentUser", null);
        }
        PageService.goToAuthResult(request, response, "- Звіт про авторизацію",
                message,user!=null);
    }

    private String getMD5Hash(String initPassword){
        String hashPassword = "";
        try {
            var md5 = MessageDigest.getInstance("MD5");
            md5.update(StandardCharsets.UTF_8.encode(initPassword));
            hashPassword = String.format("%032x", new BigInteger(1, md5.digest()));
        }
        catch (NoSuchAlgorithmException ex){
            System.out.println(ex.getMessage());
        }
        return hashPassword;
    }

    public static String getCurrentUserLogin(HttpServletRequest request) {
        var user = (User) request.getSession().getAttribute("currentUser");
        return user!=null ? user.getLogin() : "Гість";
    }
}
