package com.group18.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.group18.po.Client;
import com.group18.po.ClientInformation;
import com.group18.po.ClientQualification;
import com.group18.service.ClientQualificationService;
import com.group18.service.ClientService;

public class ClientAction {
	private Client client;
	private ClientQualification clientQualification;
	private ClientService clientService=null;
	private List<ClientQualification> clientQualificationList;
	private ClientQualificationService clientQualificationService=null;
	
	String birthday;
	String enterPassword;
	HttpServletRequest request;
	HttpSession session;
	
	public ClientAction()
	{
		request= ServletActionContext.getRequest();
		session = request.getSession();
	}
	
	public String login()//登录
	{
		try
		{
			if(clientService.loginInfoCheck(client))
			{
				client=clientService.findByName(client);
				session.setAttribute("client", client);
				session.removeAttribute("error");
				return "success";
			}
			else
			{
				session.setAttribute("error", "登录失败");
				return "failed";
			}
		}
		catch(Exception e)
		{
			session.setAttribute("error", e.getMessage());
			return "failed";
		}
		
	}
	
	public String loginOut()//登出
	{
		session.invalidate();
		return"success";
	}
	
	public String register()//注册
	{
		try
		{
			session.removeAttribute("msg");
			if(client.getPassword().equals(enterPassword))//如果新密码与确认密码输入都没问题
			{
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				ClientInformation clientInformation=client.getClientInformation();
				clientInformation.setClient(client);
				clientInformation.setBirthday(sf.parse(birthday));
				client.setClientInformation(clientInformation);
				/*clientQualification=new ClientQualification();
				clientQualification.setQualification(true);
				clientQualification.setClient(client);
				clientQualification.setImage(null);*/
				clientService.register(client);
				/*clientQualificationService.add(clientQualification);*/
				session.setAttribute("client", client);
				return "success";
			}
			else
			{
				session.setAttribute("msg","密码错误");
				return "failed";
			}
		}
		catch(Exception e)
		{
			session.setAttribute("msg",e.getMessage());
			return "failed";
		}
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
	
	public String changePassword()//修改密码
	{
		try
		{
			if(client.getPassword().equals(enterPassword))//如果新密码与确认密码输入都没问题
			{
				Client oldClient=(Client) session.getAttribute("client");
				System.out.println(client.getPassword());
				oldClient.setPassword(client.getPassword());
				clientService.update(oldClient);
				session.setAttribute("msg","密码修改成功");
				return "success";
			}
			session.setAttribute("msg","密码错误");
			return "failed";
		}
		catch(Exception e)
		{
			session.setAttribute("msg", e.getMessage());
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
	public String getEnterPassword() {
		return enterPassword;
	}
	public void setEnterPassword(String enterPassword) {
		this.enterPassword = enterPassword;
	}

	public ClientQualification getClientQualification() {
		return clientQualification;
	}

	public void setClientQualification(ClientQualification clientQualification) {
		this.clientQualification = clientQualification;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
}
