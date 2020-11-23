<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.List"%>
<%@page import="dto.Accounts"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="AgentReportGeneration" method="get">
<% Accounts accounts = (Accounts)request.getAttribute("account");
	   String busSegName = (String)request.getAttribute("busSegName");
	   List<String> questions = (List)request.getAttribute("questions");
	   List<String> selectedAnswers = (List)request.getAttribute("selectedAns");
	   Double premium = (Double)request.getAttribute("premium");
	   PrintWriter writer = response.getWriter();
	   writer.println(selectedAnswers);
	%>
	<%=accounts.getInsuredName() %><br>
	<%=accounts.getInsuredStreet() %><br>
	<%=accounts.getInsuredCity() %><br>
	<%=accounts.getInsuredState() %><br>
	<%=accounts.getInsuredZip() %><br>
	<%=busSegName %><br>
	<c:forEach items="${questions}" var="question">
	    	<c:out value="${question.polQuesDesc}" />${question.polQuesDesc}<br>
	</c:forEach>
	
	<c:forEach items="${selectedAnswers}" var="answer">
	    	<c:out value="${answer}" />${answer}<br>
	</c:forEach>
	<%=premium %>
	
</body>
</html>