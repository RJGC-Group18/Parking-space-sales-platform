package com.group18.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.group18.po.Client;
import com.group18.po.ClientInformation;
import com.group18.po.Dealing;
import com.group18.po.Parking;
import com.group18.po.Payment;
import com.group18.po.PaymentId;
import com.group18.po.Reservation;
import com.group18.po.ReservationId;
import com.group18.po.User;
import com.group18.po.UserInformation;
import com.group18.service.ClientInformationService;
import com.group18.service.ClientService;
import com.group18.service.DealingService;
import com.group18.service.ParkingService;
import com.group18.service.PaymentService;
import com.group18.service.ReservationService;
import com.group18.service.UserInformationService;
import com.group18.service.UserService;

public class ReservationAction {
	Reservation reservation;
	List<Reservation> reservationList;
	ReservationService reservationService=null;
	Parking parking;
	String pid;
	String cid;
	ParkingService parkingService=null;
	ClientService clientService=null;
	ClientInformationService clientInformationService=null;
	UserService userService=null;
	UserInformationService userInformationService=null;
	DealingService dealingService=null;
	PaymentService paymentService=null;
	
	HttpServletRequest request;
	HttpSession session;
	public ReservationAction()
	{
		request= ServletActionContext.getRequest();
		session = request.getSession();
	}
	public String findReservation()
	{
		try
		{
			int cidInt=Integer.parseInt(cid);
			int pidInt=Integer.parseInt(pid);
			ReservationId id=new ReservationId(cidInt,pidInt);
			Parking parking=new Parking();
			parking.setPid(pidInt);
			reservationList=reservationService.findByPid(parking);
			for(Reservation r:reservationList)
			{
				if(r.getId().equals(id))
				{
					reservation=r;
					break;
				}
			}
			parking=reservation.getParking();
			parking=parkingService.findByPid(parking);
			User user=parking.getUser();
			user=userService.findById(user);
			UserInformation userInformation=userInformationService.findById(user);
			user.setUserInformation(userInformation);
			parking.setUser(user);
			reservation.setParking(parking);
			Client client=reservation.getClient();
			client=clientService.findById(client);
			ClientInformation clientInformation=clientInformationService.findById(client);
			client.setClientInformation(clientInformation);
			reservation.setClient(client);
			return "success";
		}
		catch(Exception e)
		{
			return "failed";
		}
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
	public String findAllByUser()//销售方查看自己所有的预约信息
	{
		try
		{
			User user=(User) session.getAttribute("user");
			List<Parking> parkingList=parkingService.fingByUid(user);
			if(user.getIdentity())
			{
				parkingList=parkingService.findAll();	
			}
			else
			{
				parkingList=parkingService.fingByUid(user);
			}
			reservationList=new ArrayList<Reservation>();
			for(Parking p:parkingList)
			{
				List<Reservation> findReservationList=reservationService.findByPid(p);
				if(findReservationList==null||findReservationList.size()==0)
					continue;
				for(Reservation r:findReservationList)
				{
					reservationList.add(r);
				}
			}
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
			session.removeAttribute("msg");
			Client client=(Client)session.getAttribute("client");
			parking=(Parking)session.getAttribute("parking");
			reservation=new Reservation();
			ReservationId reservationId=new ReservationId();
			reservationId.setCid(client.getCid());
			reservationId.setPid(parking.getPid());
			reservation.setId(reservationId);
			reservation.setTime(new Date());
			reservationService.add(reservation);
			session.setAttribute("msg", "车位预约成功");
			return "success";
		}
		catch(Exception e)
		{
			session.setAttribute("msg", e.getMessage());
			return "failed";
		}
	}
	public String delete()//删除车位预约信息
	{
		try
		{
			session.removeAttribute("msg");
			int cidInt=Integer.parseInt(cid);
			int pidInt=Integer.parseInt(pid);
			reservation=new Reservation();
			ReservationId reservationId=new ReservationId();
			reservationId.setCid(cidInt);
			reservationId.setPid(pidInt);
			reservation.setId(reservationId);
			reservationService.delete(reservation);
			session.setAttribute("msg", "删除预约记录成功");
			if(session.getAttribute("client")==null)
			{
				findAllByUser();
			}
			else
			{
				findAllByClient();
			}
			return "success";
		}
		catch(Exception e)
		{
			session.setAttribute("msg", e.getMessage());
			return "failed";
		}
	}
	public String selectReservation()//摇号
	{
		try
		{
			session.removeAttribute("msg");
			List<Parking> parkingList=parkingService.findAll();
			int number=0;//记录摇号成功数量
			for(Parking selectedParking:parkingList)
			{
				Reservation selectedReservation=reservationService.selectReservation(selectedParking);
				if(selectedReservation==null)
				{
					continue;
				}
				Client client=new Client(selectedReservation.getId().getCid());
				client=clientService.findById(client);
				ClientInformation clientInformation=clientInformationService.findById(client);
				client.setClientInformation(clientInformation);
				Parking parking=new Parking();
				parking.setPid(selectedReservation.getId().getPid());
				parking=parkingService.findByPid(parking);
				User user=parking.getUser();
				user=userService.findById(user);
				
				Dealing dealing=new Dealing();
				dealing.setClient(client);
				dealing.setName(client.getClientInformation().getName());
				dealing.setPhone(client.getClientInformation().getPhone());
				dealing.setTime(null);
				dealing.setParking(selectedParking);
				dealing.setPay(false);
				dealing.setUser(user);
				dealingService.add(dealing);
				
				Payment payment=new Payment();
				Date dealline=new Date();
				PaymentId paymentId=new PaymentId();
				paymentId.setNo(dealing.getNo());
				paymentId.setCid(client.getCid());
				paymentId.setPid(parking.getPid());
				dealline.setTime(dealline.getTime()+604800000);
				payment.setId(paymentId);
				payment.setClient(client);
				payment.setDealing(dealing);
				payment.setPaid(new BigDecimal(0));
				payment.setPay(null);
				payment.setParking(selectedParking);
				payment.setTime(null);
				payment.setUnpaid(new BigDecimal(selectedParking.getPriceUnit()*selectedParking.getArea()));
				payment.setUser(selectedParking.getUser());
				payment.setDeadline(dealline);
				paymentService.add(payment);
				reservationService.delete(selectedReservation);
				number++;
			}
			session.setAttribute("msg", "摇号成功，已对"+number+"个车位进行摇号");
			return "success";
		}
		catch(Exception e)
		{
			session.setAttribute("msg", "摇号失败");
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
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public ClientInformationService getClientInformationService() {
		return clientInformationService;
	}
	public void setClientInformationService(ClientInformationService clientInformationService) {
		this.clientInformationService = clientInformationService;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public UserInformationService getUserInformationService() {
		return userInformationService;
	}
	public void setUserInformationService(UserInformationService userInformationService) {
		this.userInformationService = userInformationService;
	}
	public PaymentService getPaymentService() {
		return paymentService;
	}
	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
}
