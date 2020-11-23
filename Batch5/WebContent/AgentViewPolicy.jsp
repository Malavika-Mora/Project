<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Policy View</h1>
	<table class = "table" cellpadding="20px" border="0px">
	<tr>
		<th>Policy Number</th>
		<th>Policy Premium</th>
		<th>Account Number</th>
		</tr>
		<c:forEach items="${policies}" var="policy">
			<tr class = "tr">
				<td>${policy.policyNumber}</td>
				<td>${policy.policyPremium}</td>
				<td>${policy.accNumber }</td>
				<td><a href="AgentReportGeneration?accNumber=${policy.accNumber}&polNumber=${policy.policyNumber}">View Policy</a>
			</tr>
		</c:forEach>
	</table>
	

</body>
</html>