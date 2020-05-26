<%--
  Created by IntelliJ IDEA.
  User: baske
  Date: 17/05/2020
  Time: 16.17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/navbar2.inc"%>


    <title>Tilføj produkt</title>
</head>
<body>
<form  action="FrontController" method="get">
    <input type="hidden" name="taget" value="employeepage">
    <button type="submit" class="btn btn-primary">Tilbage til din side</button>
</form>
<br>
<h2>Tilføj produkt</h2>
<hr>
<form action="FrontController" method="post">
    <input type="hidden" name="taget" value="addProduct">

<h3>Hvilken type produkt vil du tilføje?</h3>
<select id="myList6" name="type">
    <option value = "SC">Skur beklædning</option>
    <option value="TRC">Tag med rejsning - tagbelægning</option>
    <option value="RC">Fladt tag - tagbelægning</option>



</select>
<br>
<h3>Navn</h3>
<input type="text" name="name" required="required">

<br>
<h3>Pris pr. meter^2</h3>
<input type="number" name="price" required="required">
<hr>

    <label>
        <button type="submit" class="btn btn-primary">Tilføj produkt</button>
    </label>
</form>
</body>
</html>
