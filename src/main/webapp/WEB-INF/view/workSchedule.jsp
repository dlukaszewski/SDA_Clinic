<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pl">
<style>
    table, th, td {
        border: 1px solid black;
    }
</style>
<body>
<h1>Ustaw grafik pracy</h1>
<form:form method="POST" action="/workSchedule" modelAttribute="visit">
    <tr><form:select path="doctor.id">
        <option selected disabled hidden></option>
        <c:forEach var="doc" items="${doctors}">
            <form:option value="${doc.id}">${doc.firstName} ${doc.lastName} ${doc.specialization}</form:option>
        </c:forEach>
    </form:select></tr>
    <br>
    <td>Wybierz date</td>
    <td>
        <form:input path="appointmentDate" id="date" type="datetime-local" value="2019-09-08T12:00"
                    min="2019-09-08T08:00" max="2019-12-31T18:00"/>
        <br>
        <input type="submit" value="Zatwierdz">
    </td>

</form:form>
<br>
<table>
    <tr>
        <th>Data</th>
        <th>Pacjent</th>
        <th>Id Lekarza</th>
        <th>Usuń wizytę</th>
    </tr>
    <c:forEach var="visit" items="${visits}">
    <tr>
            <td>${visit.appointmentDate}</td>
            <td>${visit.patient.pesel}</td>
            <td>${visit.doctor.id}</td>
            <td><a href="/removeVisit/${visit.id}"> Delete visit</a></td>
    </tr>
    </c:forEach>
</table>
<tr>
    <td><br><a href="/doctor">Powrót</a></td>
</tr>
</body>
</html>