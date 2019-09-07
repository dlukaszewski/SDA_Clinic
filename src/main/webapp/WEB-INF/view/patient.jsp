<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<form name="patientForm"
      action="/patient" method="POST">

    <table>
        <tr>
            <td>User:</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password" /></td>
        </tr>
        <tr>
            <td colspan='4'><input  name="submit" type="submit" value="Zaloguj" /></td>
        </tr>
    </table>

</form>
</body>
</html>