package com.oracle.strutsdemo.dao;

import java.util.ArrayList;

import com.oracle.strutsdemo.model.bean.User;

public interface UserDAO extends BaseDAO {
	public User  login(String username,String password);
	public  User getUserInfoByUserId(int userid);
	public boolean checkUserExsit(String username);
	public ArrayList<User>  listUserByPage(int count,int page);
	public int  getAllCountOfUser();
}
