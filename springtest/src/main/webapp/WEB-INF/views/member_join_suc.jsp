<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset = "UTF-8">
	<title>Join success</title>
	<style>
	/* @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap'); */

        * {
            font-family: 'Noto Sans KR', sans-serif;
        }
        
        body {
        	background-color : #6667AB;
        }
        
        #wellcome_join_success {
            margin: auto;
            width: 400px;
            background-color: #EEEFF1;
            border-radius: 5px;
            text-align: center;
            padding: 20px;
        }
        
        #login_btn {
            width: 80%;
            padding: 10px;
            box-sizing: border-box;
            border-radius: 5px;
            border: none;
            background-color: #6667AB;
            margin-bottom: 10px;
            color: white;
            font-size: medium;
        }
        
        #join_success{
        	font-size: x-large;
        	font-weight: bold;
        }
	</style>
</head>
<body>
	<div id = "wellcome_join_success">
		<form method = "get" action = "/springtest/MembersController/log_in" id = "wellcome_join_success_form"> <!-- form이 있어야 클라이언트의 값을 Cotroller에 보내줄 수 있음 -->
			<p class="join_success" id="join_success" name="join_success">정상적으로 처리됐습니다</p>
			<p><input type="button" onclick = "location.href='/log_in'" value = "로그인" id = "login_btn"></p>
		</form>
	</div>
</body>
</html>