<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pl">
<body>
<form name="patientForm"
      action="/patient" method="POST">

    <table>
        <tr>
            <td>User:</td>
            <td><input type="text" name="Login"></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="Haslo" /></td>
        </tr>
        <tr>
            <td colspan='4'><input  name="submit" type="submit" value="Zaloguj" /></td>
        </tr>

    </table>

</form>
<tr>
    <td><a href="/addPatient">Nie masz Konta? Zarejestruj sie do Portalu Pacjenta</a></td>
</tr>
</body>
</html>