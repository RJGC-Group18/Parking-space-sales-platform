package com.group18.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.group18.po.Client;
import com.group18.po.Dealing;
import com.group18.po.Parking;
import com.group18.po.Payment;
import com.group18.po.Reservation;
import com.group18.po.ReservationId;
import com.group18.service.ClientService;
import com.group18.service.DealingService;
import com.group18.service.ParkingService;
import com.group18.service.ReservationService;

public class ReservationAction {
	Reservation reservation;
	List<Reservation> reservationList;
	ReservationService reservationService=null;
	Parking parking;
	ParkingService parkingService=null;
	ClientService clientService=null;
	DealingService dealingService=null;
	HttpServletRequest request;
	HttpSession session;
	public ReservationAction()
	{
		request= ServletActionContext.getRequest();
		session = request.getSession();
	}
	public String findAllByClient()//用户查看自己当前所有的车位预约信息
	{
		try
		{
			Client client=(Client)session.getAttribute("client");
			reservationList=reservationService.findByCid(client);
			return "success";
		}
		catch(Exception e)
		{
			return "failed";
		}
	}
	public String findAllByParking()//销售方查看一个车位的预约信息
	{
		try
		{
			reservationList=reservationService.findByPid(parking);
			return "success";
		}
		catch(Exception e)
		{
			return "failed";
		}
	}
	public String add()//添加车位预约信息
	{
		try 
		{
			Client client=(Client)session.getAttribute("client");
			reservation=new Reservation();
			ReservationId reservationId=new ReservationId();
			reservationId.setCid(client.getCid());
			reservationId.setPid(parking.getPid());
			reservation.setId(reservationId);
			reservation.setTime(new Date());
			reservationService.add(reservation);
			return "success";
		}
		catch(Exception e)
		{
			return "failed";
		}
	}
	public String delete()//删除车位预约信息
	{
		try
		{
			Client client=(Client)session.getAttribute("client");
			reservation=new Reservation();
			ReservationId reservationId=new ReservationId();
			reservationId.setCid(client.getCid());
			reservationId.setPid(parking.getPid());
			reservation.setId(reservationId);
			reservationService.delete(reservation);
			return "success";
		}
		catch(Exception e)
		{
			return "failed";
		}
	}
	public String SelectReservation()//摇号
	{
		try
		{
			List<Parking> parkingList=parkingService.findAll();
			for(Parking selectedParking:parkingList)
			{
				Reservation selectedReservation=reservationService.selectReservation(selectedParking);		
				Client client=new Client(selectedReservation.getId().getCid());
				client=clientService.findById(client);
				
				Dealing dealing=new Dealing();
				dealing.setClient(client);
				dealing.setName(client.getUsername());
				dealing.setPhone(client.getClientInformation().getPhone());
				dealing.setTime(null);
				dealing.setParking(selectedParking);
				dealing.setPay(false);
				dealing.setUser(selectedParking.getUser());
				dealingService.add(dealing);
				
				Payment payment=new Payment();
				Date dealline=new Date();
				dealline.setTime(dealline.getTime()+604800000);
				payment.setClient(client);
				payment.setDealing(dealing);
				payment.setPaid(new BigDecimal(0));
				payment.setPay(false);
				payment.setParking(selectedParking);
				payment.setTime(new Date());
				payment.setUnpaid(new BigDecimal(selectedParking.getPriceUnit()));
				payment.setUser(selectedParking.getUser());
				payment.setDeadline(dealline);
				
				reservationService.delete(selectedReservation);
			}
			return "success";
		}
		catch(Exception e)
		{
			return "failed";
		}
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	public List<Reservation> getReservationList() {
		return reservationList;
	}
	public void setReservationList(List<Reservation> reservationList) {
		this.reservationList = reservationList;
	}
	public ReservationService getReservationService() {
		return reservationService;
	}
	public void setReservationService(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	public Parking getParking() {
		return parking;
	}
	public void setParking(Parking parking) {
		this.parking = parking;
	}
	public ParkingService getParkingService() {
		return parkingService;
	}
	public void setParkingService(ParkingService parkingService) {
		this.parkingService = parkingService;
	}
	public ClientService getClientService() {
		return clientService;
	}
	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}
	public DealingService getDealingService() {
		return dealingService;
	}
	public void setDealingService(DealingService dealingService) {
		this.dealingService = dealingService;
	}
}
