<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>投票日志</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="votelogController.do?save">
		<input id="id" name="id" type="hidden" value="${votelogPage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">投票地址:</label>
		      <input class="inputxt" id="voteaddress" name="voteaddress" ignore="ignore" style="width: 500px"  value="${votelogPage.voteaddress}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">投票数:</label>
		      <input class="inputxt" id="votecount" name="votecount" ignore="ignore"   value="${votelogPage.votecount}" />
		      <span class="Validform_checktip"></span>
		    </div>
			
			<div class="form">
		      <label class="Validform_label">操作详情:</label>
		      <textarea name="jsonstr" readonly="true" id="jsonstr" style="width: 500px;height:300px">${votelogPage.jsonstr}</textarea>
		      <span class="Validform_checktip"></span>
		    </div>
			
	    </fieldset>
  </t:formvalid>
 </body>