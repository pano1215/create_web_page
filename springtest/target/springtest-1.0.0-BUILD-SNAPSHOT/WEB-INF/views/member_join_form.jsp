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
	@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap');

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
        
        #id, #pw, #pw_chk, #nickname, #e_address, #gender {
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
        
        #id_text, #pw_text, #pw_chk_text, #nickname_text, #gender_text, #e_address_text, #birthday_text {
        	text-align: left;
        	margin-left: 45px;
        	/*white-space: pre-line; <--- 줄바꿈 가능. 단, 이때의 줄바꿈은 줄을 바꿀 때가지 공백을 채우는 것임. 때문에 br 등 다른 태그로 대체하는 방법도 있음 */
        }
</style>

</head>
<script>
	function memberChk(){
		var gender = document.getElementById("gender").value;
		if (gender.equals("선택안함")) {
			gender = "N";
		}else if(gender.equals("여성")) {
			gender = "W";
		}else if(gender.equals("남성")) {
			gender = "M";
		}
		return true ;
		
		if(document.getElementById("id").value == ""){
			alert("아이디를 확인하세요.") ;
			return false ; 
		}
		if(document.getElementById("pw").value == ""){
			alert("비밀번호를 확인하세요.") ;
			return false ; 
		}
		return true ; 
	}
	/* $(function(){
		$("#wellcome_join_form").submit(function(){
			// 스크립크 정규 표현식
			// / : 정규 표현식 지정 및 둘러싸는 용도
			// ^ : 처음부터 끝까지 문자를 검색하기
			// $ : 변수 지정
			
			// 아이디 유효성 검사
			var id = $("#id").val();
			console.log("id : ", id);
			var reg_id = /^[a-ZA-Z0-9]{7,}$/; // 아이디는 첫 글자는 알파벳, 이후로 알파벳/숫자 모두 가능, 8자리 이상, 특수문자 불가
			console.log("id : ", reg_id.test(id));
			if(!reg_id.test(id)){
				alert("아이디는 첫번째 문자, 영어대소문자, 숫자만 허용되며 비밀번호의 길이는 8글자 이상이어야 합니다.");
				return false;
			}
			
			// 비밀번호 유효성 검사
			// 아이디처럼 변수를 만들어주는 경우도 있지만, 클래스 id를 그대로 가져와서 지정해주는 경우도 있음
			var reg_pw = /^[a-zA-Z]{1}[a-ZA-Z0-9@#*_]{7}$/; // 비밀번호는 첫 글자는 알파벳, 이후로 알파벳/숫자 모두 가능, 8자리 이상, 특수문자는 @#*_만 가능
			console.log("pw : ", reg_id.test("#pw"));
			if(!reg_pw.test($("#pw").val())){
				alert("비밀번호는 첫번째 문자, 영어대소문자, 숫자, 특수문자  @#*_만 허용되며 비밀번호의 길이는 8글자 이상이어야 합니다.");
				return false;
			}
			
			// 비밀번호 일치 검사
			if($("#pw_chk").val() != $("#pw").val()){
				alert("비밀번호가 일치하지 않습니다.");
				return false;
			}
			
			// 닉네임 유효성 검사
			var nickname = $("#nickname").val();
			var reg_nk = /^[a-zA-Z][가-힣]$/; // 닉네임은 한글, 영어만 가능
			if(!reg_nk.test(nickname)){
				alert("닉네임은 한글, 영어만 가능합니다.");
				return false;
			}
			
			// 생년월일 유효성 검사
			// 연도
			var birthday_year = $("#birthday_year").val();
			var reg_by = /^[1900-2023]{4}$/; // 연도는 1900~2023까지 4자리만 가능
			if(!reg_by.test(birthday_year)){
				alert("연도를 확인해주세요");
				return false;
			}
			
			// 일자 
			var birthday_date = $("#birthday_date").val();
			var reg_bd = /^[1-31]{1, 2}$/; // 일자는 1부터 31까지 1, 2자리만 가능
			if(!reg_bd.test(birthday_date)){
				alert("일자를 확인해주세요");
				return false;
			}
			
			// 이메일 유효성 검사
			var e_address = $("#e_address").val();
			var reg_e = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0, 66})\.([a-z]{2, 6}(?:\.[a-z]{2})?)$/i; 
			if(!reg_e.test(e_address)){
				alert("이메일을 확인해주세요");
				return false;
			}
			
			return true;
		});
	}); */
</script>
<body>
<!-- float : 한 요소(element)가 보통 흐름(normal flow)으로부터 빠져 텍스트 및 인라인(inline) 요소가 그 주위를 감싸는 자기 컨테이너의 좌우측을 따라 배치되어야 함을 지정 -->
	<div id = "wellcome_join">
		<h1 id = "wellcome_join_title">회원가입</h1>
		<form method = "get" action = "/memberChk" id = "wellcome_join_form"> <!-- form이 있어야 클라이언트의 값을 Cotroller에 보내줄 수 있음 -->
			<!-- p : paragraph, 즉 문단의 약자로, 하나의 문단을 만들 때 사용 -->
			<!-- &nbsp : 공백 설정 -->
			<p class="id_text" id="id_text" name="id_text">아이디 *필수<br>
				<input type="text" placeholder="아이디" class="id" id="id" name="id" value="${id}"></p>
			<p class="pw_text" id="pw_text" name="pw_text">비밀번호 *필수<br>
				<input type="password" placeholder="비밀번호" class="pw" id="pw" name="pw">
			<p class="pw_chk_text" id="pw_chk_text" name="pw_chk_text">비밀번호 확인 *필수<br>
				<input type="password" placeholder="비밀번호 확인" class="pw_chk" id="pw_chk" name="pw_chk"></p>
			<p class="nickname_text" id="nickname_text" name="nickname_text">닉네임 *필수<br>
				<input type="text" placeholder="닉네임" class="nickname" id="nickname" name="nickname"></p>
			<p class="birthday_text" id="birthday_text" name="birthday_text">생년월일<br> <!-- br : 줄바꿈  -->
				<input type="text" placeholder="년(4자)" class="birthday_year" id="birthday_year" name="birthday_year">
				<select class="birthday_month" id="birthday_month" name="birthday_month"> <!-- label : 사용자 인터페이스 항목의 설명. ex. 체크박스, 캘린더 등등 -->
					<option value = "월">월</option>
					<option value = "1월">1</option>
  					<option value = "2월">2</option>
  					<option value = "3월">3</option>
  					<option value = "4월">4</option>
  					<option value = "5월">5</option>
  					<option value = "6월">6</option>
  					<option value = "7월">7</option>
  					<option value = "8월">8</option>
  					<option value = "9월">9</option>
  					<option value = "10월">10</option>
  					<option value = "11월">11</option>
  					<option value = "12월">12</option>
				</select>
				<input type="text" placeholder="일" class="birthday_date" id="birthday_date" name="birthday_date">
			</p>
			<p class="gender_text" id="gender_text" name="gender_text"> <!-- ul : 순서가 없는 HTML 리스트(list)를 정의 But ol : 번호를 메겨 순서가 있는 (ordered list) 목록 생성 -->
				성별<br> <!-- li : list의 약자로, 목록을 만드는 태그. ul / ol 태그와 함께 사용 -->
				<select class="gender" id="gender" name="gender"> <!-- select : 옵션 메뉴를 제공하는 드롭다운 리스트(drop-down list)를 정의할 때 사용 -->
					<!-- option : <select>, <optgroup>, <datalist> 요소의 항목 정의. 팝업 메뉴 등 목록에서 하나의 항목을 나타낼 수 있음 -->
					<option value = "선택안함">선택안함</option>
					<option value = "여성">여성</option>
					<option value = "남성">남성</option>
				</select>
			</p>
			<p class="e_address_text" id="e_address_text" name="e_address_text">이메일 *필수<br>
				<input type="text" placeholder="이메일" class="e_address" id="e_address" name="e_address" ></p>
			<p><br>
				<input type = "submit" value = "가입하기" id = "btn">
			</p>
		</form>
	</div>
</body>
</html>