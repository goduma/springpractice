package com.nec.jimba.sample.controller;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nec.jimba.sample.domain.User;
//import com.nec.jimba.sample.service.GetUserListService;
import com.nec.jimba.sample.service.GetUserListServiceImpl;


@RestController
public class GetUserJsonController {
	List<String> testlist = new ArrayList<String>();
	
	@Autowired
	GetUserListServiceImpl getUserListServiceImpl;
	
	
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
		List<User> list = new ArrayList<User>();
		
		list = getUserListServiceImpl.getUserList();//serviceの呼び出し
	    
		return list;
	}
	
	@RequestMapping(value="/submit")//jsonのリクエストにマッピング
	public void userinsert() {
		
		 getUserListServiceImpl.insertUserList();//serviceの呼び出し
	}

	private List<String> setlist() {
		
		testlist.add("test");
		testlist.add("test2");
		return testlist;
	}
	
}
