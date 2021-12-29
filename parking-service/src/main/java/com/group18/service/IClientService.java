package com.group18.service;

import java.util.List;

import com.group18.po.Client;

public interface IClientService {
	public boolean loginInfoCheck(Client client);//登录信息检查
	public void register(Client client);//业主注册
	public void update(Client client);//业主登录信息修改
	public Client findByName(Client client);//根据业主名字查找业主登录信息
	public Client findById(Client client);//根据业主id查找业主登录信息
	public List<Client> findAll();//查找所有业主信息
}
