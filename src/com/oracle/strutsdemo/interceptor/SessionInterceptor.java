package com.oracle.strutsdemo.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class SessionInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation invacation) throws Exception {
		
		System.out.println("进入到拦截起了");
		String path=ServletActionContext.getRequest().getRequestURL().toString();
		
		if(path.contains("UserAction!index.action")) {//
			System.out.println("用户正在访问主页");
			if(ServletActionContext.getRequest().getSession().getAttribute("user")==null)
			{
				System.out.println("说明非法访问主页");
				return "sessionCheckError";
			}else
			{
				System.out.println("正常访问");
				return  invacation.invoke();//放行
				
			}
		}else
		{
			System.out.println("不是请求主页，所以不用拦截");
			return invacation.invoke();//放行
		}
		
	}

}
