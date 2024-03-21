// @Controller 어노테이션으로 HomeController가 컨트롤러 매핑 대상이 될 수 있음
// @RequestMapping에서는 호출하기 위한 URL의 path를 "/" 로 설정하여 기본 주소로 request를 보낼 시 매핑 됨
// HomeController에서는 @Inject된 service에서 selectMovie를 호출(SQL 호출)하여 data를 리턴받아 movieList에 담고, 이를 model에 "movieList"라는 이름으로 담아 "home"이라는 이름을 가진 view로 전달될 수 있도록 함
// return “home”;은 home.jsp를 view로 정하고 data 전달하라는 의미

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
