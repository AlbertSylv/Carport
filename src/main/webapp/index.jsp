
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="includes/navbar.inc"%>





    </head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
<link href="./includes/style.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--webfonts-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans:600italic,400,300,600,700' rel='stylesheet' type='text/css'>
<!--//webfonts-->

<style>a{text-decoration:none;}
.txt-rt{text-align:right;}/* text align right */
.txt-lt{text-align:left;}/* text align left */
.txt-center{text-align:center;}/* text align center */
.float-rt{float:right;}/* float right */
.float-lt{float:left;}/* float left */
.clear{clear:both;}/* clear float */
.pos-relative{position:relative;}/* Position Relative */
.pos-absolute{position:absolute;}/* Position Absolute */
.vertical-base{	vertical-align:baseline;}/* vertical align baseline */
.vertical-top{	vertical-align:top;}/* vertical align top */
nav.vertical ul li{	display:block;}/* vertical menu */
nav.horizontal ul li{	display: inline-block;}/* horizontal menu */
img{max-width:100%;}
/*end reset*/
/****-----start-body----****/
body{
    background: #174b87;
    font-family: 'Open Sans', sans-serif;

}
.login-form {
    background:#eee;
    width: 26%;
    margin:9% auto 4% auto;
    position: relative;
    -webkit-border-radius: 0.4em;
    -o-border-radius: 0.4em;
    -moz-border-radius: 0.4em;
    box-shadow: rgba(23, 75, 135, 0.33) 1px 1px,
    rgba(23, 75, 135, 0.33) 2px 2px,
    rgba(23, 75, 135, 0.33) 3px 3px,
    rgba(23, 75, 135, 0.33) 4px 4px,
    rgba(23, 75, 135, 0.33) 5px 5px,
    rgba(23, 75, 135, 0.33) 6px 6px,
    rgba(23, 75, 135, 0.33) 7px 7px,
    rgba(23, 75, 135, 0.33) 8px 8px,
    rgba(23, 75, 135, 0.33) 9px 9px,
    rgba(23, 75, 135, 0.33) 10px 10px,
    rgba(23, 75, 135, 0.33) 11px 11px,
    rgba(23, 75, 135, 0.33) 12px 12px,
    rgba(23, 75, 135, 0.33) 13px 13px,
    rgba(23, 75, 135, 0.33) 14px 14px,
    rgba(23, 75, 135, 0.33) 15px 15px,
    rgba(23, 75, 135, 0.33) 16px 16px,
    rgba(23, 75, 135, 0.33) 17px 17px,
    rgba(23, 75, 135, 0.33) 18px 18px,
    rgba(23, 75, 135, 0.33) 19px 19px,
    rgba(23, 75, 135, 0.33) 20px 20px,
    rgba(23, 75, 135, 0.33) 21px 21px,
    rgba(23, 75, 135, 0.33) 22px 22px,
    rgba(23, 75, 135, 0.33) 23px 23px,
    rgba(23, 75, 135, 0.33) 24px 24px,
    rgba(23, 75, 135, 0.33) 25px 25px,
    rgba(23, 75, 135, 0.33) 26px 26px,
    rgba(23, 75, 135, 0.33) 27px 27px,
    rgba(23, 75, 135, 0.33) 28px 28px,
    rgba(23, 75, 135, 0.33) 29px 29px,
    rgba(23, 75, 135, 0.33) 30px 30px,
    rgba(23, 75, 135, 0.33) 31px 31px,
    rgba(23, 75, 135, 0.33) 32px 32px,
    rgba(23, 75, 135, 0.33) 33px 33px,
    rgba(23, 75, 135, 0.33) 34px 34px,
    rgba(23, 75, 135, 0.33) 35px 35px,
    rgba(23, 75, 135, 0.33) 36px 36px,
    rgba(23, 75, 135, 0.33) 37px 37px,
    rgba(23, 75, 135, 0.33) 38px 38px,
    rgba(23, 75, 135, 0.33) 39px 39px,
    rgba(23, 75, 135, 0.33) 40px 40px,
    rgba(23, 75, 135, 0.33) 41px 41px,
    rgba(23, 75, 135, 0.33) 42px 42px,
    rgba(23, 75, 135, 0.33) 43px 43px,
    rgba(23, 75, 135, 0.33) 44px 44px,
    rgba(23, 75, 135, 0.33) 45px 45px,
    rgba(23, 75, 135, 0.33) 46px 46px,
    rgba(23, 75, 135, 0.33) 47px 47px,
    rgba(23, 75, 135, 0.33) 48px 48px,
    rgba(23, 75, 135, 0.33) 49px 49px,
    rgba(23, 75, 135, 0.33) 50px 50px,
    rgba(23, 75, 135, 0.33) 51px 51px,
    rgba(23, 75, 135, 0.33) 52px 52px,
    rgba(23, 75, 135, 0.33) 53px 53px,
    rgba(23, 75, 135, 0.33) 54px 54px,
    rgba(23, 75, 135, 0.33) 55px 55px,
    rgba(23, 75, 135, 0.33) 56px 56px,
    rgba(23, 75, 135, 0.33) 57px 57px,
    rgba(23, 75, 135, 0.33) 58px 58px,
    rgba(23, 75, 135, 0.33) 59px 59px,
    rgba(23, 75, 135, 0.33) 60px 60px,
    rgba(23, 75, 135, 0.33) 61px 61px

}

.head {
    position: absolute;
    top:-15%;
    left: 35%;
}
.head img {
    border-radius:50%;
    -webkit-border-radius:50%;
    -o-border-radius:50%;
    -moz-border-radius:50%;
    border:6px solid rgba(221, 218, 215, 0.23);
}
.main{
    position:relative;
}
.main h1{
    font-size:25px;
    color:#676767;
    font-family: 'Open Sans', sans-serif;
    font-weight:400;
    padding-top: 19%;
    text-align: center;
}
.main form {
    width: 80%;
    margin: 0 auto;
    padding: 6% 0 9% 0;
}
.main p {
    text-align: center;
}
.main form p a {
    color: #888;
    font-family: 'Open Sans', sans-serif;
}
form p a:hover {
    color:#21A957;
}
input[type="text"], input[type="password"]{
    text-align:left;
    position: relative;
    width:92%;
    padding:3%;
    background:#D3D3D3;
    margin-bottom: 6%;
    font-family: 'Open Sans', sans-serif;
    color: #676767;
    font-weight:600;
    font-size: 16px;
    outline: none;
    border: none;
    border-radius: 5px;
    border:1px solid #DED6D6;
    -webkit-appearance:none;
}
input[type="text"]:hover, input[type="password"]:hover{
    border:1px solid #949494;
    transition:0.5s;
    -webkit-transition:0.5s;
    -moz-transition:0.5s;
    -o-transition:0.5s;
    -ms-transition:	0.5s;

}
input[type="submit"]{
    width: 99%;
    padding: 3%;
    margin-bottom: 8%;
    background: #21A957;
    font-family: 'Open Sans', sans-serif;
    color: #ECECEC;
    box-shadow: inset 0px 0px 10px #666464;
    -webkit-text-shadow: 0px 0px 3px #000;
    -moz-text-shadow: 0px 0px 3px #000;
    -o-text-shadow: 0px 0px 3px #000;
    -ms-text-shadow: 0px 0px 3px #000;
    font-size: 20px;
    outline: none;
    border: none;
    cursor: pointer;
    font-weight:500;
    border-radius: 5px;
    transition: 0.5s;
    -webkit-appearance:none;
    -webkit-transition: 0.5s;
    -moz-transition: 0.5s;
    -o-transition: 0.5s;
    -ms-transition: 0.5s;
}
input[type="submit"]:hover{
    background:#128A42;
    color:#fff;
}
/****************/
.copy-right {
    position: absolute;
    bottom:-19%;
    left: 43.7%;
}
.copy-right p {
    color: #fff;
    font-size: 1em;
    font-family: 'Open Sans', sans-serif;
    font-weight: 600;
}
.copy-right p a {
    font-family: 'Open Sans', sans-serif;
    font-size: 1em;
    color:#21A957;
    -webkit-transition: all 0.3s ease-out;
    -moz-transition: all 0.3s ease-out;
    -ms-transition: all 0.3s ease-out;
    -o-transition: all 0.3s ease-out;
    transition: all 0.3s ease-out;
}
.copy-right p a:hover{
    color:#fff;
}
/*-----start-responsive-design------*/
@media (max-width:1440px){
    .login-form {
        width:30%;
        margin: 11% auto 4% auto;
    }
    .main h1 {
        padding-top: 23%;
    }
    .copy-right {
        bottom: -26%;
    }
}
@media (max-width:1366px){
    .login-form {
        width: 32%;
        margin: 10% auto 4% auto;
    }
}
@media (max-width:1280px){
    .login-form  {
        margin:8% auto 0;
        width:34%;

    }
    .copy-right {
        left: 41%;
        bottom:-18%;
    }
}
@media (max-width:1024px){
    .login-form  {
        margin:12% auto 0;
        width:45%;

    }
    .copy-right {
        left: 41%;
        bottom:-18%;
    }
}
@media (max-width:768px){
    .login-form  {
        margin: 16% auto 0;
        width: 59%;
    }
    .copy-right {
        left:38%;
        bottom:-14%;
    }
}
@media (max-width:640px){
    .login-form {
        margin: 20% auto 0;
        width: 63%;
    }
    .copy-right {
        left:36%;
        bottom:-18%;
    }
}
@media (max-width:480px) {
    .login-form {
        margin: 32% auto 0;
        width: 74%;

    }

    .copy-right {
        left: 30%;
        bottom: -17%;
    }

    .main h1 {
        font-size: 22px;
    }

    .head img {
        width: 78%;
    }

    .head {
        top: -15%;
        left: 34%;
    }

    input[type="text"], input[type="password"], input[type="submit"] {
        font-weight: 600;
        margin-bottom: 4%;
    }

    @media (max-width: 320px) {
        .login-form {
            margin: 20% auto 0;
            width: 85%;


        }

        .main h1 {
            padding-top: 20%;
            font-size: 20px;
        }

        .head img {
            width: 60%;
            border: 5px solid rgba(221, 218, 215, 0.23);
        }

        .head {
            top: -15%;
            left: 36%;
        }

        input[type="text"], input[type="password"], input[type="submit"] {
            font-weight: 600;
            font-size: 15px;
        }

        .main form p a {
            font-size: 15px;
        }

        input[type="submit"] {
            padding: 4%;
        }

    }
}
</style>

</head>
<body>
<!-----start-main---->

<div class="main">
    <div class="login-form">

        <div class="head">
            <img src="img/fog_logo.jpg" width="140px" height="140px" alt=""/>
        </div>
        <br>
        <h1>Fog Login</h1>
        <form  name="login" action="FrontController" method="post">
            <input type="hidden" name="taget" value="login">
            <input type="text" class="text" placeholder="E-mail" required="required" name="email"  >
            <input type="password" placeholder="Password" required="required" name="password" >
            <div class="submit">
                <input type="submit" value="LOGIN" >
            </div>
            <p><a href="#">Forgot Password ?</a></p>
        </form>
    </div>
    <!--//End-login-form-->

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
