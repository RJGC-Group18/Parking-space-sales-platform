package com.group18.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.group18.po.Client;
import com.group18.po.ClientInformation;
import com.group18.po.ClientQualification;
import com.group18.service.ClientInformationService;
import com.group18.service.ClientQualificationService;
import com.group18.service.ClientService;

public class ClientAction {
	private Client client;
	private Client gClient;
	private List<Client> clientList;
	private ClientQualification clientQualification;
	private ClientService clientService=null;
	private List<ClientQualification> clientQualificationList;
	private ClientQualificationService clientQualificationService=null;
	private ClientInformationService clientInformationService=null;
	
	String cid;
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
				
				//以下部分计算年龄
				Calendar cal = Calendar.getInstance();
				if(cal.before(clientInformation.getBirthday()))
				{
					session.setAttribute("msg","出生日期在当前日期之后");
					return "failed";
				}
				int yearNow = cal.get(Calendar.YEAR);  //当前年份
		        int monthNow = cal.get(Calendar.MONTH);  //当前月份
		        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH); //当前日期
		        cal.setTime(clientInformation.getBirthday()); 
		        int yearBirth = cal.get(Calendar.YEAR);
		        int monthBirth = cal.get(Calendar.MONTH);
		        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);  
		        int age = yearNow - yearBirth;   //计算整岁数
	            if (monthNow <= monthBirth) 
	            {
	            	if (monthNow == monthBirth) 
	            	{
	            		if (dayOfMonthNow < dayOfMonthBirth) age--;//当前日期在生日之前，年龄减一
	            	}
	            	else
	            	{
	            		age--;//当前月份在生日之前，年龄减一
	                } 
	            }
				
	            clientInformation.setAge(age);
				client.setClientInformation(clientInformation);
				clientQualification.setQualification(true);
				clientQualification.setClient(client);
				clientQualification.setImage(null);
				clientService.register(client);
				clientQualificationService.add(clientQualification);
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
			Client gClient=new Client();
			gClient.setCid(Integer.parseInt(cid));
			gClient=clientService.findById(gClient);
			ClientInformation gClientInformation=clientInformationService.findById(gClient);
			gClient.setClientInformation(gClientInformation);
			return "success";
		}
		catch(Exception e)
		{
			return "failed";
		}
	}
	public String lookAllClient()
	{
		try
		{
			clientList=clientService.findAll();
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

	public Client getgClient() {
		return gClient;
	}

	public void setgClient(Client gClient) {
		this.gClient = gClient;
	}

	public List<Client> getClientList() {
		return clientList;
	}

	public void setClientList(List<Client> clientList) {
		this.clientList = clientList;
	}

	public ClientInformationService getClientInformationService() {
		return clientInformationService;
	}

	public void setClientInformationService(ClientInformationService clientInformationService) {
		this.clientInformationService = clientInformationService;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}
}
