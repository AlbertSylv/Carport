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
<script>
    function myFunction() {


        var x = (${sessionScope.req.shedLength});
        var y = document.getElementById("myDIV2")

        if (x == 0) {
            y.style.display = "none";
        } else {
            y.style.display = "block";
        }
    }
</script>
<h1><strong>Stykliste</strong></h1>
<hr>
<h2>Pæl </h2>
<p><Strong>Navn: </Strong>${sessionScope.pole.woodName}</p>
<p><Strong>Meter: </Strong>${sessionScope.pole.meters}</p>
<p><Strong>Pris: </Strong>${sessionScope.pole.price} kr.</p>
<hr>
<h2>Spær</h2>
<p><Strong>Navn: </Strong>${sessionScope.spær.woodName}</p>
<p><Strong>Meter: </Strong>${sessionScope.spær.meters}</p>
<p><Strong>Pris: </Strong>${sessionScope.spær.price} kr.</p>
<hr>
<h2>Regel som løsholter til skur</h2>
<p><Strong>Navn: </Strong>${sessionScope.regel.woodName}</p>
<p><Strong>Meter: </Strong>${sessionScope.regel.meters}</p>
<p><Strong>Pris: </Strong>${sessionScope.regel.price} kr.</p>
<hr>
<h2>Tag</h2>
<p><Strong>Navn: </Strong>${sessionScope.tag.name}</p>
<p><Strong>Meter^2: </Strong>${sessionScope.tag.meter2}</p>
<p><Strong>Pris: </Strong>${sessionScope.tag.price} kr.</p>
<hr>
<h2>Beklædning</h2>
<p><Strong>Navn: </Strong>${sessionScope.clothing.name}</p>
<p><Strong>Meter^2: </Strong>${sessionScope.clothing.meter2}</p>
<p><Strong>Pris: </Strong>${sessionScope.clothing.price} kr.</p>
<hr>
<h2>Metaller</h2>
<p>Navn: 4,5 x 60 mm. Skruer. </p>
<p>Antal: Én pakke af 200 </p>
<p>Pris: 75 kr. </p>
<hr>
<p>${sessionScope.håndtagN}</p>
<p>${sessionScope.håndtagA}</p>
<p>${sessionScope.håndtagP}</p>
<hr>
<h2><strong>Sammenlagt pris: </strong> ${sessionScope.sum}</h2>


</body>
</html>
