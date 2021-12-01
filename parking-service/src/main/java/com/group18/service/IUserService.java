package com.group18.service;

import com.group18.po.User;

public interface IUserService {
	public boolean loginInfoCheck(User user);//登录信息检查
	public void register(User user);//销售方注册
	public void update(User user);//销售方登录信息更新
	public User findByName(User user);//根据销售方名字查找销售方信息
	public User findById(User user);//根据销售方id查找销售方信息
}
