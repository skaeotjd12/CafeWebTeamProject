package com.green.cafe.dto;

import java.sql.Date;

public class PostDto {
	private int post_no;
	private String post_writer;
	private String post_title;
	private String post_content;
	private int post_hit;
	private int post_like;
	private Date post_regdate;
	private Date post_moddate;
	
	private String file_name;
	private String stored_file_name;
	private String file_size;
	private int reply_count;

	public PostDto() {
		
	}
	
	public PostDto(int post_no, String post_writer, String post_title, String post_content, int post_hit, int post_like,
			Date post_regdate, Date post_moddate, int reply_count) {
		super();
		this.post_no = post_no;
		this.post_writer = post_writer;
		this.post_title = post_title;
		this.post_content = post_content;
		this.post_hit = post_hit;
		this.post_like = post_like;
		this.post_regdate = post_regdate;
		this.post_moddate = post_moddate;
		this.reply_count = reply_count;
	}
	
	public int getReply_count() {
		return reply_count;
	}

	public void setReply_count(int reply_count) {
		this.reply_count = reply_count;
	}

	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	public String getPost_writer() {
		return post_writer;
	}
	public void setPost_writer(String post_writer) {
		this.post_writer = post_writer;
	}
	public String getPost_title() {
		return post_title;
	}
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
	public String getPost_content() {
		return post_content;
	}
	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}
	public int getPost_hit() {
		return post_hit;
	}
	public void setPost_hit(int post_hit) {
		this.post_hit = post_hit;
	}
	public int getPost_like() {
		return post_like;
	}
	public void setPost_like(int post_like) {
		this.post_like = post_like;
	}
	public Date getPost_regdate() {
		return post_regdate;
	}
	public void setPost_regdate(Date post_regdate) {
		this.post_regdate = post_regdate;
	}
	public Date getPost_moddate() {
		return post_moddate;
	}
	public void setPost_moddate(Date post_moddate) {
		this.post_moddate = post_moddate;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getStored_file_name() {
		return stored_file_name;
	}

	public void setStored_file_name(String stored_file_name) {
		this.stored_file_name = stored_file_name;
	}

	public String getFile_size() {
		return file_size;
	}

	public void setFile_size(String file_size) {
		this.file_size = file_size;
	}
	
}
