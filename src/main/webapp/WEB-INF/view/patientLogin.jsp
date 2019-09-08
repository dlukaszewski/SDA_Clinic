<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pl">
<body>
<form name="patientForm"
      action="/patientLogin" method="POST">

    <table>
        <tr>
            <td>Login:</td>
            <td><input type="text" name="user"></td>
        </tr>
        <tr>
            <td>Hasło:</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td colspan='4'><input  name="submit" type="submit" value="Zaloguj" /></td>
        </tr>

    </table>

</form>
<tr>
    <td><a href="/addPatient">Nie masz konta? Zarejestruj się do Portalu Pacjenta</a></td>
</tr>
<br>
<tr>
    <td><a href="/">Powrót do strony głównej</a> </td>
</tr>
</body>
</html>