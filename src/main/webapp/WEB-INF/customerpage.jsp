<%--
  Created by IntelliJ IDEA.
  User: danie
  Date: 12-05-2020
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/navbar2.inc"%>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>
        <link rel="stylesheet" type="text/css" href="../includes/style.css" />
    </head>

<p style="text-align:center;"> Carport med rejsning</p>
    <p style="text-align:center;">
        <a href="FrontController?taget=Rejsning">
        <img class="floating" border="0" alt="Rejsning" src="img/carport.jpg" width="250" height="250">
    </a>
    </p>

<p style="text-align:center;"> Carport med fladt tag</p>
<p style="text-align:center;">:
        <a href="FrontController?taget=fladtTag">
        <img border="0" alt="Fladt tag" src="img/carport2.jpg" width="250" height="250">
         </a>
    </p>

<!--
    <button type="submit"><a href="FrontController?taget=fladtTag">Carport med fladt tag</a></button>
    <button type="submit"><a href="FrontController?taget=Rejsning">Carport med rejsning</a></button>

-->


    </body>
</html>



