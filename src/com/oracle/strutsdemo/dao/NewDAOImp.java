package com.oracle.strutsdemo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.oracle.strutsdemo.model.bean.New;

public class NewDAOImp extends BaseDAOImp implements NewDAO {

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
		
		return null;
	}

	@Override
	public ArrayList<New> listRecentNewsByCount(int count) {
		PreparedStatement  sta=null;
		ArrayList<New> news=new ArrayList<>();
		ResultSet rs=null;
	try {
		  sta=getPreSta("select  *  from new order by newid desc  limit  ?");
		sta.setInt(1, count);
		rs=sta.executeQuery();
		while(rs.next()) {
			New  n=parseResultsetToNew(rs);
			news.add(n);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
		return news;
	}

	@Override
	public New getNewInfoById(int id) {
		PreparedStatement  sta=null;
		ResultSet rs=null;
		New  n=null;
	try {
		  sta=getPreSta("select  *  from  new where newid=?");
		sta.setInt(1, id);
		rs=sta.executeQuery();
		if(rs.next()) {
			  n=parseResultsetToNew(rs);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
		return n;
	}
	public New parseResultsetToNew(ResultSet rs) {
		New  n=new New();
			try {
				n.setNewid(rs.getInt("newid"));
				n.setBiaoti(rs.getString("biaoti"));
				n.setNeirong(rs.getString("neirong"));
				n.setFaburen(rs.getString("faburen"));
				n.setFabushijian(rs.getString("fabushijian"));
				n.setXinwenpeitu(rs.getString("xinwenpeitu"));
				n.setYueduliang(rs.getInt("yueduliang"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		return n;
	}

}
