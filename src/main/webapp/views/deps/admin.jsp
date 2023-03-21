<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import ="java.util.List" %>
<%@ page import ="models.Department" %>
<%@ page import ="services.DepsService" %>

<!DOCTYPE html>
<html lang="uk">
<head>
    <%@include file="../../views/layouts/head.jsp"%>
    <style>
        #deps-table {
            width: 60%;
            margin: 20px auto;
            margin-top: 30px;
        }
        #deps-table th,
        #deps-table td {
            padding: 5px;
            border: 1px solid silver;
        }
        #deps-table th {
            background-color: whitesmoke;
        }
    </style>
</head>
<body>
<header>
    <%@include file="../../views/layouts/nav.jsp"%>
</header>
<main class="container">
    <div class="bg-light p-5 rounded text-center main-box">
        <div class="title-box">
            <h1>Моя компанія</h1>
            <h3>Офіційний сайт компаніх MyCompany</h3>
        </div>
        <div class="content-box">
            <%-- Content Placeholder --%>
            <h2>Департаменти</h2>
                <p>
                    <a href="/Departments?page=create">Створити новий департамент</a>
                </p>
                <%
                    DepsService service = (DepsService) request.getAttribute("service");
                    var deps = service.getAllDeps();
                %>
                <table id="deps-table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Назва департаменту</th>
                            <th>Управління даними</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Department dep : deps) { %>
                            <tr>
                                <td class="cell-1"><%=dep.getId()%></td>
                                <td class="cell-2"><%=dep.getName()%></td>
                                <td class="cell-3">
                                    <a href="" class="btn btn-sm btn-primary">Деталі</a>
                                    <a href="" class="btn btn-sm btn-success">Змінити</a>
                                    <a href="" class="btn btn-sm btn-danger">Видалити</a>
                                </td>
                            </tr>
                        <% } %>
                    </tbody>
                </table>
            <%-- /Content Placeholder --%>
        </div>
    </div>
</main>
<footer class="container text-center">
    <%@include file="../../views/layouts/footer.jsp"%>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
