<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<style>
    table, th, td {
        border: 1px solid black;
    }
</style>
<body>
<h1>Witamy w portalu pacjenta</h1>
    <table>
        <h1>Umów wizytę</h1>
        <tr>Dostępni Lekarze:
            <select>
            <c:forEach var="doc" items="${doctors}">
                <option value="${doc.id}">${doc.firstName} ${doc.lastName} ${doc.specialization}</option>
            </c:forEach>
            </select>
        </tr>
    </table>
    <table>
        <tr>
            <th>Dostępne Terminy</th>
            <th>Lekarz</th>
        </tr>
        <c:forEach var="docVisit" items="${docVisits}">
            <tr>
                <td>${docVisit.appointmentDate}</td>
                <td>${docVisit.doctor.firstName} ${docVisit.doctor.lastName}</td>
                <td><a href="/book/${docVisit.id}"> Wybierz termin</a></td>
            </tr>
        </c:forEach>
    </table>

<br>
<td><a href="/logout">Wyloguj</a></td>
<br>
<a href="/">Powrót do strony głównej</a>
</body>