<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: wenbinli
  Date: 5/1/18
  Time: 11:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Post test</title>
</head>
<body>
    <h2>This is a do post demo</h2>

    <br>
    <div>

        <%
            String name = (String)request.getAttribute("forward_name");
            String passwd = (String)request.getAttribute("forward_passwd");

            out.println("name is " + name);
            out.println("password is " + passwd);

            // this out has been defined
        %>
    </div>
</body>
</html>
