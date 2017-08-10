<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="votelogList" sortName="votetime" sortOrder="desc" title="投票日志" actionUrl="votelogController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="操作人" field="account"   width="120"></t:dgCol>
   <t:dgCol title="任务ID" field="taskid"   width="120"></t:dgCol>
   <t:dgCol title="投票链接" field="voteaddress"   width="120"></t:dgCol>
   <t:dgCol title="投票数" field="votecount"   width="120"></t:dgCol>
   <t:dgCol title="开始票数" field="startnum"   width="120"></t:dgCol>
   <t:dgCol title="结束票数" field="endnum"   width="120"></t:dgCol>
   <t:dgCol title="日志类型" field="logtype"   width="120"></t:dgCol>
   <t:dgCol title="请求结果" field="code" dictionary="sf"  width="120"></t:dgCol>
   <t:dgCol title="投票时间" field="votetime" formatter="yyyy-MM-dd hh:mm:ss"  width="120"></t:dgCol>
   <t:dgToolBar title="查看详情" icon="icon-search" url="votelogController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>