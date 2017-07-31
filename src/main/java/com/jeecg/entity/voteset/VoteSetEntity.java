package com.jeecg.entity.voteset;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: 投票设置
 * @author cfma
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
	/**description*/
	private java.lang.String description;
	/**createDate*/
	private java.util.Date createDate;
	/**createBy*/
	private java.lang.String createBy;
	/**createName*/
	private java.lang.String createName;
	/**updateDate*/
	private java.util.Date updateDate;
	/**updateBy*/
	private java.lang.String updateBy;
	/**updateName*/
	private java.lang.String updateName;
	
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
	
	
	@Column(name ="DESCRIPTION",nullable=true,length=200)
	public java.lang.String getDescription() {
		return description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}

	@Column(name ="CREATEDATE",nullable=true,length=0)
	public java.util.Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	
	@Column(name ="CREATEBY",nullable=true,length=40)
	public java.lang.String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(java.lang.String createBy) {
		this.createBy = createBy;
	}
	
	@Column(name ="CREATENAME",nullable=true,length=40)
	public java.lang.String getCreateName() {
		return createName;
	}

	public void setCreateName(java.lang.String createName) {
		this.createName = createName;
	}
	
	@Column(name ="UPDATEDATE",nullable=true,length=0)
	public java.util.Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name ="UPDATEBY",nullable=true,length=40)
	public java.lang.String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(java.lang.String updateBy) {
		this.updateBy = updateBy;
	}

	@Column(name ="UPDATENAME",nullable=true,length=40)
	public java.lang.String getUpdateName() {
		return updateName;
	}

	public void setUpdateName(java.lang.String updateName) {
		this.updateName = updateName;
	}

}
