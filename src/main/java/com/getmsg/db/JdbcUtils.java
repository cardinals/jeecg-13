package com.getmsg.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class JdbcUtils { 
        @SuppressWarnings("resource")
		public  boolean jdbcUtils(String sql){
            BeanFactory factory = new ClassPathXmlApplicationContext("spring-mvc-hibernate.xml");   
            DataSource ds = (DataSource) factory.getBean("dataSource_jeecg");  
            boolean flag = false;
            try {
    			Connection conn = ds.getConnection();
    			PreparedStatement ps = conn.prepareStatement(sql);
    			ResultSet rs = ps.executeQuery();
    			while(rs.next()){
    				flag = true;
    			}
    		} catch (SQLException e) {
    			flag = false;
    			e.printStackTrace();
    		}
            return flag;
    	}
}
