<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>TEST</title>
</head>
<body>
WELCOME IN REVIEW V1

<form action="addUser" method="post">
    input Name: <input type="text" name="uName"><br/>
    input Surname: <input type="text" name="uSurname"><br/>
    <input type="submit"><br/>
</form>
<br/>
<form action="getUsers">
    Get data from Database: <input type="submit">
</form>
    ${message}
    <br/>
    ${userList}

</body>
</html>