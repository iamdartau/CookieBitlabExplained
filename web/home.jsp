<%--
  Created by IntelliJ IDEA.
  User: Alexey.Dartau
  Date: 14.01.2020
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
</head>
<body>
<h1>Welcome to home</h1>
    <form action="/home" method="post">
        <!--текст в поле должен быть без пробелов -->
        <!--
                        Здесь передаём наш String text
                                    ↡             -->
        <input type="text" name="cookiename">
        <button>save</button>
    </form>
<h1>
    <%
    String cookieValue = (String) request.getAttribute("cookieValue");
    out.print(cookieValue);
    %>
</h1>

<!-- сделали ссылку для Get запроса
            ↡                        -->
<a href="delete">Clear cookie</a>

</body>
</html>
