package com.nec.jimba.sample.service;

import com.nec.jimba.sample.domain.User;
import java.util.List;

public interface GetUserListService {
	
	List<User> getUserList();
	
	List<User> SelectCurl(int tempId);
	
	void insertUserList();
	
	void insertCurl(User user);
	
	void updateCurl(User user);


}
