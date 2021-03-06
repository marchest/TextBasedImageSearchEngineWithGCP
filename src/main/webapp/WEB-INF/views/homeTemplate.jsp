<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>

<c:url var="coreJquery" value="/resources/js/jquery-3.2.1.min.js"></c:url>
  <meta charset="utf-8">
  <script src="${coreJquery}"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!--   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->

  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 
  
<!--   <script src="../src/main/webapp/resources/js/jquery-3.2.1.min.js"></script> -->
<%--   <link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" type="text/css"/> --%>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    
    <ul class="nav navbar-nav">
      <li class="active"><a href="${pageContext.request.contextPath}/home/">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Page 1-1</a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      </li>
      <li><a href="#">Page 2</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="${pageContext.request.contextPath}/user/profile"><span class="glyphicon glyphicon-user"></span>Profile</a></li>
       <li><a href="${pageContext.request.contextPath}/home/logout"><span class="glyphicon glyphicon-user"></span> Log Out</a></li>

    </ul>
  </div>
</nav>


</body>
</html>