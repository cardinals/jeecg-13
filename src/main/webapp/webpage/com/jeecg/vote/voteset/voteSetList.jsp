<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="voteSetList" title="投票设置" actionUrl="voteSetController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
   <t:dgCol title="主机地址" field="address"   width="400"></t:dgCol>
   <t:dgCol title="描述" field="description"   width="300"></t:dgCol>
   <t:dgCol title="客户端标志" field="clientsign"   width="120"></t:dgCol>
   <t:dgCol title="账号" field="account"   width="120"></t:dgCol>
   <t:dgCol title="密码" field="password"   width="120"></t:dgCol>
   <t:dgCol title="创建人" field="createName"   width="120"></t:dgCol>
   <t:dgCol title="创建时间" field="createDate"   width="120"></t:dgCol>
   <t:dgCol title="创建人ID" field="createBy"   width="120"></t:dgCol>
   <t:dgCol title="最后更新人" field="updateName"   width="120"></t:dgCol>
   <t:dgCol title="最后更新时间" field="updateDate"   width="120"></t:dgCol>
   <t:dgCol title="最后更新ID" field="updateBy"   width="120"></t:dgCol>
   <t:dgCol title="是否启用" field="enable"   dictionary="sf_yn" width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="voteSetController.do?del&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="voteSetController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="voteSetController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="voteSetController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>