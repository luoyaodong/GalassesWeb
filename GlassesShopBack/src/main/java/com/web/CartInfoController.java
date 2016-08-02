package com.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Cart;
import com.entity.CartInfo;
import com.entity.Glasses;
import com.entity.GlassesBrand;
import com.entity.GlassesColor;
import com.entity.GlassesMaterial;
import com.entity.GlassesType;
import com.entity.User;
import com.service.CartInfoService;
import com.service.GlassesBrandService;
import com.service.GlassesColorService;
import com.service.GlassesMaterialService;
import com.service.GlassesService;
import com.service.GlassesTypeService;

@Controller
public class CartInfoController {
	@Resource
	private CartInfoService cartInfoService;
	@Resource
	private GlassesService glassesService;
	@Resource
	private GlassesBrandService glassesBrandService;
	@Resource
	private GlassesMaterialService glassesMaterialService;
	@Resource
	private GlassesColorService glassesColorService;
	@Resource
	private GlassesTypeService glassesTypeService;
	
	@RequestMapping("/showCart")
	public ModelAndView showCart(ModelAndView mav ,HttpSession session){
		User user = (User) session.getAttribute("user");
		if(user!=null){
			Cart cart = user.getCart();
			List<CartInfo> info = cartInfoService.getInfoByCart(cart.getId());
			List<Glasses> glasses = new ArrayList<>();
			for(CartInfo f:info){
				Glasses g = glassesService.findById(f.getInfoId());
				glasses.add(g);
			}
			List<GlassesBrand> brands =  glassesBrandService.getAll();
			List<GlassesType> types = glassesTypeService.getAll();
			List<GlassesColor> colors = glassesColorService.getAll();
			List<GlassesMaterial> materials = glassesMaterialService.getAll();
			mav.addObject("brands",brands);
			mav.addObject("colors",colors);
			mav.addObject("types",types);
			mav.addObject("materials",materials);
			mav.addObject("glasses",glasses);
			mav.setViewName("cart");
			mav.addObject("username",user.getName());
			return mav;
		}
		mav.setViewName("login");
		return mav;
	}
}
