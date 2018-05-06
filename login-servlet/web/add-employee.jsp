<%--
  Created by IntelliJ IDEA.
  User: wenbinli
  Date: 5/4/18
  Time: 2:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>


<head>

    <title>Add Employee</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        label {
            width: 150px;
            display: inline-block;
        }
    </style>

</head>
<body>
<div class="container">
    <div class="row row-center">
        <div class="container">
            <nav class="navbar navbar-dark bg-primary">
                <a class="navbar-brand" style="color: aliceblue;" href="index.jsp">Home</a>
                <a class="navbar-brand active" style="color: aliceblue;" href="add-employee.jsp">Add Employee</a>
                <a class="navbar-brand" style="color: aliceblue;" href="edit-employee.jsp">Edit Employee</a>
                <a class="navbar-brand" style="color: aliceblue;" href="delete-employee.jsp">Delete Employee</a>
                <a class="navbar-brand" style="color: aliceblue;" href="view-employee.jsp">View Employee</a>
            </nav>
        </div>
        <h3>Add an Employee</h3>
        <hr>
        <form action="AddEmployee" method="get">

            <label>User ID</label>
            <input type="text" class="form-control" placeholder="Id" name="id"> <br>

            <label>Employee Name</label>
            <input type="text" class="form-control" placeholder="Username" name="name"> <br>

            <label>Employee Salary</label>
            <input type="text" class="form-control" placeholder="salary" name="salary"> <br>

            <label>Employee Email</label>
            <input type="text" class="form-control" placeholder="email" name="email"> <br>

            <input type="submit" class="btn btn-primary" value="Add Employee">

        </form>
    </div>
</div>

</body>
</html>
