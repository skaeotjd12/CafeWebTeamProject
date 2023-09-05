package com.green.cafe.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.green.cafe.dto.PageMaker;
import com.green.cafe.dto.PostDto;
import com.green.cafe.dto.ReplyDto;
import com.green.cafe.dto.SearchCriteria;
import com.green.cafe.service.PostService;
import com.green.cafe.service.ReplyService;

@Controller
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostService service;
	@Autowired
	private ReplyService rservice;
	
	@RequestMapping("/list")
	public String list(@ModelAttribute("scri") SearchCriteria scri, Model model) throws Exception {
		ArrayList<PostDto> list = service.list(scri);
		model.addAttribute("list", list);
		// 페이징 처리
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(service.listCount(scri));
		
		model.addAttribute("pageMaker", pageMaker);
		
		return "post/list";
	}

	@RequestMapping("/write_view")
	public String write_view() {
		
		return "post/write_view";
	}
	
	@RequestMapping("/write")
	public String write(@RequestParam HashMap<String, String> param, MultipartFile file, Model model) throws Exception {
		service.write(param, file);
		
		return "redirect:list";
	}
	
	
	@RequestMapping("/content_view")
	public String content_view(@RequestParam HashMap<String, String> param, @ModelAttribute("scri") SearchCriteria scri, HttpSession session, Model model) throws Exception {
		PostDto dto = service.contentView(param);
		
		// 조회수 증가
		String post_writer = dto.getPost_writer();
		String sesssion_id = (String) session.getAttribute("mem_id");
		if (sesssion_id == null) {
			service.update_view(param);
		} else {
			if (!sesssion_id.equals(post_writer)) {
				service.update_view(param);
			}
		}
		
		ArrayList<ReplyDto> replyList = rservice.replyList(param);
		model.addAttribute("replyList", replyList);

		rservice.updateReplyCount(param);
		
		model.addAttribute("content_view", service.contentView(param));
		model.addAttribute("scri", scri);
		
		return "post/content_view";
	}
	
	@RequestMapping("/modify_view")
	public String modify_view(@RequestParam HashMap<String, String> param, @ModelAttribute("scri") SearchCriteria scri, Model model) throws Exception {
		PostDto dto = service.contentView(param);
		model.addAttribute("modify_view", dto);
		
		model.addAttribute("scri", scri);
		
		return "post/modify_view";
	}
	
	@RequestMapping(value = "/modify")
	public String modify(@RequestParam HashMap<String, String> param, @ModelAttribute("scri") SearchCriteria scri, RedirectAttributes rttr) throws Exception {
		service.modify(param);
		
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/delete")
	public String delete(@RequestParam HashMap<String, String> param, @ModelAttribute("scri") SearchCriteria scri, RedirectAttributes rttr) throws Exception {
		service.delete(param);
		
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		
		return "redirect:list";
	}
	
	// 첨부파일 다운로드
	@RequestMapping(value = "/download_file")
	public void download_file(@RequestParam HashMap<String, String> param, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("===== download_file =====");
		
		PostDto postDto = service.file_info(param);
		String regdate = postDto.getPost_regdate().toString().substring(0, 10).replaceAll("-", "");
		String storedFileName = postDto.getStored_file_name();

		byte[] fileByte = FileUtils.readFileToByteArray(new File("D:\\uploadFiles\\" + regdate + "\\" + storedFileName));
		
		response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
		response.setContentLength(fileByte.length);
		response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(storedFileName, "UTF-8") + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		response.getOutputStream().write(fileByte);
		response.getOutputStream().flush();
		response.getOutputStream().close();
	}
}
