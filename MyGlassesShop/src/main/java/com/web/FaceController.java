package com.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Face;
import com.service.FaceService;

@Controller
public class FaceController {
	@Resource
	private FaceService faceService;
	
	@RequestMapping("/regUser")
	public ModelAndView regUser(ModelAndView mav){
		List<Face> faces=faceService.getAll();
		mav.addObject("faces",faces);
		mav.setViewName("register");
		return mav;
	}
}
