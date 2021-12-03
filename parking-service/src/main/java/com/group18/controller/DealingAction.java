package com.group18.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.group18.po.Client;
import com.group18.po.Dealing;
import com.group18.po.User;
import com.group18.service.DealingService;

public class DealingAction {
	Dealing dealing;
	List<Dealing> dealingList;
	DealingService dealingService=null;
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
			User user=(User)session.getAttribute("user");
			dealingList=dealingService.findByUid(user);
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
			dealingService.delete(dealing);
			return "success";
		}
		catch(Exception e)
		{
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
	
}
