package com.group18.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.group18.po.Client;
import com.group18.po.Dealing;
import com.group18.service.DealingService;

public class DealingAction {
	Dealing dealing;
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
			dealingService.findByCid(client);
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
}
