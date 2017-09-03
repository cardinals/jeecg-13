<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<script>
	function pay(id,index) {
		if(id==""||id==null){
			tip('请选择一条记录充值');
		}
		var title = "充值";
		var url = "userbalanceController.do?pay&id="+id;
		createwindow(title,url,"700","300");
	}
</script>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="userbalanceList" title="用户账户金额" actionUrl="userbalanceController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="用户ID" field="userid"  query="true"  width="50"></t:dgCol>
   <t:dgCol title="用户名称" field="username"   width="50"></t:dgCol>
   <t:dgCol title="账户余额" field="balance"   width="50"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="150"></t:dgCol>
   <t:dgFunOpt funname="pay(id)" title="充值" urlclass="ace_button"  urlfont="fa-money"></t:dgFunOpt>
  </t:datagrid>
  </div>
 </div>