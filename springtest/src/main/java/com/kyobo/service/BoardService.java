package com.kyobo.service;

import java.util.List;

import com.kyobo.vo.BoardVO;
import com.kyobo.vo.MembersVO;
import com.kyobo.vo.PagingVO;

public interface BoardService {
	// public List<BoardVO> boardList(PagingVO pvo) throws Exception;
	public List<BoardVO> boardList(BoardVO vo) throws Exception;
	public int boardInsert(BoardVO vo) throws Exception;
	public BoardVO boardView(BoardVO vo) throws Exception;
	public int boardEdit(BoardVO vo) throws Exception;
	public List<BoardVO> boardSearch(BoardVO vo) throws Exception;
	
	public int boardCount(BoardVO vo) throws Exception;
}
