package com.kyobo.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.kyobo.vo.MembersVO;

@Mapper
public interface MembersDAO {

	// RSA에서 in out을 설정해주는 것 처럼 여기서 in out을 설정해줌
	// 예를 들어, selectMembers()가 있다면 ()안에 파라미터 값을 넣고 SQL로 보냄
	// sql에서 입력값에 따른 결과값을 List<MembersVO>에 담음
	// 이때 MembersVO로만 가져올거면 List없이 가져와도 됨 
	// List는 데이터 형식일 뿐
	//  out             in
	public List<MembersVO> selectMembers() throws Exception;
	public MembersVO memberLogin(MembersVO vo) throws Exception;
	public int memberInsert(MembersVO vo) throws Exception;
}
