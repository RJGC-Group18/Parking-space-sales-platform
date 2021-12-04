package com.group18.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.group18.po.User;
import com.group18.po.UserQualification;
import com.group18.service.ClientQualificationService;
import com.group18.service.ClientService;
import com.group18.service.UserQualificationService;
import com.group18.service.UserService;

public class UserAction {
	private User user;
	private UserService userService=null;
	private List<UserQualification> userQualificationList;
	private UserQualificationService userQualificationService=null;
	HttpServletRequest request;
	HttpSession session;
	public UserAction()
	{
		request= ServletActionContext.getRequest();
		session = request.getSession();
	}
	public String login()//登录
	{
		if(userService.loginInfoCheck(user))
		{
			user=userService.findByName(user);
			session.setAttribute("user", user);
			return "success";
		}
		else
		{
			return "failed";
		}
	}
	public String loginOut()//登出
	{
		session.removeAttribute("user");
		session.removeAttribute("type");
		return"success";
	}
	public String register()//注册
	{
		try
		{
			user.setIdentity(false);
			userService.register(user);
		}
		catch(Exception e)
		{
			return "failed";
		}
		session.setAttribute("user", user);
		return "success";
	}
	public String lookUser()//查看销售方信息
	{
		try
		{
			User inUser=(User) session.getAttribute("user");
			user=userService.findById(inUser);
			return "success";
		}
		catch(Exception e)
		{
			return "failed";
		}
	}
	public String lookUserQualification()//查看销售方资质信息
	{
		try
		{
			userQualificationList=userQualificationService.findByUid(user);
			return "success";
		}
		catch(Exception e)
		{
			return "failed";
		}
	}
	public String update()//更新销售方信息
	{
		try
		{
			userService.update(user);
			return "success";
		}
		catch(Exception e)
		{
			return "failed";
		}
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public List<UserQualification> getUserQualificationList() {
		return userQualificationList;
	}
	public void setUserQualificationList(List<UserQualification> userQualificationList) {
		this.userQualificationList = userQualificationList;
	}
	public UserQualificationService getUserQualificationService() {
		return userQualificationService;
	}
	public void setUserQualificationService(UserQualificationService userQualificationService) {
		this.userQualificationService = userQualificationService;
	}
}
