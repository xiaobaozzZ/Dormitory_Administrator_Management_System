package cn.xiaobao.management.mapper;

import java.util.List;

import cn.xiaobao.management.entity.User;

public interface UserMapper {
	List<User> findAllUser();
}
