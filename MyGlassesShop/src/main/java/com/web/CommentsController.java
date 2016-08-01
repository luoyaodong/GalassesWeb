package com.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Comments;
import com.entity.User;
import com.service.CommentsService;

@Controller
public class CommentsController {
	@Resource
	private CommentsService commentsService;
	
	@RequestMapping("/saveComment")
	public String saveComments(ModelAndView mav,HttpSession session,@ModelAttribute Comments comment){
		User user  = (User) session.getAttribute("user");
		if(user==null){
			mav.setViewName("login");
			return "login";
		}else{
			System.out.println(comment.getComments());
			System.out.println(comment.getGlassesId());
			comment.setUserId(user.getId());
			commentsService.save(comment);
		}
		return "redirect:/single?glasseId="+comment.getGlassesId();
	}
}
