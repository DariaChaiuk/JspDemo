<%@ page import="models.User" %>
<%@ page import="controllers.Auth" %>
<%@ page import="services.AuthService" %>
<%@ page pageEncoding="UTF-8" language="java" %>
    <nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
        <div class="container-fluid">
            <a class="navbar-brand" href="./">My Company</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav me-auto mb-2 mb-md-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="./">Головна</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="Home?page=about">Про сайт</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="News?page=list">Новини</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="Products?page=catalog">Продукти</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="Home?page=contacts">Контакти</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="Home?page=feedback">Feedback</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="dropdown" data-bs-toggle="dropdown" aria-expanded="false">Адмін</a>
                        <ul class="dropdown-menu" aria-labelledby="dropdown">
                            <li><a class="dropdown-item" href="Departments?page=admin">Департаменти</a></li>
                            <li><a class="dropdown-item" href="Employees?page=admin">Співробітники</a></li>
                            <li><a class="dropdown-item" href="Users?page=admin">Користувачі</a></li>
                        </ul>
                    </li>
                </ul>
                <ul class="navbar-nav ms-auto nb-2 mb-md-0">
                    <li class="nav-item">
                        <a class="nav-link" href="#" style="margin-right: 75px">
                            <span style="color: bisque">Привіт,
                                <%= AuthService.getCurrentUserLogin(request)%>!
                            </span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Auth?page=signin">Вхід</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Auth?page=signup">Реєстрація</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
