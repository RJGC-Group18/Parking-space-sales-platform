package com.group18.service;

import java.util.List;

import com.group18.po.Client;
import com.group18.po.Parking;
import com.group18.po.User;

public interface IParkingService {
	public List<Parking>findAll();//查找没进入交易确认阶段的所有车位信息
	public List<Parking>findByClient(Client client);//返回所有的车位信息（要求车位不在交易表和用户的预约表中）
	public List<Parking>fingByUid(User user);//根据销售方id查找车位信息
	public Parking findByPid(Parking parking);//根据车位id查找车位信息
	public void add(Parking parking);//添加车位信息
	public void update(Parking parking);//更新车位信息
	public void delete(Parking parking);//删除车位信息
}
