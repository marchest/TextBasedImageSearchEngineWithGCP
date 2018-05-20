<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>404 Error Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="../homeTemplate.jsp"></jsp:include>
<script type="text/javascript">

</script>
<style type="text/css">
img {
    display: inline-block;
    width: 60%;
    align:middle;
    margin-left:300px;
    margin-right:100px;
    height: auto;
}

@media (max-width: 600px) {
  img {
    width: 100%; 
  }
</style>
</head>

<body>
<div class="img404">
<img src="${pageContext.request.contextPath}/resources/images/404_page_cover.jpg"  alt="404">
</div>
</body>
</html>
