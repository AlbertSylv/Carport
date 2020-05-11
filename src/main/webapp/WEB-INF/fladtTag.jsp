<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/navbar.inc"%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Customer home page</title>
    <link rel="stylesheet" type="text/css" href="../includes/style.css" />
</head>
<body>


<p class="text-center">
<button type="submit"><a href="FrontController?taget=fladtTag">Carport med fladt tag</a></button>
<button type="submit"><a href="FrontController?taget=Rejsning">Carport med rejsning</a></button>
</p>
<hr>


<script>
    function myFunction() {


        var x = document.getElementById("myDIV2");

        if (x.style.display === "none") {
            x.style.display = "block";
        } else {
            x.style.display = "none";
        }
    }
</script>
<h4 class="text-center">
    Her kan du vælge redskabsskur til eller fra <br> <br>
    <button onclick="myFunction()">Til/Fra</button>
</h4>
<p style="text-align:center;">Bemærk at bredde og længde er fra stolpe til stolpe. Taget vil hænge 30 cm ud over de valgte mål på hver side.</p>
<form class="text-center" action="FrontController" method="post" id="bestilling">
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
    <input type="hidden" name="tiltedroof" value="1">
    <input type="hidden" name="angle" value="0">
    <p>
    <h3>Tag</h3>
    <select id = "select" name="roof">
        <c:forEach items="${sessionScope.roofcoatings}"  var="RC">
            <option value = ${RC.roofID}>${RC.name}</option>

        </c:forEach>
    </select>

    </p>

    <div id="myDIV2">
        <p>
        <h3>Redskabsrum bredde</h3>
        <select id = "myList5" name="shedWidth">
            <option value = "0"> --- cm</option>
            <option value = "210">210 cm</option>
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
        </select>
        </p>

        <p>
        <h3>Redskabsrum længde</h3>
        <select id = "myList6" name="shedLength">
            <option value = "0"> --- cm</option>
            <option value = "150">150 cm</option>
            <option value = "180">180 cm</option>
            <option value = "210">210 cm</option>
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


        </select>
        </p>

        <p>
        <h3>Redskabsrum beklædning</h3>

        <select id = "myList7" name="shedclothing" required="required">
            <option value = "1"> --- </option>
            <c:forEach items="${sessionScope.shedclothing}" var="SC">
                <option value = ${SC.shedID}>${SC.name}</option>

            </c:forEach>
        </select>
        </p>
    </div>
    <p>Indtast email</p>
    <input type="text" name="email" required="required">

    <p>Indtast note</p>
    <input type="text" name="note">

    <br> <br>
    <button type="submit">Bestil carport med valgte mål</button>
    <br> <br>
</form>
</body>
</html>




