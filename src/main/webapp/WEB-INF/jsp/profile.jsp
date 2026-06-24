<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Profile</title>
</head>
<body>

<h1>Student Profile</h1>

<hr>

<p><strong>Name:</strong> ${student.name}</p>

<p><strong>Email:</strong> ${student.email}</p>

<p><strong>Phone:</strong> ${student.phone}</p>

<p><strong>Course:</strong> ${student.course}</p>

<p><strong>Status:</strong> ${student.status}</p>

<hr>

<a href="/profile/edit">
    Edit Profile
</a>

<br><br>

<a href="/logout">
    Logout
</a>

</body>
</html>