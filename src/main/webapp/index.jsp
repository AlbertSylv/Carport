
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="includes/navbar.inc"%>




        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome page</title>
    </head>
    <style>
        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
            font-family: Arial;
        }

        .header {
            text-align: center;
            padding: 32px;
        }

        .row {
            display: -ms-flexbox; /* IE10 */
            display: flex;
            -ms-flex-wrap: wrap; /* IE10 */
            flex-wrap: wrap;
            padding: 0 4px;
        }

        /* Create four equal columns that sits next to each other */
        .column {
            -ms-flex: 25%; /* IE10 */
            flex: 25%;
            max-width: 25%;
            padding: 0 4px;
        }

        .column img {
            margin-top: 8px;
            vertical-align: middle;
            width: 100%;
        }

        /* Responsive layout - makes a two column-layout instead of four columns */
        @media screen and (max-width: 800px) {
            .column {
                -ms-flex: 50%;
                flex: 50%;
                max-width: 50%;
            }
        }

        /* Responsive layout - makes the two columns stack on top of each other instead of next to each other */
        @media screen and (max-width: 600px) {
            .column {
                -ms-flex: 100%;
                flex: 100%;
                max-width: 100%;
            }
        }
    </style>

    <div class="header">
        <h1>Sådan her har andre fået lavet deres carport her hos os</h1>
        <p>Caporte nedenfor er både selvbyg, men også vores egne designs</p>
    </div>

    <!-- Photo Grid -->
    <div class="row">
        <div class="column">
            <img src="img/carport.jpg" style="width:100%">
            <img src="img/carport2.jpg" style="width:100%">
            <img src="img/carport3.jpg" style="width:100%">
            <img src="img/carport4.jpg" style="width:100%">


        </div>
        <div class="column">
            <img src="img/carport8.jpg" style="width:100%">
            <img src="img/carport9.jpg" style="width:100%">
            <img src="img/carport10.jpg" style="width:100%">
            <img src="img/carport11.jpg" style="width:100%">
            <img src="img/carport12.jpg" style="width:100%">

        </div>
        <div class="column">
            <img src="img/carport14.jpg" style="width:100%">
            <img src="img/carport15.jpg" style="width:100%">
            <img src="img/carport16.jpg" style="width:100%">
            <img src="img/carport17.jpg" style="width:100%">
            <img src="img/carport18.jpg" style="width:100%">


        </div>
        <div class="column">
            <img src="img/carport6.jpg" style="width:100%">
            <img src="img/carport7.jpg" style="width:100%">
            <img src="img/carport13.jpg" style="width:100%">
            <img src="img/carport19.jpg" style="width:100%">


        </div>
    </div>

    </body>
</html>


    <!--
    <button type="submit"> <a href="FrontController?taget=customerpage">Customerpage</a></button>
    <button type="submit"> <a href="FrontController?taget=employeepage">Employeepage</a></button>


        <p>Indtast email</p>
        <input type="text" name="email">

        <p>Indtast note</p>
        <input type="text" name="note">


        <button type="submit">Bestil carport med valgte mål</button>

    </form>
        <h1>Welcome to Sem 2</h1>
        
        <table>
            <tr><td>Login</td>
                <td>
                    <form name="login" action="FrontController" method="POST">
                        <input type="hidden" name="taget" value="login">
                        Email:<br>
                        <input type="text" name="email" value="someone@nowhere.com">
                        <br>
                        Password:<br>
                        <input type="password" name="password" value="sesam">
                        <br>
                        <input type="submit" value="Submit">
                    </form>
                </td>
                <td>Or Register</td>
                <td>
                    <form name="register" action="FrontController" method="POST">
                        <input type="hidden" name="taget" value="register">
                        Email:<br>
                        <input type="text" name="email" value="someone@nowhere.com">
                        <br>
                        Password:<br>
                        <input type="password" name="password1" value="sesam">
                        <br>
                        Retype Password:<br>
                        <input type="password" name="password2" value="sesam">
                        <br>
                        <input type="submit" value="Submit">
                    </form>
                </td>
            </tr>
        </table>
-->


<%--        Bare lige se I har en ide om hvad vi forslå I ikke gør ! det hedder scpript lets --%>
<%--        <% String error = (String) request.getAttribute( "error");--%>
<%--           if ( error != null) { --%>
<%--               out.println("<H2>Error!!</h2>");--%>
<%--               out.println(error);--%>
<%--           }--%>
<%--        %>--%>

        <c:if test = "${requestScope.error!= null}" >

           <h2>Error ! </h2>
            ${requestScope.error}

        </c:if>
    </body>
</html>
