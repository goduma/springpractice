package com.nec.jimba.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nec.jimba.sample.domain.SampleException;
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
	public List<User> SelectCurl(int tempId) {
		List<User> list = userMapper.selectId(tempId);
		
		return list;
		// TODO Auto-generated method stub
		
	}
	@Override
	public void insertUserList() {
		User user = new User();
	
		userMapper.insert(user);//mapperの呼び出し
	
}
	@Override
	public void insertCurl(User user) throws SampleException {
			if(user.getName().trim()=="")
				throw new SampleException(400,"nameが未入力です。");
			else
				userMapper.insert(user);//mapperの呼び出し
	}
	@Override
	public void updateCurl(User user) {
		userMapper.update(user);//mapperの呼び出し
		
	}
	@Override
	public void deleteCurl() {
		userMapper.delete();
		// TODO Auto-generated method stub
		
	}
	
}