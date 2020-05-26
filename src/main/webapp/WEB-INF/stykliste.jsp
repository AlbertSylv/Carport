<%--
  Created by IntelliJ IDEA.
  User: baske
  Date: 05/05/2020
  Time: 18.58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/navbar2.inc"%>
<form  action="FrontController" method="get">
    <input type="hidden" name="taget" value="bestillinger">
    <button type="submit" class="btn btn-primary">Tilbage til bestillinger</button>
</form>
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
<p><Strong>Navn: </Strong>${sessionScope.spær.woodName}</p>
<p><Strong>Meter: </Strong>${sessionScope.spær.meters}</p>
<p><Strong>Pris: </Strong>${sessionScope.spær.price} kr.</p>
<hr>
<h2>${sessionScope.regelOverskrift}</h2>
<p><Strong>${sessionScope.NavnMS}</Strong>${sessionScope.regel.woodName}</p>
<p><Strong>${sessionScope.AntalMS}</Strong>${sessionScope.regel.meters}</p>
<p><Strong>${sessionScope.PrisMS}</Strong>${sessionScope.regel.price}${sessionScope.KrMS}</p>
${sessionScope.hrMS}
<h2>Tag</h2>
<p><Strong>Navn: </Strong>${sessionScope.tag.name}</p>
<p><Strong>Meter^2: </Strong>${sessionScope.tag.meter2}</p>
<p><Strong>Pris: </Strong>${sessionScope.tag.price} kr.</p>
<br>
<h3>${sessionScope.lægteoverskrift}</h3>
<p><Strong>${sessionScope.navn}</Strong>${sessionScope.lægte.woodName}</p>
<p><Strong>${sessionScope.meter}</Strong>${sessionScope.lægte.meters}</p>
<p><Strong>${sessionScope.pris}</Strong>${sessionScope.lægte.price}</p>

<hr>
<h2>Vindskede</h2>
<p><Strong>Navn: </Strong>${sessionScope.vindskede.woodName}</p>
<p><Strong>Meter: </Strong>${sessionScope.vindskede.meters}</p>
<p><Strong>Pris: </Strong>${sessionScope.vindskede.price} kr.</p>
<hr>

<h2>Beklædning</h2>
<p><Strong>Navn: </Strong>${sessionScope.clothing.name}</p>
<p><Strong>Meter^2: </Strong>${sessionScope.clothing.meter2}</p>
<p><Strong>Pris: </Strong>${sessionScope.clothing.price} kr.</p>
<hr>
<h2>Metaller</h2>
<p><strong>${sessionScope.navnFT}</strong>${sessionScope.hulbåndN} </p>
<p><strong>${sessionScope.antalFT}</strong>${sessionScope.hulbåndA}</p>
<p><strong>${sessionScope.prisFT}</strong>${sessionScope.hulbåndP}</p>
${sessionScope.brFT}
<p><strong>Navn: </strong>5,0 x 40 mm. Beslagskruer. (universalbeslag)</p>
<p><strong>Antal: </strong>1 pakke af 200 </p>
<p><strong>Pris: </strong>167 kr. </p>
<br>
<p><strong>Navn: </strong>4,5 x 60 mm. Skruer. (vindskeder)</p>
<p><strong>Antal: </strong>${sessionScope.VSskruer} pakke af 200 </p>
<p><strong>Pris: </strong>${sessionScope.VSskruer * sessionScope.VSskruepris} kr. </p>
<br>
<p><strong>${sessionScope.navn}</strong>${sessionScope.TLskruer} </p>
<p><strong>${sessionScope.antal}</strong>${sessionScope.TLskruePakker}</p>
<p><strong>${sessionScope.pris}</strong>${sessionScope.TLskruePris}</p>
<br>
<p><strong>${sessionScope.NavnMS}</strong>${sessionScope.håndtagN}</p>
<p><strong>${sessionScope.AntalMS}</strong>${sessionScope.håndtagA}</p>
<p><strong>${sessionScope.PrisMS}</strong>${sessionScope.håndtagP} ${sessionScope.KrMS}</p>
${sessionScope.brMS}
<p><strong>Navn: </strong>${sessionScope.uniBeslag.woodName}</p>
<p><strong>Antal: </strong>${sessionScope.uniBeslag.meters}</p>
<p><strong>Pris: </strong>${sessionScope.uniBeslag.price}</p>
<br>
<p><strong>Navn: </strong>${sessionScope.bræddeBolt.woodName}</p>
<p><strong>Antal: </strong>${sessionScope.bræddeBolt.meters}</p>
<p><strong>Pris: </strong>${sessionScope.bræddeBolt.price} kr</p>
${sessionScope.brMS}
<p><strong>${sessionScope.NavnMS}</strong> ${sessionScope.løsBeslag.woodName}</p>
<p><strong>${sessionScope.AntalMS}</strong> ${sessionScope.løsBeslag.meters}</p>
<p><strong>${sessionScope.PrisMS}</strong> ${sessionScope.løsBeslag.price} ${sessionScope.KrMS}</p>
<hr>
<h3><strong>Sammenlagt pris: </strong> ${sessionScope.sum} kr</h3>


</body>
</html>
