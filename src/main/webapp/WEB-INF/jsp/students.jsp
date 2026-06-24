<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<h2>Search Student</h2>

<form action="/admin/students" method="get">

    <input type="text"
           name="keyword"
           placeholder="Enter student name"
           value="${keyword}">

    <button type="submit">
        Search
    </button>

</form>

<br>

<h3>Total Records: ${students.size()}</h3>

<table border="1">

    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Course</th>
        <th>Status</th>
        <th>Role</th>
        <th>Actions</th>
    </tr>

    <c:forEach items="${students}" var="student">

        <tr>

            <td>${student.id}</td>

            <td>${student.name}</td>

            <td>${student.email}</td>

            <td>${student.course}</td>

            <td>${student.status}</td>

            <td>${student.role}</td>

            <td>

                <a href="/admin/student/${student.id}">
                    View
                </a>

            </td>

        </tr>

    </c:forEach>

</table>

<br><br>

<c:if test="${totalPages > 1}">

    <c:forEach begin="0"
               end="${totalPages - 1}"
               var="i">

        <a href="/admin/students?page=${i}">
            ${i + 1}
        </a>

        &nbsp;

    </c:forEach>

</c:if>