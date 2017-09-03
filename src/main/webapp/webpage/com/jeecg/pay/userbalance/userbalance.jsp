<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>用户账户金额</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="userbalanceController.do?save">
		<input id="id" name="id" type="hidden" value="${userbalancePage.id }">
		<fieldset class="step">
		<div class="form">
		      <label class="Validform_label">充值账户:</label>
		      <input class="inputxt" id="userid" name="userid" ignore="ignore"  readonly="readonly" value="${userbalancePage.userid}" datatype="*" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">账户余额:</label>
		      <input class="inputxt" id="balance" name="balance" ignore="ignore"  readonly="readonly" value="${userbalancePage.balance}" datatype="d" />
		      <span class="Validform_checktip"></span>
		    </div>
		    <div class="form">
		      <label class="Validform_label">充值金额:</label>
		      <input class="inputxt" id="money" name="money" ignore="ignore"   value="" datatype="d" />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>