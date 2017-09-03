package com.jeecg.entity.userbalancelog;

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
 * @Description: 支付日志
 * @author zhangdaihao
 * @date 2017-08-25 11:08:32
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_user_balance_log", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class UserbalancelogEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**orderid*/
	private java.lang.String orderid;
	/**userid*/
	private java.lang.String userid;
	/**paymoney*/
	private java.lang.Float paymoney;
	/**paytime*/
	private java.util.Date paytime;
	/**payway*/
	private java.lang.String payway;
	/**key*/
	private java.lang.String key;
	/**operator*/
	private java.lang.String operator;
	/**remarks*/
	private java.lang.String remarks;
	
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
	 *@return: java.lang.String  orderid
	 */
	@Column(name ="ORDERID",nullable=true,length=2000)
	public java.lang.String getOrderid(){
		return this.orderid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  orderid
	 */
	public void setOrderid(java.lang.String orderid){
		this.orderid = orderid;
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
	 *方法: 取得java.lang.Float
	 *@return: java.lang.Float  paymoney
	 */
	@Column(name ="PAYMONEY",nullable=true,precision=10,scale=4)
	public java.lang.Float getPaymoney(){
		return this.paymoney;
	}

	/**
	 *方法: 设置java.lang.Float
	 *@param: java.lang.Float  paymoney
	 */
	public void setPaymoney(java.lang.Float paymoney){
		this.paymoney = paymoney;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  paytime
	 */
	@Column(name ="PAYTIME",nullable=true)
	public java.util.Date getPaytime(){
		return this.paytime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  paytime
	 */
	public void setPaytime(java.util.Date paytime){
		this.paytime = paytime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  payway
	 */
	@Column(name ="PAYWAY",nullable=true,length=40)
	public java.lang.String getPayway(){
		return this.payway;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  payway
	 */
	public void setPayway(java.lang.String payway){
		this.payway = payway;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  key
	 */
	@Column(name ="KEY",nullable=true,length=100)
	public java.lang.String getKey(){
		return this.key;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  key
	 */
	public void setKey(java.lang.String key){
		this.key = key;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  operator
	 */
	@Column(name ="OPERATOR",nullable=true,length=40)
	public java.lang.String getOperator(){
		return this.operator;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  operator
	 */
	public void setOperator(java.lang.String operator){
		this.operator = operator;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  remarks
	 */
	@Column(name ="REMARKS",nullable=true,length=2000)
	public java.lang.String getRemarks(){
		return this.remarks;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  remarks
	 */
	public void setRemarks(java.lang.String remarks){
		this.remarks = remarks;
	}
}
