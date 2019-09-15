<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<body>
<h1>Usuń Lekarza</h1>

<c:forEach var="doc" items="${doctors}">
    <td>${doc.firstName} ${doc.lastName} ${doc.specialization}</td>
    <td><a href="/removeDoctor/${doc.id}"> Delete doctor</a></td>
    <br>
</c:forEach>
<br>
<a href="/admin">Powrót</a>
</body>