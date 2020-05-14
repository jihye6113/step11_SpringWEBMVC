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
<h1>MemberList 등록 결과</h1>
${memberListDTO.list} --> memberListDTO.getList() 호출
<table>
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>나이</th>
		<th>주소</th>
		<th>상태</th>
	</tr>
	<c:forEach items="${listDTO.list}" var="member" varStatus="i">
	<tr>
		<td>${i.count}</td>
		<td>${member.name}</td>
		<td>${member.age}</td>
		<td>${member.addr}</td>
		<td>${member.state}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>