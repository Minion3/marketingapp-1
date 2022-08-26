<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="updateLead" method="post">
		<pre>
		<input type="hidden" name="id" value="${video.id}"/>
			FirstName<input type="text" name="firstName" value="${video.firstName}"/>
			LastName<input type="text" name="lastName" value="${video.lastName}"/>
			Email<input type="text" name="email" value="${video.email}"/>
			Mobile<input type="text" name="mobile" value="${video.mobile}"/>
			<input type="submit" value="update"/>
		</pre>
	</form>
</body>
</html>