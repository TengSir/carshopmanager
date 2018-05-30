package com.oracle.strutsdemo.dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.oracle.strutsdemo.model.bean.Car;
import com.oracle.strutsdemo.model.bean.CarImage;

public class CarDAOImp extends BaseDAOImp  implements CarDao {

	@Override
	public boolean add(Object o) {
		return false;
	}

	@Override
	public boolean delete(Object id) {
		return false;
	}

	@Override
	public boolean update(Object o) {
		return false;
	}

	@Override
	public Object list() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 根据传入的数量查询出最近的指定数量的二手车信息
	 */
	public ArrayList<Car> listRecentCarsByCount(int count) {
		ArrayList<Car> cars = new ArrayList<Car>();// 定义一个集合存储查询出来的所有车辆信息
		ResultSet rs = null;
		try {
			rs = getSta().executeQuery("select *  from  car order by  carid desc  limit " + count);
			while (rs.next()) {
				cars.add(parsetResultToCar(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cars;
	}

	@Override
	public ArrayList<Car> getAllCarByTuiguang() {
		ArrayList<Car> cars = new ArrayList<Car>();// 定义一个集合存储查询出来的所有车辆信息
		ResultSet rs = null;
		try {
			rs = getSta().executeQuery("select *  from  car   where  shifoutuiguang=1");
			while (rs.next()) {

				cars.add(parsetResultToCar(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cars;
	}

	@Override
	public Car getCarInfoByCarId(int carId) {
		Car c = null;
		ResultSet rs = null;
		try {
			rs = getSta().executeQuery("select *  from  car  where carid=" + carId);
			if (rs.next()) {
				c = parsetResultToCar(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public ArrayList<Car> searchCarsByCondition(String pinpai, String minPrice, String maxPrice, String minMile,
			String maxMile,String biansuxiang,String cheliangleixing) {
		/**
		 * 条件有很多种不同，那么sql语句就应该有对应的变动
		 */
		String SQL = "select *  from  car  where  1=1";
		if (pinpai != null && !pinpai.equals("")) {
			SQL += "   and  pinpaiming='" + pinpai + "'";
		}
		if (minPrice != null && !minPrice.equals("")) {
			SQL += "   and  shoujia>=" + minPrice;
		}
		if (maxPrice != null && !maxPrice.equals("")) {
			SQL += "   and  shoujia<=" + maxPrice;
		}
		if (minMile != null && !minMile.equals("")) {
			SQL += "   and  gonglishu>=" + Integer.parseInt(minMile) * 10000;
		}
		if (maxMile != null && !maxMile.equals("")) {
			SQL += "  and  gonglishu<=" + Integer.parseInt(maxMile) * 10000;
		}
		if (biansuxiang != null && !biansuxiang.equals("")) {
			SQL += "   and  biansuxiang  like '%"+biansuxiang+"%'";
		}
		if (cheliangleixing != null && !cheliangleixing.equals("")) {
			SQL += "  and  cheliangleixing like '%"+cheliangleixing+"%'";
		}

		ArrayList<Car> cars = new ArrayList<Car>();// 定义一个集合存储查询出来的所有车辆信息
		ResultSet rs = null;
		try {
			rs = getSta().executeQuery(SQL);
			while (rs.next()) {
				cars.add(parsetResultToCar(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cars;
	}

	public Car parsetResultToCar(ResultSet rs) {
		Car c = null;
		try {
			c = new Car();
			c.setCarId(rs.getInt("carid"));
			c.setPinpaiming(rs.getString("pinpaiming"));
			c.setXilie(rs.getString("xilie"));
			c.setGonglishu(rs.getFloat("gonglishu"));
			c.setGoumaishijian(rs.getString("goumaishijian"));
			c.setShoujia(rs.getFloat("shoujia"));
			c.setPailiang(rs.getString("pailiang"));
			c.setMiaoshu(rs.getString("miaoshu"));
			c.setZhuangtai(rs.getInt("zhuangtai"));
			c.setQicheshoutu(rs.getString("qicheshoutu"));
			c.setBiansuxiang(rs.getString("biansuxiang"));
			c.setRanliaoleixing(rs.getString("ranliaoleixing"));
			c.setCheliangleixing(rs.getString("cheliangleixing"));
			c.setDijishou(rs.getInt("dijishou"));
			c.setShipin(rs.getString("shipin"));
			c.setShifoutuiguang(rs.getInt("shifoutuiguang"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public Set<CarImage> getCarImagesByCarId(int carId) {
		Set<CarImage>  imgs=new HashSet<>();
		try {
			Statement  sta=getSta();
			ResultSet  rs=sta.executeQuery("select *  from carImage where carid="+carId);
			while(rs.next())
			{
				CarImage  img=new CarImage();
				img.setCarid(rs.getInt("carid"));
				img.setImageid(rs.getInt("imageid"));
				img.setImagepath(rs.getString("imagepath"));
				imgs.add(img);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return imgs;
	}

	@Override
	public ArrayList<Car> searchAllByKey(String key) {
		String[] keys=key.split("\\s+");
		ArrayList<Car> cars = new ArrayList<Car>();// 定义一个集合存储查询出来的所有车辆信息
		ResultSet rs = null;
		try {
			rs = getSta().executeQuery("select *  from  car  limit 1");
			ResultSetMetaData  data=rs.getMetaData();
			String sql="select * from car  where 1=0  or";
			String[] columnName=new String[data.getColumnCount()];
			for(int n=1;n<=data.getColumnCount();n++)
			{
				columnName[n-1]=data.getColumnLabel(n);
			}
			for(String k:keys) {
				sql+="  (  1=0";
				for(String column:columnName)
				{
					sql+="  or  "+column+" like  '%"+k+"%'";
				}
				sql+=" ) and";
			}
			sql=sql.substring(0, sql.length()-3);
			rs=getSta().executeQuery(sql);
			while(rs.next()) {
				Car c=parsetResultToCar(rs);
				cars.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cars;
	}
	public void updateCarVideo() {
		try {
			ResultSet rs=getSta().executeQuery("select carid from car");
			int n=1;
			while(rs.next()) {
				int result=getSta().executeUpdate("update  car   set  shipin='videos/"+n+".mp4' where carid="+rs.getInt(1));
				System.out.println(result);
				n++;
				if(n==23)n=1;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<Car> listCarByPage(int page, int count) {
		ArrayList<Car> cars = new ArrayList<Car>();// 定义一个集合存储查询出来的所有车辆信息
		ResultSet rs = null;
		try {
			rs = getSta().executeQuery("select *  from  car    limit  "+(page-1)*count+" ,"+count);
			while (rs.next()) {

				cars.add(parsetResultToCar(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cars;
	}

	@Override
	public int getAllCountOfCars() {
		int  n=0;
		ResultSet  rs=null;
		try {
			  rs=getSta().executeQuery("select count(carid)  from  car");
			  rs.next();
			  n=rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public ArrayList<String> mohuSearch(String key) {
		ArrayList<String> titles = new ArrayList<String>();
		ResultSet rs = null;
		try {
			rs = getSta().executeQuery("select  xilie  from  car  where xilie  like '%"+key+"%'  limit 10");
			while (rs.next()) {
					titles.add(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return titles;
	}
}
