package com.jeecg.entity.voteset;

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
 * @Description: 投票设置
 * @author zhangdaihao
 * @date 2017-07-19 16:18:44
 * @version V1.0   
 *
 */
@Entity
@Table(name = "T_VOTE_SET", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class VoteSetEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**address*/
	private java.lang.String address;
	/**clientsign*/
	private java.lang.String clientsign;
	/**account*/
	private java.lang.String account;
	/**password*/
	private java.lang.String password;
	/**enable*/
	private java.lang.String enable;
	
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
	 *@return: java.lang.String  address
	 */
	@Column(name ="ADDRESS",nullable=true,length=200)
	public java.lang.String getAddress(){
		return this.address;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  address
	 */
	public void setAddress(java.lang.String address){
		this.address = address;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  clientsign
	 */
	@Column(name ="CLIENTSIGN",nullable=true,length=200)
	public java.lang.String getClientsign(){
		return this.clientsign;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  clientsign
	 */
	public void setClientsign(java.lang.String clientsign){
		this.clientsign = clientsign;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  account
	 */
	@Column(name ="ACCOUNT",nullable=true,length=200)
	public java.lang.String getAccount(){
		return this.account;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  account
	 */
	public void setAccount(java.lang.String account){
		this.account = account;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  password
	 */
	@Column(name ="PASSWORD",nullable=true,length=40)
	public java.lang.String getPassword(){
		return this.password;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  password
	 */
	public void setPassword(java.lang.String password){
		this.password = password;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  enable
	 */
	@Column(name ="ENABLE",nullable=true,length=1)
	public java.lang.String getEnable(){
		return this.enable;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  enable
	 */
	public void setEnable(java.lang.String enable){
		this.enable = enable;
	}
}
