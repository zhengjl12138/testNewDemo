package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.entity.ResultResponse;
import com.test.entity.User;
import com.test.service.impl.UserServiceImpl;
//import com.test.utils.TokenRequired;

@Controller
public class UserController {

	// @Autowired：实例化UserService类
	@Autowired
	private UserServiceImpl userServiceImpl;

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

//	@TokenRequired
	@RequestMapping("/selectUserList")
	@ResponseBody
	public ResultResponse<Object> queryUserList() {
		// 1.调用业务方法
		List<User> list = userServiceImpl.listUser();
		// 2.把查询的用户集合信息
		// 通过model的addAttribute方法，把list集合值传给前端页面
		// model.addAttribute("前端接收的变量名", "结果值");
		ResultResponse<List<User>> result = new ResultResponse<List<User>>();
		// 3.返回到页面
		return result.builder().code(0).message("获取列表成功").data(list).build();
	}

	@RequestMapping("/loginUser")
	public String loginUser(Model model) {
		model.addAttribute("params", new Params());
		return "login";
	}

	@RequestMapping("/showJwt")
	public String showJwt() {
		return "showJwt";
	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

//	@RequestMapping(value="/login", method = RequestMethod.POST)
//	@ResponseBody
//	public User login(@ModelAttribute("params") Params params) {
//		
//		System.out.println("账号：" + params.getUsername());
//		System.out.println("用户信息：" + userServiceImpl.queryByUsernameAndPassword(params.getUsername(), params.getPassword()));
//		
//		User user = userServiceImpl.queryByUsernameAndPassword(params.getUsername(), params.getPassword());
//		
//		return user;
//	}

	public class Params {
		private String username;
		private String password;

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

	}

//	@GetMapping("/form")
//    public String showForm(Model model) {
//        model.addAttribute("formData", new FormData());
//        return "form";
//    }

	@PostMapping("/submit")
	@ResponseBody
	public String submitForm(@ModelAttribute("formData") FormData formData) {
		// 处理表单提交的数据
		// 可以将数据保存到数据库或执行其他操作

		System.out.print("请求参数:" + formData.getEmail() + formData.getName());
		return "success";
	}

	public class FormData {

		private String name;
		private String email;

		// 添加getter和setter方法

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
	}

}
