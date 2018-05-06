<%--
  Created by IntelliJ IDEA.
  User: wenbinli
  Date: 5/1/18
  Time: 9:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>welcome</title>
</head>
<body>
<form action="WelcomeServlet">
    <input type="submit" value="call servlet"/>
    <br>

</form>

<form action="Servlet2">
    <input type="submit" value="call to servlet2"/>
</form>


<form action="Servlet0">
    <input type="submit" value="call to servlet 0">
</form>


<form action="Servlet4" method="post">
    <input type="text" name="name" placeholder="name"/>
    <input type="password" name="passwd" placeholder="password"/><br>
    <input type="submit" value="call to servlet 4">
</form>
</body>
</html>
