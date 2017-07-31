<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>投票设置</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="voteSetController.do?save">
		<input id="id" name="id" type="hidden" value="${voteSetPage.id }">
		<input id="createDate" name="createDate" type="hidden" value="${voteSetPage.createDate }"/>
		<input id="createBy" name="createBy" type="hidden" value="${voteSetPage.createBy }"/>
		<input id="createName" name="createName" type="hidden" value="${voteSetPage.createName }"/>
		<input id="updateBy" name="updateBy" type="hidden" value="${voteSetPage.updateBy }"/>
		<input id="updateDate" name="updateDate" type="hidden" value="${voteSetPage.updateDate }"/>
		<input id="updateName" name="updateName" type="hidden" value="${voteSetPage.updateName }"/>
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">主机地址:</label>
		      <input class="inputxt" id="address" name="address" ignore="ignore"  datatype="*"  value="${voteSetPage.address}" />
		      <span class="Validform_checktip"></span>
		      <label class="Validform_label" style="display: none;">主机地址</label>
		    </div>
		    <div class="form">
		      <label class="Validform_label">描述:</label>
		      <input class="inputxt" id="description" name="description" ignore="ignore" datatype="*"  value="${voteSetPage.description}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">客户端标识:</label>
		      <input class="inputxt" id="clientsign" name="clientsign" ignore="ignore" datatype="*"  value="${voteSetPage.clientsign}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">账号:</label>
		      <input class="inputxt" id="account" name="account" ignore="ignore" datatype="*"  value="${voteSetPage.account}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">密码:</label>
		      <input class="inputxt" id="password" name="password" ignore="ignore" datatype="*"  value="${voteSetPage.password}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		       <label class="Validform_label">是否启用:</label>
		       <t:dictSelect field="enable" type="radio" 
									typeGroupCode="sf_yn" defaultVal="${voteSetPage.enable==null?'N':voteSetPage.enable}" hasLabel="false"   title="是否启用" ></t:dictSelect>     
			   <span class="Validform_checktip"></span>
			   <label class="Validform_label" style="display: none;">是否启用</label>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>