package com.kyobo.service;

import java.util.List;
import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kyobo.dao.BoardDAO;
import com.kyobo.vo.BoardVO;
import com.kyobo.vo.MembersVO;
import com.kyobo.vo.PagingVO;
import com.kyobo.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {
	 @Inject
	 BoardDAO dao;
	 
//	 @Override
//	 public List<BoardVO> boardList(PagingVO pvo) throws Exception {
//		 return dao.boardList(pvo);
//	 }
	 
	 @Override
	 public List<BoardVO> boardList(BoardVO vo) throws Exception {
		 return dao.boardList(vo);
	 }

	 @Override
	 public List<BoardVO> boardSearch(BoardVO vo) throws Exception {
		 return dao.boardSearch(vo);
	 }
	 
	 @Override
	 public int boardInsert(BoardVO vo) throws Exception {
		 return dao.boardInsert(vo);
	 }
	 
	 @Override
	 public BoardVO boardView(BoardVO vo) throws Exception {
		 return dao.boardView(vo);
	 }
	 
	 @Override
	 public int boardEdit(BoardVO vo) throws Exception {
		 return dao.boardEdit(vo);
	 }
	 
	 @Override
	 public int boardCount(BoardVO vo) throws Exception {
		 return dao.boardCount(vo);
	 }
}
