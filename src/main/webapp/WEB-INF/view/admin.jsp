<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<form name='adminForm'
      action="<c:url value='/admin' />" method='POST'>

    <table>
        <tr>
            <td>User:</td>
            <td><input class= type='text' name='username'></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
        </tr>
        <tr>
            <td colspan='2'><input  name="submit" type="submit" value="submit" /></td>
        </tr>
    </table>

</form>
</body>
</html>