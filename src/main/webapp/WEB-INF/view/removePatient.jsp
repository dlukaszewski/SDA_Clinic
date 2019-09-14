<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<body>
<h1>Usuń Pacjenta</h1>

<c:forEach var="patients" items="${patients}">
    <td>${patients.firstName} ${patients.lastName} ${patients.pesel}</td>
    <td><a href="/removePatient/${patients.pesel}"> Delete Patient</a></td>
    <br>
</c:forEach>
<br>
<a href="/admin">Powrót</a>
</body>