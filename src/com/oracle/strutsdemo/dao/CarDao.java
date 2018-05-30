package com.oracle.strutsdemo.dao;

import java.util.ArrayList;
import java.util.Set;

import com.oracle.strutsdemo.model.bean.Car;
import com.oracle.strutsdemo.model.bean.CarImage;

public interface  CarDao  extends BaseDAO{
	/*
	 * 设计一个可以根据用户传入的数量查询显示出最近发布的二手车信息
	 */
	public abstract ArrayList<Car>  listRecentCarsByCount(int count);
	
	
	/**
	 * 定义一个查询需要推广显示到滚动区域二手车信息的方法
	 */
	public  abstract  ArrayList<Car>  getAllCarByTuiguang();
	
	/**
	 * 
	 * @param carId 要查询的车辆ID
	 * @return  一个查询并封装好的Car对象
	 */
	public  abstract Car  getCarInfoByCarId(int carId);

	/**
	 * 根据传入的条件，搜索对应的车辆信息的方法
	 * @param pinpai
	 * @param minPrice
	 * @param maxPrice
	 * @param minMile
	 * @param maxMile
	 * @param biansuxiang
	 * @param cheliangleixing
	 * @return
	 */
	public   abstract   ArrayList<Car>  searchCarsByCondition(String pinpai,String minPrice,String maxPrice,String minMile,String maxMile,String biansuxiang,String cheliangleixing);

	/**
	 * 根据车辆编号查询车辆对应的图片的方法
	 * @param carId
	 * @return
	 */
	public   abstract  Set<CarImage>  getCarImagesByCarId(int carId);
	
	/**
	 * 根据模糊关键字查询所有的内容
	 * @param key
	 * @return
	 */
	public  abstract ArrayList<Car>  searchAllByKey(String key);
	
/**
 * 分页查询车辆信息的方法
 * @param page   传入的页面
 * @param count  传入的每页查看多少条数据
 * @return   返回这一页的count条车辆信息
 */
	public ArrayList<Car>  listCarByPage(int page,int count);
	
	/**
	 * 查询出车辆信息表有多少条数据
	 * @return
	 */
	public int getAllCountOfCars();
	
	public  ArrayList<String>  mohuSearch(String key);
}
