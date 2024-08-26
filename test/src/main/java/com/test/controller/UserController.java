package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.entity.User;
import com.test.service.UserService;

@Controller
public class UserController {
	
	//@Autowired：实例化UserService类
		@Autowired
		private UserService userservice;
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "热更新1234";		
	}
	
	@RequestMapping("/tc")
	public String tc(Model model) {
		model.addAttribute("name", "tangcheng");
		model.addAttribute("age", 20);
		return "tc";
	}
	
	@RequestMapping("/selectUserList")
	public String queryUserList(Model model){
		//1.调用业务方法
		List<User> list= userservice.listUser();
		//2.把查询的用户集合信息
		//通过model的addAttribute方法，把list集合值传给前端页面
		//model.addAttribute("前端接收的变量名", "结果值");
		model.addAttribute("userList", list);
		//3.返回到页面
		return "userlist";
	}

}
