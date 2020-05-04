<%--
  Created by IntelliJ IDEA.
  User: danie
  Date: 04-05-2020
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>

<button type="submit"> <a href="FrontController?taget=fladtTagMedSkur">Fladt med skur</a></button>
<button type="submit"> <a href="FrontController?taget=fladtTagUdenSkur">Fladt uden skur</a></button>
<button type="submit"> <a href="FrontController?taget=Rejsning">Rejsning</a></button>
<button type="submit"> <a href="FrontController?taget=RejsningSkur">Rejsning Skur</a></button>

<form action="FrontController" method="post" id="bestilling">
    <input type="hidden" name="taget" value="createRequest">
    <h3>Carport bredde</h3>
    <select id = "myList1" name="width">

        <option value = "240">240 cm</option>
        <option value = "270">270 cm</option>
        <option value = "300">300 cm</option>
        <option value = "330">330 cm</option>
        <option value = "360">360 cm</option>
        <option value = "390">390 cm</option>
        <option value = "420">420 cm</option>
        <option value = "450">450 cm</option>
        <option value = "480">480 cm</option>
        <option value = "510">510 cm</option>
        <option value = "540">540 cm</option>
        <option value = "570">570 cm</option>
        <option value = "600">600 cm</option>
        <option value = "630">630 cm</option>
        <option value = "660">660 cm</option>
        <option value = "690">690 cm</option>
        <option value = "720">720 cm</option>
        <option value = "750">750 cm</option>


    </select>
    <p>
    <h3>Carport længde</h3>
    <select id = "myList2" name="length">

        <option value = "270">270 cm</option>
        <option value = "300">300 cm</option>
        <option value = "330">330 cm</option>
        <option value = "360">360 cm</option>
        <option value = "390">390 cm</option>
        <option value = "420">420 cm</option>
        <option value = "450">450 cm</option>
        <option value = "480">480 cm</option>
        <option value = "510">510 cm</option>
        <option value = "540">540 cm</option>
        <option value = "570">570 cm</option>
        <option value = "600">600 cm</option>
        <option value = "630">630 cm</option>
        <option value = "660">660 cm</option>
        <option value = "690">690 cm</option>
        <option value = "720">720 cm</option>
        <option value = "750">750 cm</option>
        <option value = "780">780 cm cm</option>

    </select>
    </p>

    <p>
    <h3>Tag</h3>
    <select id = "myList3" name="roof" required="required">
        <c:forEach items="${sessionScope.roofcoatings}"  var="RC">
            <option value = ${RC.roofID}>${RC.name}</option>

        </c:forEach>
    </select>
    </p>

    <div id="myDIV2">
        <p>
        <h3>Taghældning</h3>
        <select id = "myList4" name="angle">
            <option value = "15">15 grader</option>
            <option value = "20">20 grader</option>
            <option value = "25">25 grader</option>
            <option value = "30">30 grader</option>
            <option value = "35">35 grader</option>
            <option value = "40">40 grader</option>
            <option value = "45">45 grader</option>

        </select>
        </p>

    </div>
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

</body>
</html>
