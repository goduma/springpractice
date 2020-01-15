package com.nec.jimba.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.nec.jimba.sample.domain.User;


@Mapper
@Component
public interface UserMapper {
	List<User> selectAll();
	
	void insert(User user);
	
	void update(User user);
	
}

