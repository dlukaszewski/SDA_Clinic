<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>


<h1>Welcome to our clinic</h1>
<br>
<form action="/patient">
    <h1>Panel Pacjenta</h1>
    <br>
    <input type="submit" value="Panel Pacjenta">
</form>
<br>
<form action="/doctor">
    <h1>Panel Lekarza</h1>
    <br>
    <input type="submit" value="Panel Lekarza">

</form>
<br>
<form action="/admin">
    <h1>Panel Administracyjny</h1>
    <br>
    <input type="submit" value="Panel Administracyjny">
</form>


</body>
</html>