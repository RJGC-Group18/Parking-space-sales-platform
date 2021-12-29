package com.group18.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.group18.po.Client;
import com.group18.po.Dealing;
import com.group18.po.Payment;
import com.group18.po.User;
import com.group18.service.DealingService;
import com.group18.service.PaymentService;

public class DealingAction {
	Dealing dealing;
	List<Dealing> dealingList;
	DealingService dealingService=null;
	PaymentService paymentService=null;
	String no;
	HttpServletRequest request;
	HttpSession session;
	public DealingAction()
	{
		request= ServletActionContext.getRequest();
		session = request.getSession();
	}
	public String findAllByClient()//查找一个业主所有的交易信息
	{
		try
		{
			session.removeAttribute("msg");
			Client client=(Client) session.getAttribute("client");
			dealingList=dealingService.findByCid(client);
			return "success";
		}
		catch(Exception e)
		{
			return "failed";	
		}
	}
	
	public String findAllByUser()//查找一个销售方所有的交易信息
	{
		try
		{
			session.removeAttribute("msg");
			User user=(User)session.getAttribute("user");
			if(user.getIdentity())
			{
				dealingList=dealingService.findAll();
			}
			else
			{
				dealingList=dealingService.findByUid(user);
			}
			return "success";
		}
		catch(Exception e)
		{
			return "failed";
		}
	}
	public String find()//查找单个交易的具体信息
	{
		try
		{
			dealing=dealingService.findByNo(dealing);
			return "success";
		}
		catch(Exception e)
		{
			return "failed";
		}
	}
	public String update()//更新交易信息
	{
		try
		{
			dealingService.update(dealing);
			return "success";
		}
		catch(Exception e)
		{
			return "failed";	
		}
	}
	public String delete()//删除交易信息
	{
		try
		{
			session.removeAttribute("msg");
			int noInt=Integer.parseInt(no);
			dealing=new Dealing();
			dealing.setNo(noInt);
			dealing=dealingService.findByNo(dealing);
			Payment payment=paymentService.findByNo(dealing);
			paymentService.delete(payment);
			dealingService.delete(dealing);
			session.setAttribute("msg", "删除成功");
			if(session.getAttribute("client")==null)
			{
				findAllByUser();
			}
			else
			{
				findAllByClient();
			}
			return "success";
		}
		catch(Exception e)
		{
			session.setAttribute("msg", e.getMessage());
			return "failed";	
		}
	}
	
	public Dealing getDealing() {
		return dealing;
	}
	public void setDealing(Dealing dealing) {
		this.dealing = dealing;
	}
	public List<Dealing> getDealingList() {
		return dealingList;
	}
	public void setDealingList(List<Dealing> dealingList) {
		this.dealingList = dealingList;
	}
	public DealingService getDealingService() {
		return dealingService;
	}
	public void setDealingService(DealingService dealingService) {
		this.dealingService = dealingService;
	}
	public PaymentService getPaymentService() {
		return paymentService;
	}
	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	
}
