// service interface�μ� service ���� ��ü MovieServiceImpl���� MovieService�� ����

package com.kyobo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kyobo.vo.MembersVO;

public interface MembersService {
    public List<MembersVO> selectMembers() throws Exception;
    public MembersVO memberLogin(MembersVO vo) throws Exception;
    public int memberInsert(MembersVO vo) throws Exception;
}