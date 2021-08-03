package com.pty.web.vo;

public class MemberVO {

	private String memberId; // 회원 id
	private String memberPw; // 회원 비밀번호
	private String memberName; // 회원 이름
	private String memberMail; // 회원 이메일
	private int adminCk; // 관리자 구분(0:일반사용자, 1:관리자)
	private int regDate; // 등록일자
	private int money; // 회원 돈
	private int point; // 회원 포인트
	
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
