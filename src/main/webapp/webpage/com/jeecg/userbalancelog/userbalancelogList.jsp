<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="userbalancelogList" title="支付日志" actionUrl="userbalancelogController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="orderid" field="orderid"   width="120"></t:dgCol>
   <t:dgCol title="userid" field="userid"   width="120"></t:dgCol>
   <t:dgCol title="paymoney" field="paymoney"   width="120"></t:dgCol>
   <t:dgCol title="paytime" field="paytime" formatter="yyyy-MM-dd hh:mm:ss"  width="120"></t:dgCol>
   <t:dgCol title="payway" field="payway"   width="120"></t:dgCol>
   <t:dgCol title="key" field="key"   width="120"></t:dgCol>
   <t:dgCol title="operator" field="operator"   width="120"></t:dgCol>
   <t:dgCol title="remarks" field="remarks"   width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="userbalancelogController.do?del&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="userbalancelogController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="userbalancelogController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="userbalancelogController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>