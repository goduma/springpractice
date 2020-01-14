package com.nec.jimba.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.nec.jimba.demo.domain.User;


@Mapper
@Component
public interface UserMapper {
	List<User> selectAll();
}
