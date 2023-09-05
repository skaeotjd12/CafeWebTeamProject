package com.green.cafe.dto;

import java.sql.Timestamp;

public class MemDto {
	String mem_id; //아이디
	String mem_pw; //비밀번호
	String mem_name; //회원명
	String mem_tel; //연락처
	String mem_email; //이메일
	Timestamp mem_regdate; //가입일
	int mem_level; //회원등급
	int mem_days; //가입일수 
	/**미구현*/
	int mem_post; //회원별 게시글 수  
	
	public MemDto() {}

	public MemDto(String mem_id, String mem_pw, String mem_name,String mem_tel, String mem_email,Timestamp mem_regdate, int mem_level, int mem_days, int mem_post) {
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
		this.mem_name = mem_name;
		this.mem_tel = mem_tel;
		this.mem_email = mem_email;
		this.mem_regdate = mem_regdate;
		this.mem_level = mem_level;
		this.mem_days = mem_days;
		this.mem_post = mem_post;
	}
	
	public int getMem_post() {
		return mem_post;
	}

	public void setMem_post(int mem_post) {
		this.mem_post = mem_post;
	}

	public int getMem_days() {
		return mem_days;
	}

	public void setMem_days(int mem_days) {
		this.mem_days = mem_days;
	}

	public String getMem_tel() {
		return mem_tel;
	}

	public void setMem_tel(String mem_tel) {
		this.mem_tel = mem_tel;
	}
	
	public String getMem_email() {
		return mem_email;
	}

	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}

	public Timestamp getMem_regdate() {
		return mem_regdate;
	}

	public void setMem_regdate(Timestamp mem_regdate) {
		this.mem_regdate = mem_regdate;
	}

	public int getMem_level() {
		return mem_level;
	}

	public void setMem_level(int mem_level) {
		this.mem_level = mem_level;
	}

	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	
	public String getMem_id() {
		return mem_id;
	}
	
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
	public String getMem_pw() {
		return mem_pw;
	}
	
	public void setMem_pwd(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	
	public String getMem_name() {
		return mem_name;
	}
	
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
}