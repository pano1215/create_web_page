package com.kyobo.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.kyobo.vo.MembersVO;

@Mapper
public interface MembersDAO {

	// RSA���� in out�� �������ִ� �� ó�� ���⼭ in out�� ��������
	// ���� ���, selectMembers()�� �ִٸ� ()�ȿ� �Ķ���� ���� �ְ� SQL�� ����
	// sql���� �Է°��� ���� ������� List<MembersVO>�� ����
	// �̶� MembersVO�θ� �����ðŸ� List���� �����͵� �� 
	// List�� ������ ������ ��
	//  out             in
	public List<MembersVO> selectMembers() throws Exception;
	public MembersVO memberLogin(MembersVO vo) throws Exception;
	public int memberInsert(MembersVO vo) throws Exception;
}
