// PathVariableController Ŭ����

package com.example.demo.controller;

import org.springframework.streotype.Controller;
import org.springframework.web.bind.annotaion.GetMapping;

@Controller
public class PathVariableController {
	/* ȭ��ǥ�� */
	// ��û �ڵ鷯 �޼��忡 ������̼� �ο�
	// Ŭ���̾�Ʈ���� GET�޼���� URL�� �����ϸ� PathVariableController �޼����� showView �޼��� ȣ��
	@GetMapping("show")
	public String showView() {
		// ��ȯ������ �� �̸��� ������
		return "show";
	}
}
