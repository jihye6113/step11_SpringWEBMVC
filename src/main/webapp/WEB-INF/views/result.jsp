<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>결과 page</h1>
<h3>
메세지: ${requestScope.message }<p>
아이디: ${id }
</h3>

<hr color="pink"/>
메시지: ${msg}<p>
</h3>
<fieldset>
	<legend>취미</legend>
	<c:forEach items="${hobbies}" var="h">
		<input type="checkbox" name="hobby" value="${h}">${h}
	</c:forEach>
</fieldset>
</body>
</html>