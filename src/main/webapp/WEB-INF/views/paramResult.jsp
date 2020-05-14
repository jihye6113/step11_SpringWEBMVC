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
<h2>폼 전송 결과 Page</h2>
<h3>
아이디: ${member.id}<p>
이름: ${member.name}<p>
나이: ${member.age}<p>
주소: ${member.addr}<p>

<hr color="pink"/>
<h2>@ModelAttribute("m") 으로 접근하기</h2>
아이디: ${m.id}<p>
이름: ${m.name}<p>
나이: ${m.age}<p>
주소: ${m.addr}<p>

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