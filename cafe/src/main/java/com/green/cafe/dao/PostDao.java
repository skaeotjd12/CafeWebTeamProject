package com.green.cafe.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.green.cafe.dto.PostDto;
import com.green.cafe.dto.SearchCriteria;

public interface PostDao {
	// 게시물 조회
	public ArrayList<PostDto> list(SearchCriteria scri) throws Exception;;
	// 게시물 총 갯수
	public int listCount(SearchCriteria scri) throws Exception;
	// 게시글 작성
	public void write(HashMap<String, String> param) throws Exception;
	// 게시글 조회
	public PostDto contentView(HashMap<String, String> param) throws Exception;
	// 게시글 수정
	public void modify(HashMap<String, String> param) throws Exception;
	// 게시글 삭제
	public void delete(HashMap<String, String> param) throws Exception;
	// 게시물 조회 수 증가
	public void update_view(HashMap<String, String> param);
	// 첨부파일 다운로드
	public PostDto file_info(HashMap<String, String> param) throws Exception;
}
