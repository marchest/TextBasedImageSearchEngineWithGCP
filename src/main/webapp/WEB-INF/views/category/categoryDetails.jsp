<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<c:url var="home" value="/" scope="request" />
<jsp:include page="../homeTemplate.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category Detail</title>
<style type="text/css">
.container2 {
	width: %80;
	height: 400px;
	margin-left: 100px;
	margin-top: 25px;
	margin-right: 150px;
}

.row.content {
	height: 50px;
	width: 100px;
}

/* Set gray background color and 100% height */
.sidenav {
	background-color: #f1f1f1;
	height: 100%;
}

/* On small screens, set height to 'auto' for the grid */
@media screen and (max-width: %100) {
	.row.content {
		height: auto;
	}
}
</style>
<script type="text/javascript">
function callUpdate(){

		var data = {};
		data["categoryName"] = $("#inpName").val();
		data["categoryState"] = $("#inpState").val();
		data["categoryId"] = $("#categoryId").val();
		data["userId"] = $("#userId").val();
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "${home}/category/update",
			data : JSON.stringify(data),
			dataType : 'json',
			timeout : 10000,
			succes : function(data) {
				console.log(data);
			},
			done : function(e) {
				console.log("DONE");
			}
		});

	}
</script>
</head>
<body>
	<div class="container" style="align: center">
		<form>
			<div class="form-group row">
				<label for="inpName">Category Name</label> <input
					class="form-control input-sm" id="inpName" type="text"
					value="${categoryDetail.categoryName}"></input>
			</div>
			<div class="form-group row">
				<label for="inpState">Category State</label> <input
					class="form-control input-sm" id="inpState" type="text"
					value="${categoryDetail.categoryState}"></input>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary" id="btnUpdate" onclick="callUpdate()">Update</button>
			</div>
			
				 <input
					class="form-control input-sm" id="categoryId" style="display: none;" type="text"
					value="${categoryDetail.categoryId}"></input>
			 <input
					class="form-control input-sm" id="userId" style="display: none;" type="text"
					value="${categoryDetail.userId}"></input>
			
			
		</form>
	</div>
</body>
</html>