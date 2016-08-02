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
	 * 查询所有的用户信息，将用户list返回到index.jsp页面
	 */
	@RequestMapping("/list")
	public ModelAndView list(ModelAndView mav) {
		List<User> user = null;
		user = userService.getAll();
		//设置user列表的返回属性为users
		mav.addObject("users", user);
		mav.setViewName("index");
		return mav;
	}
	/*
	 * 存储用户登录类
	 */
	@RequestMapping("/register")
	public String register(@ModelAttribute User user) {
		userService.saveUser(user);
		return "login";
	}
	/*
	 * 根据用户的id和名字验证用户是不是在列表中，返回flag属性值，返回值是字符串的形式
	 */
	@RequestMapping("/checkName")
	public void checkName(@RequestParam String name, HttpServletResponse response) throws IOException {
		boolean flag = userService.checkName(name);
		response.getWriter().print(flag);
	}
	/**
	 * 验证用户有没有登录，如果用户已经登录，那么验证用户有没有购物车，如果没有购物车则给用户分配一个购物车
	 * @param name
	 * @param pwd
	 * @param session
	 * @return 重定向到showGlasses方法
	 */
	@RequestMapping("/checkLogin")
	public String checkLogin(@RequestParam String name, @RequestParam String pwd, HttpSession session) {
		//判断session的user属性是否为空
		User user = userService.findUser(name, pwd);
		if (userService.checkLogin(name, pwd)) {
			if ((user.getCart()) == null) {
				Cart c = new Cart();
				//给用户增加购物车属性
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
	 * 根据用户的id信息删除对应的用户
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
	 * 验证用户是否可以进入眼镜适配的界面，如果用户可以进入眼镜适配的界面，则将用户对应的头像信息返回到页面上面
	 * @param mav
	 * @param session
	 * @return shipei页面
	 */
	@RequestMapping("/checkLoginState")
	public ModelAndView checkLoginState(ModelAndView mav, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			mav.addObject("error", "用户请登录");
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
	 * 验证用户是否可以使用摄像头，用户如果没有登录那么将用户返回到登录界面
	 * @param mav
	 * @param session
	 * @return mav
	 */
	@RequestMapping("/checkCameraLogin")
	public ModelAndView checkCameraLogin(ModelAndView mav, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			mav.addObject("error", "用户请登录");
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
