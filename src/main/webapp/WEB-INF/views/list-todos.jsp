<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<%@include file="communs/header.jspf" %>
<body>
	<%@include file="communs/navigation.jspf" %>
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
							<th>is Compleated?</th>
							<th></th>
							<th><th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${todos}" var="todo">
						<tr>	
						 	<td>${todo.desc}</td>
							<td>
							<fmt:formatDate  pattern="dd/MM/yyyy"
										value="${todo.targetDate}"/>
							</td>
						 	<td>${todo.done}</td>
						 	<td><a href="/update-todo?id=${todo.id}" class="btn btn-success">Update</a></td>
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
	<%@include file="communs/footer.jspf" %>
</body>
</html>