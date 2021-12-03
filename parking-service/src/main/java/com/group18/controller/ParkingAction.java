package com.group18.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.group18.po.Parking;
import com.group18.po.User;
import com.group18.service.ParkingService;

public class ParkingAction {
	Parking parking;
	List<Parking> parkingList;
	ParkingService parkingService=null;
	HttpServletRequest request;
	HttpSession session;
	public ParkingAction()
	{
		request= ServletActionContext.getRequest();
		session = request.getSession();
	}
	public String findAll()//查找全部可预约的车位信息
	{
		try
		{
			parkingList=parkingService.findAll();
			return "success";
		}
		catch(Exception e)
		{
			return "failed";
		}
	}
	public String findAllByUser()//查找销售方全部可预约的车位信息
	{
		try
		{
			User user=(User) session.getAttribute("user");
			parkingList=parkingService.fingByUid(user);
			return "success";
		}
		catch(Exception e)
		{
			return "failed";
		}
	}
	public String lookParking()//查看车位信息
	{
		try
		{
			parking=parkingService.findByPid(parking);
			return "success";
		}
		catch(Exception e)
		{
			return "failed";
		}
	}
	public String add()//添加车位信息
	{
		try
		{
			parkingService.add(parking);
			return "success";
		}
		catch(Exception e)
		{
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
}
