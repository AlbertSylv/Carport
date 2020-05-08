<%--
  Created by IntelliJ IDEA.
  User: baske
  Date: 05/05/2020
  Time: 18.58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/navbar.inc"%>

    <title>Stykliste</title>
</head>
<body>
<h1><strong>Stykliste</strong></h1>
<hr>
<h2>Pæl </h2>
<p><Strong>Navn: </Strong>${sessionScope.pole.woodName}</p>
<p><Strong>Meter: </Strong>${sessionScope.pole.meters}</p>
<p><Strong>Pris: </Strong>${sessionScope.pole.price} kr.</p>
<hr>
<h2>Spær</h2>
<p><Strong>Navn: </Strong>${sessionScope.pole.woodName}</p>
<p><Strong>Meter: </Strong>${sessionScope.pole.meters}</p>
<p><Strong>Pris: </Strong>${sessionScope.pole.price}</p>
<hr>
<h2>Regel</h2>
<p><Strong>Navn: </Strong>${sessionScope.pole.woodName}</p>
<p><Strong>Meter: </Strong>${sessionScope.pole.meters}</p>
<p><Strong>Pris: </Strong>${sessionScope.pole.price}</p>
<hr>
<h2>Tag</h2>
<p><Strong>Navn: </Strong>${sessionScope.pole.woodName}</p>
<p><Strong>Meter^2: </Strong>${sessionScope.pole.meters}</p>
<p><Strong>Pris: </Strong>${sessionScope.pole.price}</p>
<hr>
<h2>Beklædning</h2>
<p><Strong>Navn: </Strong>${sessionScope.pole.woodName}</p>
<p><Strong>Meter: </Strong>${sessionScope.pole.meters}</p>
<p><Strong>Pris: </Strong>${sessionScope.pole.price}</p>
<hr>

</body>
</html>
