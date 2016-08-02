package com.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Cart;
import com.entity.Face;
import com.entity.Image;
import com.entity.User;
import com.service.CartInfoService;
import com.service.CartService;
import com.service.FaceService;
import com.service.GlassesService;
import com.service.ImageService;
import com.service.UserService;

@Controller
public class UserController {
	@Resource
	private UserService userService;
	@Resource
	private ImageService imageService;
	@Resource
	private CartService cartService;
	@Resource
	private CartInfoService cartInfoService;
	@Resource
	private GlassesService  glassesService;
	@Resource
	private FaceService faceService;
	/*
	 * ��ѯ���е��û���Ϣ�����û�list���ص�index.jspҳ��
	 */
	@RequestMapping("/list")
	public ModelAndView list(ModelAndView mav) {
		List<User> user = null;
		user = userService.getAll();
		//����user�б�ķ�������Ϊusers
		mav.addObject("users", user);
		mav.setViewName("index");
		return mav;
	}
	/*
	 * �洢�û���¼��
	 */
	@RequestMapping("/register")
	public String register(@ModelAttribute User user) {
		userService.saveUser(user);
		return "login";
	}
	/*
	 * �����û���id��������֤�û��ǲ������б��У�����flag����ֵ������ֵ���ַ�������ʽ
	 */
	@RequestMapping("/checkName")
	public void checkName(@RequestParam String name, HttpServletResponse response) throws IOException {
		boolean flag = userService.checkName(name);
		response.getWriter().print(flag);
	}
	/**
	 * ��֤�û���û�е�¼������û��Ѿ���¼����ô��֤�û���û�й��ﳵ�����û�й��ﳵ����û�����һ�����ﳵ
	 * @param name
	 * @param pwd
	 * @param session
	 * @return �ض���showGlasses����
	 */
	@RequestMapping("/checkLogin")
	public String checkLogin(@RequestParam String name, @RequestParam String pwd, HttpSession session) {
		//�ж�session��user�����Ƿ�Ϊ��
		User user = userService.findUser(name, pwd);
		if (userService.checkLogin(name, pwd)) {
			if ((user.getCart()) == null) {
				Cart c = new Cart();
				//���û����ӹ��ﳵ����
				cartService.save(c);
				user.setCart(c);
				user = userService.update(user);
				session.setAttribute("user", user);
				// return "redirect:/reg";
				return "redirect:/showGlasses";
			}else{
				session.setAttribute("user", user);
				return "redirect:/showGlasses";
			}
		} else {
			return "login";
		}
	}
	
	@RequestMapping("/userPage")
	public ModelAndView listByNowPage(ModelAndView mav,
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage) {
		Map<String, Object> map = userService.findUserByNowPage(nowPage);
		mav.addObject("map", map);
		mav.setViewName("user");
		return mav;
	}
	/**
	 * �����û���id��Ϣɾ����Ӧ���û�
	 * @param mav
	 * @param nowId
	 * @return
	 */
	@RequestMapping("deleteUser")
	public ModelAndView deleteById(ModelAndView mav, @RequestParam(value = "nowId") int nowId) {
		userService.deleteByID(nowId);
		Map<String, Object> map = userService.findUserByNowPage(1);
		mav.addObject("map", map);
		mav.setViewName("user");
		return mav;
	}
	/**
	 * ��֤�û��Ƿ���Խ����۾�����Ľ��棬����û����Խ����۾�����Ľ��棬���û���Ӧ��ͷ����Ϣ���ص�ҳ������
	 * @param mav
	 * @param session
	 * @return shipeiҳ��
	 */
	@RequestMapping("/checkLoginState")
	public ModelAndView checkLoginState(ModelAndView mav, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			mav.addObject("error", "�û����¼");
			mav.setViewName("login");
			return mav;
		}
		List<Image> images = imageService.getImageByUserId(user.getId());
		mav.addObject("images", images);
		mav.addObject("username",user.getName());
		mav.setViewName("shipei");
		return mav;
	}
	/**
	 * ��֤�û��Ƿ����ʹ������ͷ���û����û�е�¼��ô���û����ص���¼����
	 * @param mav
	 * @param session
	 * @return mav
	 */
	@RequestMapping("/checkCameraLogin")
	public ModelAndView checkCameraLogin(ModelAndView mav, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			mav.addObject("error", "�û����¼");
			mav.setViewName("login");
			return mav;
		}
		mav.addObject("username",user.getName());
		mav.setViewName("camera");
		return mav;
	}
	
	@RequestMapping("quit")
	public String quit(HttpSession session){
		session.invalidate();
		return "redirect:/showGlasses";
	}
	
	@RequestMapping("updateUser")
	public ModelAndView updateUser(ModelAndView mav,@RequestParam(value = "nowId") int userId){
		List<Face> faces = faceService.getAll();
		User user = userService.findUserById(userId);
		mav.addObject("faces",faces);
		mav.addObject("user",user);
		mav.setViewName("userupdate");
		return mav;
	}
	
	@RequestMapping("updateOneUser")
	public ModelAndView userUpdate(ModelAndView mav,@ModelAttribute User user){
		User user2 = userService.update(user);
		Map<String, Object> map = userService.findUserByNowPage(1);
		mav.addObject("map", map);
		mav.setViewName("user");
		return mav;
	}
}
