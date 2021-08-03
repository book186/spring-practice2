package com.pty.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pty.web.service.MemberService;
import com.pty.web.vo.MemberVO;

@Controller
@RequestMapping(value = "/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService;

	@Autowired
	private BCryptPasswordEncoder pwEncoder;

	// ȸ������ ������ �̵�
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public void joinGET() {
		logger.debug("ȸ������ ������ ����");
	}

	// ȸ������
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinPOST(MemberVO member) throws Exception {
		String rawPw = ""; // ���ڵ� �� ��й�ȣ
		String encodePw = ""; // ���ڵ� �� ��й�ȣ

		rawPw = member.getMemberPw(); // ��й�ȣ ������ ����
		encodePw = pwEncoder.encode(rawPw); // ��й�ȣ ���ڵ�
		member.setMemberPw(encodePw); // ���ڵ��� ��й�ȣ member��ü�� �ٽ� ����

		/* ȸ������ ���� ���� */
		memberService.memberJoin(member);

		return "redirect:/member/login";
	}

	// �α��� ������ �̵�
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void loginGET() {
		logger.debug("�α��� ������ ����");
	}

	// ���̵� �ߺ� �˻�
	@RequestMapping(value = "/memberIdChk", method = RequestMethod.POST)
	@ResponseBody
	public String memberIdChkPOST(String memberId) throws Exception {
		logger.debug("memberIdChk() ����");

		int result = memberService.idCheck(memberId);

		logger.debug("����� = " + result);

		if (result != 0) {
			return "fail"; // �ߺ� ���̵� ����
		} else {
			return "success"; // �ߺ� ���̵� x
		}
	}

	/* �α��� */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String loginPOST(HttpServletRequest request, MemberVO member, RedirectAttributes rttr) throws Exception {
		HttpSession session = request.getSession();
		String rawPw = "";
		String encodePw = "";

		MemberVO lvo = memberService.memberLogin(member); // �����Ѿ��̵�� ��ġ�ϴ� ���̵� �ִ���

		if (lvo != null) { // ��ġ�ϴ� ���̵� �����
			rawPw = member.getMemberPw(); // ����ڰ� ������ ��й�ȣ
			encodePw = lvo.getMemberPw(); // �����ͺ��̽��� ������ ���ڵ��� ��й�ȣ
			if (true == pwEncoder.matches(rawPw, encodePw)) { // ��й�ȣ ��ġ���� �Ǵ�
				lvo.setMemberPw(""); // ���ڵ��� ��й�ȣ ���� ����
				session.setAttribute("member", lvo); // session�� ������� ���� ����

				return "redirect:/main"; // ���������� �̵�
			} else {
				rttr.addFlashAttribute("result", 0);

				return "redirect:/member/login"; // �α��� �������� �̵�
			}
		} else { // ��ġ�ϴ� ���̵� �������� ���� �� (�α��� ����)
			rttr.addFlashAttribute("result", 0);

			return "redirect:/member/login"; // �α��� �������� �̵�
		}
	}
}