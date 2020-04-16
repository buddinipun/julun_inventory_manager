<!DOCTYPE html>
<html lang="en">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Inventory Manager- Apptota portal</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
	<meta name="description" content="Admin, Dashboard, Bootstrap" />
	<link rel="shortcut icon" sizes="196x196" href="../../UnipointWeb/resources/assets/images/logo.png">
	
	<link rel="stylesheet" href="public/static/libs/bower/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="public/static/libs/bower/material-design-iconic-font/dist/css/material-design-iconic-font.min.css">
	<link rel="stylesheet" href="public/static/libs/bower/animate.css/animate.min.css">
	<link rel="stylesheet" href="public/static/css/bootstrap.css">
	<link rel="stylesheet" href="public/static/css/core.css">
	<link rel="stylesheet" href="public/static/css/misc-pages.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway:400,500,600,700,800,900,300">
    <link rel="stylesheet" href="public/static/libs/bower/fullcalendar/dist/fullcalendar.min.css"/>
	<link rel="stylesheet" href="public/static/libs/bower/perfect-scrollbar/css/perfect-scrollbar.css"/>
    <script type="text/javascript" src="public/static/libs/bower/jquery/dist/jquery.js"></script>
    <script type="text/javascript" src="public/static/libs/bower/jquery-ui/jquery-ui.min.js"></script>
    
</head>
<body class="simple-page">
	<div id="back-to-home">
		<a href="index.html" class="btn btn-outline btn-default"><i class="fa fa-home animated zoomIn"></i></a>
	</div>
	<div class="simple-page-wrap">
		<div class="simple-page-logo animated swing">
			<a href="index.html">
				<span><i class="fa fa-gg"></i></span>
				<span>Inventory Manager</span>
			</a>
		</div><!-- logo -->
		<div class="simple-page-form animated flipInY" id="login-form">
	<h4 class="form-title m-b-xl text-center">Sign In Inventory Manager</h4>
	 <p style="color: red">${SPRING_SECURITY_LAST_EXCEPTION.message}</p>
	 <form action="login" method="post">

			<div class="form-group">
				<input id="sign-up-name" type="text" class="form-control" name="username"
					placeholder="User Name" />
			</div>
			<div class="form-group">
				<input d="sign-in-password" type="password" class="form-control" name="password"
					placeholder="Password" />
			</div>
			<div class="form-group">
				<input type="submit" value="Sign In" class="btn btn-primary" />
			</div>
		
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
</div><!-- #login-form -->

<div class="simple-page-footer">
	<p><a href="password-forget.html">FORGOT YOUR PASSWORD ?</a></p>
	<p>
		<small>Don't have an account ?</small>
		<a href="signup.html">CREATE AN ACCOUNT</a>
	</p>
</div><!-- .simple-page-footer -->


	</div><!-- .simple-page-wrap -->
</body>
</html>