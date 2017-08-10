package com.jeecg.entity.levset;

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
 * @Description: 用户级别设置
 * @author zhangdaihao
 * @date 2017-08-07 11:44:04
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_vote_levset", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class LevSetEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**levelcode*/
	private java.lang.String levelcode;
	/**levelname*/
	private java.lang.String levelname;
	/**discount*/
	private java.lang.Float discount;
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
	 *@return: java.lang.String  levelcode
	 */
	@Column(name ="LEVELCODE",nullable=true,length=40)
	public java.lang.String getLevelcode(){
		return this.levelcode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  levelcode
	 */
	public void setLevelcode(java.lang.String levelcode){
		this.levelcode = levelcode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  levelname
	 */
	@Column(name ="LEVELNAME",nullable=true,length=100)
	public java.lang.String getLevelname(){
		return this.levelname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  levelname
	 */
	public void setLevelname(java.lang.String levelname){
		this.levelname = levelname;
	}
	/**
	 *方法: 取得java.lang.Float
	 *@return: java.lang.Float  discount
	 */
	@Column(name ="DISCOUNT",nullable=true,precision=20,scale=2)
	public java.lang.Float getDiscount(){
		return this.discount;
	}

	/**
	 *方法: 设置java.lang.Float
	 *@param: java.lang.Float  discount
	 */
	public void setDiscount(java.lang.Float discount){
		this.discount = discount;
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
