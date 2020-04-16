<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="headder.jsp" />
<body class="simple-page">
	
	<div class="simple-page-wrap">
		<div class="simple-page-logo animated swing">
			<a href="index.html">
				<span><i class="fa fa-gg"></i></span>
				<span>Inventory Manager test </span>
			</a>
		</div><!-- logo -->
		
<div class="simple-page-form animated flipInY" id="signup-form">
	<h4 class="form-title m-b-xl text-center">Sign Up For a new Account</h4>
	<form:form action="user.create" method="post" modelAttribute="SysUser">
		<div class="form-group">
			<input id="sign-up-name" type="text" class="form-control" placeholder="Name">
		</div>

		<div class="form-group">
			<form:input id="sign-up-username" path="username" type="text" class="form-control" placeholder="Username" />
		</div>
		<div class="form-group">
						
							<select class="form-control" name="userTypes">
								<option value="NONE">Select User Type</option>
								<option value="ADMIN">Manager</option>
								<option value="USER">Cashier</option>
							</select>
						
					</div><!-- .form-group -->
		<div class="form-group">
			<form:input id="sign-up-password" path="password" type="password" class="form-control" placeholder="Password" />
		</div>
		<div class="form-group">
			<input id="confirmpassword" type="password" class="form-control" placeholder="Confirm Password"/>
		</div>
		
		<input type="submit" class="btn btn-primary" value="SING IN">
	</form:form>
</div><!-- #login-form -->

<div class="simple-page-footer">
	<p>
		<small>Do you have an account ?</small>
		
		<a href="<%=request.getContextPath()%>/">SIGN IN</a>
	</p>
</div><!-- .simple-page-footer -->


	</div><!-- .simple-page-wrap -->
</body>
</html>