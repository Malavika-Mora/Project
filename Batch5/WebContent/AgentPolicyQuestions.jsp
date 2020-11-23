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
<form action="AgentPremiumGeneration" method="post">
<table>
<h1>Policy Creation</h1>
<c:forEach var="ques" items="${questions}">
<%question++;%>
<tr>${ques.polQuesDesc}<br>
        <input type = "radio" name = "question<%=question%>" value="${ques.polQuesId }!${ques.polQuesAns1}!${ques.polQuesAns1Weightage}">${ques.polQuesAns1}
	    <input type = "radio" name = "question<%=question%>" value="${ques.polQuesId }!${ques.polQuesAns2}!${ques.polQuesAns2Weightage}">${ques.polQuesAns2}
		<input type = "radio" name = "question<%=question%>" value="${ques.polQuesId }!${ques.polQuesAns3}!${ques.polQuesAns3Weightage}">${ques.polQuesAns3}<br></tr>
<br>
</c:forEach>
</table><br>
<input type="hidden" name="numofquestions" value="<%=question%>">
<input type="submit" value="createPolicy">
</form>
</body>
</html>