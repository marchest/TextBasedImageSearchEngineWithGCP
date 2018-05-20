<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%-- <c:url var="home" value="/" scope="request" /> --%>
<jsp:include page="homeTemplate.jsp"></jsp:include>
<script type="text/javascript">
	$(document).ready(function(e) {
		$('.search-panel .dropdown-menu').find('a').click(function(e) {
			e.preventDefault();
			var param = $(this).attr("href").replace("#", "");
			var concept = $(this).text();
			$('.search-panel span#search_concept').text(concept);
			$('.input-group #search_param').val(param);
	
		});
		
		$("#search_btn").click(function(){
			var search = {}
			var operator=$('#search_param').val();
			var text=$("#search_txt").val();
			var json={'desc':text,'operator':operator};
		
		$.ajax(
			{
				type : 'POST',
				url : '${home}/home/filter',
				data : JSON.stringify(json),
				contentType : 'application/json',
				dataType:'text',
				success:function(response){
					$("#change").html($(response).find('#change'));
					console.log(response);
					
				},
				error: function (xhr, ajaxOptions, thrownError) {
					$("#change").html("<strong>Error2</strong>");
			        alert(xhr.status);
			        alert(thrownError);

			      }	
			});
		});
	
	});

		
		

	
</script>
<style type="text/css">
.container2 {
	width: %80;
	height: 400px;
	margin-left: 100px;
	margin-top: 25px;
	margin-right: 150px;
}

.row.content {
	height: auto;
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
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-8 col-xs-offset-2">
				<div class="input-group">
					<div class="input-group-btn search-panel">
						<button type="button" class="btn btn-default dropdown-toggle"
							data-toggle="dropdown">
							<span id="search_concept">Filter by</span> <span class="caret"></span>
						</button>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#wildcard">WildCard Query</a></li>
							<li><a href="#prefix">Prefix Query</a></li>
							<li><a href="#match">Match Query </a></li>
							<li><a href="#regex">Regex Query </a></li>
						</ul>
					</div>
					<input type="hidden" name="search_param" id="search_param">
					<input type="text" class="form-control" id="search_txt" name="x"
						placeholder="Search term..."> <span
						class="input-group-btn">
						<button class="btn btn-default" type="button" id="search_btn"
							style="height: 34px;">
							<span class="glyphicon glyphicon-search"></span>
						</button>
					</span>
				</div>
			</div>
		</div>
	</div>
	<div class="col content">
			<div class="col-sm-2">
				<div class="well">
					<a href="${pageContext.request.contextPath}/category/addImage2"
						style="text-decoration: none; font-family: Lucida Console;">Add Image</a>
				</div>
			</div>
		</div>
	<div class="container">
		<h2>Image Gallery</h2>
		<p>Text based image search engine.</p>
		<div class="row" id="change">
			<c:if test="${not empty imgUrl}">
				<c:forEach var="temp" items="${imgUrl}">
					<div class="col-md-4">
						<div class="thumbnail">
							<a href="${temp}" target="_blank"> 
							<img src="${temp}" alt="Lights" style="width: 250px; height: 250px;">
								<div class="caption">
									<p>Lorem ipsum donec id elit non mi porta gravida at eget
										metus.</p>
								</div>
							</a>
						</div>
					</div>
				</c:forEach>
			</c:if>
		</div>
	</div>
</body>
</html>