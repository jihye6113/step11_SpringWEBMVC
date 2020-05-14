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
<h1>예외 Page</h1>
<h3>
	errMsg: ${errMsg}<p>
	errorInfo: ${errorInfo}<p>
</h3>

<a href="${pageContext.request.contextPath}/exception.html">메인으로</a> 
</body>
</html>