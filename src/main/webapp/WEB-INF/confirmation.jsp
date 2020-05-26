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

<h3>Er din carports dimensioner korrekte?</h3>
<hr>
<p>
<strong>Carport længde: </strong>${sessionScope.req.length} cm
</p>
<p>
<strong>Carport bredde: </strong>${sessionScope.req.width} cm
</p>
    <hr>
<p>
<strong>Hældning på tag: </strong>${sessionScope.req.angle} grader
</p>
<p>
<strong>Tag: </strong>${sessionScope.req.RCname}
</p>
<p>
    <strong>Tag type:</strong> ${sessionScope.req.TRCname}
</p>
<hr>
<p><strong>${sessionScope.SCwarning}</strong></p>
<p>
    <strong>Skur beklædning:</strong> ${sessionScope.req.SCname}
</p>
<p><strong>${sessionScope.Wwarning}</strong></p>
<p>
    <strong>Skur bredde:</strong> ${sessionScope.req.shedWidth} cm
</p>
<p><strong>${sessionScope.Lwarning}</strong></p>
<p>
    <strong>Skur længde:</strong> ${sessionScope.req.shedLength} cm
</p>

<hr>
<form  action="FrontController" method="post">
    <input type="hidden" name="taget" value="drawing">
    <input type="hidden" name="id" value="${sessionScope.req.id}">
    <button  type="submit" class="btn btn-primary">Se tegning</button>
</form>
<hr>
<form action="FrontController" method="post">
    <input type="hidden" name="taget" value="bestilt">
<button type="submit" class="btn btn-primary">Ja, det ser fint ud!</button>
</form>
<br>
<form action="FrontController" method="post">
    <input type="hidden" name="taget" value="deleteRequest">

    <input type="hidden" name="email" value="${sessionScope.req.email}">

<button type="submit" class="btn btn-primary">Nej, lad mig starte forfra!</button>

</form>
<br>
</body>
</html>
