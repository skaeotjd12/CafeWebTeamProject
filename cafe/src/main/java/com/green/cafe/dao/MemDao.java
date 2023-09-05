package com.green.cafe.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.green.cafe.dto.MemDto;

public interface MemDao {
	/**로그인*/
	public ArrayList<MemDto> loginYn(HashMap<String, String> param);
	/**관리자 : 회원조회*/
	public ArrayList<MemDto> memberView();
	/**로그인 정보*/
	public ArrayList<MemDto> loginView(HashMap<String, String> param);
	/**회원가입*/
	public void register(HashMap<String, String> param);
	/**정보수정*/
	public void updateInfo(HashMap<String, String> param);
	/**정보조회*/
	public void checkInfo(HashMap<String, String> param);
	/**회원탈퇴*/
	public void deleteMember(HashMap<String, String> param);
	/**가입일수 갱신*/
	public void countDays();
	/**레벨1 -> 레벨2 자동등업*/
	public void levelUp_auto(HashMap<String, String> param);
	/**관리자 : 레벨2 -> 레벨3 변경*/
	public void levelUp_admin(HashMap<String, String> param);
	/**관리자 : 레벨3 -> 레벨2 변경*/
	public void levelDown_admin(HashMap<String, String> param);
}
