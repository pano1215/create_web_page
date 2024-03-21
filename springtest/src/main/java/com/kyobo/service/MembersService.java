// service interface로서 service 구현 객체 MovieServiceImpl에서 MovieService를 구현

package com.kyobo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kyobo.vo.MembersVO;

public interface MembersService {
    public List<MembersVO> selectMembers() throws Exception;
    public MembersVO memberLogin(MembersVO vo) throws Exception;
    public int memberInsert(MembersVO vo) throws Exception;
}