package com.kyobo.dao;

import java.util.List;
import java.util.logging.Handler;

import javax.inject.Inject;

import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kyobo.vo.BoardVO;
import com.kyobo.vo.MembersVO;
import com.kyobo.vo.PagingVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	@Inject
	SqlSession sqlSession;
	private static final String Namespace = "com.kyobo.mapper.BoardMapper";

	@Override
	/* public List<BoardVO> boardList(PagingVO pvo) throws Exception{ */
	public List<BoardVO> boardList(BoardVO vo) throws Exception{
//		System.out.println("getBoard_search : " + pvo.getBoard_search());
//		System.out.println("getCurrentPage : " + pvo.getCurrentPage());
//		System.out.println("getDisplayPageNum : " + pvo.getDisplayPageNum());
//		System.out.println("getEndPage : " + pvo.getEndPage());
//		System.out.println("getPostsPerPage : " + pvo.getPostsPerPage());
//		System.out.println("getSearchWord : " + pvo.getSearchWord());
//		System.out.println("getStartPage : " + pvo.getStartPage());
//		System.out.println("getTotalPages : " + pvo.getTotalPages());
//		System.out.println("getTotalPosts : " + pvo.getTotalPosts());
		
//		System.out.println(sqlSession.selectList(Namespace + ".boardList", pvo));
		
		return sqlSession.selectList(Namespace + ".boardList", vo);
	}
	
	@Override
	public List<BoardVO> boardSearch(BoardVO vo) throws Exception{
		return sqlSession.selectList(Namespace + ".boardSearch", vo);
	}
	
	@Override
	public int boardInsert(BoardVO vo) throws Exception{
		return sqlSession.insert(Namespace + ".boardInsert", vo);
	}
	
	@Override
	public BoardVO boardView(BoardVO vo) throws Exception{
		return sqlSession.selectOne(Namespace + ".boardView", vo);
	}
	
	@Override
	public int boardEdit(BoardVO vo) throws Exception{
		return sqlSession.update(Namespace + ".boardEdit", vo);
	}
	
	@Override
	public int boardCount(BoardVO vo) throws Exception{
		return sqlSession.selectOne(Namespace + ".boardCount", vo);
	}
}
