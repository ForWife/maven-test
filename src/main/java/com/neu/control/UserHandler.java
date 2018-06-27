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
//		1.�ļ��ϴ�
//		 	1.1����������1��ʱ���+�ļ�����2��UUID+�ļ���
		System.out.println(".....................UserHandler");
		
//		String fileName;
//			fileName = new String(upload.getOriginalFilename().getBytes("ISO-8859-1"),"UTF-8");
//			System.out.println("............"+fileName);
			String filename = System.currentTimeMillis()+upload.getOriginalFilename();
			System.out.println(filename);
//			1.2�ļ�������� ���ڵ��Ǹ�Ǯ����ͬ��Ŀ¼��
//		��ǰ·��
			String path = request.getServletContext().getRealPath("/");
			System.out.println("...............path:"+path);
			File f = new File(path);
//		�õ���һ��·��
			String ppath = f.getParent();
			System.out.println("..............ppath"+ppath+"����������������һ��·��");
//			1.3��ʱ->Ŀ��һ
			System.out.println("..............."+ppath+"/upload");
			File dest = new File(ppath+"/upload",filename);
			try {
				upload.transferTo(dest);
				request.setAttribute("msg", "�ɹ�");
			} catch (IllegalStateException | IOException e) {
				request.setAttribute("msg", "ʧ��");
				e.printStackTrace();
			}
			
		
		return "forward:/msg.jsp";
	}
	@RequestMapping(value="/test/uploadajax")
	@ResponseBody
	public String uploadajax(String username,String pwd,MultipartFile upload,HttpServletRequest request){
//		1.�ļ��ϴ�
//		 	1.1����������1��ʱ���+�ļ�����2��UUID+�ļ���
		System.out.println(".....................UserHandler");
		System.out.println(".................."+username);
//		String fileName;
//			fileName = new String(upload.getOriginalFilename().getBytes("ISO-8859-1"),"UTF-8");
//			System.out.println("............"+fileName);
		String filename = System.currentTimeMillis()+upload.getOriginalFilename();
		System.out.println(filename);
//			1.2�ļ�������� ���ڵ��Ǹ�Ǯ����ͬ��Ŀ¼��
//		��ǰ·��
		String path = request.getServletContext().getRealPath("/");
		System.out.println("...............path:"+path);
		File f = new File(path);
//		�õ���һ��·��
		String ppath = f.getParent();
		System.out.println("..............ppath"+ppath+"����������������һ��·��");
//			1.3��ʱ->Ŀ��һ
		System.out.println("..............."+ppath+"/upload");
		File dest = new File(ppath+"/upload",filename);
		try {
			upload.transferTo(dest);
			request.setAttribute("msg", "�ɹ�");
		} catch (IllegalStateException | IOException e) {
			request.setAttribute("msg", "ʧ��");
			e.printStackTrace();
		}
		
		
		return "{\"result\":\"����ɹ�\"}";
	}
}
