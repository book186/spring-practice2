package com.pty.web.mapper;

import com.pty.web.vo.MemberVO;

public interface MemberMapper {

	// ȸ������
	public void memberJoin(MemberVO member);

	// ���̵� �ߺ� �˻�
	public int idCheck(String memberId);

	/* �α��� */
	public MemberVO memberLogin(MemberVO member);
}
