package com.nec.jimba.sample.controller;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nec.jimba.sample.domain.SampleException;
import com.nec.jimba.sample.domain.User;
import com.nec.jimba.sample.form.UserForm;
//import com.nec.jimba.sample.service.GetUserListService;
import com.nec.jimba.sample.service.GetUserListServiceImpl;


@RestController
public class GetUserJsonController {
	
	@Autowired
	GetUserListServiceImpl getUserListServiceImpl;
	
	@ModelAttribute
	public UserForm setUserForm() {
		return new UserForm();
	};
	
	@RequestMapping("/")//jsonのリクエストにマッピング
	public String index() {
		return "Hello World";
		
	}

	//DBの値を参照
	@RequestMapping("/user")//jsonのリクエストにマッピング
	public List<User> json() {
		List<User> list = new ArrayList<User>();
		list = getUserListServiceImpl.getUserList();//serviceの呼び出し
		return list;
	}
	
	//curlのPostの入力値でDBを検索
			//結果の表示
			@RequestMapping(value="/CurlSelect",method=RequestMethod.POST)//jsonのリクエストにマッピング
			public ResponseEntity<List<User>> CurlSelect(@RequestBody int tempId) { 
				List<User> selectUser = new ArrayList<User>();
				  selectUser = getUserListServiceImpl.SelectCurl(tempId);//serviceの呼び出し
				 HttpHeaders headers = new HttpHeaders();
			      //headers.add("header1", "heaer1-value");
			      //HttpStatus status = HttpStatus.NOT_FOUND;
			        return ResponseEntity.ok()
			        		.headers(headers)
			        		.body(selectUser);
			}
	
	//curlのPostの入力値をDBに挿入
		//結果の表示
		@RequestMapping(value="/CurlInsert",method=RequestMethod.POST)//jsonのリクエストにマッピング
		public ResponseEntity<String> CurlInsert(@RequestBody User user) {
			String body = "登録しました";
			 HttpHeaders headers = new HttpHeaders();
		        headers.add("header1", "heaer1-value");
		        HttpStatus status = HttpStatus.CREATED;
		        
			try{
				getUserListServiceImpl.insertCurl(user);//serviceの呼び出し
			}catch(SampleException e) {
				e.printStackTrace();
					body = e.getMessage();
					status = HttpStatus.BAD_REQUEST;
			}
			 
		        return new ResponseEntity<>(body, headers, status);
		}
		
	//curlのPutの入力値でDBを更新
		@RequestMapping(value="/CurlUpdate",method=RequestMethod.PUT)
		public ResponseEntity<String> CurlUpdate(@RequestBody User user) {
			getUserListServiceImpl.updateCurl(user);//serviceの呼び出し
			HttpHeaders headers = new HttpHeaders();
	        headers.add("header1", "heaer1-value");
	        HttpStatus status = HttpStatus.OK;
	        return new ResponseEntity<>("更新しました", headers, status);
		}
		
	//deleteでテーブルデータを削除
		@RequestMapping(value="/CurlDelete",method=RequestMethod.DELETE)
		public ResponseEntity<String> CurlDelete() {;//serviceの呼び出し
			HttpHeaders headers = new HttpHeaders();
	        headers.add("header1", "heaer1-value");
	        HttpStatus status = HttpStatus.OK;
	        return new ResponseEntity<>("削除しました", headers, status);
		}
	
	
	/*
	//以下、画面からの入力値を操作
	//初期ページを表示
	@RequestMapping(value="/index",method=RequestMethod.GET)//jsonのリクエストにマッピング
	public String displayAdd() {
		
		//表示するhtml
		return "userAdd";f
	}
	
	//初期ページの値をDBに挿入
	//結果の表示
	@RequestMapping(value="/userInsert",method=RequestMethod.POST)//jsonのリクエストにマッピング
	public String userInsert(@ModelAttribute("userForm")UserForm userForm,Model model) {
		 getUserListServiceImpl.insertUserList();//serviceの呼び出し
		 model.addAttribute("form",userForm);
		 
		 return "result";
	}
	*/
}
