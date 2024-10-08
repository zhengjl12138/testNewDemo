package com.test.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.User;
import com.test.mapper.UserMapper;
import com.test.service.UserService;


@Service  
public class UserServiceImpl implements UserService{
	//注入UserMapper
		@Autowired
		private UserMapper userMapper;
	
		
		public List<User> listUser() {
			//查询所有，调用usermapper中的查询方法listUser
			return userMapper.listUser();
		}
		//新增用户信息
		public Integer insertUser(User user) {
			//给时间赋值
			//调用usermapper中的新增方法insertUser
			return userMapper.insertUser(user);
		}
		
		public User queryByUsernameAndPassword(String username, String password) {
			//调用usermapper中的根据用户id查询用户信息的方法queryByUserId
			return userMapper.queryByUsernameAndPassword(username, password);
		}

		public Integer updateUser(User user) {
			//调用usermapper中的修改方法updateUser
			return userMapper.updateUser(user);
		}
		
		public Integer delete(Integer userId) {
			//调用usermapper中的删除方法delete
			return userMapper.delete(userId);
		}

}


