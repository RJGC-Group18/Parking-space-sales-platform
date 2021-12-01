package com.group18.service;

import java.util.List;

import com.group18.dao.IPaymentDAO;
import com.group18.po.Client;
import com.group18.po.Dealing;
import com.group18.po.Parking;
import com.group18.po.Payment;

public class PaymentService implements IPaymentService {

	IPaymentDAO paymentDAO=null;
	
	public Payment findByCidAndPid(Client client, Parking parking) {
		String hql= "from Dealing where cid='" + String.valueOf(client.getCid())+
				"' and pid='"+ String.valueOf(parking.getPid())+"'";
		List list=paymentDAO.findByHql(hql);
		if(list.isEmpty())
		{
			return null;
		}
		return (Payment)list.get(0);
	}

	public Payment findByNo(Dealing dealing) {
		String hql= "from Payment where no='" + String.valueOf(dealing.getNo())+"'";
		List list=paymentDAO.findByHql(hql);
		if(list.isEmpty())
		{
			return null;
		}
		return (Payment)list.get(0);
	}
	
	public boolean checkPay(Payment payment) {
		Payment findPayment=findByNo(payment.getDealing());
		if(findPayment.getPay())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void add(Payment payment) {
		paymentDAO.save(payment);
	}

	public void update(Payment payment) {
		paymentDAO.update(payment);
	}

	public void delete(Payment payment) {
		paymentDAO.delete(payment);
	}

	public IPaymentDAO getPaymentDAO() {
		return paymentDAO;
	}

	public void setPaymentDAO(IPaymentDAO paymentDAO) {
		this.paymentDAO = paymentDAO;
	}

}
