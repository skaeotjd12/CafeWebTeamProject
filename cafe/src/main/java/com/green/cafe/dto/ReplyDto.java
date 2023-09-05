package com.green.cafe.dto;

import java.sql.Date;

public class ReplyDto {
	private int reply_no;
	private int post_no;
	private int reply_parent;
	private int reply_depth;
	private String mem_id;
	private String reply_content;
	private Date reply_regdate;
	private String  reply_writer;
	
	public ReplyDto() {
		
	}
	
	public String getReply_writer() {
		return reply_writer;
	}

	public void setReply_writer(String reply_writer) {
		this.reply_writer = reply_writer;
	}

	public int getReply_no() {
		return reply_no;
	}
	public void setReply_no(int reply_no) {
		this.reply_no = reply_no;
	}
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	public int getReply_parent() {
		return reply_parent;
	}
	public void setReply_parent(int reply_parent) {
		this.reply_parent = reply_parent;
	}
	public int getReply_depth() {
		return reply_depth;
	}
	public void setReply_depth(int reply_depth) {
		this.reply_depth = reply_depth;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	
	public Date getReply_regdate() {
		return reply_regdate;
	}

	public void setReply_regdate(Date reply_regdate) {
		this.reply_regdate = reply_regdate;
	}

	public ReplyDto(int reply_no, int post_no, int reply_parent, int reply_depth, String mem_id, String reply_content,
			Date reply_regdate, String reply_writer) {
		this.reply_no = reply_no;
		this.post_no = post_no;
		this.reply_parent = reply_parent;
		this.reply_depth = reply_depth;
		this.mem_id = mem_id;
		this.reply_content = reply_content;
		this.reply_regdate = reply_regdate;
		this.reply_writer = reply_writer;
	}

	
	
	
}
