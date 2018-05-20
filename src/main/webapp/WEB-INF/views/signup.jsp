<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Sign in</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/demo.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style3.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/animate-custom.css" />
<jsp:include page="/index.jsp"></jsp:include>
<link href="${pageContext.request.contextPath}/resources/css/signUp.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function validateForm() {
		var name = document.forms["registerForm"]["userName"].value;
		var surname = document.forms["registerForm"]["surName"].value;
		var emailAddress = document.forms["registerForm"]["email"].value;
		var password = document.forms["registerForm"]["password"].value;
		$('#ded').remove();
		if (name == "") {
			//alert("asdasd");
			$('#xx').click();
			$('#modal-body').append('<p id="ded">Name can not be empty</p>');

			return false;
		}
		if (surname == "") {
			$('#xx').click();
			$('#modal-body').append('<p id="ded">Surname can not be empty</p>');
			return false;
		}
		if (emailAddress == "") {
			$('#xx').click();
			$('#modal-body').append(
					'<p id="ded">EmailAddress can not be empty</p>');
			return false;
		}
		if (password == "") {
			$('#xx').click();
			$('#modal-body')
					.append('<p id="ded">Password can not be empty</p>');
			return false;
		}

		return true;
	}
</script>
</head>
<body>
	<form:form name="registerForm"
		action="${pageContext.request.contextPath}/account/signup"
		commandName="customerData" method="post"
		onsubmit="return validateForm()">
		<div class="container">
			<section>
			<div id="container_demo">
				<!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
				<a class="hiddenanchor" id="toregister"></a> <a class="hiddenanchor"
					id="tologin"></a>
				<div id="wrapper">

					<div id="register" class="animate form">

						<h1>Sign up</h1>
						<p>
							<label for="usernamesignup" class="uname" data-icon="u">Your
								username</label> <input id="userName" name="userName"
								type="text" placeholder="mysuperusername690" />
						</p>
						<p>
							<label for="emailsignup" class="youmail" data-icon="e">
								Your email</label> <input id="email" name="email"
								required="required" type="email"
								placeholder="mysupermail@mail.com" />
						</p>
						<p>
							<label for="password" class="password" data-icon="p">Your
								password </label> <input id="password" name="password"
								required="required" type="password" placeholder="eg. X8df!90EO" />
						</p>
						<p>
							<label for="passwordsignup_confirm" class="youpasswd"
								data-icon="p">Please confirm your password </label> <input
								id="passwordsignup_confirm" name="passwordsignup_confirm"
								required="required" type="password" placeholder="eg. X8df!90EO" />
						</p>
						<p class="signin button">
							<input type="submit" value="Sign up" />

						</p>
						<p class="change_link">
							Already a member ? <a href="#tologin" class="to_register"> Go
								and log in </a>
						</p>

					</div>
	</form:form>
	<form:form name="registerForm"
		action="${pageContext.request.contextPath}/user/Login"
		commandName="customerData" method="post"
		onsubmit="return validateForm()">
		<div id="login" class="animate form">

			<h1>Log in</h1>
			<p>
				<label for="username" class="uname" data-icon="u"> Your
					email or username </label>
				<form:input path="email" name="email" id="email"
					required="required" type="text"
					placeholder="myusername or mymail@mail.com" />
			</p>
			<p>
				<label for="password" class="youpasswd" data-icon="p"> Your
					password </label> <input id="password" name="password" required="required"
					type="password" placeholder="eg. X8df!90EO" />
			</p>
			<p class="keeplogin">
				<input type="checkbox" name="loginkeeping" id="loginkeeping"
					value="loginkeeping" /> <label for="loginkeeping">Keep me
					logged in</label>
			</p>
			<p class="login button">
				<input type="submit" value="Login" />
			</p>
			<p class="change_link">
				Not a member yet ? <a href="#toregister" class="to_register">Join
					us</a>
			</p>

		</div>

	</form:form>

	</div>
	</div>
	</section>
	</div>

</body>
</html>