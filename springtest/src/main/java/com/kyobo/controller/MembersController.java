// @Controller 어노테이션으로 HomeController가 컨트롤러 매핑 대상이 될 수 있음
// @RequestMapping에서는 호출하기 위한 URL의 path를 "/" 로 설정하여 기본 주소로 request를 보낼 시 매핑 됨
// HomeController에서는 @Inject된 service에서 selectMovie를 호출(SQL 호출)하여 data를 리턴받아 movieList에 담고, 이를 model에 "movieList"라는 이름으로 담아 "home"이라는 이름을 가진 view로 전달될 수 있도록 함
// return “home”;은 home.jsp를 view로 정하고 data 전달하라는 의미

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
	
	// 로그인 -> 회원가입 페이지 이동
	@RequestMapping(value = "/member_join_form") 
	public String login() {
		return "/member_join_form"; 
	}
	
	// 회원가입 -> 로그인 페이지 이동
	@RequestMapping(value = "/log_in")
	public String member_join_form() {
		return "/log_in";
	}
	
	// 로그인 유효성 검사
	// value url을 같은거로 해도 나중에 에러가 안 나나?
	@RequestMapping(value="/loginChk", method=RequestMethod.GET)
	public String loginCheck(Model model, MembersVO vo, HttpSession session, HttpServletRequest request) throws Exception {
		System.out.println("vo = " + vo);
		System.out.println("session.getId : " + session.getId());
	
		MembersVO loginVO = service.memberLogin(vo);
		
		if (loginVO == null) {
			request.setAttribute("msg", "아이디를 확인하세요");
			return "/login_fail"; // 아이디를 확인하세요
		} 
		
		// row는 나오지만 result가 0인 경우
		else if(loginVO.getPWresult() == 0) {
			request.setAttribute("msg", "패스워드를 확인하세요");
			return "/login_fail"; // 패스워드를 확인하세요
		}
		
		// row도 나오고 result가 1인 경우
		else {
			session.setAttribute("logId", loginVO.getId());
			session.setAttribute("logPw", loginVO.getPw());
			session.setAttribute("logName", loginVO.getNickname());

			return "redirect: /board_list" ;
		}
	}
	
	// 회원가입 유효성 검사
	@RequestMapping(value="/memberChk", method=RequestMethod.GET)
	public ModelAndView member_join_write(MembersVO vo, HttpSession session, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		// 변수는 맨 위에 / 실행하려는 것 위에서 미리 조건검사 / 왜 안 타는지 부터 원인을 분석해야함
		// 빈값 유효성 체크

		System.out.println("vo.getId() : " + vo.getId());
		System.out.println("vo.getPw() : " + vo.getPw());
		if (vo != null) {
			if (vo.getId() == null || vo.getId().equals("")) {
				request.setAttribute("msg", "아이디를 확인하세요");
				mav.setViewName("/member_join_fail");
				return mav;
				// 객체 자체의 값은 null 값을 가질 수 있지만 값 자체는 ''
			} else if (vo.getPw() == null || vo.getId().equals("") || vo.getPw().length() < 8) {
				request.setAttribute("msg", "패스워드를 확인하세요");
				mav.setViewName("/member_join_fail");
				return mav;
			} else if (vo.getNickname() == null || vo.getId().equals("") || vo.getNickname().length() < 2) {
				request.setAttribute("msg", "이름을 확인하세요");
				mav.setViewName("/member_join_fail");
				return mav;
			} else if (vo.getBirthday_year() == null || vo.getBirthday_year().equals("") || vo.getBirthday_year().length() != 4) {
				request.setAttribute("msg", "생년월일-년을 확인하세요(연도는 4자리여야 합니다)");
				mav.setViewName("/member_join_fail");
				return mav;
			} else if (vo.getBirthday_month() == null || vo.getBirthday_month().equals("")) {
				request.setAttribute("msg", "생년월일-월을 확인하세요");
				mav.setViewName("/member_join_fail");
				return mav;
			} else if (vo.getBirthday_date() == null || vo.getBirthday_date().equals("") || vo.getBirthday_date().length() > 2 || Integer.parseInt(vo.getBirthday_date()) > 31) {
				request.setAttribute("msg", "생년월일-일을 확인하세요(일자는 2자리를 넘을 수 없습니다)");
				mav.setViewName("/member_join_fail");
				return mav;
			} 
		}
				
		int result = service.memberInsert(vo);
		
		try {
			System.out.println("try 안의 vo " + vo);
			// 회원가입 성공
			if(result > 0) {
				System.out.println("result 안의 vo " + vo);
				mav.setViewName("/member_join_suc");
			}else {// 회원가입 실패
				System.out.println("else 안의 vo " + vo);
				mav.setViewName("/member_join_fail");
			}			
		}catch (Exception e){
			System.out.println("catch 안의 vo " + vo);
			// 회원가입 실패한 경우
			mav.setViewName("/member_join_fail");
		}
		
		return mav;
	}
	
	// 회원가입 중복검사
	@RequestMapping(value = "/id_double_check", method = RequestMethod.GET, produces="application/json; charset=UTF-8")
	@ResponseBody
	public String id_double_check(MembersVO vo) throws Exception { 
		MembersVO memberVO = service.memberLogin(vo);
		
		if(memberVO == null) {
			return "사용 가능한 ID입니다";
		} else {
			return "이미 사용 중인 ID입니다";
		}
	}
}