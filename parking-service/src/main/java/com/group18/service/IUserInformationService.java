package com.group18.service;

import com.group18.po.User;
import com.group18.po.UserInformation;

public interface IUserInformationService {
	public void register(UserInformation userInformation);//注册导入销售方信息
	public void update(UserInformation userInformation);//修改销售方信息
	public UserInformation findById(User user);//根据销售方id查找销售方信息
}
