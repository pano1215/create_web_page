<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset = "UTF-8">
	<title>Write New Story</title>
	<style>
	/* @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap'); */

        * {
            font-family: 'Noto Sans KR', sans-serif;
        } 
        
        body {
        	background-color : #6667AB;
        }
        
        .container {
            margin: auto;
            width: 800px;
            background-color: #EEEFF1;
            border-radius: 5px;
            text-align: center;
            padding: 20px;
        }
        
        #board_write{
        	text-align: center;
        }
        
        #save_content {
            width: 30%;
            padding: 10px;
            box-sizing: border-box;
            border-radius: 5px;
            border: none;
            background-color: #6667AB;
            margin: 10px;
            color: white;
            font-size: medium ;
            align: right;
        } 
        
        .content {
        	width: 700px;
        	border: none;
        	resize: none;
        	border-radius: 5px;
        } 
        
        #contents{
        	height: 500px;
        }
        
        #title{
        	height: 30px;
        }
        
        .cate{
        	text-align: left;
        }
        
        .hide{
        	display: none;
        }
        
        .input{
        	border: none;
        	background-color: #EEEFF1;
        	pointer-events: none;
        }
	</style>
</head>
<script>
</script>
<body>
	<div class = "container">
		<h2 id = "board_write">게시판 등록</h2>
		<form action="/board_content_save" id = "frm" name = "frm" method = "get">
			<table class = "board_detail">
			<c:set value="<%=new Date()%>" var="today"/>
				<tr>
					<input class="hide" name="id" value="${logId}">
				</tr>
				<tr>
					<td class="cate">게시일자  | </td>
					<td name="postDate" class="cate"><input class="input" name="postDate" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${today}"/>" readonly></td>
				</tr>
				<tr>
					<td class="cate">게시자&nbsp&nbsp&nbsp | </td>
					<td name="userNickname" class="cate"><input class="input" name="userNickname" value="${logName}" readonly></td>
				</tr>
				<tr>
					<td class="cate">제목</td>
					<td><input class="content" type="text" id="title" name="postTitle" placeholder="제목" ></td>
				</tr>
				<tr>
					<td class="cate" id="cate-content">내용</td>
					<td>
						<textarea class="content" id = "contents" name = "postContent" placeholder="내용을 입력해 주세요"></textarea>
					</td>
				</tr>
			</table>
			<input type = "submit" id = "save_content" value = "저장하기 " class = "btn">
		</form>
	</div>
</body>
</html>