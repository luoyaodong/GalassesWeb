package com.web;

import java.lang.ProcessBuilder.Redirect;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Cart;
import com.entity.CartInfo;
import com.entity.Glasses;
import com.entity.User;
import com.service.CartInfoService;
import com.service.GlassesService;
import com.service.UserService;

@Controller
public class CartController {
	@Resource
	private GlassesService glassesService;
	@Resource
	private UserService userService;
	@Resource
	private CartInfoService cartInfoService;
	
	@RequestMapping("/addCart")
	public String addCart(ModelAndView mav,@RequestParam (value="glasseId") int id,HttpSession session){
		User user = (User) session.getAttribute("user");
		if(user!=null){
			Cart cart = user.getCart();
			if(cart!=null){
				CartInfo f = new CartInfo();
				if(cartInfoService.checkInfo(cart.getId(),id)){
					f.setInfoId(id);
					f.setCartId(cart.getId());
					cartInfoService.save(f);
					return "redirect:/showGlasses";
				}else{
					return "redirect:/showGlasses";
				}
			}else{
				return "login";
			}
		}else{
			return "login";
		}
	}
	@RequestMapping("deleteCartInfo")
	public String deleteCartInfo(@RequestParam (value="glasseId") int id,HttpSession session){
		User user = (User)session.getAttribute("user");
		cartInfoService.deleteCartInfo(user.getCart().getId(),id);
		return "redirect:/showCart";
	}
}
