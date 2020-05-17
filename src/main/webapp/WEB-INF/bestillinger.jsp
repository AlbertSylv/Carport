<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: baske
  Date: 05/05/2020
  Time: 18.08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/navbar2.inc"%>

    <title>Aktiv bestillinger</title>
</head>
<body>
<form  action="FrontController" method="get">
    <input type="hidden" name="taget" value="employeepage">
    <button type="submit">Tilbage til din side</button>
</form>


<hr>

<ul class="text-center">

    <c:forEach items="${sessionScope.bestillinger}"  var="request">
        <li><p>E-mail:<strong> ${request.email}</strong></p>
            <p>Carport længde:<strong> ${request.length}</strong></p>
            <p>Carport bredde:<strong> ${request.width}</strong></p>
            <p>Skur længde:<strong> ${request.shedLength}</strong></p>
            <p>Skur bredde:<strong> ${request.shedWidth}</strong></p>
            <p>Skur beklædning:<strong> ${request.SCname}</strong></p>
            <p>Tag hældning:<strong> ${request.angle}</strong></p>
            <p>Tag:<strong> ${request.RCname}</strong></p>
            <p>Tag type:<strong> ${request.TRCname}</strong></p>
            <p>Kunde note:<strong> ${request.note}</strong></p>
            <p>Bestilling ID:<strong> ${request.id}</strong></p>

            <form  action="FrontController" method="post">
                <input type="hidden" name="taget" value="drawing">
                <input type="hidden" name="id" value="${request.id}">
                <button  type="submit" class="btn btn-primary">Se tegning</button>
            </form>



            <form action="FrontController" method="post">


                <input type="hidden" name="taget" value="stykliste">
                <input type="hidden" name="id" value="${request.id}">


                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Se stykliste</button>
                </div>
            </form>

            <form action="FrontController" method="post">


                <input type="hidden" name="taget" value="adminDeleteRequest">
                <input type="hidden" name="ID" value="${request.id}">
                <input type="hidden" name="email" value="${sessionScope.email}">


                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Slet</button>
                </div>
            </form>

        </li> <hr>

    </c:forEach>

</ul>

</body>
</html>
