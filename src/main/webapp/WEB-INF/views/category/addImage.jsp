<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<jsp:include page="../homeTemplate.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AddImage</title>
<style type="text/css">
.upload-btn-wrapper {
	position: relative;
	overflow: hidden;
	display: inline-block;
	mmargin: 50px 800px;
}

.btn {
	border: 2px solid gray;
	color: gray;
	background-color: white;
	padding: 8px 20px;
	border-radius: 8px;
	font-size: 20px;
	font-weight: bold;
}

.upload-btn-wrapper input[type=file] {
	font-size: 100px;
	position: absolute;
	left: 10;
	top: 0;
	opacity: 0;
}
</style>
</head>
<body>
<!-- 	<div class="upload-btn-wrapper">
		<form method="POST" enctype="multipart/form-data" action="${pageContext.request.contextPath}/image">
			<input type="file" class="btn" name="file" />
			<input type="submit" value="Upload" />
		</form>
	</div>
	 -->
	 <div>
		<form method="POST" enctype="multipart/form-data" action="${pageContext.request.contextPath}/image/uploadImage">
			<table>
				<tr><td>File to upload:</td><td><input type="file" name="imgFile" /></td></tr>
				<tr><td></td><td><input type="submit" value="Upload" /></td></tr>
			</table>
		</form>
	</div>
</body>
</html>