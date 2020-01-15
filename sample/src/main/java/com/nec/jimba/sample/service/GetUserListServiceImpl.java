package com.nec.jimba.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nec.jimba.sample.domain.User;
import com.nec.jimba.sample.mapper.UserMapper;

@Service
public class GetUserListServiceImpl implements GetUserListService {
	
	@Autowired
	UserMapper userMapper;
	
	
	@Override
	public List<User> getUserList() {
	
		List<User> list = userMapper.selectAll();//mapperの呼び出し
	
	return list;
}
	@Override
	public void insertUserList() {
		User user = new User();
	
		userMapper.insert(user);//mapperの呼び出し
	
}
	@Override
	public void insertCurl(User user) {
		
		userMapper.insert(user);//mapperの呼び出し
		
	}
	@Override
	public void updateCurl(User user) {
		userMapper.update(user);//mapperの呼び出し
		
	}
}