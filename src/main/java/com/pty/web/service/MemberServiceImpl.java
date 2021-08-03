package com.pty.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pty.web.mapper.MemberMapper;
import com.pty.web.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberMapper memberMapper;

	@Override
	public void memberJoin(MemberVO member) throws Exception {

		memberMapper.memberJoin(member);
	}

	@Override
	public int idCheck(String memberId) throws Exception {

		return memberMapper.idCheck(memberId);
	}

	/* ·Î±×ÀÎ */
	@Override
	public MemberVO memberLogin(MemberVO member) throws Exception {

		return memberMapper.memberLogin(member);
	}
}
