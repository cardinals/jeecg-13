package com.jeecg.getmsg;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecgframework.core.util.ApplicationContextUtil;
import org.springframework.jdbc.datasource.DataSourceUtils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.util.JdbcUtils;
import com.getmsg.db.ApplicationContextHelper;

import sun.jdbc.odbc.ee.DataSource;


/**
 * Servlet implementation class GetMsgSevlet
 */
@WebServlet("/GetMsgServlet")
public class GetMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JdbcUtils jdbcUtils = new JdbcUtils();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMsgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ddh = "";
		if(request.getParameter("ddh")!=null){
			ddh=(String)request.getParameter("ddh");
		}
		String money = "";
		if(request.getParameter("money")!=null){
			money=(String)request.getParameter("money");
		}
		String lb = "";
		if(request.getParameter("lb")!=null){
			lb=(String)request.getParameter("lb");
		}
		String name = "";
		if(request.getParameter("name")!=null){
			name=(String)request.getParameter("name");
		}
		String key = "";
		if(request.getParameter("key")!=null){
			key=(String)request.getParameter("key");
		}
		String paytime = "";
		if(request.getParameter("paytime")!=null){
			paytime=(String)request.getParameter("paytime");
		}
		String sqls = "insert into t_user_balance_log(id,orderid,userid,paymoney,paytime,payway,operator,key,remarks)values(UUID(),'"+ddh+"','admin',"+money+",'"+paytime+"','"+lb+"','优云宝','"+key+"','"+name+"')";
		DruidDataSource dataSource = (DruidDataSource)ApplicationContextHelper.getBean("dataSource_jeecg");  
		Connection connection = DataSourceUstils.getConnection(dataSource);  
		String flag = "failure";
		try {
			PreparedStatement ps = connection.prepareStatement(sqls);
			ps.setString(1, ddh);
			ps.setString(2,money);
			ps.setString(3,paytime);
			ps.setString(4,lb);
			ps.setString(5,key);
			ps.setString(6,name);
			ResultSet rs = ps.executeQuery();
			flag  = "ok";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = "failure";
		};
		response.getWriter().append(flag);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
 	}

}
