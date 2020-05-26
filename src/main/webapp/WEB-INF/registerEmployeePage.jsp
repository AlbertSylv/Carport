<%--
  Created by IntelliJ IDEA.
  User: baske
  Date: 15/05/2020
  Time: 16.10
  To change this template use File | Settings | File Templates.
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/navbar2.inc"%>




    <title>Register Employee</title>
</head>
<body>
<form  action="FrontController" method="get">
    <input type="hidden" name="taget" value="employeepage">
    <button type="submit" class="btn btn-primary">Tilbage til din side</button>
</form>
<div class="text-center">
<form action="FrontController" method="post">
    <input type="hidden" name="taget" value="registerEmployee">
    <p class="hint-text">Fyld formlen ud for at lave en ny medarbejder profil!</p>

    <input type="text" class="form-control" name="email" placeholder="E-mail" required="required">

    <input type="text" class="form-control" name="name" placeholder="Navn" required="required">

    <input type="text" class="form-control" name="address" placeholder="Adresse" required="required">

    <input type="text" class="form-control" name="zipCity" placeholder="Postnr." required="required">

    <input type="text" class="form-control" name="phone" placeholder="Tlf." required="required">

    <input type="password" class="form-control" name="password1" placeholder="Password" required="required">

    <input type="password" class="form-control" name="password2" placeholder="Confirm Password" required="required">

    <div class="form-group">
        <label class="checkbox-inline"><input type="checkbox" required="required"> I accept the <a href="#">Terms &amp; Conditions</a></label>
    </div>
    <input type="submit" class="btn btn-primary btn-block" value="Sign up">
</form>
</div>
</body>
</html>
