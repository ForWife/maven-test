package com.neu.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.po.Userinfo;
import com.neu.service.UserinfoService;

@Controller
public class MyHandler {
	@Autowired
	UserinfoService userinfoService;
	
	@RequestMapping(value="/test/findAll")
	public String findAll(HttpServletRequest request){
		System.out.println("..........MyHandler.......findAll.");
		List<Userinfo> list = userinfoService.findAll();
		for(Userinfo u :list){
			System.out.println(u.getUser_id());
		}
		request.setAttribute("list", list);
		request.setAttribute("msg", "成功");
		return "forward:/msg.jsp";
	}
	
	@RequestMapping(value="/test/ajax.action")
	@ResponseBody
	public List<Userinfo> getAll(){
		System.out.println("........MyHandler...........getAll..");
		return userinfoService.findAll();
	}
	
	@RequestMapping(value="test/adduser")
//	@ResponseBody
	public String addUserinfo(Userinfo userinfo){
		try {
			userinfoService.addUserinfo(userinfo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(".......fail...........");
			return "{\"result\":\"保存失败\"}";
		}
		return "{\"result\":\"保存成功\"}";
	}
	
}
