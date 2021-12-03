package com.group18.service;

import java.util.List;

import com.group18.po.Client;
import com.group18.po.Dealing;
import com.group18.po.Parking;

public interface IDealingService {
	public Dealing findByCidAndPid(Client client,Parking parking);//根据业主id和车位id查找交易信息
	public List<Dealing> findByCid(Client client);//根据业主id查找交易信息
	public Dealing findByNo(Dealing dealing);//根据交易id查找交易信息
	public boolean checkDealing(Dealing dealing);//检查交易是否完成
	public void add(Dealing dealing);//添加交易信息
	public void update(Dealing dealing);//更新交易信息
	public void delete(Dealing dealing);//删除交易信息
}
