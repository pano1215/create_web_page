// VO Ŭ������ ĸ��ȭ �ϰ��� �ϴ� DB ���̺��� �÷���� �����ϰ� ��������� ������ ��
// getter�� setter�� ���� ��������� ������

package com.kyobo.vo;

public class MembersVO {
	private int seq;
	private String id;
	private String pw;
	private String nickname;
	private String gender;
	private String birthday_year;
	private String birthday_month;
	private String birthday_date;
	private int PWresult;
	
	public int getPWresult() {
		return PWresult;
	}
	public void setPWresult(int pWresult) {
		PWresult = pWresult;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getBirthday_year() {
		return birthday_year;
	}
	public void setBirthday_year(String birthday_year) {
		this.birthday_year = birthday_year;
	}
	public String getBirthday_month() {
		return birthday_month;
	}
	public void setBirthday_month(String birthday_month) {
		this.birthday_month = birthday_month;
	}
	public String getBirthday_date() {
		return birthday_date;
	}
	public void setBirthday_date(String birthday_date) {
		this.birthday_date = birthday_date;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}