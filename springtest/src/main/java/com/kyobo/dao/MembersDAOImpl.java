// SqlSession을 통해 등록된(test.xml) SQL 쿼리문을 실행하여 List 리턴

package com.kyobo.dao;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.kyobo.dao.MembersDAO;
import com.kyobo.vo.MembersVO;

@Repository
public class MembersDAOImpl implements MembersDAO {
	@Inject
	SqlSession sqlSession;
	private static final String Namespace = "com.kyobo.mapper.MembersMapper";
	
	@Override
	public List<MembersVO> selectMembers() throws Exception {
		return sqlSession.selectList(Namespace + ".selectMembers");
	}
	
	@Override
	public MembersVO memberLogin(MembersVO vo) throws Exception{
		return sqlSession.selectOne(Namespace + ".memberLogin", vo);
	}
	
	@Override
	public int memberInsert(MembersVO vo) throws Exception{
		return sqlSession.insert(Namespace + ".memberInsert", vo);
	}
}