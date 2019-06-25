package cn.xiaobao.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("user")
@Controller
public class UserController {
	
	@RequestMapping("handle_login.do")
	public String handleLogin(String username,String password) {
		System.out.println("这个方法被调用了,配置正常,可以开始写代码了");
		return null;
	}
}
