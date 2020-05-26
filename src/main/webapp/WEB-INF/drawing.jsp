<%--
  Created by IntelliJ IDEA.
  User: Bruger
  Date: 5/13/2020
  Time: 8:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/navbar2.inc"%>
<html>
<head>
    <title>Carport tegning</title>
</head>
<body>
<input action="action" onclick="window.history.go(-1); return false;" type="submit" class="btn btn-primary" value="Tilbage"/>
<h1 class="text-center">Din carport</h1>
${requestScope.svgdrawing}

</body>
</html>
