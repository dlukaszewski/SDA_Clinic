<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<style>
    table, th, td {
        border: 1px solid black;
    }
    .myClass {
        display: none;
    }
</style>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
</head>
<body>
<h1>Witamy w portalu pacjenta</h1>
<div class="controls">
    <table>
        <h1>Umów wizytę</h1>
        <th>Dostępni Lekarze:</th>
            <option selected disabled hidden></option>
            <c:forEach var="doc" items="${doctors}">
                <option value="${doc.id}">${doc.firstName} ${doc.lastName} ${doc.specialization}</option>
            </c:forEach>
        </th>
        <br>
    </table>
</div>
<br>
<div id="dates">
    <table class="table table-bordered table-striped table-hover">
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
</div>
<br>
<td><a href="/logout">Wyloguj</a></td>
<br>
<a href="/">Powrót do strony głównej</a>
</body>