<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>支付日志</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="userbalancelogController.do?save">
		<input id="id" name="id" type="hidden" value="${userbalancelogPage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">orderid:</label>
		      <input class="inputxt" id="orderid" name="orderid" ignore="ignore"   value="${userbalancelogPage.orderid}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">userid:</label>
		      <input class="inputxt" id="userid" name="userid" ignore="ignore"   value="${userbalancelogPage.userid}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">paymoney:</label>
		      <input class="inputxt" id="paymoney" name="paymoney" ignore="ignore"   value="${userbalancelogPage.paymoney}" datatype="d" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">paytime:</label>
		      <input class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width: 150px" id="paytime" name="paytime" ignore="ignore"     value="<fmt:formatDate value='${userbalancelogPage.paytime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">payway:</label>
		      <input class="inputxt" id="payway" name="payway" ignore="ignore"   value="${userbalancelogPage.payway}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">key:</label>
		      <input class="inputxt" id="key" name="key" ignore="ignore"   value="${userbalancelogPage.key}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">operator:</label>
		      <input class="inputxt" id="operator" name="operator" ignore="ignore"   value="${userbalancelogPage.operator}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">remarks:</label>
		      <input class="inputxt" id="remarks" name="remarks" ignore="ignore"   value="${userbalancelogPage.remarks}" />
		      <span class="Validform_checktip"></span>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>