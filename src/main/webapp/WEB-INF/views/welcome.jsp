<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<%@include file="communs/header.jspf" %>
<body>
    <%@include file="communs/navigation.jspf" %>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                Welcome ${name}!!! <br />
                Now, you can <a href="list-todos">Manager your Todo</a>
            </div>
        </div>
    </div>

<%@include file="communs/footer.jspf" %>
</body>
</html>