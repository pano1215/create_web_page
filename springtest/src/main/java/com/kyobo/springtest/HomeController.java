// @Controller ������̼����� HomeController�� ��Ʈ�ѷ� ���� ����� �� �� ����
// @RequestMapping������ ȣ���ϱ� ���� URL�� path�� "/" �� �����Ͽ� �⺻ �ּҷ� request�� ���� �� ���� ��
// HomeController������ @Inject�� service���� selectMovie�� ȣ��(SQL ȣ��)�Ͽ� data�� ���Ϲ޾� movieList�� ���, �̸� model�� "movieList"��� �̸����� ��� "home"�̶�� �̸��� ���� view�� ���޵� �� �ֵ��� ��
// return ��home��;�� home.jsp�� view�� ���ϰ� data �����϶�� �ǹ�

package com.kyobo.springtest;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kyobo.service.BoardService;
import com.kyobo.service.MembersService;
import com.kyobo.springtest.HomeController;
import com.kyobo.vo.MembersVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/*
	 * @Inject private MembersService service;
	 * 
	 * @Inject private BoardService service2;
	 */
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception{
		
		// return "member_join_suc";
		// return "member_join_form";
		return "log_in";
		// return "board_list";
		// return "board_write";
	}
}
