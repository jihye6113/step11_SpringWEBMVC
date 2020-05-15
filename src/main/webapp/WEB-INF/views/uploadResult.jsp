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
<h1>파일 업로드 결과</h1>
<h3>
작성자: ${name}<p>
파일이름: ${fileName}<p>
파일용량: ${fileSize}<p>
저장경로: ${path}<p>
</h3>

<hr color="orange"/>
작성자: ${uploadDTO.name}<p>
파일이름: ${uploadDTO.fileName} / ${uploadDTO.file.originalFilename}<p>
파일용량: ${uploadDTO.fileSize} / ${uploadDTO.file.size}<p>
저장경로: <p>
</body>
</html>