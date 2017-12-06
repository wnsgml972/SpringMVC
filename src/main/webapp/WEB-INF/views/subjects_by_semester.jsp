<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="formtable">
		<thead>
			<tr class="first_tr">
				<th>년도</th>
				<th>학기</th>
				<th>이수학점</th>
				<th>상세보기</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="subject" items="${subjects}">
				<tr class="table_hover">
					<td><c:out value="${subject.year}"></c:out></td>
					<td><c:out value="${subject.semester}"></c:out></td>
					<td><c:out value="${subject.grade}"></c:out></td>
					<td><a href="${pageContext.request.contextPath}/subjects?year=${subject.year}&semester=${subject.semester}">링크</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>