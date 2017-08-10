<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>用户级别设置</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="div" action="levSetController.do?save">
		<input id="id" name="id" type="hidden" value="${levSetPage.id }">
		<fieldset class="step">
			<div class="form">
		      <label class="Validform_label">用户级别编码:</label>
		      <input class="inputxt" id="levelcode" name="levelcode" ignore="ignore"   datatype="*"  value="${levSetPage.levelcode}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">用户级别名称:</label>
		      <input class="inputxt" id="levelname" name="levelname" ignore="ignore"  datatype="*"   value="${levSetPage.levelname}" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		      <label class="Validform_label">折扣率:</label>
		      <input class="inputxt" id="discount" name="discount" ignore="ignore"   value="${levSetPage.discount}" datatype="d" />
		      <span class="Validform_checktip"></span>
		    </div>
			<div class="form">
		       <label class="Validform_label">是否启用:</label>
		       <t:dictSelect field="enable" type="radio" 
									typeGroupCode="sf_yn" defaultVal="${levSetPage.enable==null?'N':levSetPage.enable}" hasLabel="false"   title="是否启用" ></t:dictSelect>     
			   <span class="Validform_checktip"></span>
			   <label class="Validform_label" style="display: none;">是否启用</label>
		    </div>
	    </fieldset>
  </t:formvalid>
 </body>