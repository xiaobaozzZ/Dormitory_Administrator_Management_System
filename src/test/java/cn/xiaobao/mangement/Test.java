package cn.xiaobao.mangement;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.xiaobao.management.entity.User;
import cn.xiaobao.management.mapper.UserMapper;

public class Test {
	public static void main(String[] args) {
		//加载Spring配置文件,获取Spring容器
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		//获取UserMapper对象
		UserMapper usermapper = ac.getBean("userMapper", UserMapper.class);
		//调用Usermapper对象的方法
		User user = usermapper.findByUserName("小宝");
		//输出数据
		System.out.println("Begin");
		System.out.println(user);
		System.out.println("End");
		//释放资源
		ac.close();
	}
}
