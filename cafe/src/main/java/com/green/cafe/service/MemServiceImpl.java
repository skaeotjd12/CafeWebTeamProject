package com.green.cafe.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.cafe.dao.MemDao;
import com.green.cafe.dto.MemDto;

@Service("MemService")
public class MemServiceImpl implements MemService{

	@Autowired
	private SqlSession sqlSession;
	
	/**로그인*/
	@Override
	public int loginYn(HashMap<String, String> param) {
		MemDao dao = sqlSession.getMapper(MemDao.class);
		ArrayList<MemDto> dtos = dao.loginYn(param);
		
		int re = -1;
		if(!dtos.isEmpty()) {
			if (dtos.get(0).getMem_pw().equals(param.get("mem_pw"))) {
				re=1;
				System.out.println("로그인 성공!");
				
			} else {
				re=0;
				System.out.println("비밀번호가 일치하지 않습니다.");
			}
		}else {
			 System.out.println("존재하지 않는 회원입니다.");
		}
		return re;
	}
	
	/**회원가입*/
	@Override
	public void register(HashMap<String, String> param) {
		MemDao dao = sqlSession.getMapper(MemDao.class);
		dao.register(param);
	}
	/**관리자 : 회원조회*/
	@Override
	public ArrayList<MemDto> memberView() {
		MemDao dao = sqlSession.getMapper(MemDao.class);
		ArrayList<MemDto> dtos = dao.memberView();
		return dtos;
	}
	/**정보수정*/
	@Override
	public void updateInfo(HashMap<String, String> param) {
		MemDao dao = sqlSession.getMapper(MemDao.class);
		dao.updateInfo(param);
	}
	/**정보조회*/
	@Override
	public void checkInfo(HashMap<String, String> param) {
		MemDao dao = sqlSession.getMapper(MemDao.class);
		dao.checkInfo(param);
	}
	/**회원탈퇴*/
	@Override
	public void deleteMember(HashMap<String, String> param) {
		MemDao dao = sqlSession.getMapper(MemDao.class);
		dao.deleteMember(param);
	}
	/**로그인 정보*/
	@Override
	public ArrayList<MemDto> loginView(HashMap<String, String> param) {
		MemDao dao = sqlSession.getMapper(MemDao.class);
		ArrayList<MemDto> dtos = dao.loginView(param);
		return dtos;
	}
	/**가입일수 갱신*/
	@Override
	public void countDays() {
		MemDao dao = sqlSession.getMapper(MemDao.class);
		dao.countDays();
	}
	/**레벨1 -> 레벨2 자동등업*/
	@Override
	public void levelUp_auto(HashMap<String, String> param) {
		MemDao dao = sqlSession.getMapper(MemDao.class);
		dao.levelUp_auto(param);
	}
	/**관리자 : 레벨2 -> 레벨3 변경*/
	@Override
	public void levelUp_admin(HashMap<String, String> param) {
		MemDao dao = sqlSession.getMapper(MemDao.class);
		dao.levelUp_admin(param);
	}
	/**관리자 : 레벨3 -> 레벨2 변경*/
	@Override
	public void levelDown_admin(HashMap<String, String> param) {
		MemDao dao = sqlSession.getMapper(MemDao.class);
		dao.levelDown_admin(param);
	}
}
