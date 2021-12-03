package com.group18.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.group18.po.Dealing;
import com.group18.po.Parking;
import com.group18.po.Payment;
import com.group18.po.Reservation;
import com.group18.service.DealingService;
import com.group18.service.PaymentService;
import com.group18.service.ReservationService;

public class PaymentAction {
	Payment payment;
	PaymentService paymentService=null;
	Dealing dealing;
	DealingService dealingService=null;
	ReservationService reservationService=null;
	HttpServletRequest request;
	HttpSession session;
	public PaymentAction()
	{
		request= ServletActionContext.getRequest();
		session = request.getSession();
	}
	public String find()//查找交易的支付信息
	{
		try
		{
			payment=paymentService.findByNo(dealing);
			return "success";
		}
		catch(Exception e)
		{
			return "failed";
		}
	}
	public String pay()//支付（请在支付页面的表单中包含dealing.no传递交易id以及使用payment.paid传递当前支付金额）
	{
		try
		{
			Payment oldPayment=paymentService.findByNo(dealing);
			BigDecimal Unpaid=oldPayment.getUnpaid().add(payment.getPaid().negate());//Unpaid=oldPayment.unpaid-payment.paid
			if(Unpaid.compareTo(new BigDecimal(0))<0)//如果成立则说明能支付
			{
				oldPayment.setPaid(oldPayment.getPaid().add(Unpaid));
				oldPayment.setTime(new Date());
				oldPayment.setUnpaid(oldPayment.getUnpaid().add(Unpaid.negate()));//oldPayment.unpaid=oldPayment.unpaid-Unpaid
				
				if(Unpaid.compareTo(new BigDecimal(0))==0)//如果钱正好支付完
				{
					Dealing dealing=oldPayment.getDealing();
					oldPayment.setPay(true);
					dealing.setPay(true);
				}
				paymentService.update(oldPayment);
				dealingService.update(dealing);
				
				if(Unpaid.compareTo(new BigDecimal(0))==0)//如果交易成功，删除剩下的预定信息
				{
					Parking parking=dealing.getParking();
					List<Reservation> reservationList=reservationService.findByPid(parking);
					for(Reservation reservation:reservationList)
					{
						reservationService.delete(reservation);
					}
				}
				return "success";
			}
			else
			{
				return "failed";
			}
		}
		catch(Exception e)
		{
			return "failed";
		}
	}
	
	public String delete()//删除超时支付的支付信息以及交易信息，暂不实现
	{
		return "failed";
	}
	
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public PaymentService getPaymentService() {
		return paymentService;
	}
	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	public Dealing getDealing() {
		return dealing;
	}
	public void setDealing(Dealing dealing) {
		this.dealing = dealing;
	}
	public DealingService getDealingService() {
		return dealingService;
	}
	public void setDealingService(DealingService dealingService) {
		this.dealingService = dealingService;
	}
	public ReservationService getReservationService() {
		return reservationService;
	}
	public void setReservationService(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
}
