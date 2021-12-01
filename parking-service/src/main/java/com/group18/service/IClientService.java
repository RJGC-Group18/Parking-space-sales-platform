package com.group18.service;

import com.group18.po.Client;

public interface IClientService {
	public boolean loginInfoCheck(Client client);//登录信息检查
	public void register(Client client);//业主注册
	public Client findByName(Client client);//根据业主名字查找业主信息
	public Client findById(Client client);//根据业主id查找业主信息
}
