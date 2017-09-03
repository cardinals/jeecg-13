<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="userbalancelogList" title="用户账户充值日志"   sortName="paytime"  actionUrl="userbalancelogController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="充值账户" field="userid"    query="true"    width="120"></t:dgCol>
   <t:dgCol title="充值金额" field="paymoney"   width="120"></t:dgCol>
   <t:dgCol title="充值时间" field="paytime" formatter="yyyy-MM-dd hh:mm:ss"  width="120"></t:dgCol>
   <t:dgCol title="充值方式" field="payway"   width="120"></t:dgCol>
   <t:dgCol title="操作人" field="operator"   width="120"></t:dgCol>
  </t:datagrid>
  </div>
 </div>