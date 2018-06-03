package com.oracle.strutsdemo.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.interceptor.RequestAware;
import org.json.JSONArray;
import org.json.JSONObject;

import com.mysql.fabric.HashShardMapping;
import com.opensymphony.xwork2.ActionContext;
import com.oracle.strutsdemo.dao.UserDAO;
import com.oracle.strutsdemo.dao.UserDAOImp;
import com.oracle.strutsdemo.model.bean.PageBean;
import com.oracle.strutsdemo.model.bean.User;
import com.oracle.strutsdemo.util.MD5;
import com.oracle.strutsdemo.util.Responser;
//component
//javabean 豆子
//功能bean和模型bean

@InterceptorRef("sessionChecker")
public class UserAction  implements RequestAware{
	private Map<String,Object>  request=new HashMap<>();
	private  User  u;
	
	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}
	private  UserDAO  dao;
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

	public String index() {
		return "success";
	}
	
	/**
	 * 处理登陆的业务方法
	 * @return
	 */

	public String   login() {
		System.out.println(dao);
		System.out.println(u);
		User u=dao.login(this.u.getUsername(), MD5.MD5(this.u.getPassword()));
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

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request=arg0;
	}
	
	/**
	 * 这是处理登陆的后台业务方法
	 * @return
	 */
	public  String  processLogin() {
		System.out.println(u.getUsername()+"\t"+u.getPassword());
		//调用dao 的方法
		User user=dao.login(u.getUsername(), MD5.MD5(u.getPassword()));
		System.out.println(user);
		if(user==null)
		{
			ServletActionContext.getRequest().setAttribute("message", "loginFail");//在登陆失败的情况下，王request里面存一个登陆失败的消息，让前端页面可以判断是否打开提示框
			return "loginFail";
		}else
		{
			return "loginSuccess";
		}
		
	}
}
