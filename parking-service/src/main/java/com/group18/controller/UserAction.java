package com.group18.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.group18.po.Client;
import com.group18.po.User;
import com.group18.po.UserInformation;
import com.group18.po.UserQualification;
import com.group18.service.ClientQualificationService;
import com.group18.service.ClientService;
import com.group18.service.UserInformationService;
import com.group18.service.UserQualificationService;
import com.group18.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private User user;
	private User gUser;
	private List<User> userList;
	private UserQualification userQualification;
	private UserService userService=null;
	private List<UserQualification> userQualificationList;
	private UserQualificationService userQualificationService=null;
	private UserInformationService userInformationService=null;
	/*private File upFile;*/
	
	String uid;
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
				session.setAttribute("error", "密码错误");
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
			if(user.getPassword().equals(enterPassword))//如果密码值跟确认的密码相同
			{
				/*FileInputStream fis = new FileInputStream(getUpFile());
				byte[] content = new byte[fis.available()];
				fis.read(content);*/
				user.setIdentity(false);
				UserInformation userInformation=user.getUserInformation();
				userInformation.setUser(user);
				user.setUserInformation(userInformation);
				userQualification=new UserQualification();
				userQualification.setQualification(true);
				userQualification.setUser(user);
				userService.register(user);
				userQualificationService.add(userQualification);
				/*userQualification.setUser(user);
				userQualification.setQualification(true);
				userQualification.setImage(content);
				userQualification.setImage(null);
				Set<UserQualification> userQualificationSet=user.getUserQualifications();
				userQualificationSet.add(userQualification);
				user.setUserQualifications(userQualificationSet);*/
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
			session.setAttribute("msg",e.getMessage());
			return "failed";
		}
	}
	public String changePassword()//修改密码
	{
		try
		{
			if(user.getPassword().equals(enterPassword))//å¦‚æžœæ–°å¯†ç �ä¸Žç¡®è®¤å¯†ç �è¾“å…¥éƒ½æ²¡é—®é¢˜
			{
				User oldUser=(User) session.getAttribute("user");
				System.out.println(user.getPassword());
				oldUser.setPassword(user.getPassword());
				userService.update(oldUser);
				session.removeAttribute("msg");;
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
	public String lookUser()//查找用户信息
	{
		try
		{
			User gUser=new User();
			gUser.setUid(Integer.parseInt(uid));
			gUser=userService.findById(gUser);
			UserInformation gUserInformation=userInformationService.findById(gUser);
			gUser.setUserInformation(gUserInformation);
			return "success";
		}
		catch(Exception e)
		{
			return "failed";
		}
	}
	
	public String lookAllUser()//查找所有用户信息
	{
		try
		{
			userList=userService.findAll();
			return "success";
		}
		catch(Exception e)
		{
			return "failed";
		}
	}
	public String lookUserQualification()//查找用户资质信息
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
	public String update()//更新用户信息
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
	/*public File getUpFile() {
		return upFile;
	}
	public void setUpFile(File upFile) {
		this.upFile = upFile;
	}*/
	public UserInformationService getUserInformationService() {
		return userInformationService;
	}
	public void setUserInformationService(UserInformationService userInformationService) {
		this.userInformationService = userInformationService;
	}
	public User getgUser() {
		return gUser;
	}
	public void setgUser(User gUser) {
		this.gUser = gUser;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
}
