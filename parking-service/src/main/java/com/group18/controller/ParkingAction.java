package com.group18.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.group18.po.Client;
import com.group18.po.Parking;
import com.group18.po.User;
import com.group18.service.ParkingService;
import com.group18.service.UserService;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ParkingAction {
	Parking parking;
	List<Parking> parkingList;
	ParkingService parkingService=null;
	UserService userService=null;
	HttpServletRequest request;
	HttpSession session;
	
	String pid;
	String price;
	String address;
	
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
			Client client=(Client) session.getAttribute("client");
			parkingList=parkingService.findByClient(client);
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
	public String findAllByPriceOrAddress()//查找车位信息满足输入的价格或地址
	{
		try
		{
			session.removeAttribute("msg");
			parkingList=parkingService.findAll();
			int priceInt=-1;
			if(price!=null&&!price.equals(""))
				priceInt=Integer.parseInt(price);
			//如果价格和地址都为空，且登录用户身份为user的话，返回销售方原本的车位列表
			if(priceInt<=0&&address.equals("")&&session.getAttribute("user")!=null)
			{
				findAllByUser();
				return "success";
			}
			for(Iterator<Parking> it=parkingList.iterator();it.hasNext();)
			{
				Parking p=it.next();
				if((priceInt>0&&priceInt!=p.getPriceUnit())||
						!p.getAddress().contains(address))
				{
					it.remove();
				}
			}
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
	public String addFromExcel()//批量导入车位 
	{
		User user=(User) session.getAttribute("user");
		int uid=user.getUid();
		int pid=27;
		try {
			session.removeAttribute("msg");
			//1:创建workbook
	        Workbook workbook=Workbook.getWorkbook(new File("C:\\Users\\24036\\Desktop\\parking.xls")); 
	        //2:获取第一个工作表sheet
	        Sheet sheet=workbook.getSheet(0);
	        //3:获取数据
	        System.out.println("行："+sheet.getRows());
	        System.out.println("列："+sheet.getColumns());
	        for(int i=0;i<sheet.getRows();i++){
	        	Cell cell1=sheet.getCell(0,i);
	            Cell cell2=sheet.getCell(1,i);
	            Cell cell3=sheet.getCell(2,i);
	            Cell cell4=sheet.getCell(3,i);
	            System.out.println
	            (cell1.getContents()+" "+cell2.getContents()+" "+cell3.getContents()+" "+cell4.getContents());
	            
	            //加载驱动程序
	            String URL = "jdbc:mysql://localhost:3306/parkingsafesdb?useSSL=false&serverTimezone=Asia/Shanghai";
			    String USER = "root";
			    String PASSWORD = "123456";
			    try {
			    	//获得数据库链接
				    Class.forName("com.mysql.cj.jdbc.Driver");
				    Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				    //楼层
				    String Sublevel=cell1.getContents();
				    int sublevel=Integer.parseInt(Sublevel);
				    //面积
				    String Area=cell2.getContents();
				    int area=Integer.parseInt(Area);
				    //价格
				    String Price=cell3.getContents();
				    int price=Integer.parseInt(Price);
				    //地址
				    String address=cell4.getContents();
				    //处理数据
				    String sql="insert into parking(pid,uid,sublevel,area,price_unit,address) values (?,?,?,?,?,?)";
				    PreparedStatement statement = conn.prepareStatement(sql);
				    statement.setLong(1, pid);
				    statement.setLong(2, uid);
				    statement.setLong(3, sublevel);
				    statement.setLong(4, area);
				    statement.setLong(5, price);
				    statement.setString(6, address);
				    statement.executeUpdate();	
				    pid++;
			        //关闭资源
			        statement.close();	
			        conn.close();
			    }
			    catch (SQLException e) 
		        {			
				    e.printStackTrace();
			    }
			} 
	        //最后一步：关闭资源
	        workbook.close();
	        session.setAttribute("msg", "车位添加成功");
		    return "success";
		}
	    catch (Exception e) {	
	    	session.setAttribute("msg", "车位添加失败");
	    	e.printStackTrace();
	    	return "failed";
		}		
	}
	public String update()//更新车位信息
	{
		try
		{
			session.removeAttribute("msg");
			
			//以下过程为查找原车位信息防止管理员更新信息的时候发生把销售方信息覆盖了的情况
			int pidInt=Integer.parseInt(pid);
			Parking parking1=new Parking();
			parking1.setPid(pidInt);
			parking1=parkingService.findByPid(parking1);
			
			parking.setPid(pidInt);
			parking.setUser(parking1.getUser());
			parkingService.update(parking);
			findAllByUser();
			session.setAttribute("msg", "车位信息更新成功");
			return "success";
		}
		catch(Exception e)
		{
			findAllByUser();
			session.setAttribute("msg", "车位信息更新失败");
			return "failed";	
		}
	}
	public String delete()//删除车位信息
	{
		try
		{
			session.removeAttribute("msg");
			int pidInt=Integer.parseInt(pid);
			parking=new Parking();
			parking.setPid(pidInt);
			parking=parkingService.findByPid(parking);
			parkingService.delete(parking);
			findAllByUser();
			session.setAttribute("msg", "车位"+pid+"删除成功");
			return "success";
		}
		catch(Exception e)
		{
			findAllByUser();
			session.setAttribute("msg", "车位"+pid+"删除失败");
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
