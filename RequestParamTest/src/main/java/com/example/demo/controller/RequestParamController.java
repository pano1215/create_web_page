package com.example.demo.controller;
// RequestParamController

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller ;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.* ;

@Controller
public class RequestParamController {
	/* �Է� ȭ���� ǥ�� */
	@GetMapping("show")
	public String showView() {
		// ��ȯ������ �� �̸��� ������
		return "entry" ;
	}
	
	/* Ȯ�� ȭ���� ǥ�� */
	// @PostMapping�� POST�޼���� ���� URL(/confirm)�� ����
//	@PostMapping("confirm")
//	public String confirmView(
//			// �信�� ������ name �Է°��� �Ķ���� ������ ����
//			Model model, @RequestParam String name, @RequestParam Integer age, 
//			// date�� ������ yyyy-mm-dd�̶� ������ �������� �м� �� ��ȯ�ϱ� ����
//			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam LocalDate birth
//		) {
//		// Model�� ����
//		// �޾ƿ� ���� �����ϴ� �μ�
//		model.addAttribute("name", name);
//		model.addAttribute("age", age);
//		model.addAttribute("birth", birth);
//		
//		// ��ȯ������ �� �̸��� ������
//		return "confirm";
//	}
	
	/* Ȯ�� ȭ���� ǥ�� : Form Ŭ������ */
	@PostMapping("confirm")
	// Form�� �μ��� ����
	// �μ����� Model�� �����ϰ� Form�� �μ��� ���
	public String confirmView(Form f) {
		// ��ȯ������ �� �̸��� ������
		return "confirm2";
	}
}
