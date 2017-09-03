<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>用户信息</title>
<t:base type="jquery,easyui,tools"></t:base>
</head>
<body style="overflow-y: hidden" scroll="no">
<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="userController.do?saveUserForSy" beforeSubmit="setOrgIds">
	<input id="id" name="id" type="hidden" value="${user.id }">
	<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
	<tr>
	   <td class="value" colspan="2" style="text-align:center">
	       <a class="easyui-linkbutton" id="btn_reset" iconCls="icon-edit" href="javascript:add('<t:mutiLang langKey="common.change.password"/>','userController.do?changepassword','',550,200)">
                                    <t:mutiLang langKey="common.change.password"/>
           </a>
       </td>
     </tr>
		<tr>
			<td align="right" width="25%" nowrap>
                <label  class="Validform_label">  <t:mutiLang langKey="common.username"/>:  </label>
            </td>
			<td class="value" width="85%">
                ${user.userName }
            </td>
		</tr>
		<tr>
			<td align="right" width="10%" nowrap>
			     <label class="Validform_label"> <t:mutiLang langKey="common.real.name"/>: </label>
			</td>
			<td class="value" width="85%">
                ${user.realName }
            </td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> <t:mutiLang langKey="common.department"/>: </label></td>
			<td class="value" width="85%">
               ${departname}
            </td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> <t:mutiLang langKey="common.role"/>: </label></td>
			<td class="value" width="85%">
                ${roleName }
            </td>
		</tr>
		<tr>
			<td align="right" nowrap><label class="Validform_label"><t:mutiLang langKey="common.userlevel"/>: </label></td>
            <td class="value"><t:dictSelect readonly="readonly"  field="levelid" defaultVal="${user.levelid}" dictTable="t_vote_levset" dictField="levelcode"  dictText="levelname" title="用户等级"></t:dictSelect> 
			<span class="Validform_checktip"></span>
			</td>
		</tr>
		
		<tr>
			<td align="right" nowrap><label class="Validform_label">  <t:mutiLang langKey="common.phone"/>: </label></td>
			<td class="value">
                <input class="inputxt" name="mobilePhone" id="mobilePhone" value="${user.mobilePhone}" datatype="m" errormsg="手机号码不正确" ignore="ignore">
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> <t:mutiLang langKey="common.tel"/>: </label></td>
			<td class="value">
                <input class="inputxt" name="officePhone" id="officePhone" value="${user.officePhone}" datatype="n" errormsg="办公室电话不正确" ignore="ignore">
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		<tr>
			<td align="right"><label class="Validform_label"> <t:mutiLang langKey="common.common.mail"/>: </label></td>
			<td class="value">
                <input class="inputxt" name="email" id="email" value="${user.email}" datatype="e" errormsg="邮箱格式不正确!" ignore="ignore">
                <span class="Validform_checktip"></span>
            </td>
		</tr>
		 <tr>
			 <div class="form" style="width:600px" id="showmsg">
					  
			 </div>
		 </tr>
		<tr>
		<td style="text-align:center" colspan="2"><input class="btn" type="submit"   value="保存" style="height:30px;width:100px !important;border-radius:5px"></td>
		</tr>
	</table>
</t:formvalid>
	<table>
	    <tr>
	    <span class="panel-title" style="font-size: 20px">当前余额:￥${money}</span>
	    </tr>
		<tr align="center">
		<td style="text-align:center" colspan="2"><input class="btn" type="submit"   value="充值" style="height:30px;width:100px !important;border-radius:5px"></td>
		</tr>
	</table>
<script type="text/javascript">
function save(){
	  
	  $.ajax({
		  url:"<%=request.getContextPath()%>/userController.do?saveUserForSy&mobilePhone="+document.getElementById("mobilePhone").value+"&officePhone="+document.getElementById("officePhone").value+"&email="+document.getElementById("email").value, 
			type:"post",
			dataType:"json",
			success:function(data){
				 var obj =  $.parseJSON( data ); 
				$("#showmsg").append("<br/><span style='color:red'>修改成功</span>");
			}
		})
}

</script>
</body>