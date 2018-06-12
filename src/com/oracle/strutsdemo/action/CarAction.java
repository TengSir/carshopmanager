package com.oracle.strutsdemo.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.oracle.strutsdemo.dao.CarDAOImp;
import com.oracle.strutsdemo.dao.CarDao;
import com.oracle.strutsdemo.model.bean.Car;
import com.oracle.strutsdemo.util.Responser;

public class CarAction  extends ActionSupport{
	private File  image;
	private String imageFileName;
	private String imageContentType;
	
	public File getImage() {
		return image;
	}
	public void setImage(File image) {
		this.image = image;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public String getImageContentType() {
		return imageContentType;
	}
	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}
	private List cars;
	
	public List getCars() {
		return cars;
	}
	public void setCars(List cars) {
		this.cars = cars;
	}
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
	
	
	public String listAllCars() {
		cars=dao.listCarByPage(page, rows);
		System.out.println(cars.toString());
		return "tag";
	}
	
	public String  addCar() {
		System.out.println("add car method");
		for(Object c:cars)
		{
			System.out.println(c);
		}
//		System.out.println(car.toString());
		
		return null;
	}
	
	public void updateCar() {
		
		String path=ServletActionContext.getRequest().getRealPath("upload");//用request获取服务器上的upload目录绝对地址
//		System.out.println(path);
//		System.out.println(image);
//		System.out.println(imageFileName);
//		System.out.println(imageContentType);
		String lastFileName=UUID.randomUUID()+imageFileName.substring(imageFileName.lastIndexOf("."),	 imageFileName.length());
		File  dest=new File(path,lastFileName);//新建一个文件对象，准备将上传的文件存储到这个文件位置上
		try {
			FileUtils.copyFile(image, dest);//用apache的fileupload组件里面的文件帮助类直接讲上传的文件拷贝到我们想放置的文件位置上
			System.out.println("upload  ok");
			//ajax response text
			ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
			PrintWriter  out=ServletActionContext.getResponse().getWriter();
			System.out.println("upload/"+lastFileName);
			out.write("upload/"+lastFileName);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
