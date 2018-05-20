<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Details</title>
<jsp:include page="homeTemplate.jsp"></jsp:include>
</head>
<body>


	<div class="leftbar"
		style="float: left; margin-left: 20px; margin-top: 30px; width: 320px; height: 700px;">

		<div class="list-group">
			<a href="#" class="list-group-item active"> Islemler </a> <a
				href="${pageContext.request.contextPath}/user/profile"
				class="list-group-item list-group-item-action"> Hesabim</a> <a
				href="#" class="list-group-item list-group-item-action">Lorem Ipsum</a>
			<a href="#" class="list-group-item list-group-item-action">Porta
				ac consectetur ac</a> <a href="#"
				class="list-group-item list-group-item-action ">Vestibulum</a>

		</div>




	</div>

	<form:form name="registerForm"
		action="${pageContext.request.contextPath}/account/profile"
		commandName="customerData" method="post"
		onsubmit="return validateForm()">
		<div class="container"
			style="float: left; margin-left: 20px; margin-top: 10px;">
			<section>
				<div id="container_demo">
					<div id="wrapper">

						<div id="register">

							<h2 style="text-align: center">Account details</h2>
							<div class="form-group row">
								<label for="example-text-input" class="col-2 col-form-label">UserName</label>
								<div class="col-3">
									<input class="form-control" type="text" id="userName"
										name="userName"
										value="${userDetail.getUser().getUserName()==null? "":userDetail.getUser().getUserName()}">
								</div>
							</div>
							<div class="form-group row">
								<label for="example-email-input" class="col-2 col-form-label">Email</label>
								<div class="col-10">
									<input class="form-control" type="email" id="email"
										name="email" required="required" disabled="true"
										value="${userDetail.getUser().getEmail()==null? " ":
										userDetail.getUser().getEmail()}" width="250px"
										placeholder="mysupermail@mail.com">
								</div>
							</div>

							<div class="form-group row">
								<label for="example-email-input" class="col-2 col-form-label">Old
									password</label>
								<div class="col-10">
									<input class="form-control" type="password" id="oldpassword"
										name="oldpassword" required="required"
										placeholder="Enter old password">
								</div>
							</div>
							
								<div class="form-group row">
								<label for="example-email-input" class="col-2 col-form-label">New
									password</label>
								<div class="col-10">
									<input class="form-control" type="password" id="newpassword"
										name="newpassword" required="required"
										placeholder="Enter new password">
								</div>
							</div>
							<button type="submit" class="btn btn-primary">Submit</button>


						</div>
					</div>
				</div>
	</form:form>
</body>
</html>