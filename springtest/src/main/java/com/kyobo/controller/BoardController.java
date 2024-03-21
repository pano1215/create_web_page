package com.kyobo.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspTagException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.catalina.tribes.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import com.google.protobuf.Service;
import com.kyobo.service.BoardService;
import com.kyobo.vo.BoardVO;
import com.kyobo.vo.MembersVO;
import com.kyobo.vo.PagingVO;
import com.mysql.cj.xdevapi.JsonParser;
import com.kyobo.springtest.HomeController;

@Controller
public class BoardController {
	
		@Autowired
		BoardService service;
		
		// 게시판 페이지 띄우기 
		@RequestMapping(value = "/board_list", method = RequestMethod.GET) 
		public String board_list(BoardVO vo, Model model, HttpSession session) throws Exception {			
			try { 
				List<BoardVO> boardpVO = service.boardList(vo);
				boardpVO.get(0).setTotalPosts(service.boardCount(vo));
				
				int totalPage = 0 ;
				if (boardpVO.get(0).getTotalPosts() % 20 == 0) { // 20개 단위로 딱 떨어지는 경우
					totalPage = service.boardCount(vo) / 20; // 총 row수(totalPosts) / postsPerPage(20)
				}else {
					totalPage = (service.boardCount(vo) / 20) + 1; // 총 row수(totalPosts)  / postsPerPage(20) + 1
				}	
				
				int currentPage = vo.getCurrentPage() ;
				currentPage = ((currentPage) - 1) / 20 + 1 ;
						
				if (totalPage < currentPage) {
					currentPage = totalPage ;
				}

				int startPage = (int)((currentPage) / 10) * 10 + 1;
				int endPage = startPage + 10 - 1 ; 

				if (endPage > totalPage) {
					endPage = totalPage ;
				}
				
				System.out.println("currentPage : " + currentPage);
				System.out.println("totalPage : " + totalPage);
				System.out.println("startPage : " + startPage);
				System.out.println("endPage : " + endPage);

				model.addAttribute("boardVOList", boardpVO); // 전체
				model.addAttribute("totalPage", totalPage); // 총 row수
				
				model.addAttribute("currentPage", currentPage);
				model.addAttribute("startPage", startPage);
				model.addAttribute("endPage", endPage);
			 }
			finally {
			}
			
			// 세션에서 값 가져오기
			String logId = (String) session.getAttribute("logId");
			String logName = (String) session.getAttribute("logName");
			model.addAttribute("logId", logId); // 모델로 리턴시켜줘야함
			model.addAttribute("logName", logName); 
					
			return "/board_list";
		}
		
		// 게시판 검색기능
//		 @RequestMapping(value = "/board_list_search", method = RequestMethod.GET)
//		 public String board_list_search(BoardVO vo, Model model, HttpSession session)throws Exception {
//		 
//		 try { 
//			 System.out.println("getSearchWord : " + vo.getSearchWord());
//		 	 System.out.println("getBoard_search : " + vo.getBoard_search());
//		 
//		 	 List<BoardVO> boardVO = service.boardSearch(vo);
//		 	 model.addAttribute("boardVOList", boardVO); 
//		 }catch(ClassNotFoundException e){ 
//			 if(vo.getSearchWord() == null) { 
//				 vo.setSearchWord(""); 
//			}
//			 if(vo.getBoard_search() == null) { 
//				 vo.setBoard_search(""); 
//			}
//		 }catch(NoClassDefFoundError e) { 
//			 if(vo.getSearchWord() == null) {
//				 vo.setSearchWord(""); 
//			}
//		 
//			 if(vo.getBoard_search() == null) { 
//				 vo.setBoard_search(""); 
//			} 
//		 }finally {
//			 System.out.println("getBoard_search : " + vo.getBoard_search());
//			 System.out.println("getSearchWord : " + vo.getSearchWord()); 
//		}
//		 
//		 // 세션에서 값 가져오기 
//		 String logId = (String) session.getAttribute("logId");
//		 model.addAttribute("logId", logId); // 모델로 리턴시켜줘야함
//		  
//		 return "/board_list"; 
//		}
		
		// 게시판 리스트 -> 게시판 글 등록
		@RequestMapping(value = "/board_write", method = RequestMethod.GET) 
		public String board_write(Model model, HttpSession session) {
			// 세션에서 값 가져오기
			String logName = (String) session.getAttribute("logName");
			model.addAttribute("logName", logName); // 모델로 리턴시켜줘야함
			
			// 세션에서 로그인된 id를 가져옴
			String logId = (String) session.getAttribute("logId");
			model.addAttribute("logId", logId); // 모델로 리턴시켜줘야함
						
			return "/board_write"; 
		}
		
		// 게시판 등록에서 저장하기 버튼 클릭
		@RequestMapping(value = "/board_content_save", method = RequestMethod.GET) 
		public ModelAndView board_content_save(BoardVO vo, HttpSession session, HttpServletRequest request) throws Exception {
			ModelAndView mav = new ModelAndView();
			
			if((vo.getPostContent() == null && vo.getPostTitle() == null) || (vo.getPostContent().equals("") && vo.getPostTitle().equals(""))) { // 화면에 아무 값도 입력이 안 된 경우 
				request.setAttribute("msg", "내용을 입력해주세요(제목 필수 입력)");
				mav.setViewName("/board_write_fail");
				return mav;
			}else if (vo.getPostTitle().equals("") || vo.getPostTitle() == null) {
				request.setAttribute("title", "제목을 입력해주세요.");
				mav.setViewName("/board_write_fail");
				return mav;
			}

			int result = service.boardInsert(vo);
			
			try {
				// 등록 성공
				if(result > 0) {
					mav.setViewName("redirect: /board_list");
				}else {// 등록 실패
					mav.setViewName("/board_write_fail");
				}			
			}catch (Exception e){
				// 등록 실패한 경우
				mav.setViewName("/board_write_fail");
			}
			
			return mav;
		}
		
		// 게시판 리스트에서 사용자가 선택한 글로 이동하기
		@RequestMapping("/board_view")
		public String board_view(Model model, BoardVO vo, HttpSession session) throws Exception{
			BoardVO boardVO = service.boardView(vo);
			model.addAttribute("boardVOView", boardVO);
			
			// 세션에서 값 가져오기
			String logId = (String) session.getAttribute("logId");
			String logName = (String) session.getAttribute("logName");
			
			model.addAttribute("logId", logId); // 모델로 리턴시켜줘야함
			model.addAttribute("logName", logName);
						
			return "/board_view"; 
		}
		
		// 게시판 글 보기 -> 게시판 수정하기
		@RequestMapping(value = "/board_edit", method = RequestMethod.GET) 
		public String board_edit(Model model, BoardVO vo, HttpSession session)  throws Exception {
			BoardVO boardVO = service.boardView(vo);
			model.addAttribute("boardVOView", boardVO);
			
			// 세션에서 값 가져오기
			String logId = (String) session.getAttribute("logId");
			String logName = (String) session.getAttribute("logName");
						
			model.addAttribute("logId", logId); // 모델로 리턴시켜줘야함
			model.addAttribute("logName", logName);
						
			return "/board_edit"; 
		}
		
		// 게시판 수정에서 수정하기 버튼 클릭
		@RequestMapping(value = "/board_edit_save", method = RequestMethod.GET) 
		public ModelAndView board_edit_save(BoardVO vo, HttpSession session, HttpServletRequest request) throws Exception {
			ModelAndView mav = new ModelAndView();

			int result = service.boardEdit(vo);
			
			try {
				// 등록 성공
				if(result > 0) {
					mav.setViewName("redirect: /board_list");
				}else {// 등록 실패
					request.setAttribute("msg", "글 수정에 실패했습니다");
					mav.setViewName("/board_edit_fail");
				}			
			}catch (Exception e){
				// 등록 실패한 경우
				request.setAttribute("msg", "글 수정에 실패했습니다");
				mav.setViewName("/board_edit_fail");
			}
			
			return mav;
		}
		
		// 로그아웃 구현
		@RequestMapping("/logout") 
		public String logout(HttpServletRequest request) {
			HttpSession session = request.getSession();
			session.invalidate();
			
			return "redirect: /"; 
		}
}
