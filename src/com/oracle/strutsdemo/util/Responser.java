package com.oracle.strutsdemo.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 封装好的独立输出json格式数据的帮助类
 * @author tengsir
 *
 */
public class Responser {
	public  static  void   responseToJson(HttpServletResponse response,HttpServletRequest request,String jsonText) throws Exception {
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.write(jsonText);
		out.flush();
		out.close();
	}

}
