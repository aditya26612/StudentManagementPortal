<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Edit Profile</title>
</head>
<body>

<h2>Edit Profile</h2>

<form action="/profile/update" method="post">

    <label>Name:</label>
    <input type="text"
           name="name"
           value="${student.name}">
    <br><br>

    <label>Phone:</label>
    <input type="text"
           name="phone"
           value="${student.phone}">
    <br><br>

    <label>Course:</label>
    <input type="text"
           name="course"
           value="${student.course}">
    <br><br>

    <button type="submit">
        Update Profile
    </button>

</form>

<br>

<a href="/profile">
    Back To Profile
</a>

</body>
</html>