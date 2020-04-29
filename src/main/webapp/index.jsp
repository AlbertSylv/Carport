<%-- 
    Document   : index
    Created on : Aug 22, 2017, 2:01:06 PM
    Author     : kasper
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome page</title>
    </head>
    <body>
    <form action="FrontController" method="post" id="bestilling">
        <input type="hidden" name="taget" value="createRequest">

        <select id = "myList1" name="width">

            <option value = "1">240 cm</option>
            <option value = "2">270 cm</option>
            <option value = "3">300 cm</option>
            <option value = "4">330 cm</option>
            <option value = "5">360 cm</option>
            <option value = "6">390 cm</option>
            <option value = "7">420 cm</option>
            <option value = "8">450 cm</option>
            <option value = "9">480 cm</option>
            <option value = "10">510 cm</option>
            <option value = "11">540 cm</option>
            <option value = "12">570 cm</option>
            <option value = "13">600 cm</option>
            <option value = "14">630 cm</option>
            <option value = "15">660 cm</option>
            <option value = "16">690 cm</option>
            <option value = "17">720 cm</option>
            <option value = "18">750 cm</option>


        </select>


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
