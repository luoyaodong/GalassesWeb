package com.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Image;
import com.entity.User;
import com.service.ImageService;

import sun.misc.BASE64Decoder;

@Controller
public class ImageController {
	
	@Resource
	private ImageService imageService;
	
	private String filename;
	private String imageName; 
	
	@RequestMapping("/saveSmallImage")
	public void saveSmallImage(@RequestParam(value="name",required = false, defaultValue = "null") String name,HttpSession session){
		String path = "C:\\Users\\Administrator\\workspace\\MyGlassesShop\\src\\main\\webapp\\img";
		//创建用户的图片存储路径
		String path2 = session.getServletContext().getRealPath("/img");
		File f= new File(path);
		File f2 = new File(path);
		if(!f2.exists()&&!f2.isDirectory()){
			f2.mkdir();
		}
		if(!f.exists()&&!f.isDirectory()){
			f.mkdir();
		}
		//base64解码图片流信息
		BASE64Decoder base64 = new BASE64Decoder();
		User user=(User) session.getAttribute("user");
		Image image = new Image();
		try {
			//将图片流存入字符数组
			byte[] k=base64.decodeBuffer(name.substring("data:image/jpeg;base64,".length()));
			SimpleDateFormat df = new SimpleDateFormat("HH-mm-ss");
			filename = df.format(new Date());
			System.out.println(filename);
			FileOutputStream outputStream = new FileOutputStream(new File(path,"model_"+filename+".jpg"));
			FileOutputStream outputStream2 = new FileOutputStream(new File(path2,"model_"+filename+".jpg"));
			//将字符数组存入文件流
	        outputStream.write(k);
	        outputStream2.write(k);
	        outputStream.flush();  
	        outputStream2.flush();  
	        outputStream.close();
	        outputStream2.close();
	        image.setSmallImg("model_"+filename+".jpg");
	        image.setBigImg("big_"+filename+".jpg");
	        image.setUser(user);
	        imageService.save(image);
	         
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/saveBigImage")
	public void saveBigImage(PrintWriter out,@RequestParam(value="name",required = false, defaultValue = "null") String name,HttpSession session){
		String path = "C:\\Users\\Administrator\\workspace\\MyGlassesShop\\src\\main\\webapp\\img";
		//得到用户的图片存储路径
		String path2 = session.getServletContext().getRealPath("/img");
		//base64解码图片流信息
		BASE64Decoder base64 = new BASE64Decoder();
		try {
			byte[] k=base64.decodeBuffer(name.substring("data:image/jpeg;base64,".length()));
			FileOutputStream outputStream = new FileOutputStream(new File(path,"big_"+filename+".jpg"));
			FileOutputStream outputStream2 = new FileOutputStream(new File(path2,"big_"+filename+".jpg"));
			imageName="big_"+filename+".jpg";
			//将字符数组存入文件流
	        outputStream.write(k);
	        outputStream2.write(k);
	        outputStream.flush();  
	        outputStream2.flush();  
	        outputStream.close();
	        outputStream2.close();
	    	out.write("上传成功");
	    	out.flush();
	    	out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 将用户的头像列表信息返回到适配界面
	 * @param mav
	 * @param session
	 * @return mav
	 */
	@RequestMapping("/imgShow")
	public ModelAndView showImage(ModelAndView mav,HttpSession session){
		User user = (User) session.getAttribute("user");
		List<Image> images=imageService.getImageByUserId(user.getId());
		mav.addObject("images",images);
		mav.setViewName("shipei");
		return mav;
	}
	
	@RequestMapping("/checkImage")
	public ModelAndView checkImage(ModelAndView mav,HttpSession session){
		String iName=null;
		User user  = (User) session.getAttribute("user");
		if(user!=null){
			iName = imageService.findName(user.getId());
			if(iName==null){
				mav.addObject("username",user.getName());
				mav.setViewName("camera");
				return mav;
			}
			mav.addObject("imageName",iName);
			mav.addObject("username",user.getName());
			mav.setViewName("check");
		}else{	
			mav.setViewName("login");
		}
		return mav;
	}
	
}
