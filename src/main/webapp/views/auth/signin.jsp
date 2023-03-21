<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="uk">
<head>
  <%@include file="../../views/layouts/head.jsp"%>
  <style>
    #signupForm {
      border: 1px solid silver;
      border-radius: 15px;
      width: 450px;
      padding: 20px 40px 30px;
      margin: 20px auto;
      text-align: left;
    }
    label {
      padding-bottom: 0px;
      color: navy;
      margin-top: 5px;
    }

    .my-btn {
      margin-top: 25px;
      margin-bottom: 10px;
      width: 150px;
      border-radius: 5px;
    }

    .error {
      display: block;
      margin-top: 3px;
      color: red;
      font-style: italic;
      font-size: 10pt;
    }

    footer {
      padding-top: 30px;
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
      <h2>Реєстррація</h2>
      <form id="signupForm" action="Auth?page=signin" method="post" onsubmit="return true">
        <div class="form-group">
          <label for="login">Логін:</label>
          <input type="text" id="login" name="login" class="form-control" required>
          <span id="login-err" class="error"></span>
        </div>
        <div class="form-group">
          <label for="password">Підтвердження пароля:</label>
          <input type="password" id="password" name="password" class="form-control" required>
          <span id="password-err" class="error"></span>
        </div>
        <div class="form-group text-center">
          <input type="submit" id="submit" value="Відправити" class="btn btn-success my-btn">
          <input type="reset" id="reset" value="Очистити" class="btn btn-danger my-btn">
        </div>
      </form>
      <script src="static/js/signup.js"></script>
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
