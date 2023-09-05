package com.green.cafe.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.green.cafe.dto.ReplyDto;


public interface ReplyService {
	public ArrayList<ReplyDto> replyList(HashMap<String, String> param);
	public void addReply(HashMap<String, String> param);
	public void updateReplyCount(HashMap<String, String> param);
	public int regReply(Map<String, String> param);
	public void deleteReply(HashMap<String, String> param);
	public void updateReply(HashMap<String, String> param);
}
