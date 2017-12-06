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
				<c:forEach var="subject" items="${subjects}">
					<th><c:out value="${subject.type}"></c:out></th>
				</c:forEach>
			</tr>
		</thead>
		<tbody>
			<tr class="table_hover">
				<c:forEach var="subject" items="${subjects}">
					<td><c:out value="${subject.grade}"></c:out></td>
				</c:forEach>
			</tr>
		</tbody>

	</table>
</body>
</html>