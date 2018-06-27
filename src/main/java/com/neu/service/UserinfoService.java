package com.neu.service;

import java.util.List;

import com.neu.po.Userinfo;

public interface UserinfoService {
	public List<Userinfo> findAll();
	public Boolean addUserinfo(Userinfo userinfo) throws Exception;
	public Boolean saveUserinfo(Userinfo userinfo) throws Exception;
	
}
