package com.neu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.mapper.UserinfoMapper;
import com.neu.po.Userinfo;
import com.neu.service.UserinfoService;

@Service
public class UserinfoServiceBean implements UserinfoService {
	@Autowired
	UserinfoMapper userinfoMapper;
	
	@Override
	public List<Userinfo> findAll() {
		// TODO Auto-generated method stub
		System.out.println("....UserinfoServiceBean................findAll....");
		List<Userinfo> list;
		try {
			list = userinfoMapper.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			list = null;
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Boolean addUserinfo(Userinfo userinfo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("....UserinfoServiceBean................addUserinfo....");
		int count;
		boolean isOk;
		count=userinfoMapper.addUser(userinfo);
		if(count>0){
			isOk = true;
		}else{
			isOk = false;
		}
		return isOk;
	}

	@Override
	public Boolean saveUserinfo(Userinfo userinfo) throws Exception {
		// TODO Auto-generated method stub
		Userinfo e = new Userinfo();
		Boolean isOk;
		Integer.parseInt("s");
		
		e.setUser_name("lla");
		int count = userinfoMapper.addUser(e);
		if(count>0){
			isOk = true;
		}else{
			isOk = false;
		}
		return isOk;

	}

}
