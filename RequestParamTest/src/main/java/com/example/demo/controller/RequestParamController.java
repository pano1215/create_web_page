package com.example.demo.controller;
// RequestParamController

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller ;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.* ;

@Controller
public class RequestParamController {
	/* 입력 화면을 표시 */
	@GetMapping("show")
	public String showView() {
		// 반환값으로 뷰 이름을 돌려줌
		return "entry" ;
	}
	
	/* 확인 화면을 표시 */
	// @PostMapping은 POST메서드로 들어온 URL(/confirm)에 대응
//	@PostMapping("confirm")
//	public String confirmView(
//			// 뷰에서 지정한 name 입력값을 파라미터 변수로 설정
//			Model model, @RequestParam String name, @RequestParam Integer age, 
//			// date의 형식은 yyyy-mm-dd이라 지정한 형식으로 분석 및 변환하기 위함
//			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam LocalDate birth
//		) {
//		// Model에 저장
//		// 받아온 값을 저장하는 인수
//		model.addAttribute("name", name);
//		model.addAttribute("age", age);
//		model.addAttribute("birth", birth);
//		
//		// 반환값으로 뷰 이름을 돌려줌
//		return "confirm";
//	}
	
	/* 확인 화면을 표시 : Form 클래스용 */
	@PostMapping("confirm")
	// Form을 인수로 지정
	// 인수에서 Model을 삭제하고 Form을 인수로 사용
	public String confirmView(Form f) {
		// 반환값으로 뷰 이름을 돌려줌
		return "confirm2";
	}
}
