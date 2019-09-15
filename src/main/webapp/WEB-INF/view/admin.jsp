<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<body>

    <h1>Witamy w portalu Administratora</h1>
    <form action="/addDoctor">
        <h4>Dodaj Lekarza do Systemu</h4>
        <input type="submit" value="Select">
    </form>
    <br>
    <form action="/removeDoctor">
        <h4>Usuń Lekarza z Systemu</h4>
        <input type="submit" value="Select">
    </form>
    <br>
    <form action="/removePatient">
        <h4>Usuń Pacjenta z Systemu</h4>
        <input type="submit" value="Select">
    </form>
    <br>
    <a href="/logout">Wyloguj</a>
    <br>
    <a href="/">Powrót do strony głównej</a>

</body>
</html>