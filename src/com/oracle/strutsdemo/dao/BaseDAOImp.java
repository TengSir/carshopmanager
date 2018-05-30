package com.oracle.strutsdemo.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;


public abstract class BaseDAOImp implements  BaseDAO {
	private Connection con;
	private Statement sta;
	private PreparedStatement  preSta;
	private CallableStatement  callSta;
	private DataSource  dataSource;//定义一个连接池对象，这个对象是用来缓存若干个连接的一个‘集合’
//	public BaseDAOImp() {
//	try {
//		/**
//		 * 用jndi访问服务，读取在猫里面创建好并发布成服务的那个链接池对象
//		 */
//		Context  c=new InitialContext();
//		dataSource=(DataSource)c.lookup("java:comp/env/carshop");
//		
//		
//		/**
//		 * 这是在dao里面主动创建连接池的方法
//		 */
//		/**
//		Properties  peizhi=new Properties();//創建一個集合類，這個集合是用來存儲連接池配置文件裡面的參數的
//		File  config=new File("C:\\work\\workspace\\java\\JavaEE\\carshop\\src\\dbcp.properties");
//		peizhi.load(new FileInputStream(config));//用輸入流將配置文件釐米恩的參數加載到集合裡面
//		dataSource=BasicDataSourceFactory.createDataSource(peizhi);//用連接池工廠類創建好一個指定的連接池對象
//		
//		**/
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//	}
	public PreparedStatement getPreSta(String sql) {
		try {
			preSta=getCon().prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return preSta;
	}

	public CallableStatement getCallSta(String sql) {
		try {
			callSta=getCon().prepareCall(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return callSta;
	}

	public Connection getCon() {
		try {
			Class.forName(dirverClass);
			con=DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//如果使用了連接池技術，則basedao中的獲取連接的方法中，不再用傳統的jdbc方式獲取，而應該是從連接池裡面拿出來
		return con;
	}

	public Statement getSta() {
		try {
			sta = getCon().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sta;
	}

	public void disposeResource(Statement sta, ResultSet rs) {// dispose释放，关闭资源
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (sta != null) {
			try {
				sta.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void disposeResource(Statement sta, Connection con) {// dispose释放，关闭资源
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (sta != null) {
			try {
				sta.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void disposeResource(Statement sta, ResultSet rs, Connection con) {// dispose释放，关闭资源
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (sta != null) {
			try {
				sta.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void disposeResource(PreparedStatement sta, ResultSet rs, Connection con) {// dispose释放，关闭资源
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (sta != null) {
			try {
				sta.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void disposeResource(PreparedStatement sta,Connection con) {// dispose释放，关闭资源
		if (sta != null) {
			try {
				sta.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
