package com.group18.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
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
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private User user;
	private UserQualification userQualification;
	private UserService userService=null;
	private List<UserQualification> userQualificationList;
	private UserQualificationService userQualificationService=null;
	private File upFile;
	private String upFileFileName;
    private String upFileContentType;
	
	String enterPassword;
	HttpServletRequest request;
	HttpSession session;
	public UserAction()
	{
		request= ServletActionContext.getRequest();
		session = request.getSession();
	}
	public String login()//ç™»å½•
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
				session.setAttribute("error", "ç™»å½•å¤±è´¥");
				return "failed";
			}
		}
		catch(Exception e)
		{
			session.setAttribute("error", e.getMessage());
			return "failed";
		}
	}
	public String loginOut()//ç™»å‡º
	{
		session.invalidate();
		return"success";
	}
	public String register()//æ³¨å†Œ
	{
		try
		{
			if(user.getPassword().equals(enterPassword))//å¦‚æžœæ–°å¯†ç �ä¸Žç¡®è®¤å¯†ç �è¾“å…¥éƒ½æ²¡é—®é¢˜
			{
				System.out.println(upFile.getAbsolutePath());
				InputStream is = new FileInputStream(upFile);
				/*
				 * String path = ServletActionContext.getServletContext().getRealPath("/");
				 * ArrayList<String>dataUrl = new ArrayList<String>();
				 * dataUrl.add(imgpath+this.getFileFileName().get(i));
				 */
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				byte[] b=null;
				int n;
				while((n=is.read(b))!=-1)
				{
					bos.write(b, 0, n);
				}
				is.close();
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
				session.setAttribute("msg","å¯†ç �é”™è¯¯");
				return "failed";
			}
		}
		catch(Exception e)
		{
			session.setAttribute("msg",e.getMessage());
			return "failed";
		}
	}
	public String changePassword()//ä¿®æ”¹å¯†ç �
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
			session.setAttribute("msg","å¯†ç �ä¿®æ”¹æˆ�åŠŸ");
			return "failed";
		}
		catch(Exception e)
		{
			session.setAttribute("msg", e.getMessage());
			return "failed";
		}
	}
	public String lookUser()//æŸ¥çœ‹é”€å”®æ–¹ä¿¡æ�¯
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
	public String lookUserQualification()//æŸ¥çœ‹é”€å”®æ–¹èµ„è´¨ä¿¡æ�¯
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
	public String update()//æ›´æ–°é”€å”®æ–¹ä¿¡æ�¯
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
	public File getUpFile() {
		return upFile;
	}
	public void setUpFile(File upFile) {
		this.upFile = upFile;
	}
	public String getUpFileFileName() {
		return upFileFileName;
	}
	public void setUpFileFileName(String upFileFileName) {
		this.upFileFileName = upFileFileName;
	}
	public String getUpFileContentType() {
		return upFileContentType;
	}
	public void setUpFileContentType(String upFileContentType) {
		this.upFileContentType = upFileContentType;
	}
}
