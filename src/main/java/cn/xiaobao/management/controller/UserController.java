package cn.xiaobao.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xiaobao.management.entity.User;
import cn.xiaobao.management.mapper.UserMapper;
import cn.xiaobao.management.util.JsonResult;

@RequestMapping("user")
@Controller
public class UserController {
	@Autowired
	UserMapper usermapper;
	@RequestMapping("handle_login.do")
	@ResponseBody
	public JsonResult<Void> handleLogin(String username,String password) {
		//创建一个JSON返回对象
		JsonResult<Void> jr = new JsonResult<Void>();
		//先根据用户名查询数据库返回一个结果Result
		User result = usermapper.findByUserName(username);
		//如果结果为空,则说明用户名不存在,返回数字0,并设置消息为用户名不存在
		if(result==null) {
			jr.setState(0);
			jr.setMessage("用户名不存在!");
		}else {
			//结果不为空,说明用户存在,再判断密码是否正确
			if(result.getUpassword().equals(password)) {
				//判断正确,登录成功,设置状态码为1
				jr.setState(1);
			}else {
				//判断错误,登录失败,设置状态码为-1,并设置消息为密码错误
				jr.setState(-1);
				jr.setMessage("密码错误!");
			}
		}
		return jr;
	}
}
