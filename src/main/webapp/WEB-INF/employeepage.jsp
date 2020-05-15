<%--
  Created by IntelliJ IDEA.
  User: danie
  Date: 12-05-2020
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../includes/navbar2.inc"%>


        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee home page</title>
    </head>


        <h1>Hello ${sessionScope.name} </h1>




        You are now logged in as a EMPLOYEE of our wonderful site.

        <form action="FrontController" method="get">
            <input type="hidden" name="taget" value="bestillinger">
            <div>
                <label>
                    <button class="btn btn-primary">Aktive bestillinger</button>
                </label>
            </div> </form>
<br>
<form action="FrontController" method="get">
    <input type="hidden" name="taget" value="registerEmployeePage">
    <div>
        <label>
            <button class="btn btn-primary">Opret ny medarbejder</button>
        </label>
    </div> </form>
<br>
<form action="FrontController" method="get">
    <input type="hidden" name="taget" value="UpdateNameAndPrice">
    <div>
        <label>
            <button class="btn btn-primary">Opdater produkt navn og pris</button>
        </label>
    </div> </form>

    </body>
</html>
