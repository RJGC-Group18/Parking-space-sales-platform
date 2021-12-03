package com.group18.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.group18.po.Client;
import com.group18.po.ClientQualification;
import com.group18.service.ClientQualificationService;
import com.group18.service.ClientService;

public class ClientAction {
	private Client client;
	private ClientService clientService=null;
	private List<ClientQualification> clientQualificationList;
	private ClientQualificationService clientQualificationService=null;
	HttpServletRequest request;
	HttpSession session;
	public ClientAction()
	{
		request= ServletActionContext.getRequest();
		session = request.getSession();
	}
	public String login()//登录
	{
		if(clientService.loginInfoCheck(client))
		{
			session.setAttribute("client", client);
			return "success";
		}
		else
		{
			return "failed";
		}
	}
	public String loginOut()//登出
	{
		session.removeAttribute("client");
		return"success";
	}
	public String register()//注册
	{
		try
		{
			clientService.register(client);
		}
		catch(Exception e)
		{
			return "failed";
		}
		session.setAttribute("client", client);
		return "success";
	}
	public String lookClient()//查看业主信息
	{
		try
		{
			Client inClient=(Client) session.getAttribute("client");
			client=clientService.findById(inClient);
			return "success";
		}
		catch(Exception e)
		{
			return "failed";
		}
	}
	public String lookClientQualification()//查看业主资质信息
	{
		try
		{
			clientQualificationList=clientQualificationService.findByCid(client);
			return "success";
		}
		catch(Exception e)
		{
			return "failed";
		}
	}
	public String update()//更新业主信息
	{
		try
		{
			clientService.update(client);
			return "success";
		}
		catch(Exception e)
		{
			return "failed";
		}
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public ClientService getClientService() {
		return clientService;
	}
	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}
	public List<ClientQualification> getClientQualificationList() {
		return clientQualificationList;
	}
	public void setClientQualificationList(List<ClientQualification> clientQualificationList) {
		this.clientQualificationList = clientQualificationList;
	}
	public ClientQualificationService getClientQualificationService() {
		return clientQualificationService;
	}
	public void setClientQualificationService(ClientQualificationService clientQualificationService) {
		this.clientQualificationService = clientQualificationService;
	}
}