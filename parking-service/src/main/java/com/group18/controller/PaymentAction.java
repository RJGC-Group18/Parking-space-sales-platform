package com.group18.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.group18.po.Client;
import com.group18.po.ClientInformation;
import com.group18.po.Dealing;
import com.group18.po.Parking;
import com.group18.po.Payment;
import com.group18.po.Reservation;
import com.group18.po.User;
import com.group18.po.UserInformation;
import com.group18.service.ClientInformationService;
import com.group18.service.ClientService;
import com.group18.service.DealingService;
import com.group18.service.PaymentService;
import com.group18.service.ReservationService;
import com.group18.service.UserInformationService;
import com.group18.service.UserService;

public class PaymentAction {
	Payment payment;
	PaymentService paymentService=null;
	Dealing dealing;
	DealingService dealingService=null;
	ReservationService reservationService=null;
	ClientService clientService=null;
	UserService userService=null;
	ClientInformationService clientInformationService=null;
	UserInformationService userInformationService=null;
	String no;
	HttpServletRequest request;
	HttpSession session;
	public PaymentAction()
	{
		request= ServletActionContext.getRequest();
		session = request.getSession();
	}
	public String lookPayment()
	{
		try
		{
			payment=(Payment) session.getAttribute("payment");
			return "success";
		}
		catch(Exception e)
		{
			return "failed";
		}
	}
	public String findDealing()//查找交易信息和其支付信息
	//（由于设计缺陷，事实上只用payment反而方便展示交易信息）
	{
		try
		{
			session.removeAttribute("msg");
			int noInt=Integer.parseInt(no);
			dealing=new Dealing();
			dealing.setNo(noInt);
			dealing=dealingService.findByNo(dealing);
			payment=paymentService.findByNo(dealing);
			payment.setDealing(dealing);
			
			Client client=payment.getClient();
			client=clientService.findById(client);
			ClientInformation clientInformation=clientInformationService.findById(client);
			client.setClientInformation(clientInformation);
			payment.setClient(client);
			
			User user=payment.getUser();
			user=userService.findById(user);
			UserInformation userInformation=userInformationService.findById(user);
			user.setUserInformation(userInformation);
			payment.setUser(user);
			
			session.setAttribute("payment", payment);
			return "success";
		}
		catch(Exception e)
		{
			session.setAttribute("msg", e.getMessage());
			return "failed";
		}
	}
	public String pay()//支付（请在支付页面的表单中包含dealing.no传递交易id以及使用payment.paid传递当前支付金额）
	{
		try
		{
			session.removeAttribute("msg");
			dealing=new Dealing();
			dealing.setNo(payment.getId().getNo());
			dealing=dealingService.findByNo(dealing);
			Payment oldPayment=paymentService.findByNo(dealing);
			BigDecimal Unpaid=oldPayment.getUnpaid().add(payment.getPaid().negate());//Unpaid=oldPayment.unpaid-payment.paid
			if(Unpaid.compareTo(new BigDecimal(0))>=0)//如果成立则说明能支付
			{
				oldPayment.setPaid(oldPayment.getPaid().add(payment.getPaid()));
				oldPayment.setTime(new Date());
				oldPayment.setUnpaid(Unpaid);
				
				if(Unpaid.compareTo(new BigDecimal(0))==0)//如果钱正好支付完
				{
					Dealing dealing=oldPayment.getDealing();
					oldPayment.setPay(true);
					dealing.setPay(true);
					oldPayment.setDeadline(null);
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
				session.setAttribute("msg", "成功支付"+payment.getPaid()+"元");
				return "success";
			}
			else
			{
				session.setAttribute("msg", "支付量超出需支付的金额");
				return "failed";
			}
		}
		catch(Exception e)
		{
			session.setAttribute("msg", e.getMessage());
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
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public ClientService getClientService() {
		return clientService;
	}
	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public ClientInformationService getClientInformationService() {
		return clientInformationService;
	}
	public void setClientInformationService(ClientInformationService clientInformationService) {
		this.clientInformationService = clientInformationService;
	}
	public UserInformationService getUserInformationService() {
		return userInformationService;
	}
	public void setUserInformationService(UserInformationService userInformationService) {
		this.userInformationService = userInformationService;
	}
}
