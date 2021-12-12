package com.group18.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.group18.po.Client;
import com.group18.po.User;
import com.group18.po.UserQualification;
import com.group18.service.ClientQualificationService;
import com.group18.service.ClientService;
import com.group18.service.UserQualificationService;
import com.group18.service.UserService;

public class UserAction {
	private User user;
	private UserQualification userQualification;
	private UserService userService=null;
	private List<UserQualification> userQualificationList;
	private UserQualificationService userQualificationService=null;
	private List<File> file;
	
	String enterPassword;
	HttpServletRequest request;
	HttpSession session;
	public UserAction()
	{
		request= ServletActionContext.getRequest();
		session = request.getSession();
	}
	public String login()//登录
	{
		try
		{
			if(userService.loginInfoCheck(user))
			{
				user=userService.findByName(user);
				session.setAttribute("user", user);
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
			if(user.getPassword().equals(enterPassword))//如果新密码与确认密码输入都没问题
			{
				FileInputStream fis=new FileInputStream(file.get(0));
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				byte[] b=null;
				int n;
				while((n=fis.read(b))!=-1)
				{
					bos.write(b, 0, n);
				}
				fis.close();
				bos.close();
				
				user.setIdentity(false);
				userService.register(user);
				userQualification.setUser(user);
				userQualification.setQualification(true);
				userQualification.setImage(bos.toByteArray());
				userQualificationService.add(userQualification);
				session.setAttribute("user", user);
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
			return "failed";
		}
	}
	public String changePassword()//修改密码
	{
		try
		{
			if(user.getPassword().equals(enterPassword))//如果新密码与确认密码输入都没问题
			{
				User oldUser=(User) session.getAttribute("user");
				System.out.println(user.getPassword());
				oldUser.setPassword(user.getPassword());
				userService.update(oldUser);
				session.removeAttribute("msg");;
				return "success";
			}
			session.setAttribute("msg","密码修改成功");
			return "failed";
		}
		catch(Exception e)
		{
			session.setAttribute("msg", e.getMessage());
			return "failed";
		}
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
	public String getEnterPassword() {
		return enterPassword;
	}
	public void setEnterPassword(String enterPassword) {
		this.enterPassword = enterPassword;
	}
	public UserQualification getUserQualification() {
		return userQualification;
	}
	public void setUserQualification(UserQualification userQualification) {
		this.userQualification = userQualification;
	}
	public List<File> getFile() {
		return file;
	}
	public void setFile(List<File> file) {
		this.file = file;
	}
}
