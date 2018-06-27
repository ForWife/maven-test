package com.neu.control;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UserHandler {
	
	@RequestMapping(value="/test/upload")
	public String upload(String username,String pwd,MultipartFile upload,HttpServletRequest request){
//		1.文件上传
//		 	1.1重命名：（1）时间戳+文件名（2）UUID+文件名
		System.out.println(".....................UserHandler");
		
//		String fileName;
//			fileName = new String(upload.getOriginalFilename().getBytes("ISO-8859-1"),"UTF-8");
//			System.out.println("............"+fileName);
			String filename = System.currentTimeMillis()+upload.getOriginalFilename();
			System.out.println(filename);
//			1.2文件传到哪里： 放在但那个钱工程同级目录下
//		当前路径
			String path = request.getServletContext().getRealPath("/");
			System.out.println("...............path:"+path);
			File f = new File(path);
//		得到上一级路径
			String ppath = f.getParent();
			System.out.println("..............ppath"+ppath+"。。。。。这是上一级路径");
//			1.3临时->目的一
			System.out.println("..............."+ppath+"/upload");
			File dest = new File(ppath+"/upload",filename);
			try {
				upload.transferTo(dest);
				request.setAttribute("msg", "成功");
			} catch (IllegalStateException | IOException e) {
				request.setAttribute("msg", "失败");
				e.printStackTrace();
			}
			
		
		return "forward:/msg.jsp";
	}
	@RequestMapping(value="/test/uploadajax")
	@ResponseBody
	public String uploadajax(String username,String pwd,MultipartFile upload,HttpServletRequest request){
//		1.文件上传
//		 	1.1重命名：（1）时间戳+文件名（2）UUID+文件名
		System.out.println(".....................UserHandler");
		System.out.println(".................."+username);
//		String fileName;
//			fileName = new String(upload.getOriginalFilename().getBytes("ISO-8859-1"),"UTF-8");
//			System.out.println("............"+fileName);
		String filename = System.currentTimeMillis()+upload.getOriginalFilename();
		System.out.println(filename);
//			1.2文件传到哪里： 放在但那个钱工程同级目录下
//		当前路径
		String path = request.getServletContext().getRealPath("/");
		System.out.println("...............path:"+path);
		File f = new File(path);
//		得到上一级路径
		String ppath = f.getParent();
		System.out.println("..............ppath"+ppath+"。。。。。这是上一级路径");
//			1.3临时->目的一
		System.out.println("..............."+ppath+"/upload");
		File dest = new File(ppath+"/upload",filename);
		try {
			upload.transferTo(dest);
			request.setAttribute("msg", "成功");
		} catch (IllegalStateException | IOException e) {
			request.setAttribute("msg", "失败");
			e.printStackTrace();
		}
		
		
		return "{\"result\":\"传输成功\"}";
	}
}
