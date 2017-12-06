<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Subjects</title>
</head>
<body>
	<table class="formtable">
		<thead>
			<tr class="first_tr">
				<th>년도</th>
				<th>학기</th>
				<th>과목코드</th>
				<th>과목이름</th>
				<th>구분</th>
				<th>학점</th>				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="subject" items="${subjects}">
				<tr class="table_hover">
					<td><c:out value="${subject.year}"></c:out></td>
					<td><c:out value="${subject.semester}"></c:out></td>
					<td><c:out value="${subject.subjectCode}"></c:out></td>
					<td><c:out value="${subject.subjectName}"></c:out></td>															
					<td><c:out value="${subject.type}"></c:out></td>
					<td><c:out value="${subject.grade}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>