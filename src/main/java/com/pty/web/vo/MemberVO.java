package com.pty.web.vo;

public class MemberVO {

	private String memberId; // ȸ�� id
	private String memberPw; // ȸ�� ��й�ȣ
	private String memberName; // ȸ�� �̸�
	private String memberMail; // ȸ�� �̸���
	private int adminCk; // ������ ����(0:�Ϲݻ����, 1:������)
	private int regDate; // �������
	private int money; // ȸ�� ��
	private int point; // ȸ�� ����Ʈ
	
	public String getMemberId() {
		return memberId;
	}
	
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	public String getMemberPw() {
		return memberPw;
	}
	
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	
	public String getMemberName() {
		return memberName;
	}
	
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public String getMemberMail() {
		return memberMail;
	}
	
	public void setMemberMail(String memberMail) {
		this.memberMail = memberMail;
	}
	
	public int getAdminCk() {
		return adminCk;
	}
	
	public void setAdminCk(int adminCk) {
		this.adminCk = adminCk;
	}
	
	public int getRegDate() {
		return regDate;
	}
	
	public void setRegDate(int regDate) {
		this.regDate = regDate;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public int getPoint() {
		return point;
	}
	
	public void setPoint(int point) {
		this.point = point;
	}
}
