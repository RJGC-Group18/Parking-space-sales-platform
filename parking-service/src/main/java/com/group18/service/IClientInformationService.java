package com.group18.service;

import com.group18.po.Client;
import com.group18.po.ClientInformation;

public interface IClientInformationService {
	public void register(ClientInformation clientInformation);//注册导入业主信息
	public void update(ClientInformation clientInformation);//修改业主信息
	public ClientInformation findById(Client client);//根据业主id查找业主信息
}
