// service는 비즈니스 로직을 작성하는 곳이며, DB 처리를 할 때 많이 이용
// MovieDAO 객체를 의존 주입(DI, Dependency Injection)

package com.kyobo.service;

import java.util.List;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyobo.dao.MembersDAO;
import com.kyobo.service.MembersService;
import com.kyobo.vo.MembersVO;

@Service
public class MembersServiceImpl implements MembersService {
 
    @Inject
    MembersDAO dao;
    
    @Override
    public List<MembersVO> selectMembers() throws Exception {
        return dao.selectMembers();
    }
    
    @Override
    public MembersVO memberLogin(MembersVO vo) throws Exception {
        return dao.memberLogin(vo);
    }
    
    @Override
    public int memberInsert(MembersVO vo) throws Exception {
        return dao.memberInsert(vo);
    }
}