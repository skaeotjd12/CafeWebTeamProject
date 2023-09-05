package com.green.cafe.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.green.cafe.dto.ReplyDto;


public interface ReplyDao {
	public ArrayList<ReplyDto> replyList(HashMap<String, String> param);
	public void addReply(HashMap<String, String> param);
	public void updateReplyCount(HashMap<String, String> param);
	public int regReply(Map<String, String> param);
	public void deleteReplyAll(HashMap<String, String> param);
	public void deleteReplyOne(HashMap<String, String> param);
	public void updateReply(HashMap<String, String> param);
}
