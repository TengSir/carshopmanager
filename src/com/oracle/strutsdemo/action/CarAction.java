package com.oracle.strutsdemo.action;

import java.util.ArrayList;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;

import com.oracle.strutsdemo.dao.CarDAOImp;
import com.oracle.strutsdemo.dao.CarDao;
import com.oracle.strutsdemo.model.bean.Car;
import com.oracle.strutsdemo.util.Responser;

public class CarAction {
	private Car  car;
	
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	private CarDao dao;
	public CarAction() {
		dao=new CarDAOImp();
	}
	private int page;
	private int rows;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	/**
	 * 分页显示查询车辆信息的方法
	 */
	public void listCarsByPage() {
		ArrayList<Car> cars=dao.listCarByPage(page, rows);
		JSONArray  js=new JSONArray();
		for(Car c:cars) {
			try {
				JSONObject  j=new JSONObject();
				j.put("carid", c.getCarId());
				j.put("pinpai", c.getPinpaiming());
				j.put("xilie", c.getXilie());
				j.put("shijian", c.getGoumaishijian());
				j.put("gonglishu", c.getGonglishu());
				j.put("pailiang", c.getPailiang());
				j.put("biansuxiang", c.getBiansuxiang());
				j.put("image", "<img src='"+c.getQicheshoutu()+"'  style='width:20px;height:20px'/>");
				j.put("shipin", "<video  src='"+c.getShipin()+"'  style='width:20px;height:20px;'   preload='preload'/>");
				js.put(j);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(js.toString());
		try {
			Responser.responseToJson(ServletActionContext.getResponse(), ServletActionContext.getRequest(), js.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 根据id删除车辆信息的方法
	 */
	public void deleteCarInfoByCarId() {
		boolean result=dao.delete(car.getCarId());
		System.out.println(car.getCarId());
		System.out.println("delete result:"+result);
		try {
			Responser.responseToJson(ServletActionContext.getResponse(), ServletActionContext.getRequest(), result+"");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
