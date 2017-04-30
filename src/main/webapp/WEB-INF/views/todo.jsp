<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<%@include file="communs/header.jspf" %>
<body>
	<%@include file="communs/navigation.jspf" %>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>Add a Todo</h1>
					<form:form method="post" commandName="todo">
						<div class="form-group">
							<form:label path="desc">Description</form:label>
							<form:hidden path="id" />
							<form:input path="desc" type="text" class="form-control" required="required"/>
							<form:errors path="desc" cssClass="text-warning"></form:errors>
						</div>
						<div class="form-group">
							<form:label path="desc">Date</form:label>
							<form:input path="targetDate" type="text" class="form-control" required="required"/>
							<form:errors path="targetDate" cssClass="text-warning"></form:errors>
						</div>
						<div class="form-group">
							<input class="btn btn-success" type="submit"  value="Enviar"/>
						</div>
					</form:form>
			</div>
		</div>
	</div>
	<%@include file="communs/footer.jspf" %>
</body>
</html>