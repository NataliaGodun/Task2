<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
<title>Customer Registration Form</title>

<style>
.error {
	color: red
}
</style>

</head>

<body>
	<img src="${pageContext.request.contextPath}/resources/images/welcom.jpg"/>
	<br>
	<br>

	<form:form action="processUserForm" modelAttribute="user">
	
		Login: <form:input path="login" />
        <form:errors path="login" cssClass="error" />
		<br>
		<br>
		
		Password : <form:input path="password" />
		<form:errors path="password" cssClass="error" />

		<br>
		<br>
		
		
		<br>
		<br>

		<input type="submit" value="Submit" />

	</form:form>
		<br>
		<br>
		
		Or you want registration?
		<br>
		<br>
		<form:form action="showRegistrationForm" modelAttribute="user">
	
		
		<input type="submit" value="Registration" />

	</form:form>

</body>

</html>
