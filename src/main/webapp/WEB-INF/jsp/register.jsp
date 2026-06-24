<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Register</title>
</head>
<body>

<h2>Register</h2>

<form action="/register" method="post">

    Name:
    <input type="text" name="name">
    <br><br>

    Email:
    <input type="email" name="email">
    <br><br>

    Phone:
    <input type="text" name="phone">
    <br><br>

    Course:
    <input type="text" name="course">
    <br><br>

    Password:
    <input type="password" name="password">
    <br><br>

    <button type="submit">
        Register
    </button>

</form>

<a href="/login">
    Login Here
</a>

</body>
</html>