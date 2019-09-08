<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<body>
<h1>Witamy w portalu pacjenta</h1>

    <form:form method="POST" action="/addVisit" modelAttribute="visit">
    <table>
        <h1>Umów wizytę</h1>
        <tr>Dostępni Lekarze:</tr>
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
                        min="2019-09-08T08:00" max="2019-12-31T18:00" />
            <br>
            <input type="submit" value="Zatwierdz">
        </td>
    </table>
</form:form>
<td><a href="/patientLogin">Wyloguj</a></td>
</body>