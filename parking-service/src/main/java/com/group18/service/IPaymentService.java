package com.group18.service;

import com.group18.po.Client;
import com.group18.po.Dealing;
import com.group18.po.Parking;
import com.group18.po.Payment;

public interface IPaymentService {
	public Payment findByCidAndPid(Client client,Parking parking);//根据用户id和车位id查找支付记录
	public Payment findByNo(Dealing dealing);//根据交易记录id查找支付记录
	public boolean checkPay(Payment payment);//检查是否支付了
	public void add(Payment payment);//添加支付记录
	public void update(Payment payment);//更新支付记录
	public void delete(Payment payment);//删除支付记录
	
}
