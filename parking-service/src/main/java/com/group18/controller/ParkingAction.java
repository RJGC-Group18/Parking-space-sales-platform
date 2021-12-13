package com.group18.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.group18.po.Parking;
import com.group18.po.User;
import com.group18.service.ParkingService;
import com.group18.service.UserService;

public class ParkingAction {
	Parking parking;
	List<Parking> parkingList;
	ParkingService parkingService=null;
	UserService userService=null;
	HttpServletRequest request;
	HttpSession session;
	
	String pid;
	
	public ParkingAction()
	{
		request= ServletActionContext.getRequest();
		session = request.getSession();
	}
	public String findAll()//查找全部可预约的车位信息
	{
		try
		{
			session.removeAttribute("msg");
			parkingList=parkingService.findAll();
			return "success";
		}
		catch(Exception e)
		{
			session.setAttribute("msg", e.getMessage());
			return "failed";
		}
	}
	public String findAllByUser()//查找销售方全部可预约的车位信息
	{
		try
		{
			session.removeAttribute("msg");
			User user=(User) session.getAttribute("user");
			parkingList=parkingService.fingByUid(user);
			return "success";
		}
		catch(Exception e)
		{
			session.setAttribute("msg", e.getMessage());
			return "failed";
		}
	}
	public String lookParking()//查看车位信息
	{
		try
		{
			session.removeAttribute("msg");
			int pidInt=Integer.parseInt(pid);
			parking=new Parking();
			parking.setPid(pidInt);
			parking=parkingService.findByPid(parking);
			User user=parking.getUser();
			user=userService.findById(user);
			parking.setUser(user);
			session.setAttribute("parking", parking);
			return "success";
		}
		catch(Exception e)
		{
			session.setAttribute("msg", e.getLocalizedMessage());
			return "failed";
		}
	}
	public String add()//添加车位信息
	{
		try
		{
			session.removeAttribute("msg");
			User user=(User) session.getAttribute("user");
			parking.setUser(user);
			parkingService.add(parking);
			session.setAttribute("msg", "车位信息添加成功");
			return "success";
		}
		catch(Exception e)
		{
			session.setAttribute("msg",e.getMessage());
			return "failed";	
		}
	}
	public String update()//更新车位信息
	{
		try
		{
			parkingService.update(parking);
			return "success";
		}
		catch(Exception e)
		{
			return "failed";	
		}
	}
	public String delete()//删除车位信息
	{
		try
		{
			parkingService.delete(parking);
			return "success";
		}
		catch(Exception e)
		{
			return "failed";	
		}
	}
	public Parking getParking() {
		return parking;
	}
	public void setParking(Parking parking) {
		this.parking = parking;
	}
	public List<Parking> getParkingList() {
		return parkingList;
	}
	public void setParkingList(List<Parking> parkingList) {
		this.parkingList = parkingList;
	}
	public ParkingService getParkingService() {
		return parkingService;
	}
	public void setParkingService(ParkingService parkingService) {
		this.parkingService = parkingService;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
