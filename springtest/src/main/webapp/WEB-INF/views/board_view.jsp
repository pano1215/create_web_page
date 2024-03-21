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
        
        #edit_content {
            width: 30%;
            padding: 10px;
            box-sizing: border-box;
            border-radius: 5px;
            border: none;
            background-color: #6667AB;
            margin: 50px;
            color: white;
            font-size: medium ;
            align: right;
            text-decoration: none;
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
        
        .content_input{
        	/* border-color: #6667AB; */
        	background-color: #EEEFF1;
        	pointer-events: none;
        	width: 700px;
        	resize: none;
        	border-radius: 5px;
        	border: none; 
        }
	</style>
</head>
<script>
</script>
<body>
	<div class = "container">
		<h2 id = "board_write">게시판 글 보기</h2>
		<form action="/board_content_save" id = "frm" name = "frm" method = "get">
			<table class = "board_detail">
			<c:set value="<%=new Date()%>" var="today"/>
				<tr>
					<input class="hide" name="id" value="${logId}">
					<input class="hide" name="id" value="${boardVOView.boardId}">
				</tr>
				<tr>
					<td class="cate">게시일자  | </td>
					<td name="postDate" class="cate"><input class="input" name="postDate" value="${boardVOView.postDate}" readonly></td>
				</tr>
				<tr>
					<td class="cate">게시자&nbsp&nbsp&nbsp | </td>
					<td name="userNickname" class="cate"><input class="input" name="userNickname" value="${logName}" readonly></td>
				</tr>
				<tr>
					<td class="cate">제목</td>
					<td><input class="content_input" type="text" id="title" name="postTitle" value="${boardVOView.postTitle}" readonly></td>
				</tr>
				<tr>
					<td class="cate" id="cate-content">내용</td>
					<td>
						<input class="content_input" type="text" id = "contents" name = "postContent" value="${boardVOView.postContent}" readonly>
					</td>
				</tr>
			</table>
			<c:if test = "${boardVOView.id==logId}">
				<a href="/board_edit?boardId=${boardVOView.boardId}" id = "edit_content">수정하기</a>
			</c:if>
		</form>
	</div>
</body>
</html>