<%--
  Created by IntelliJ IDEA.
  User: baske
  Date: 05/05/2020
  Time: 15.24
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="../includes/navbar2.inc"%>

    <title>Bekræftelse</title>
</head>
<body>

<h3>Er din carport lige så liderlig, som du havde forestillet dig den?</h3>
<hr>
<p>
Carport længde: ${sessionScope.req.length} cm
</p>
<p>
Carport bredde: ${sessionScope.req.width} cm
</p>
    <hr>
<p>
Hældning på tag: ${sessionScope.req.angle} grader
</p>
<p>
Tag: ${sessionScope.req.RCname}
</p>
<p>
Tag type: ${sessionScope.req.TRCname}
</p>
<hr>
<p>
Skur beklædning: ${sessionScope.req.SCname}
</p>
<p>
Skur bredde: ${sessionScope.req.shedWidth} cm
</p>
<p>
Skur længde: ${sessionScope.req.shedLength} cm

</p>
<hr>
<h1>TEGNING HER</h1>
<hr>
<button type="submit"><a href="FrontController?taget=bestilt">Jaaaa!</a></button>

<form action="FrontController" method="post">
    <input type="hidden" name="taget" value="deleteRequest">
    <input type="hidden" name="email" value="${sessionScope.req.email}">

<button type="submit">Nej den er lort, lad mig starte forfra!</button>

</form>

</body>
</html>
