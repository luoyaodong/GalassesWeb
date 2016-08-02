package com.web;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Comments;
import com.entity.Glasses;
import com.entity.GlassesBrand;
import com.entity.GlassesColor;
import com.entity.GlassesMaterial;
import com.entity.GlassesType;
import com.entity.User;
import com.service.CommentsService;
import com.service.GlassesBrandService;
import com.service.GlassesColorService;
import com.service.GlassesMaterialService;
import com.service.GlassesService;
import com.service.GlassesTypeService;
import com.service.UserService;

@Controller
public class GlassesController {
	@Resource
	private GlassesService glassesService;
	@Resource
	private GlassesBrandService glassesBrandService;
	@Resource
	private GlassesColorService glassesColorService;
	@Resource
	private GlassesMaterialService glassesMaterialService;
	@Resource
	private GlassesTypeService glassesTypeService;
	@Resource
	private UserService userService;
	@Resource
	private CommentsService commentsService;
	/**
	 * 存储眼镜信息
	 * @param glasses
	 * @return 重定向到reg
	 */
	@RequestMapping("/glassesSave")
	public String save(@ModelAttribute Glasses glasses) {
		System.out.println("=====");
		glassesService.save(glasses);
		return "redirect:/reg";
	} 
	@RequestMapping("GlasseSave")
	public String upload(@ModelAttribute Glasses glasses,@RequestParam(value = "file", required = false) MultipartFile file,HttpSession session){
		String fileName = file.getOriginalFilename();
		glasses.setImage(fileName);
		String path ="C://apache-tomcat-8.0.32//wtpwebapps//MyGlassesShop//img";
        File f = new File(path, fileName);
        try {
            file.transferTo(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        glassesService.save(glasses);
		return "redirect:/reg";
	}
	/**
	 * 眼镜信息分页返回，将眼镜的返回列表增加到设置为mav的Glasses属性
	 * @param mav
	 * @param nowPage
	 * @return mav
	 */
	@RequestMapping("/page")
	public ModelAndView listByNowPage(ModelAndView mav,
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage) {
		Map<String, Object> map = glassesService.findGlassesByNowPage(nowPage);
		mav.addObject("map", map);
		mav.setViewName("glasses");
		return mav;

	}
	/**
	 * 查询眼镜所有的brand，color，types，materials列表见列表设置为mav的brands属性，colors属性，types属性，materials属性
	 * @param mav
	 * @return mav视图
	 */
	@RequestMapping("/reg")
	public ModelAndView index(ModelAndView mav){
		List<GlassesBrand> brands =  glassesBrandService.getAll();
		List<GlassesType> types = glassesTypeService.getAll();
		List<GlassesColor> colors = glassesColorService.getAll();
		List<GlassesMaterial> materials = glassesMaterialService.getAll();
		mav.addObject("brands",brands);
		mav.addObject("colors",colors);
		mav.addObject("types",types);
		mav.addObject("materials",materials);
		mav.setViewName("index");
		return mav;
	}
	/**
	 * 根据id删除眼镜的信息，重选查询眼镜的所有信息，返回到Glasses视图
	 * @param mav
	 * @param nowId
	 * @return	mav
	 */
	@RequestMapping("/delete")
	public ModelAndView deleteById(ModelAndView mav, @RequestParam(value = "nowId") int nowId) {
		glassesService.deleteByID(nowId);
		Map<String, Object> map = glassesService.findGlassesByNowPage(1);
		mav.addObject("map", map);
		mav.setViewName("glasses");
		return mav;
	}
	/**
	 * 查询眼镜的属性信息，将这些属性信息对应返回到眼镜更新页面上面
	 * @param mav
	 * @param nowId
	 * @return mav
	 */
	@RequestMapping("/update")
	public ModelAndView updateByid(ModelAndView mav, @RequestParam(value = "nowId") int nowId) {
		Glasses glasse = new Glasses();
		glasse = glassesService.findById(nowId);
		mav.addObject("glasse", glasse);
		List<GlassesBrand> brands =  glassesBrandService.getAll();
		List<GlassesType> types = glassesTypeService.getAll();
		List<GlassesColor> colors = glassesColorService.getAll();
		List<GlassesMaterial> materials = glassesMaterialService.getAll();
		mav.addObject("brands",brands);
		mav.addObject("colors",colors);
		mav.addObject("types",types);
		mav.addObject("materials",materials);
		mav.setViewName("update");
		return mav;
	}
	/**
	 * 更新眼镜的信息，将眼镜对应id的眼镜信息进行更新
	 * @param mav
	 * @param glasse
	 * @return mav
	 */
	@RequestMapping("/glassesUpdate")
	public ModelAndView updateById(ModelAndView mav, @ModelAttribute Glasses glasse) {
		glassesService.updateById(glasse);
		Map<String, Object> map = glassesService.findGlassesByNowPage(1);
		mav.addObject("map", map);
		mav.setViewName("glasses");
		return mav;
	}
	/**
	 * 展示眼镜的列表返回到对应的页面信息上面
	 * @param mav
	 * @param nowPage
	 * @return mav
	 */
	@RequestMapping("/showGlasses")
	public ModelAndView showGlasses(ModelAndView mav,
			@RequestParam(value = "nowPage", required = false, defaultValue = "1") int nowPage,HttpSession session) {
		Map<String, Object> map = glassesService.findGlassesByNowPage(nowPage);
		User user = (User) session.getAttribute("user");
		String username=null;
		if(user!=null){
			username=user.getName(); 
		}
		List<GlassesBrand> brands =  glassesBrandService.getAll();
		List<GlassesType> types = glassesTypeService.getAll();
		List<GlassesColor> colors = glassesColorService.getAll();
		List<GlassesMaterial> materials = glassesMaterialService.getAll();
		mav.addObject("brands",brands);
		mav.addObject("colors",colors);
		mav.addObject("types",types);
		mav.addObject("materials",materials);
		mav.addObject("username",username);
		mav.addObject("map", map);
		mav.setViewName("index");
		return mav;

	}
	/**
	 * 根据眼镜的id，查询对应的眼镜，将眼镜的信息返回
	 * @param mav
	 * @param id
	 * @return mav
	 */
	@RequestMapping("/single")
	public ModelAndView single(ModelAndView mav,@RequestParam(value ="glasseId") int id,HttpSession session){
		User user = (User) session.getAttribute("user");
		String username=null;
		if(user!=null){
			username=user.getName();
		}
		Glasses g = glassesService.findById(id);
		List<Comments> comments = commentsService.findByGlassesId(id);
		mav.addObject("comments",comments);
		mav.addObject("glasse",g);
		mav.addObject("brand",g.getBrand());
		mav.addObject("type",g.getType());
		mav.addObject("color",g.getColor());
		mav.addObject("material",g.getMaterial());
		mav.addObject("username",username);
		mav.setViewName("single");
		return mav;
	}
	/**
	 * 根据用户选择的类型查询相应的眼镜进行显示
	 * @param typeId
	 * @return
	 */
	@RequestMapping("/typeSelect")
	public ModelAndView typeSelectById(ModelAndView mav,@RequestParam(value="type") int typeId){
		List<Glasses> g = glassesService.findByTypeId(typeId);
		List<GlassesBrand> brands =  glassesBrandService.getAll();
		List<GlassesType> types = glassesTypeService.getAll();
		List<GlassesColor> colors = glassesColorService.getAll();
		List<GlassesMaterial> materials = glassesMaterialService.getAll();
		mav.addObject("brands",brands);
		mav.addObject("colors",colors);
		mav.addObject("types",types);
		mav.addObject("materials",materials);
		mav.addObject("glasses",g);
		mav.setViewName("select");
		return mav;
	}
	
	@RequestMapping("/priceSelect")
	public ModelAndView priceSelect(ModelAndView mav,@RequestParam(value="bottom") int bottom,@RequestParam(value="top") int top){
		List<Glasses> g=glassesService.findPrice(bottom,top);
		List<GlassesBrand> brands =  glassesBrandService.getAll();
		List<GlassesType> types = glassesTypeService.getAll();
		List<GlassesColor> colors = glassesColorService.getAll();
		List<GlassesMaterial> materials = glassesMaterialService.getAll();
		mav.addObject("brands",brands);
		mav.addObject("colors",colors);
		mav.addObject("types",types);
		mav.addObject("materials",materials);
		mav.addObject("glasses",g);
		mav.setViewName("select");
		return mav;
	}
	@RequestMapping("/brandSelect")
	public ModelAndView brandSelect(ModelAndView mav,@RequestParam(value="brand") int brandId){
		List<Glasses> g=glassesService.findByBrandId(brandId);
		List<GlassesBrand> brands =  glassesBrandService.getAll();
		List<GlassesType> types = glassesTypeService.getAll();
		List<GlassesColor> colors = glassesColorService.getAll();
		List<GlassesMaterial> materials = glassesMaterialService.getAll();
		mav.addObject("brands",brands);
		mav.addObject("colors",colors);
		mav.addObject("types",types);
		mav.addObject("materials",materials);
		mav.addObject("glasses",g);
		mav.setViewName("select");
		return mav;
	}
	@RequestMapping("/materialSelect")
	public ModelAndView materialSelect(ModelAndView mav,@RequestParam(value = "material") int materialId){
		List<Glasses> g = glassesService.findByMaterialId(materialId);
		List<GlassesBrand> brands =  glassesBrandService.getAll();
		List<GlassesType> types = glassesTypeService.getAll();
		List<GlassesColor> colors = glassesColorService.getAll();
		List<GlassesMaterial> materials = glassesMaterialService.getAll();
		mav.addObject("brands",brands);
		mav.addObject("colors",colors);
		mav.addObject("types",types);
		mav.addObject("materials",materials);
		mav.addObject("glasses",g);
		mav.setViewName("select");
		return mav;
	}
	@RequestMapping("/colorSelect")
	public ModelAndView colorSelect(ModelAndView mav,@RequestParam(value = "color") int colorId){
		List<Glasses> g = glassesService.findByColorId(colorId);
		List<GlassesBrand> brands =  glassesBrandService.getAll();
		List<GlassesType> types = glassesTypeService.getAll();
		List<GlassesColor> colors = glassesColorService.getAll();
		List<GlassesMaterial> materials = glassesMaterialService.getAll();
		mav.addObject("brands",brands);
		mav.addObject("colors",colors);
		mav.addObject("types",types);
		mav.addObject("materials",materials);
		mav.addObject("glasses",g);
		mav.setViewName("select");
		return mav;
	}
	@RequestMapping("/manSelect")
	public ModelAndView manSelect(ModelAndView mav){
		List<Glasses> g = glassesService.findManGlasses();
		List<GlassesBrand> brands =  glassesBrandService.getAll();
		List<GlassesType> types = glassesTypeService.getAll();
		List<GlassesColor> colors = glassesColorService.getAll();
		List<GlassesMaterial> materials = glassesMaterialService.getAll();
		mav.addObject("brands",brands);
		mav.addObject("colors",colors);
		mav.addObject("types",types);
		mav.addObject("materials",materials);
		mav.addObject("glasses",g);
		mav.setViewName("select");
		return mav;
	}
	@RequestMapping("/womenSelect")
	public ModelAndView womanSelect(ModelAndView mav){
		List<Glasses> g = glassesService.findWomenGlasses();
		List<GlassesBrand> brands =  glassesBrandService.getAll();
		List<GlassesType> types = glassesTypeService.getAll();
		List<GlassesColor> colors = glassesColorService.getAll();
		List<GlassesMaterial> materials = glassesMaterialService.getAll();
		mav.addObject("brands",brands);
		mav.addObject("colors",colors);
		mav.addObject("types",types);
		mav.addObject("materials",materials);
		mav.addObject("glasses",g);
		mav.setViewName("select");
		return mav;
	}
	@RequestMapping("/glassesInfo")
	public ModelAndView glassesInfo(ModelAndView mav){
		List<GlassesBrand> brands =  glassesBrandService.getAll();
		List<GlassesType> types = glassesTypeService.getAll();
		List<GlassesColor> colors = glassesColorService.getAll();
		List<GlassesMaterial> materials = glassesMaterialService.getAll();
		mav.addObject("brands",brands);
		mav.addObject("colors",colors);
		mav.addObject("types",types);
		mav.addObject("materials",materials);
		mav.setViewName("info");
		return mav;
	}
	@RequestMapping("/deleteBrand")
	public String deleteBrand(@RequestParam (value = "nowId") int id){
		glassesService.deleteByBrandId(id);
		glassesBrandService.deleteByBrandId(id);
		return "redirect:/glassesInfo";
	}
	@RequestMapping("/addBrand")
	public String addBrand(@ModelAttribute GlassesBrand brand){
		glassesBrandService.saveBrand(brand);
		return "redirect:/glassesInfo";
	}
	@RequestMapping("/deleteColor")
	public String deleteColor(@RequestParam (value = "nowId") int id){
		glassesService.deleteByColorId(id);
		glassesColorService.deleteByColorId(id);
		return "redirect:/glassesInfo";
	}
	@RequestMapping("/addColor")
	public String addColor(@ModelAttribute GlassesColor color){
		glassesColorService.save(color);
		return "redirect:/glassesInfo";
	}
	@RequestMapping("/deleteType")
	public String deleteType(@RequestParam(value = "nowId") int id){
		glassesService.deleteByTypeId(id);
		glassesTypeService.deleteByTypeId(id);
		return "redirect:/glassesInfo";
	}
	@RequestMapping("/addType")
	public String addType(@ModelAttribute GlassesType type){
		glassesTypeService.saveType(type);
		return "redirect:/glassesInfo";
	}
	@RequestMapping("/deleteMaterial")
	public String deleteMaterial(@RequestParam(value = "nowId") int id){
		glassesService.deleteByMaterialId(id);
		glassesMaterialService.deleteByMaterialId(id);
		return "redirect:/glassesInfo";
	}
	@RequestMapping("/addMaterial")
	public String addType(@ModelAttribute GlassesMaterial material){
		glassesMaterialService.save(material);
		return "redirect:/glassesInfo";
	}
}
