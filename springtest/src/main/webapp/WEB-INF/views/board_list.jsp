<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">

<head>
	<meta charset = "UTF-8">
	<title>Board List - Welcome</title>
	<style>
	/* @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap'); */

        * {
            font-family: 'Noto Sans KR', sans-serif;
        }
        
        body {
        	background-color : #6667AB;
        }
        
        #board_container {
            margin: auto;
            width: 900px;
            height: 1100px;
            background-color: #EEEFF1;
            border-radius: 5px;
            text-align: center;
            padding: 20px;
        }
        
        table{
        	width: 100%;
        	border-top : 1px solid #6667AB;
        	border-collapse: collapse;
        }
        
        th, td {
        	border-bottom : 1px solid #6667AB;
        	padding: 10px;
        }
        
        /* 검색 항목 */
        #board_search {
            width: 15%;
            padding: 10px;
            box-sizing: border-box;
            border-radius: 5px;
            border: none;
        }
        
        /* 검색 텍스트 박스 */
        #board_search_text {
            width: 40%;
            padding: 10px;
            box-sizing: border-box;
            border-radius: 5px;
            border: none;
        }
        
        /* 검색버튼 */
        #board_search_btn {
            width: 10%;
            padding: 10px;
            box-sizing: border-box;
            border-radius: 5px;
            border: none;
            background-color: #6667AB;
            color: white;
        }
        
        /* 새로등록하기 버튼 */
        #new_write {
            width: 15%;
            padding: 10px;
            color: #6667AB;
            text-decoration: none;
        }
        
        /* 새로등록하기 버튼 */
        #new_write:hover{
        	color: white;
            background-color: #6667AB;
            width: 300px;
            padding: 10px;
            box-sizing: border-box;
            border-radius: 5px;
            border: none;
        }
        
         /* 로그아웃 버튼 */
        #logout_btn{
            box-sizing: border-box;
            border-radius: 5px;
           	border-color: #6667AB;
            color: #6667AB;
            text-decoration: none;
        } 
        
        #table_title{
        	text-decoration: none;
        }
        
        .page{
        	text-decoration: none;
        }
	</style>
</head>
<script src="../resources/jquery-3.6.3.min.js"></script>
<script>

const searchParams = new URL(location).searchParams ;
let obj = {
		"currentPage" : searchParams.get('currentPage')
} ;

$.ajax({
	type: 'GET',
	url: "/board_list",
	data: obj.currentPage,
	success: function(data){
		// 컨트롤러에서 스트링으로 넘겨주기 때문에 json을 스트링으로 변환해주는 과정이 필요함
	},error: function(data){
	}
})

</script>
<body>
		<div id = "board_container">
			<h1>내 손 안의 게시판</h1> <!-- 중앙 정렬로 / 큰 사각형(회색) /  -->
			<form action="/board_list" id = "frm" name = "frm" method = "get">
				<p>${logName}님
				<select class="board_search" id="board_search" name="board_search" onchange="ChangeValue()"> <!-- label : 사용자 인터페이스 항목의 설명. ex. 체크박스, 캘린더 등등 -->
					<option value = "postTitle">제목</option>
					<option value = "userNickname">게시자</option>
				</select>
				<input type="text" id="board_search_text" name="searchWord"> <!-- 검색어 입력 input box -->
				<input type="submit" id="board_search_btn" value="검색">
			
				<a href = "/board_write" id = "new_write">새로등록하기</a> <!-- 밑줄 지워야함  / 글쓰기 이모티콘으로 -->	 
				<a id="logout_btn"  href="/logout" >로그아웃</a>
			</form>
			</p>
			<table id = "container_cate">
				<thread>
					<tr>
						<th id = "post_date">게시일자</th><th id = "write_user">게시자</th><th id = "title">제목</th>
					</tr>
				</thread>
				<!-- jstl -->
				<c:forEach var = "boardVO" items = "${boardVOList}" > 
					<tbody>
						<tr>
						<td><c:out value="${boardVO.postDate}" /></td><td><c:out value="${boardVO.userNickname}" /></td><td ><a href="/board_view?boardId=${boardVO.boardId}" id="table_title"><c:out value="${boardVO.postTitle}" /></a></td>
						</tr>
					</tbody>
				</c:forEach> 
			</table>	
			<br>
			<div id = "paging">
			<!-- 이전 페이지 -->
				<c:if test="${startPage eq 1}"> <!-- le : <= -->
					<a href="" id="currentPage" name="currentPage" class="page">
						<label>‹</label>
					</a>
				</c:if> 
				<c:if test="${startPage ge 10}"> <!-- le : <= -->
					<a href="/board_list?currentPage=${0}<c:if test='${searchWord!=null}'>&board_search=${board_search}&searchWord=${searchWord}</c:if>" id="currentPage" name="currentPage" id="currentPage" name="currentPage" class="page">
						<label>‹</label>
					</a>
				</c:if> 
			<!-- 페이지 번호 -->
				<c:forEach var="p" begin="${startPage}" end="${endPage}">
					<c:if test="${p le totalPage}"> <!-- le : <= -->
						<a href="/board_list?currentPage=${(p-1) * 20}<c:if test='${searchWord!=null}'>&board_search=${board_search}&searchWord=${searchWord}</c:if>" id="currentPage" name="currentPage" class="page">
							${p}
						</a>
					</c:if> 
				</c:forEach>	
			<!-- 다음 페이지 -->
				<c:if test="${endPage ne totalPage}"> <!-- ge >= -->
					<a href="/board_list?currentPage=${(endPage) * 20}<c:if test='${searchWord!=null}'>&board_search=${board_search}&searchWord=${searchWord}</c:if>" id="currentPage" name="currentPage" class="page">
						<label>›</label>
					</a>
				</c:if> 
				<c:if test="${endPage eq totalPage}"> <!-- ge : >= -->
					<a href="" id="currentPage" name="currentPage" class="page">
						<label>›</label>
					</a>
				</c:if> 
			</div>
		</div>
</body>
</html>