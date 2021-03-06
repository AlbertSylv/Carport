<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/navbar2.inc"%>


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
            document.getElementById("myList5").selectedIndex = "0";
            document.getElementById("myList6").selectedIndex = "0";
            document.getElementById("myList7").selectedIndex = "0";
        }
    }
</script>



<p style="text-align:center;">Bemærk at bredde og længde er målt fra stolpe til stolpe. Taget vil hænge 15 cm ud over de valgte mål på hver side.</p>
<form class="text-center" action="FrontController" method="post" id="bestilling">
    <input type="hidden" name="taget" value="createRequest">
    <input type="hidden" name="email" value="${sessionScope.email}">
    <h3>Carport bredde</h3>
    <select id="myList1" name="width" onchange="removeOptions()">
        <option value="240">240 cm</option>
        <option value="270">270 cm</option>
        <option value="300">300 cm</option>
        <option value="330">330 cm</option>
        <option value="360">360 cm</option>
        <option value="390">390 cm</option>
        <option value="420">420 cm</option>
        <option value="450">450 cm</option>
        <option value="480">480 cm</option>
        <option value="510">510 cm</option>
        <option value="540">540 cm</option>
        <option value="570">570 cm</option>
        <option value="600">600 cm</option>
        <option value="630">630 cm</option>
        <option value="660">660 cm</option>
        <option value="690">690 cm</option>
        <option value="720">720 cm</option>
        <option value="750">750 cm</option>


    </select>
    <p>
    <h3>Carport længde</h3>
    <select id="myList2" name="length">

        <option value="270">270 cm</option>
        <option value="300">300 cm</option>
        <option value="330">330 cm</option>
        <option value="360">360 cm</option>
        <option value="390">390 cm</option>
        <option value="420">420 cm</option>
        <option value="450">450 cm</option>
        <option value="480">480 cm</option>
        <option value="510">510 cm</option>
        <option value="540">540 cm</option>
        <option value="570">570 cm</option>
        <option value="600">600 cm</option>
        <option value="630">630 cm</option>
        <option value="660">660 cm</option>
        <option value="690">690 cm</option>
        <option value="720">720 cm</option>
        <option value="750">750 cm</option>
        <option value="780">780 cm</option>

    </select>
    </p>
    <input type="hidden" name="roof" value="1">
    <p>
    <h3>Tag</h3>
    <select id="myList3" name="tiltedroof" required="required">
        <c:forEach items="${sessionScope.tiltedroofcoatings}" var="TRC">
            <option value = ${TRC.tiltedroofID}> ${TRC.name} </option>

        </c:forEach>
    </select>

    </p>


    <p>
    <h3>Taghældning</h3>
    <select id="myList4" name="angle">

        <option value="15">15 grader</option>
        <option value="20">20 grader</option>
        <option value="25">25 grader</option>
        <option value="30">30 grader</option>
        <option value="35">35 grader</option>
        <option value="40">40 grader</option>
        <option value="45">45 grader</option>
    </select>
    </p>
    <br>
    <hr>
    <h4 class="text-center">
        Her kan du vælge redskabsskur til eller fra <br>
        <button type="button" class="btn btn-primary" onclick="myFunction()">Til/Fra</button>
    </h4>

    <div id="myDIV2">

        <p>
        <h3>Redskabsrum bredde</h3>
        <select id="myList5" name="shedWidth">
            <option value = "0"> --- cm</option>
            <option value="210">210 cm</option>
            <option value="240">240 cm</option>
            <option value="270">270 cm</option>
            <option value="300">300 cm</option>
            <option value="330">330 cm</option>
            <option value="360">360 cm</option>
            <option value="390">390 cm</option>
            <option value="420">420 cm</option>
            <option value="450">450 cm</option>
            <option value="480">480 cm</option>
            <option value="510">510 cm</option>
            <option value="540">540 cm</option>
            <option value="570">570 cm</option>
            <option value="600">600 cm</option>
            <option value="630">630 cm</option>
            <option value="660">660 cm</option>
            <option value="690">690 cm</option>
            <option value="720">720 cm</option>
        </select>
        </p>

        <p>
        <h3>Redskabsrum længde</h3>
        <select id="myList6" name="shedLength">
            <option value = "0"> --- cm</option>
            <option value="150">150 cm</option>
            <option value="180">180 cm</option>
            <option value="210">210 cm</option>
            <option value="240">240 cm</option>
            <option value="270">270 cm</option>
            <option value="300">300 cm</option>
            <option value="330">330 cm</option>
            <option value="360">360 cm</option>
            <option value="390">390 cm</option>
            <option value="420">420 cm</option>
            <option value="450">450 cm</option>
            <option value="480">480 cm</option>
            <option value="510">510 cm</option>
            <option value="540">540 cm</option>
            <option value="570">570 cm</option>
            <option value="600">600 cm</option>
            <option value="630">630 cm</option>
            <option value="660">660 cm</option>
            <option value="690">690 cm</option>


        </select>
        </p>

        <p>
        <h3>Redskabsrum beklædning</h3>

        <select id = "myList7" name="shedclothing" >

            <option value = "1"> --- </option>

            <c:forEach items="${sessionScope.shedclothing}"  var="SC">

                <option value = ${SC.shedID} >${SC.name}</option>

            </c:forEach>

        </select>
        </p>
    </div>

<hr>



    <p>Indtast note</p>
    <input type="text" name="note">
<br>
    <br>
    <button  type="submit" class="btn btn-primary">Bestil carport med valgte mål</button>
    <br>
    <br>
</form>

</body>
</html>
