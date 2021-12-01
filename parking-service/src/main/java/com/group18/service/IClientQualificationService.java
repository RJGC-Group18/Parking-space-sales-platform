package com.group18.service;

import java.util.List;

import com.group18.po.Client;
import com.group18.po.ClientQualification;

public interface IClientQualificationService {
	public void add(ClientQualification clientQualification);//添加业主资质信息
	public void update(ClientQualification clientQualification);//更新业主资质信息
	public void delete(ClientQualification clientQualification);//删除业主资质信息
	public List<ClientQualification> findByCid(Client client);//通过业主id查找业主资质信息
	public ClientQualification findByQid(ClientQualification clientQualification);//通过业主资质id查找业主资质信息信息
}
