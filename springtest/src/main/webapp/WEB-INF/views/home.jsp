<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<table>
			<thead>
				<tr>
					<th>seq</th>
					<th>id</th>
					<th>pw</th>
					<th>nickname</th>
					<th>birthday</th>
					<th>gender</th>
					<th>e_address</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${membersList}" var="membersList">
					<tr>
						<td>${membersList.seq}</td>
						<td>${membersList.id}</td>
						<td>${membersList.pw}</td>
						<td>${membersList.nickname}</td>
						<td>${membersList.birthday}</td>
						<td>${membersList.gender}</td>
						<td>${membersList.e_address}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
