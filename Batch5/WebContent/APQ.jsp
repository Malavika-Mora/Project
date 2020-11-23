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
<%!int question=0; %>
 <form action = "AgentPremiumGenerationServlet" method ="get">
 <table>
<h1>Policy Creation</h1>
<c:forEach var="ques" items="${questions}">
<%question++ ;%>
<tr>${ques.polQuesDesc}<br>
		<input type = "radio" name = "${ques.polQuesSeq }" value="${ques.polQuesId }!${ques.polQuesAns1}!${ques.polQuesAns1Weightage}"><c:out value="${ques.polQuesAns1}"/><br>
		<input type = "radio" name = "${ques.polQuesSeq }" value="${ques.polQuesId }!${ques.polQuesAns2}!${ques.polQuesAns2Weightage}"><c:out value="${ques.polQuesAns2}"/><br>
		<input type = "radio" name = "${ques.polQuesSeq }" value="${ques.polQuesId }!${ques.polQuesAns3}!${ques.polQuesAns3Weightage}"><c:out value="${ques.polQuesAns1}"/><br></tr>
	<br>
</c:forEach>
</table><br>
<input type="hidden" name = "numofquestions" value="<%=question %>">
	<input type = "submit" value="Create Policy">
	
</body>
</html>