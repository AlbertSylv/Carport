<%--
  Created by IntelliJ IDEA.
  User: baske
  Date: 15/05/2020
  Time: 16.22
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/navbar2.inc"%>



    <title>UpdateNameAndPrice</title>
</head>
<body>
<h2>Vælg produkt du vil opdatere</h2>
<hr>

<h3>Tag med rejsning produkter</h3>
<form action="FrontController" method="post">
    <input type="hidden" name="taget" value="updateTRC">
<select id="myList1" name="tiltedroof" required="required">
    <c:forEach items="${sessionScope.tiltedroofcoatings}" var="TRC">
        <option value = ${TRC.tiltedroofID}> ${TRC.name} </option>
    </c:forEach>

</select>
    <p>Nuværende navn:
    <p>Nuværende pris:


<br>
    <p>Nyt navn</p>
    <input type="text" name="name" required="required">
    <br>
    <br>
    <p>Ny pris</p>
    <input type="number" name="price" required="required">
    <br>
    <br>
    <div>
        <label>
            <button type="submit" class="btn btn-primary">Opdater produkt</button>
        </label>
    </div>

</form>
<hr>
<h3>Fladt tag produkter</h3>
<form action="FrontController" method="post">
    <input type="hidden" name="taget" value="updateRC">
    <select id="myList2" name="roof" required="required">
        <c:forEach items="${sessionScope.roofcoatings}" var="RC">
            <option value = ${RC.roofID}> ${RC.name} </option>

        </c:forEach>
    </select>
    <br>
    <br>
    <p>Nyt navn</p>
    <input type="text" name="name" required="required">
    <br>
    <br>
    <p>Ny pris</p>

    <input type="number" name="price" required="required">
    <br>
    <br>
    <div>
        <label>
            <button class="btn btn-primary">Opdater produkt</button>
        </label>
    </div>

</form>
<hr>
<h3>Skur beklædning produkter</h3>
<form action="FrontController" method="post">
    <input type="hidden" name="taget" value="updateSC">
    <select id="myList3" name="shedclothings" required="required">
        <c:forEach items="${sessionScope.shedclothings}" var="shedclothing">
            <option value = ${shedclothing.shedID}> ${shedclothing.name} </option>
        </c:forEach>

    </select>
    <br>


    <p>Nuværende navn:
    <p>Nuværende pris:


    <br>
    <br>
    <p>Nyt navn</p>
    <input type="text" name="name" required="required">
    <br>
    <br>
    <p>Ny pris</p>
    <input type="number" name="price" required="required">
    <br>
    <br>
    <div>
        <label>
            <button class="btn btn-primary">Opdater produkt</button>
        </label>
    </div>

</form>

<hr>
<h3>Faste carport materialer</h3>
<form action="FrontController" method="post">
    <input type="hidden" name="taget" value="updateWood">
    <select id="myList4" name="woods" required="required">
        <c:forEach items="${sessionScope.woods}" var="Wood">
            <option value = ${Wood.type}> ${Wood.woodName} </option>

        </c:forEach>
    </select>
    <br>
    <br>
    <p>Nyt navn</p>
    <input type="text" name="name" required="required">
    <br>
    <br>
    <p>Ny pris (pris er målt pr. meter)</p>
    <input type="number" name="price" required="required">
    <br>
    <br>
    <div>
        <label>
            <button class="btn btn-primary">Opdater produkt</button>
        </label>
    </div>
    <br>
</form>
<hr>
</body>
</html>
