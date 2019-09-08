<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pl">



<body>
<form:form method="POST" action="/addPatient" modelAttribute="patient">
    <table>
        <tr>
            <td><form:label path="firstName">Imię</form:label></td>
            <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td><form:label path="lastName">Nazwisko</form:label></td>
            <td><form:input path="lastName"/></td>
        </tr>
        <tr>
            <td><form:label path="pesel">Pesel</form:label></td>
            <td><form:input path="pesel"/></td>
        </tr>
        <tr>
            <td><form:label path="password">Hasło</form:label></td>
            <td><form:input type="password" path="password"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Zatwierdź"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>