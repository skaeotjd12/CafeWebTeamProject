package com.green.cafe.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.cafe.dao.ReplyDao;
import com.green.cafe.dto.ReplyDto;


@Service("RService")
public class ReplyServiceImpl  implements ReplyService{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public ArrayList<ReplyDto> replyList(HashMap<String, String> param) {
		ReplyDao dao = sqlSession.getMapper(ReplyDao.class);
		ArrayList<ReplyDto> list = dao.replyList(param);
		
		return list;
	}
	@Override
	public void addReply(HashMap<String, String> param) {

		ReplyDao dao = sqlSession.getMapper(ReplyDao.class);
		dao.addReply(param);
		
	}
	@Override
	public void updateReplyCount(HashMap<String, String> param) {
		ReplyDao dao = sqlSession.getMapper(ReplyDao.class);
		dao.updateReplyCount(param);
		
	}

	@Override
    public int regReply(Map<String, String> param) {
		ReplyDao dao = sqlSession.getMapper(ReplyDao.class);
		return dao.regReply(param);
    }
	@Override
	public void deleteReply(HashMap<String, String> param) {
		ReplyDao dao = sqlSession.getMapper(ReplyDao.class);
		
		if (Integer.parseInt(param.get("reply_depth")) != 1) {
				dao.deleteReplyAll(param);
			}	
				dao.deleteReplyOne(param);	
	}
	
	@Override
	public void updateReply(HashMap<String, String> param) {
		ReplyDao dao = sqlSession.getMapper(ReplyDao.class);
		dao.updateReply(param);
	}
	
}
