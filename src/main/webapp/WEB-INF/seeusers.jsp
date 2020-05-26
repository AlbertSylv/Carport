<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: baske
  Date: 26/03/2020
  Time: 15.55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/navbar2.inc" %>


<script>
    function doSearch(text) {
        if (window.find && window.getSelection) {
            document.designMode = "on";
            var sel = window.getSelection();
            sel.collapse(document.body, 0);

            while (window.find(text)) {
                document.getElementById("button").blur();
                document.execCommand("HiliteColor", false, "yellow");
                sel.collapseToEnd();
            }
            document.designMode = "off";
        } else if (document.body.createTextRange) {
            var textRange = document.body.createTextRange();
            while (textRange.findText(text)) {
                textRange.execCommand("BackColor", false, "yellow");
                textRange.collapse(false);
            }
        }
    }
</script>
<form  action="FrontController" method="get">
    <input type="hidden" name="taget" value="employeepage">
    <button type="submit" class="btn btn-primary">Tilbage til din side</button>
</form>
<h1 class="text-center">Brugere</h1>
<div class="text-center">
<input type="text" id="search">
<input type="button" class="btn btn-primary" id="button" onmousedown="doSearch(document.getElementById('search').value)" value="Søg på side">
</div>
<hr>

</hr>
<ul class="text-center">
    <c:forEach items="${sessionScope.xyz}"  var="U">
        <li>
            <p>Email:<strong> ${U.email}</strong></p>
            <p>Password:<strong> ${U.password}</strong></p>
            <p>Role:<strong> ${U.role}</strong></p>
            <p>Name:<strong> ${U.name}</strong></p>
            <p>Address:<strong> ${U.address}</strong></p>
            <p>ZipCode:<strong> ${U.zipCity}</strong></p>
            <p>Phone number:<strong> ${U.phone}</strong></p>





        </li>

        <hr>

        </hr>

    </c:forEach>

</ul>

</body>
</html>




