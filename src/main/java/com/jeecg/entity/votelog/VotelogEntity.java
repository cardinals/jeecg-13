package com.jeecg.entity.votelog;

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
 * @Description: 投票日志
 * @author zhangdaihao
 * @date 2017-07-29 02:23:23
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_vote_log", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class VotelogEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**account*/
	private java.lang.String account;
	/**voteaddress*/
	private java.lang.String voteaddress;
	/**votecount*/
	private java.lang.String votecount;
	/**taskid*/
	private java.lang.String taskid;
	/**startnum*/
	private java.lang.String startnum;
	/**endnum*/
	private java.lang.String endnum;
	/**votetime*/
	private java.util.Date votetime;
	/**jsonstr*/
	private java.lang.String jsonstr;
	/**logtype*/
	private java.lang.String logtype;
	/**code*/
	private java.lang.String code;
	
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
	 *@return: java.lang.String  account
	 */
	@Column(name ="ACCOUNT",nullable=true,length=40)
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
	 *@return: java.lang.String  voteaddress
	 */
	@Column(name ="VOTEADDRESS",nullable=true,length=2000)
	public java.lang.String getVoteaddress(){
		return this.voteaddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  voteaddress
	 */
	public void setVoteaddress(java.lang.String voteaddress){
		this.voteaddress = voteaddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  votecount
	 */
	@Column(name ="VOTECOUNT",nullable=true,length=40)
	public java.lang.String getVotecount(){
		return this.votecount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  votecount
	 */
	public void setVotecount(java.lang.String votecount){
		this.votecount = votecount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  taskid
	 */
	@Column(name ="TASKID",nullable=true,length=40)
	public java.lang.String getTaskid(){
		return this.taskid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  taskid
	 */
	public void setTaskid(java.lang.String taskid){
		this.taskid = taskid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  startnum
	 */
	@Column(name ="STARTNUM",nullable=false,length=40)
	public java.lang.String getStartnum(){
		return this.startnum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  startnum
	 */
	public void setStartnum(java.lang.String startnum){
		this.startnum = startnum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  endnum
	 */
	@Column(name ="ENDNUM",nullable=true,length=40)
	public java.lang.String getEndnum(){
		return this.endnum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  endnum
	 */
	public void setEndnum(java.lang.String endnum){
		this.endnum = endnum;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  votetime
	 */
	@Column(name ="VOTETIME",nullable=false)
	public java.util.Date getVotetime(){
		return this.votetime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  votetime
	 */
	public void setVotetime(java.util.Date votetime){
		this.votetime = votetime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  jsonstr
	 */
	@Column(name ="JSONSTR",nullable=true,length=4000)
	public java.lang.String getJsonstr(){
		return this.jsonstr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  jsonstr
	 */
	public void setJsonstr(java.lang.String jsonstr){
		this.jsonstr = jsonstr;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  logtype
	 */
	@Column(name ="LOGTYPE",nullable=true,length=40)
	public java.lang.String getLogtype(){
		return this.logtype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  logtype
	 */
	public void setLogtype(java.lang.String logtype){
		this.logtype = logtype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  code
	 */
	@Column(name ="CODE",nullable=true,length=40)
	public java.lang.String getCode(){
		return this.code;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  code
	 */
	public void setCode(java.lang.String code){
		this.code = code;
	}
}
