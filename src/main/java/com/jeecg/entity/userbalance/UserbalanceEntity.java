package com.jeecg.entity.userbalance;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: 用户余额
 * @author zhangdaihao
 * @date 2017-08-20 18:21:07
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_user_balance", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class UserbalanceEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**userid*/
	private java.lang.String userid;
	/**username*/
	private java.lang.String username;
	/**balance*/
	private java.lang.Float balance;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=40)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  id
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  userid
	 */
	@Column(name ="USERID",nullable=true,length=40)
	public java.lang.String getUserid(){
		return this.userid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  userid
	 */
	public void setUserid(java.lang.String userid){
		this.userid = userid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  username
	 */
	@Column(name ="USERNAME",nullable=true,length=100)
	public java.lang.String getUsername(){
		return this.username;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  username
	 */
	public void setUsername(java.lang.String username){
		this.username = username;
	}
	/**
	 *方法: 取得java.lang.Float
	 *@return: java.lang.Float  balance
	 */
	@Column(name ="BALANCE",nullable=true,precision=40,scale=4)
	public java.lang.Float getBalance(){
		return this.balance;
	}

	/**
	 *方法: 设置java.lang.Float
	 *@param: java.lang.Float  balance
	 */
	public void setBalance(java.lang.Float balance){
		this.balance = balance;
	}
}
