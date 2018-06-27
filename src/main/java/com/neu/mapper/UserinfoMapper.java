package com.neu.mapper;

import java.util.List;
import com.neu.po.Userinfo;

public interface UserinfoMapper {
	public List<Userinfo> findAll() throws Exception;
	public int addUser(Userinfo userinfo) throws Exception;
}