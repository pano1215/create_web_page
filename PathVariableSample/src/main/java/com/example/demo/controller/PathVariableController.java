// PathVariableController 클래스

package com.example.demo.controller;

import org.springframework.streotype.Controller;
import org.springframework.web.bind.annotaion.GetMapping;

@Controller
public class PathVariableController {
	/* 화면표시 */
	// 요청 핸들러 메서드에 어노테이션 부여
	// 클라이언트에서 GET메서드로 URL에 접속하면 PathVariableController 메서드의 showView 메서드 호출
	@GetMapping("show")
	public String showView() {
		// 반환값으로 뷰 이름을 돌려줌
		return "show";
	}
}
