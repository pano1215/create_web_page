<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">

<head>
	<meta charset = "UTF-8">
	<title>Join Start</title>
	<style>
	/* @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap'); */

        * {
            font-family: 'Noto Sans KR', sans-serif;
        }
        
        body {
        	background-color : #6667AB;
        }
        
        #wellcome_join_title{
        	text-align: center;
        }
        
        #wellcome_join {
            margin: auto;
            width: 400px;
            background-color: #EEEFF1;
            border-radius: 5px;
            text-align: center;
            padding: 20px;
        }
        
        #btn {
            width: 80%;
            padding: 10px;
            box-sizing: border-box;
            border-radius: 5px;
            border: none;
            background-color: #6667AB;
            margin-bottom: 10px;
            color: white;
            font-size: medium ;
        }
        
        #id{
        	width: 65%;
            padding: 10px;
            box-sizing: border-box;
            border-radius: 5px;
            border: none;
        }
        
        #pw, #pw_chk, #nickname, #gender {
            width: 90%;
            padding: 10px;
            box-sizing: border-box;
            border-radius: 5px;
            border: none;
        }
        
        #birthday_year, #birthday_month, #birthday_date {
            width: 30%;
            padding: 10px;
            box-sizing: border-box;
            border-radius: 5px;
            border: none;
        }
        
        #id_text, #pw_text, #nickname_text, #gender_text, #birthday_text {
        	text-align: left;
        	margin-left: 45px;
        	/*white-space: pre-line; <--- 줄바꿈 가능. 단, 이때의 줄바꿈은 줄을 바꿀 때가지 공백을 채우는 것임. 때문에 br 등 다른 태그로 대체하는 방법도 있음 */
        }
        
        #no_choose, #radio_w, #radio_m {
        	margin: 0px;
        }
        
        #gender_radio{
        	margin-left: 45px;
        	padding: 10px;
        	width: 75%;
        	border: 2px solid #6667AB;
        	border-radius: 5px;
        	align: center;
        	position:relative;
        }
        
        #id_check{
        	width: 25%;
        	height: 35px;
            padding: 10px;
            box-sizing: border-box;
            border-radius: 5px;
            border: none;
            background-color: #6667AB;
            margin-bottom: 10px;
            color: white;
            font-size: medium ;
        }
</style>
</head>
<script src="../resources/jquery-3.6.3.min.js"></script>
<script>
/* function id_check_fun(){
	// 버튼을 누르면 아이디값을  MembersController의 id_double_check에 보내줌
	// id_double_check에서는 result를 반환함
	// 화면에서 result를 alert함
	
	// var id = request.getAttribute(document.getElementById('id').value);
	// var join_id = document.getElementById('id').value; // 입력된 ID값을 join_id에 선언함
	location.href = "/id_double_check";
	var result = "${result}";
	alert(result);
}; */

var idk = 0;
$(function(){
	// id_check 버튼을 클릭했을 때
	$("#id_check").on("click", function(){
		// id 를 파라미터로 설정
		var id = $("#id").val();
		var data = {id: id} ;
		$.ajax({
			async: false,
			type: "GET",
			data: {id: id},
			url: "/id_double_check",
			dataType: "json", // key 밸류 형태
			contentType: "application/json; charset=UTF-8",  
			success: function(data){
				alert(JSON.stringify(data.responseText)) // 컨트롤러에서 스트링으로 넘겨주기 때문에 json을 스트링으로 변환해주는 과정이 필요함
			},
			error: function(data){
				alert(JSON.stringify(data.responseText))
			}
		});
	});
});

</script>
<body>
<!-- float : 한 요소(element)가 보통 흐름(normal flow)으로부터 빠져 텍스트 및 인라인(inline) 요소가 그 주위를 감싸는 자기 컨테이너의 좌우측을 따라 배치되어야 함을 지정 -->
	<div id = "wellcome_join">
		<h1 id = "wellcome_join_title">회원가입</h1>
		<form method = "get" action = "/memberChk" id = "wellcome_join_form" onsubmit="return memberChk()"> <!-- form이 있어야 클라이언트의 값을 Cotroller에 보내줄 수 있음 -->
			<!-- p : paragraph, 즉 문단의 약자로, 하나의 문단을 만들 때 사용 -->
			<!-- &nbsp : 공백 설정 -->
			<p class="id_text" id="id_text" name="id_text">아이디 *필수<br>
				<input type="text" placeholder="아이디" class="id" id="id" name="id">
				<!-- <form method = "get" action = "/id_double_check" id = "id_double_check" onsubmit="return id_double_check()"> -->
					<button type="button" class="id_check" id="id_check" name="join_id" >중복검사</button> <!-- 이벤트는 함수당 하나고 펑션에 함수선언은 id로 -->
				<!--</form> --> </p>																					   <!-- submit은 form.submit을 실행하겠다는 의미임 -->
			<p class="pw_text" id="pw_text" name="pw_text">비밀번호 *필수<br>
				<input type="password" placeholder="비밀번호" class="pw" id="pw" name="pw">
			<p class="nickname_text" id="nickname_text" name="nickname_text">이름 *필수<br>
				<input type="text" placeholder="이름" class="nickname" id="nickname" name="nickname"></p>
			<p class="birthday_text" id="birthday_text" name="birthday_text">생년월일 *필수<br> <!-- br : 줄바꿈  -->
				<input type="text" placeholder="년(4자)" class="birthday_year" id="birthday_year" name="birthday_year">
				<select class="birthday_month" id="birthday_month" name="birthday_month"> <!-- label : 사용자 인터페이스 항목의 설명. ex. 체크박스, 캘린더 등등 -->
					<option value = "">월</option>
					<option value = "1">1월</option>
  					<option value = "2">2월</option>
  					<option value = "3">3월</option>
  					<option value = "4">4월</option>
  					<option value = "5">5월</option>
  					<option value = "6">6월</option>
  					<option value = "7">7월</option>
  					<option value = "8">8월</option>
  					<option value = "9">9월</option>
  					<option value = "10">10월</option>
  					<option value = "11">11월</option>
  					<option value = "12">12월</option>
				</select>
				<input type="text" placeholder="일" class="birthday_date" id="birthday_date" name="birthday_date">
			</p>
			<p class="gender_text" id="gender_text" name="gender_text"> <!-- ul : 순서가 없는 HTML 리스트(list)를 정의 But ol : 번호를 메겨 순서가 있는 (ordered list) 목록 생성 -->
				성별 *필수<br> <!-- li : list의 약자로, 목록을 만드는 태그. ul / ol 태그와 함께 사용 -->
				<div class="gender_radio" id="gender_radio" name="gender_radio">
					<!-- 이때 name을 모두 동일하게 해줘야한다. 그래야 3 개 중 하나만 선택된다 -->
					<input type = "radio" name = "gender" class = "radio_w" id = "radio_w" value = "W" checked = "checked">여성&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					<input type = "radio" name = "gender" class = "radio_m" id = "radio_m" value = "M">남성
				</div>
			</p>
			<p><br>
				<input type = "submit" value = "가입하기" id = "btn">
			</p>
		</form>
	</div>
</body>
</html>