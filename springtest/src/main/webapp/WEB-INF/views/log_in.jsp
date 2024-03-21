<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">

<head>
	<meta charset = "UTF-8">
	<title>Login Start</title>
	<style>
	/* @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap'); */

        * {
            font-family: 'Noto Sans KR', sans-serif;
        }
        
        body {
        	background-color : #6667AB;
        }
        
        #first_login {
            margin: auto;
            width: 300px;
            background-color: #EEEFF1;
            border-radius: 5px;
            text-align: center;
            padding: 20px;
        }
        
        input {
            width: 100%;
            padding: 10px;
            box-sizing: border-box;
            border-radius: 5px;
            border: none;
        }
        
         #btn {
            background-color: #6667AB;
            margin-bottom: 30px;
            color: white;
            font-size: medium ;
            transition-duration: 3s;
        }
        
        #join_member{
        	text-decoration: none;
            color: #9B9B9B;
            font-size: medium;
        }
        
        #join_member:hover{
        	color: white;
            background-color: #6667AB;
            width: 300px;
            padding: 10px;
            box-sizing: border-box;
            border-radius: 5px;
            border: none;
        }
	</style>
</head>
<script>
	function logChk(){
		if(document.getElementById("id").value == ""){
			alert("아이디를 입력하세요.") ;
			return false ; 
		}
		if(document.getElementById("pw").value == ""){
			alert("비밀번호를 입력하세요.") ;
			return false ; 
		}
		return true ; 
	}

</script>
<body>
	<div id = "first_login">
		<!-- action은 request 파라미터를 보내는 역할을 함. 폼 데이터(form data)를 서버로 보낼 때 해당 데이터가 도착할 URL을 명시 -->
		<form method="get" action = "/loginChk" onsubmit="return logChk()"> 
			<p><input type="text" placeholder="아이디" class="id" id="id" name="id">${id}</p>
			<p><input type="password" placeholder="비밀번호" class="pw" id="pw" name="pw">${pw}</p>
			<input type="submit" id="btn" value="로그인">
		</form>
		<div class="links">
            <a href ="/member_join_form" id = "join_member">회원가입</a>
        </div>
	</div>
</body>

</html>
