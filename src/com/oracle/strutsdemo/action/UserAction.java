package com.oracle.strutsdemo.action;

import java.util.ArrayList;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;

import com.oracle.strutsdemo.dao.UserDAO;
import com.oracle.strutsdemo.dao.UserDAOImp;
import com.oracle.strutsdemo.model.bean.PageBean;
import com.oracle.strutsdemo.model.bean.User;
import com.oracle.strutsdemo.util.MD5;
import com.oracle.strutsdemo.util.Responser;

public class UserAction {
	private  UserDAO  dao;
	private String username;
	private String password;
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

	public UserAction() {
		dao=new UserDAOImp();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 处理登陆的业务方法
	 * @return
	 */

	public String   login() {
		User u=dao.login(username, MD5.MD5(password));
//		System.out.println("resultUser:"+u);
		if(u!=null) {
			ServletActionContext.getRequest().getSession().setAttribute("user", u);
			return "success";
		}else
		{
			return "fail";
		}
	}
	
	/**
	 * 处理退出的业务方法
	 * @return
	 */

	public String   logoff() {
		ServletActionContext.getRequest().getSession().removeAttribute("user");
		return "fail";
	}
	/**
	 * 分页加载用户资料
	 */
	public void listUserByPage() {
		ArrayList<User>  users=dao.listUserByPage(rows, page);
		JSONArray  js=new JSONArray();
		for(User u:users)
		{
			try {
				JSONObject  j=new JSONObject();
				j.put("userid", u.getUserid());
				j.put("username", u.getUsername());
				j.put("sex",(u.getSex()==0)?"男":"女");
				j.put("age", u.getAge());
				j.put("job", u.getJob());
				j.put("nickname", u.getNickname());
				j.put("image", "<img src='"+u.getImage()+"' style='width:20px;height:20px' />");
				js.put(j);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(js.toString());
		try {
			Responser.responseToJson(ServletActionContext.getResponse(), ServletActionContext.getRequest(), js.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
