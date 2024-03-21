<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title></title>
	<script>
		var msg = "<c:out value = '${msg}'/>";
		var title = "<c:out value = '${title}'/>";
		
		if(msg == null || msg.equals("")){
			alert(msg);
		}else if(title == null || title.equals("")){
			alert(title);
		}
		
		history.back();  // 이전 페이지로 이동
	
		// history.forward() : 다음 페이지로 이동
		// history.go(숫자) : 지정 페이지로 이동
		// go() : 괄호 안에 -1은 이전 페이지, 1은 다음 페이지, -2는 전전 페이지, 2는 다다음 페이지 
	</script>
</head>
<body>
</body>
</html>
