package com.green.cafe.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.cafe.dto.ReplyDto;
import com.green.cafe.service.ReplyService;


@Controller
@RequestMapping(value = "/post")
public class ReplyController {
	
	 @Autowired
	 private ReplyService service;
	 
	 @RequestMapping(value = "addReply") 
		public String addReply(@RequestParam HashMap<String, String> param) {
			service.addReply(param);
			return "redirect:content_view?post_no="+ param.get("post_no");
		}
	 @RequestMapping("addreReply") 
	  	public String addreReply(@RequestParam HashMap<String, String> param) {
			service.regReply(param);
			return "redirect:content_view?post_no="+ param.get("post_no");
	 	}
	 @RequestMapping(value = "deleteReply") 
		public String deleteReply(@RequestParam HashMap<String, String> param) {
			 service.deleteReply(param);
			 return "redirect:content_view?post_no="+ param.get("post_no");
		} 
	 @RequestMapping(value = "updateReply") 
	 	 public String updateReply(@RequestParam HashMap<String, String> param) {
			 service.updateReply(param);
			 return "redirect:content_view?post_no="+ param.get("post_no");
	 	}
			
}
