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
		
		// �Խ��� ������ ���� 
		@RequestMapping(value = "/board_list", method = RequestMethod.GET) 
		public String board_list(BoardVO vo, Model model, HttpSession session) throws Exception {			
			try { 
				List<BoardVO> boardpVO = service.boardList(vo);
				boardpVO.get(0).setTotalPosts(service.boardCount(vo));
				
				int totalPage = 0 ;
				if (boardpVO.get(0).getTotalPosts() % 20 == 0) { // 20�� ������ �� �������� ���
					totalPage = service.boardCount(vo) / 20; // �� row��(totalPosts) / postsPerPage(20)
				}else {
					totalPage = (service.boardCount(vo) / 20) + 1; // �� row��(totalPosts)  / postsPerPage(20) + 1
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

				model.addAttribute("boardVOList", boardpVO); // ��ü
				model.addAttribute("totalPage", totalPage); // �� row��
				
				model.addAttribute("currentPage", currentPage);
				model.addAttribute("startPage", startPage);
				model.addAttribute("endPage", endPage);
			 }
			finally {
			}
			
			// ���ǿ��� �� ��������
			String logId = (String) session.getAttribute("logId");
			String logName = (String) session.getAttribute("logName");
			model.addAttribute("logId", logId); // �𵨷� ���Ͻ��������
			model.addAttribute("logName", logName); 
					
			return "/board_list";
		}
		
		// �Խ��� �˻����
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
//		 // ���ǿ��� �� �������� 
//		 String logId = (String) session.getAttribute("logId");
//		 model.addAttribute("logId", logId); // �𵨷� ���Ͻ��������
//		  
//		 return "/board_list"; 
//		}
		
		// �Խ��� ����Ʈ -> �Խ��� �� ���
		@RequestMapping(value = "/board_write", method = RequestMethod.GET) 
		public String board_write(Model model, HttpSession session) {
			// ���ǿ��� �� ��������
			String logName = (String) session.getAttribute("logName");
			model.addAttribute("logName", logName); // �𵨷� ���Ͻ��������
			
			// ���ǿ��� �α��ε� id�� ������
			String logId = (String) session.getAttribute("logId");
			model.addAttribute("logId", logId); // �𵨷� ���Ͻ��������
						
			return "/board_write"; 
		}
		
		// �Խ��� ��Ͽ��� �����ϱ� ��ư Ŭ��
		@RequestMapping(value = "/board_content_save", method = RequestMethod.GET) 
		public ModelAndView board_content_save(BoardVO vo, HttpSession session, HttpServletRequest request) throws Exception {
			ModelAndView mav = new ModelAndView();
			
			if((vo.getPostContent() == null && vo.getPostTitle() == null) || (vo.getPostContent().equals("") && vo.getPostTitle().equals(""))) { // ȭ�鿡 �ƹ� ���� �Է��� �� �� ��� 
				request.setAttribute("msg", "������ �Է����ּ���(���� �ʼ� �Է�)");
				mav.setViewName("/board_write_fail");
				return mav;
			}else if (vo.getPostTitle().equals("") || vo.getPostTitle() == null) {
				request.setAttribute("title", "������ �Է����ּ���.");
				mav.setViewName("/board_write_fail");
				return mav;
			}

			int result = service.boardInsert(vo);
			
			try {
				// ��� ����
				if(result > 0) {
					mav.setViewName("redirect: /board_list");
				}else {// ��� ����
					mav.setViewName("/board_write_fail");
				}			
			}catch (Exception e){
				// ��� ������ ���
				mav.setViewName("/board_write_fail");
			}
			
			return mav;
		}
		
		// �Խ��� ����Ʈ���� ����ڰ� ������ �۷� �̵��ϱ�
		@RequestMapping("/board_view")
		public String board_view(Model model, BoardVO vo, HttpSession session) throws Exception{
			BoardVO boardVO = service.boardView(vo);
			model.addAttribute("boardVOView", boardVO);
			
			// ���ǿ��� �� ��������
			String logId = (String) session.getAttribute("logId");
			String logName = (String) session.getAttribute("logName");
			
			model.addAttribute("logId", logId); // �𵨷� ���Ͻ��������
			model.addAttribute("logName", logName);
						
			return "/board_view"; 
		}
		
		// �Խ��� �� ���� -> �Խ��� �����ϱ�
		@RequestMapping(value = "/board_edit", method = RequestMethod.GET) 
		public String board_edit(Model model, BoardVO vo, HttpSession session)  throws Exception {
			BoardVO boardVO = service.boardView(vo);
			model.addAttribute("boardVOView", boardVO);
			
			// ���ǿ��� �� ��������
			String logId = (String) session.getAttribute("logId");
			String logName = (String) session.getAttribute("logName");
						
			model.addAttribute("logId", logId); // �𵨷� ���Ͻ��������
			model.addAttribute("logName", logName);
						
			return "/board_edit"; 
		}
		
		// �Խ��� �������� �����ϱ� ��ư Ŭ��
		@RequestMapping(value = "/board_edit_save", method = RequestMethod.GET) 
		public ModelAndView board_edit_save(BoardVO vo, HttpSession session, HttpServletRequest request) throws Exception {
			ModelAndView mav = new ModelAndView();

			int result = service.boardEdit(vo);
			
			try {
				// ��� ����
				if(result > 0) {
					mav.setViewName("redirect: /board_list");
				}else {// ��� ����
					request.setAttribute("msg", "�� ������ �����߽��ϴ�");
					mav.setViewName("/board_edit_fail");
				}			
			}catch (Exception e){
				// ��� ������ ���
				request.setAttribute("msg", "�� ������ �����߽��ϴ�");
				mav.setViewName("/board_edit_fail");
			}
			
			return mav;
		}
		
		// �α׾ƿ� ����
		@RequestMapping("/logout") 
		public String logout(HttpServletRequest request) {
			HttpSession session = request.getSession();
			session.invalidate();
			
			return "redirect: /"; 
		}
}
