package com.green.cafe.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.green.cafe.dao.PostDao;
import com.green.cafe.dto.PostDto;
import com.green.cafe.dto.SearchCriteria;

@Service("PostService")
public class PostServiceImpl implements PostService {
	
	@Autowired
	private SqlSession sqlSession;
	
	private String base_path = "";
	
	@Override
	public ArrayList<PostDto> list(SearchCriteria scri) throws Exception {
		PostDao dao = sqlSession.getMapper(PostDao.class);
		ArrayList<PostDto> list = dao.list(scri);

		return list;
	}

	@Override
	public void write(HashMap<String, String> param, MultipartFile file) throws Exception {
		PostDao dao = sqlSession.getMapper(PostDao.class);
		
		String orgFileName = file.getOriginalFilename();
		String extension = orgFileName.substring(orgFileName.lastIndexOf("."), orgFileName.length());
		UUID uuid = UUID.randomUUID();
		String storedFileName = uuid.toString() + extension;
		storedFileName = storedFileName.replaceAll("-", "");
		long file_size = file.getSize();
		byte[] data = file.getBytes();
		
		mkDir();
		
		// File target = new File("D:\\uploadFiles", orgFileName);
		File target = new File(base_path + "\\", storedFileName);
		
		try {
			FileCopyUtils.copy(data, target);
		} catch (Exception e) {
			e.printStackTrace();
		}
		param.put("file_name", orgFileName);
		param.put("stored_file_name", storedFileName);
		param.put("file_size", Long.toString(file_size));
		dao.write(param);
	}

	private void mkDir() {
		Date now = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String regdate = formatter.format(now);
		base_path = "D:\\uploadFiles\\" + regdate;
		
		File folder = new File(base_path);
		
		if (!folder.exists()) {
			folder.mkdir();
		} else {
			System.out.println("폴더 존재");			
		}
	}
	
	@Override
	public PostDto contentView(HashMap<String, String> param) throws Exception {
		PostDao dao = sqlSession.getMapper(PostDao.class);
		PostDto dto = dao.contentView(param);
		return dto;
	}

	@Override
	public void modify(HashMap<String, String> param) throws Exception {
		PostDao dao = sqlSession.getMapper(PostDao.class);
		dao.modify(param);
	}

	@Override
	public void delete(HashMap<String, String> param) throws Exception {
		PostDao dao = sqlSession.getMapper(PostDao.class);
		dao.delete(param);
	}

	@Override
	public int listCount(SearchCriteria scri) throws Exception {
		PostDao dao = sqlSession.getMapper(PostDao.class);
		return dao.listCount(scri);
	}
	
	@Override
	public void update_view(HashMap<String, String> param) {
		PostDao dao = sqlSession.getMapper(PostDao.class);
		dao.update_view(param);		
	}

	// 첨부파일 다운로드
	@Override
	public PostDto file_info(HashMap<String, String> param) throws Exception {
		PostDao dao = sqlSession.getMapper(PostDao.class);
		return dao.file_info(param);
	}
}
