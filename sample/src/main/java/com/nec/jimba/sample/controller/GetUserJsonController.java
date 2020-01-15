package com.nec.jimba.sample.controller;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nec.jimba.sample.domain.User;
import com.nec.jimba.sample.form.UserForm;
//import com.nec.jimba.sample.service.GetUserListService;
import com.nec.jimba.sample.service.GetUserListServiceImpl;


@Controller
public class GetUserJsonController {
	List<String> testlist = new ArrayList<String>();
	
	@Autowired
	GetUserListServiceImpl getUserListServiceImpl;
	
	@ModelAttribute
	public UserForm setUserForm() {
		return new UserForm();
	};
	
	@ResponseBody
	@RequestMapping("/")//jsonのリクエストにマッピング
	public String index() {
		return "Hello World";
		
	}

/*
	@RequestMapping("/list")//jsonのリクエストにマッピング
	@ResponseBody
	public List<String> getjson() {
		
		setlist();
		return testlist;
		
	}
*/

	//DBの値を参照
	@RequestMapping("/user")//jsonのリクエストにマッピング
	@ResponseBody
	public List<User> json() {
		List<User> list = new ArrayList<User>();
		list = getUserListServiceImpl.getUserList();//serviceの呼び出し
		return list;
	}
	
	//curlのPostの入力値をDBに挿入
		//結果の表示
		@RequestMapping(value="/CurlInsert",method=RequestMethod.POST)//jsonのリクエストにマッピング
		public void CurlInsert(@RequestBody User user) {
			getUserListServiceImpl.insertCurl(user);//serviceの呼び出し 		 
		}
		
	//curlのPutの入力値でDBを更新
		@RequestMapping(value="/CurlUpdate",method=RequestMethod.PUT)
		public void CurlUpdate(@RequestBody User user) {
			getUserListServiceImpl.updateCurl(user);//serviceの呼び出し 
		}
	//deleteでテーブルデータを削除
	
	
	
	//以下、画面からの入力値を操作
	//初期ページを表示
	@RequestMapping(value="/index",method=RequestMethod.GET)//jsonのリクエストにマッピング
	public String displayAdd() {
		
		//表示するhtml
		return "userAdd";
	}
	
	//初期ページの値をDBに挿入
	//結果の表示
	@RequestMapping(value="/userInsert",method=RequestMethod.POST)//jsonのリクエストにマッピング
	public String userInsert(@ModelAttribute("userForm")UserForm userForm,Model model) {
		 getUserListServiceImpl.insertUserList();//serviceの呼び出し
		 model.addAttribute("form",userForm);
		 
		 return "result";
	}
}
