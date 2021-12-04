package com.group18.dao;

import java.util.List;

import com.group18.po.Payment;

public interface IPaymentDAO {
	public List findByHql(String hql);
	public void save(Payment payment);//添加支付信息
	public void update(Payment payment);//修改支付信息
	public void delete(Payment payment);//删除支付信息
}
