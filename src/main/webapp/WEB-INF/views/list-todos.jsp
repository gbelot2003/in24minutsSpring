<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Yahoo!!</title>
	<link href="webjars/bootstrap/3.3.5/css/bootstrap.min.css" 	rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
			<h6>Hi <strong>${name}</strong></h6>
		    Your Todos are: <br />
	
				<table class="table">
					<caption>Your Todos</caption>
					<thead>
						<tr>
							<th>Test Desc</th>
							<th>Test Date</th>
							<th>true</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${todos}" var="todo">
						<tr>	
						 	<td>${todo.desc}</td>
						 	<td>${todo.targetDate}</td>
						 	<td>${todo.done}</td>
						 	<td><a href="/delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a></td>
						 </tr>
						</c:forEach>
					</tbody>
				</table>
				<br />
				<hr />	
				<a class="btn btn-primary" href="/add-todo">Add</a>
			</div>
		</div>
	</div>

	
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>