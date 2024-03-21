// @Controller ������̼����� HomeController�� ��Ʈ�ѷ� ���� ����� �� �� ����
// @RequestMapping������ ȣ���ϱ� ���� URL�� path�� "/" �� �����Ͽ� �⺻ �ּҷ� request�� ���� �� ���� ��
// HomeController������ @Inject�� service���� selectMovie�� ȣ��(SQL ȣ��)�Ͽ� data�� ���Ϲ޾� movieList�� ���, �̸� model�� "movieList"��� �̸����� ��� "home"�̶�� �̸��� ���� view�� ���޵� �� �ֵ��� ��
// return ��home��;�� home.jsp�� view�� ���ϰ� data �����϶�� �ǹ�

package com.kyobo.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kyobo.service.MembersService;
import com.kyobo.springtest.HomeController;
import com.kyobo.vo.BoardVO;
import com.kyobo.vo.MembersVO;

/**
 * Handles requests for the application home page.
 */

@Controller
public class MembersController {
	
	@Inject
    MembersService service;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	// �α��� -> ȸ������ ������ �̵�
	@RequestMapping(value = "/member_join_form") 
	public String login() {
		return "/member_join_form"; 
	}
	
	// ȸ������ -> �α��� ������ �̵�
	@RequestMapping(value = "/log_in")
	public String member_join_form() {
		return "/log_in";
	}
	
	// �α��� ��ȿ�� �˻�
	// value url�� �����ŷ� �ص� ���߿� ������ �� ����?
	@RequestMapping(value="/loginChk", method=RequestMethod.GET)
	public String loginCheck(Model model, MembersVO vo, HttpSession session, HttpServletRequest request) throws Exception {
		System.out.println("vo = " + vo);
		System.out.println("session.getId : " + session.getId());
	
		MembersVO loginVO = service.memberLogin(vo);
		
		if (loginVO == null) {
			request.setAttribute("msg", "���̵� Ȯ���ϼ���");
			return "/login_fail"; // ���̵� Ȯ���ϼ���
		} 
		
		// row�� �������� result�� 0�� ���
		else if(loginVO.getPWresult() == 0) {
			request.setAttribute("msg", "�н����带 Ȯ���ϼ���");
			return "/login_fail"; // �н����带 Ȯ���ϼ���
		}
		
		// row�� ������ result�� 1�� ���
		else {
			session.setAttribute("logId", loginVO.getId());
			session.setAttribute("logPw", loginVO.getPw());
			session.setAttribute("logName", loginVO.getNickname());

			return "redirect: /board_list" ;
		}
	}
	
	// ȸ������ ��ȿ�� �˻�
	@RequestMapping(value="/memberChk", method=RequestMethod.GET)
	public ModelAndView member_join_write(MembersVO vo, HttpSession session, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		// ������ �� ���� / �����Ϸ��� �� ������ �̸� ���ǰ˻� / �� �� Ÿ���� ���� ������ �м��ؾ���
		// �� ��ȿ�� üũ

		System.out.println("vo.getId() : " + vo.getId());
		System.out.println("vo.getPw() : " + vo.getPw());
		if (vo != null) {
			if (vo.getId() == null || vo.getId().equals("")) {
				request.setAttribute("msg", "���̵� Ȯ���ϼ���");
				mav.setViewName("/member_join_fail");
				return mav;
				// ��ü ��ü�� ���� null ���� ���� �� ������ �� ��ü�� ''
			} else if (vo.getPw() == null || vo.getId().equals("") || vo.getPw().length() < 8) {
				request.setAttribute("msg", "�н����带 Ȯ���ϼ���");
				mav.setViewName("/member_join_fail");
				return mav;
			} else if (vo.getNickname() == null || vo.getId().equals("") || vo.getNickname().length() < 2) {
				request.setAttribute("msg", "�̸��� Ȯ���ϼ���");
				mav.setViewName("/member_join_fail");
				return mav;
			} else if (vo.getBirthday_year() == null || vo.getBirthday_year().equals("") || vo.getBirthday_year().length() != 4) {
				request.setAttribute("msg", "�������-���� Ȯ���ϼ���(������ 4�ڸ����� �մϴ�)");
				mav.setViewName("/member_join_fail");
				return mav;
			} else if (vo.getBirthday_month() == null || vo.getBirthday_month().equals("")) {
				request.setAttribute("msg", "�������-���� Ȯ���ϼ���");
				mav.setViewName("/member_join_fail");
				return mav;
			} else if (vo.getBirthday_date() == null || vo.getBirthday_date().equals("") || vo.getBirthday_date().length() > 2 || Integer.parseInt(vo.getBirthday_date()) > 31) {
				request.setAttribute("msg", "�������-���� Ȯ���ϼ���(���ڴ� 2�ڸ��� ���� �� �����ϴ�)");
				mav.setViewName("/member_join_fail");
				return mav;
			} 
		}
				
		int result = service.memberInsert(vo);
		
		try {
			System.out.println("try ���� vo " + vo);
			// ȸ������ ����
			if(result > 0) {
				System.out.println("result ���� vo " + vo);
				mav.setViewName("/member_join_suc");
			}else {// ȸ������ ����
				System.out.println("else ���� vo " + vo);
				mav.setViewName("/member_join_fail");
			}			
		}catch (Exception e){
			System.out.println("catch ���� vo " + vo);
			// ȸ������ ������ ���
			mav.setViewName("/member_join_fail");
		}
		
		return mav;
	}
	
	// ȸ������ �ߺ��˻�
	@RequestMapping(value = "/id_double_check", method = RequestMethod.GET, produces="application/json; charset=UTF-8")
	@ResponseBody
	public String id_double_check(MembersVO vo) throws Exception { 
		MembersVO memberVO = service.memberLogin(vo);
		
		if(memberVO == null) {
			return "��� ������ ID�Դϴ�";
		} else {
			return "�̹� ��� ���� ID�Դϴ�";
		}
	}
}