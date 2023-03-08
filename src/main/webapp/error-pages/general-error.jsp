<%@ page contentType="text/html;charset=UTF-8"%>
<html lang="uk">
  <head>
    <%@include file="../views/layouts/head.jsp"%>
    <title><%=response.getStatus() %> Error</title>
  </head>
  <body class="d-flex flex-column align-items-center justify-content-center">
    <div>
      <h2> Hi There, error code is <%=response.getStatus() %> </h2>
      <br>
      <h3> Please go to
        <a href="./">home page</a>
      </h3>
    </div>
  </body>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</html>
