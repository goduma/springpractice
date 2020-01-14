package com.nec.jimba.demo.controller;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nec.jimba.demo.domain.User;
import com.nec.jimba.demo.mapper.UserMapper;


@RestController
public class GetUserJsonController {
	
	@Autowired//インスタンスの生成
	User user;
	@Autowired
	UserMapper userMapper;
	
	List<String> testlist = new ArrayList<String>();
	
	
	
	@RequestMapping("/")//jsonのリクエストにマッピング
	public String index() {
		return "Hello World";
		
	}

	
	@RequestMapping("/list")//jsonのリクエストにマッピング
	@ResponseBody
	public List<String> getjson() {
		
		setlist();
		return testlist;
		
	}
	

	@RequestMapping("/user")//jsonのリクエストにマッピング
	@ResponseBody
	public List<User> json() {
		List<User> list = userMapper.selectAll();//mapperの呼び出し
	    
		//return Arrays.asList(new User(1, "aaa",15), new User(2, "bbb",44));
		return list;
	}

	private List<String> setlist() {
		
		testlist.add("test");
		testlist.add("test2");
		return testlist;
	}
	
}
