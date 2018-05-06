<%@ page import="ga.wenbin.util.DBUtil" %>
<%@ page import="java.sql.Connection" %><%--
  Created by IntelliJ IDEA.
  User: wenbinli
  Date: 5/4/18
  Time: 10:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Empoyees</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <h3>Employee List</h3>
    <hr>

    <div>
        <%
            Connection connection = DBUtil.connectionLoader();

        %>
    </div>
</body>
</html>
