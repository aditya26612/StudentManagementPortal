<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Student Details</title>
</head>
<body>

<h1>Student Details</h1>

<hr>

<p>
    <strong>ID:</strong>
    ${student.id}
</p>

<p>
    <strong>Name:</strong>
    ${student.name}
</p>

<p>
    <strong>Email:</strong>
    ${student.email}
</p>

<p>
    <strong>Phone:</strong>
    ${student.phone}
</p>

<p>
    <strong>Course:</strong>
    ${student.course}
</p>

<p>
    <strong>Status:</strong>
    ${student.status}
</p>

<hr>

<a href="/admin/students">
    Back To Students
</a>

</body>
</html>